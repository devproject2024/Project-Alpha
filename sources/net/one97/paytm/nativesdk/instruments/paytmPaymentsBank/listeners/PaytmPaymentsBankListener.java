package net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.listeners;

import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public interface PaytmPaymentsBankListener extends BaseViewActions {
    void addOnBoardingData(CJRFetchBalanceResponse cJRFetchBalanceResponse);

    void changePasscodeUi(boolean z);

    void closeCachierSheet();

    void deselectView();

    void disablePostPaid();

    void disableView(boolean z);

    void hideKeyboard();

    void markViewSelected();

    void onFetchBalance(Boolean bool);

    void setTSecondaryTextColor();

    void setViewDeselected();

    void setViewSelected();

    void showAnimation(boolean z);

    void toggleProceed(boolean z);
}
