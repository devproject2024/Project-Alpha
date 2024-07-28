package net.one97.paytm.nativesdk.instruments.upicollect.listeners;

import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface UpiCollectListener extends BaseViewActions {
    void changeArrowIcon(boolean z);

    void changeCheckOfferText(String str, int i2);

    void changeOfferTextColor(int i2);

    void changeVpaEditTextUi(boolean z, String str);

    void clearVpaAddress();

    void closeKeyboard();

    void createFetchDeeplinkDialog();

    void hideFetchDeeplinkDialog();

    void onIntentFlowComplete();

    void selectView();

    void setPaySecurelyText(String str);

    void showAnimation(boolean z);

    void showUpiIntent();

    void startLottieAnimation();

    void viewClicked();
}
