package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.Map;

public interface PaytmH5AppAnalyticsProvider {
    void pushDomainToHawkeye(String str, String str2, Context context, String str3);

    void sendAppAnalytics(Context context, String str, String str2, Map<String, ? extends Object> map, String str3);
}
