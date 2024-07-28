package net.one97.paytm.nativesdk.instruments.emi.listeners;

import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;

public interface EmiClickListener extends BaseViewActions {
    void binResponseReceived(BinResponse binResponse);

    void changeArrowIcon(boolean z);

    void changeCardView(boolean z);

    void changeCvvView(boolean z);

    void changeExpiryView(boolean z);

    void changePromoCodeBg(boolean z);

    void changeRemainingAmt(String str);

    void clearCardInfo();

    void closeKeyboard();

    void cvvEditTextFocus();

    void deSelectSavedCard();

    void enableDisableCVV(boolean z);

    void enableDisableExpiry(boolean z);

    void monthEditTextFocus();

    void onTenureFailure(String str, String str2);

    void onTenureSuccess(String str);

    void onViewSelected();

    void openSelectBankActivity();

    void showAnimation(boolean z);

    void tncClickListener();
}
