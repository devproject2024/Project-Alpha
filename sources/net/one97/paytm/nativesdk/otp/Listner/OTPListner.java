package net.one97.paytm.nativesdk.otp.Listner;

import com.android.volley.Request;
import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;

public interface OTPListner extends NetworkUnavailable {
    void onFailureOTPSend(String str);

    void onNetworkUnavailable(Request request);

    void onSmsReceived(String str, String str2);

    void onVerifyOTP(boolean z);

    void resendOtpDisable();
}
