package com.klaytn.caver.kas;

import com.klaytn.caver.Caver;
import com.klaytn.caver.crypto.KlayCredentials;
import com.klaytn.caver.kas.ft.abi.ERC20;
import com.klaytn.caver.kas.nft.abi.GxCards;
import com.klaytn.caver.methods.response.KlayTransactionReceipt;
import com.klaytn.caver.tx.gas.DefaultGasProvider;
import com.klaytn.caver.tx.manager.TransactionManager;
import com.klaytn.caver.tx.model.ValueTransferTransaction;
import com.klaytn.caver.tx.type.TxTypeValueTransfer;
import org.slf4j.Logger;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

import static org.slf4j.LoggerFactory.getLogger;

public class Application {
    private static final Logger log = getLogger(Application.class);
    private static final int LOCAL_CHAIN_ID = 1000;
    private static final BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;

    private static final int REQUEST_COUNT_TO_SEND = 10;
    private static final String TO_ADDRESS = "0x5dad554b0742c41508c7e091586173b8ad066524";

    private static Caver caver = Caver.build("http://15.165.104.177:8551");

    // We start by creating a new caver instance to connect to remote nodes on the network

    public static void main(String[] args) throws Exception {
        new Application().run();
    }

    public void run() throws Exception {
        log.info("Connected to Klaytn net version: "
                + caver.klay().getChainID().send().getValue());

        KlayCredentials credentials = KlayCredentials.create("0x8927587b58253c930a4a3879dfb8c11824ec5c76dfbc1bba1280514b5dc12088");

        ERC20 erc20 = ERC20.deploy(caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT)).send();
        System.out.println(erc20.name().send());
        System.out.println(erc20.balanceOf(credentials.getAddress()).send().toString());

        for (int i = 0; i < REQUEST_COUNT_TO_SEND; i++) {
            erc20.transfer(TO_ADDRESS, BigInteger.ONE).send();
        }

        GxCards gxCards = GxCards.deploy(caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT), "brandon", "BRD", "www.kas.com").send();
        System.out.println(gxCards.name().send());
        System.out.println(gxCards.baseURI().send());

        TransactionManager transactionManager = new TransactionManager.Builder(caver, credentials)
                .setChaindId(LOCAL_CHAIN_ID).build();

        int successReqCount = 0;
        for (int i = 0; i < REQUEST_COUNT_TO_SEND; i++) {
            ValueTransferTransaction valueTransferTransaction = ValueTransferTransaction
                    .create(credentials.getAddress(), TO_ADDRESS, BigInteger.ONE, GAS_LIMIT);
            KlayTransactionReceipt.TransactionReceipt receipt = transactionManager.executeTransaction(valueTransferTransaction);

            if (receipt.getStatus().equals("0x1")) {
                successReqCount++;
                log.info("current success request count : " + successReqCount);
            }
        }
        log.info("total success request count : " + successReqCount);
    }

    private String transferValue(Caver caver, KlayCredentials credentials) throws java.io.IOException {
        BigInteger nonce = caver.klay().getTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getValue();
        TxTypeValueTransfer tx = TxTypeValueTransfer.createTransaction(
                nonce,
                BigInteger.ZERO,
                GAS_LIMIT,
                TO_ADDRESS,
                BigInteger.valueOf(0xa),
                credentials.getAddress());

        return tx.sign(credentials, LOCAL_CHAIN_ID).getValueAsString();
    }
}
