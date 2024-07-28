package net.one97.paytm.nativesdk.common.listeners;

import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;

public interface ActivityInteractor {
    void disableSelectedUpiPayOption(String str);

    void disableUiInteraction();

    void enableUiInteraction();

    boolean isUIEnable();

    void onPaymentFailed(String str, String str2, TransactionProcessor transactionProcessor);
}
