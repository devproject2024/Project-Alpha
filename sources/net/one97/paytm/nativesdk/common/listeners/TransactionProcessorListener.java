package net.one97.paytm.nativesdk.common.listeners;

public interface TransactionProcessorListener {
    void onIntentFlowComplete();

    void onProcessTransactionResponse(Object obj);
}
