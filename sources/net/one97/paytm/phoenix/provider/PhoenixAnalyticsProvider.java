package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.Map;

public interface PhoenixAnalyticsProvider {
    void sendAnalytics(Context context, String str, String str2, Map<String, ? extends Object> map, String str3, boolean z);
}
