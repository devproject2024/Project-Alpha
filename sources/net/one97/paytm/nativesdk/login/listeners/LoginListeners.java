package net.one97.paytm.nativesdk.login.listeners;

import com.android.volley.Request;
import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;

public interface LoginListeners extends NetworkUnavailable {
    void closeView();

    void errorOnMobileNumber(int i2);

    void hideKeyboard();

    void hideOtpFragment();

    void onFailureOTPSend(String str);

    void onNetworkUnavailable(Request request);

    void onOTPSend(String str);

    void setPayMethodViews();
}
