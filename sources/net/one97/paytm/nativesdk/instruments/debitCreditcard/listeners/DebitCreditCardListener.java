package net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners;

import android.view.View;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface DebitCreditCardListener extends BaseViewActions {
    void addSavedCard(View view);

    void animateOneClickContainer();

    void atmRadioChecked(boolean z);

    void cardClicked();

    void changeArrowIcon(boolean z);

    void changeCardUi(boolean z, int i2);

    void changeCvvFieldLength(int i2);

    void changeCvvRequiredNotRequired(boolean z);

    void changeExpiryRequiredNotRequired(boolean z);

    void changePromoCodeBg(boolean z);

    void clearEmiDetails();

    void clearNewCardInfo();

    void clearRadioGroup();

    void clearSavedCard();

    void closeCachierSheet();

    void closeKeyboard();

    void cvvEditTextFocus();

    void enableDisableCvv(boolean z);

    void enableDisableExipary(boolean z);

    void hideCvvKeyBoard();

    void hideNewCardAnimation();

    void monthEditTextFocus();

    void scrollTo(int i2);

    void scrollTo(View view);

    void sendUncheckBroadcast();

    void showHideAnimation(View view, boolean z);

    void showHideProgressDialog(boolean z);

    void showNewCardAnimation();

    void showRiskConvenienceFeeInfo(String str, String str2, String str3);

    void updateNewCardImage(int i2);

    void updateNewCardImage(String str);
}
