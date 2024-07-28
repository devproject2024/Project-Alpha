package net.one97.paytm.nativesdk.transcation.listners;

public interface NativePlusActionListener {
    void cancelTransaction();

    void paySecurely(String str);

    void resendOtp();
}
