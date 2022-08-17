package com.webank.wecross.stub.bcos.web3j;

import org.fisco.bcos.sdk.client.protocol.response.BcosBlock;
import org.fisco.bcos.sdk.client.protocol.response.BcosBlockHeader;
import org.fisco.bcos.sdk.client.protocol.response.Call;
import org.fisco.bcos.sdk.client.protocol.response.TransactionReceiptWithProof;
import org.fisco.bcos.sdk.client.protocol.response.TransactionWithProof;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;

import java.io.IOException;
import java.math.BigInteger;


public class Web3jWrapperWithExceptionMock extends AbstractWeb3jWrapper {

    public Web3jWrapperWithExceptionMock() {
        super(null);
    }

    @Override
    public BcosBlock.Block getBlockByNumber(long blockNumber) throws IOException {
        throw new IOException(" IOException");
    }

    public BcosBlockHeader.BlockHeader getBlockHeaderByNumber(long blockNumber) throws IOException {
        throw new IOException(" IOException");
    }

    @Override
    public BigInteger getBlockNumber() throws IOException {
        throw new IOException(" IOException");
    }

    @Override
    public void sendTransaction(String signedTransactionData, TransactionCallback callback) throws IOException {
        throw new IOException(" IOException");
    }

    @Override
    public TransactionReceiptWithProof.ReceiptAndProof getTransactionReceiptByHashWithProof(String transactionHash) throws IOException {
        throw new IOException(" IOException");
    }

    @Override
    public TransactionWithProof.TransactionAndProof getTransactionByHashWithProof(String transactionHash) throws IOException {
        throw new IOException(" IOException");
    }

    @Override
    public Call.CallOutput call(String accountAddress, String contractAddress, String data) throws IOException {
        throw new IOException(" IOException");
    }

}
