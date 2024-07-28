package net.one97.paytm.nativesdk.instruments.cod.listeners;

import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface CodClickListener extends BaseViewActions {
    void changeArrowIcon(boolean z);

    void changeRemainingAmt(String str);

    void closeKeyboard();

    void showAnimation(boolean z);

    void showBankOfferText();
}
