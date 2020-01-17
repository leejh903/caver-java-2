package com.klaytn.caver.kas;

import com.klaytn.caver.Caver;
import com.klaytn.caver.crypto.KlayCredentials;
import com.klaytn.caver.fee.FeePayerManager;
import com.klaytn.caver.kas.ft.abi.ERC20;
import com.klaytn.caver.kas.nft.abi.GxCards;
import com.klaytn.caver.methods.response.KlayTransactionReceipt;
import com.klaytn.caver.tx.gas.DefaultGasProvider;
import com.klaytn.caver.tx.manager.PollingTransactionReceiptProcessor;
import com.klaytn.caver.tx.manager.TransactionManager;
import com.klaytn.caver.tx.model.ValueTransferTransaction;
import com.klaytn.caver.tx.type.TxType;
import com.klaytn.caver.tx.type.TxTypeValueTransfer;
import org.slf4j.Logger;
import org.web3j.crypto.Keys;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

import static com.klaytn.caver.base.Accounts.*;
import static com.klaytn.caver.base.LocalValues.LOCAL_CHAIN_ID;
import static org.slf4j.LoggerFactory.getLogger;

public class Application {
    private static final Logger log = getLogger(Application.class);
    // chain id
    private static final int LOCAL_CHAIN_ID = 1001;
    private static final BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;
    private static final BigInteger GAS_PRICE = BigInteger.ZERO;

    private static final int REQUEST_COUNT_TO_SEND = 1000;

    private static KlayCredentials credentials = KlayCredentials.create("0x280a99ddffe9c3df8978ff891b47f614acdb73f075658a6537fd19c9bb61d2d2");
    private static final String TO_ADDRESS = "0x5dad554b0742c41508c7e091586173b8ad066524";
    public static final KlayCredentials FEE_PAYER = KlayCredentials.create(
            "0x1e558ea00698990d875cb69d3c8f9a234fe8eab5c6bd898488d851669289e178",
            "0x9d0dcbe163be73163348e7f96accb2b9e1e9dcf6"
    );

    // client
    private static Caver caver = Caver.build("http://15.165.104.177:8551");

    public static void main(String[] args) throws Exception {
        new Application().run();
    }

    public void run() throws Exception {
        log.info("Connected to Klaytn net version: "
                + caver.klay().getChainID().send().getValue());

        // ft deploy
        ERC20 erc20 = ERC20.deploy(caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT)).send();
        log.info("ft address: " + erc20.getContractAddress());
        log.info("ft name: " + erc20.name().send());
        log.info("ft symbol: " + erc20.symbol().send());
        log.info("ft rich credential" + erc20.balanceOf(credentials.getAddress()).send().toString());

        // load ft if there is existed ft
        erc20 = ERC20.load(erc20.getContractAddress(), caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT));

        // ft transfer
        for (int i = 0; i < 10; i++) {
            erc20.transfer(TO_ADDRESS, BigInteger.ONE).send();
        }


        // nft deploy
        GxCards gxCards = GxCards.deploy(caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT), "brandon", "BRD", "www.kas.com").send();

        // load nft if there is existed ft
        gxCards = GxCards.load(gxCards.getContractAddress(), caver, credentials, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT));

        // nft mint
        KlayCredentials mintAddress = KlayCredentials.create(Keys.createEcKeyPair());
        gxCards.mintWithTokenURI(mintAddress.getAddress(), BigInteger.valueOf(1), "www.nft1.com").send();
        gxCards.mintWithTokenURI(mintAddress.getAddress(), BigInteger.valueOf(2), "www.nft2.com").send();
        log.info("nft owner - tokenId 1: " + gxCards.ownerOf(BigInteger.valueOf(1)).send());
        log.info("nft owner - tokenId 2: " + gxCards.ownerOf(BigInteger.valueOf(2)).send());
        log.info("nft balance of mintAddress: " + gxCards.balanceOf(mintAddress.getAddress()).send());
        log.info("nft address: " + gxCards.getContractAddress());
        log.info("nft name: " + gxCards.name().send());
        log.info("nft symbol: " + gxCards.symbol().send());

        // load nft from nft address
        gxCards = GxCards.load(gxCards.getContractAddress(), caver, mintAddress, LOCAL_CHAIN_ID, new StaticGasProvider(BigInteger.ZERO, GAS_LIMIT));
        // update nft owner
        KlayTransactionReceipt.TransactionReceipt nftUpdateReceipt = gxCards.transferFrom(mintAddress.getAddress(), credentials.getAddress(), BigInteger.valueOf(2)).send();
        if (nftUpdateReceipt.getStatus().equals("0x0")) {
            log.error("nft owner update failed");
        }
        log.info("nft owner - tokenId 2: " + gxCards.ownerOf(BigInteger.valueOf(2)).send());


        TransactionManager transactionManager = new TransactionManager.Builder(caver, credentials)
                .setChaindId(LOCAL_CHAIN_ID).build();

        // klay transfer
        int successReqCount = 0;
        for (int i = 0; i < REQUEST_COUNT_TO_SEND; i++) {
            ValueTransferTransaction valueTransferTransaction = ValueTransferTransaction
                    .create(credentials.getAddress(), FEE_PAYER.getAddress(), BigInteger.valueOf(100), GAS_LIMIT);
            KlayTransactionReceipt.TransactionReceipt receipt = transactionManager.executeTransaction(valueTransferTransaction);

            if (receipt.getStatus().equals("0x1")) {
                successReqCount++;
                log.info("current success request count : " + successReqCount);
            }
        }

        for (int i = 0; i < REQUEST_COUNT_TO_SEND; i++) {
            String senderRawTx = getSenderRawTx();
            FeePayerManager feePayerManager = new FeePayerManager.Builder(caver, FEE_PAYER)
                    .setTransactionReceiptProcessor(new PollingTransactionReceiptProcessor(caver, 1000, 10))
                    .setChainId(LOCAL_CHAIN_ID)
                    .build();

            KlayTransactionReceipt.TransactionReceipt feeDelegateReceipt = feePayerManager.executeTransaction(senderRawTx);
            if (feeDelegateReceipt.getStatus().equals("0x1")) {
                successReqCount++;
                log.info("current success request count : " + successReqCount);
            }
        }
        log.info("total success request count : " + successReqCount);
    }

    private String getSenderRawTx() throws Exception {
        TxType tx = ValueTransferTransaction.create(credentials.getAddress(), TO_ADDRESS, BigInteger.ONE, GAS_LIMIT)
                .gasPrice(GAS_PRICE)
                .nonce(getNonce(credentials.getAddress()))
                .feeRatio(BigInteger.valueOf(30))
                .buildFeeDelegated();
        return tx.sign(credentials, LOCAL_CHAIN_ID).getValueAsString();
    }

    BigInteger getNonce(String address) throws Exception {
        BigInteger nonce = caver.klay().getTransactionCount(
                address,
                DefaultBlockParameterName.PENDING).sendAsync().get().getValue();
        return nonce;
    }
}
