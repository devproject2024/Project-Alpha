package net.one97.paytm.passbook.beans.upi;

public interface UPICheckBalanceListenerCallback {
    void onError(String str);

    void onFetchBalanceSuccess(String str, String str2, String str3);

    void onRequestEnd();

    void onRequestStart();
}
