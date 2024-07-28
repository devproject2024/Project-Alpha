package com.paytm.paymentsettings.common.data;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

public interface PaymentSettingsCallBacks {
    void sendCustomGtmEventWithMap(String str, HashMap<String, String> hashMap, Context context);

    void showSessionTimeoutAlert(Activity activity);
}
