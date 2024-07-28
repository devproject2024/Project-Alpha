package net.one97.paytm.nativesdk.instruments.savedCard.listeners;

import android.content.Context;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface SavedCardClickListener extends BaseViewActions {
    void bankEmiOfferError();

    void bankEmiOfferReceived();

    void changeArrowIcon(boolean z);

    void changeRemainingAmt(String str);

    void closeKeyboard();

    void preInitCardEnrollment(Context context, CardData cardData);

    void showAnimation(boolean z);

    void updateVisaSingleClickUI();
}
