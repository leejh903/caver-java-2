/*
 * Copyright 2019 The caver-java Authors
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.klaytn.caver.tx.type;

import com.klaytn.caver.crypto.KlaySignatureData;
import com.klaytn.caver.utils.KlayTransactionUtils;
import org.web3j.rlp.*;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.List;

/**
 * TxTypeFeeDelegatedSmartContractExecution executes a smart contract with the given data.
 * The fee is paid by the fee payer.
 */
public class TxTypeFeeDelegatedSmartContractExecution extends AbstractTxType implements TxTypeFeeDelegate {

    /**
     * input data of the smart contract
     */
    private final byte[] payload;

    protected TxTypeFeeDelegatedSmartContractExecution(
            BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String to,
            BigInteger value, String from, byte[] payload) {
        super(nonce, gasPrice, gasLimit, from, to, value);
        this.payload = payload;
    }

    public static TxTypeFeeDelegatedSmartContractExecution createTransaction(
            BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String to,
            BigInteger value, String from, byte[] payload) {
        return new TxTypeFeeDelegatedSmartContractExecution(nonce, gasPrice, gasLimit, to, value, from, payload);
    }

    public byte[] getPayload() {
        return payload;
    }

    /**
     * create RlpType List which contains nonce, gas price, gas limit, to, value, from and payload.
     * List elements can be different depending on transaction type.
     *
     * @return List RlpType List
     */
    @Override
    public List<RlpType> rlpValues() {
        List<RlpType> values = super.rlpValues();
        values.add(RlpString.create(Numeric.hexStringToByteArray(getTo())));
        values.add(RlpString.create(getValue()));
        values.add(RlpString.create(Numeric.hexStringToByteArray(getFrom())));
        values.add(RlpString.create(getPayload()));
        return values;
    }

    /**
     * This method is overridden as FEE_DELEGATED_SMART_CONTRACT_EXECUTION type.
     * The return value is used for rlp encoding.
     *
     * @return Type transaction type
     */
    @Override
    public Type getType() {
        return Type.FEE_DELEGATED_SMART_CONTRACT_EXECUTION;
    }

    /**
     * decode transaction hash from sender to reconstruct transaction with fee payer signature.
     *
     * @param rawTransaction signed transaction hash from sender
     * @return TxTypeFeeDelegatedSmartContractExecution decoded transaction
     */
    public static TxTypeFeeDelegatedSmartContractExecution decodeFromRawTransaction(byte[] rawTransaction) {
        byte[] rawTransactionExceptType = KlayTransactionUtils.getRawTransactionNoType(rawTransaction);

        RlpList rlpList = RlpDecoder.decode(rawTransactionExceptType);
        RlpList values = (RlpList) rlpList.getValues().get(0);
        BigInteger nonce = ((RlpString) values.getValues().get(0)).asPositiveBigInteger();
        BigInteger gasPrice = ((RlpString) values.getValues().get(1)).asPositiveBigInteger();
        BigInteger gasLimit = ((RlpString) values.getValues().get(2)).asPositiveBigInteger();
        String to = ((RlpString) values.getValues().get(3)).asString();
        BigInteger value = ((RlpString) values.getValues().get(4)).asPositiveBigInteger();
        String from = ((RlpString) values.getValues().get(5)).asString();
        byte[] payload = ((RlpString) values.getValues().get(6)).getBytes();

        TxTypeFeeDelegatedSmartContractExecution tx
                = TxTypeFeeDelegatedSmartContractExecution.createTransaction(nonce, gasPrice, gasLimit, to, value, from, payload);
        if (values.getValues().size() > 6) {
            RlpList vrs = (RlpList) ((RlpList) (values.getValues().get(7))).getValues().get(0);
            byte[] v = ((RlpString) vrs.getValues().get(0)).getBytes();
            byte[] r = ((RlpString) vrs.getValues().get(1)).getBytes();
            byte[] s = ((RlpString) vrs.getValues().get(2)).getBytes();
            tx.setSenderSignatureData(new KlaySignatureData(v, r, s));
        }
        return tx;
    }

    /**
     * @param rawTransaction signed transaction hash from sender
     * @return TxTypeFeeDelegatedSmartContractExecution decoded transaction
     */
    public static TxTypeFeeDelegatedSmartContractExecution decodeFromRawTransaction(String rawTransaction) {
        return decodeFromRawTransaction(Numeric.hexStringToByteArray(Numeric.cleanHexPrefix(rawTransaction)));
    }
}
