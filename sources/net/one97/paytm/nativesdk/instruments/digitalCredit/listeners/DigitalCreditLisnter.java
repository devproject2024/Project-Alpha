package net.one97.paytm.nativesdk.instruments.digitalCredit.listeners;

public interface DigitalCreditLisnter {
    void closeCachierSheet();

    void deselectView();

    void disableView(boolean z);

    void onFetchBalance();

    void showAnimation(boolean z);
}
