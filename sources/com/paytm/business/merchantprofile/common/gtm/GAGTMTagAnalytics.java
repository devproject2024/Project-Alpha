package com.paytm.business.merchantprofile.common.gtm;

import android.content.Context;
import com.business.common_module.b.e;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.Utils;
import java.util.HashMap;

public class GAGTMTagAnalytics {
    public static GAGTMTagAnalytics mInstance;
    public e gaEventPublisher = ProfileConfig.getInstance().getEventPublisher();

    public void pushScreenEvent(String str) {
    }

    public void setCurrentVisibleScreen(String str) {
    }

    public static GAGTMTagAnalytics getSingleInstance() {
        if (mInstance == null) {
            synchronized (GAGTMTagAnalytics.class) {
                if (mInstance == null) {
                    mInstance = new GAGTMTagAnalytics();
                }
            }
        }
        return mInstance;
    }

    public void sendEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        this.gaEventPublisher.b(context, str, str2, str3, str4);
    }

    public void sendEvent(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.gaEventPublisher.b(context, str, str2, str3, str4);
    }

    public void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        this.gaEventPublisher.a(str, hashMap, context);
    }

    public void sendEvent(Context context, String str, String str2, String str3, String str4) {
        this.gaEventPublisher.a(context, str, str2, str3, str4);
    }

    public void sendEventAndScreen(Context context, String str, String str2, String str3) {
        String buildScreenName = Utils.buildScreenName(str, str2, str3);
        this.gaEventPublisher.a(context, str, str2, buildScreenName, str3);
        pushScreenEvent(buildScreenName);
    }
}
