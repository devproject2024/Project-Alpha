package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.j.a;

public final class PaytmH5AnalyticsProviderImpl implements PhoenixAnalyticsProvider {
    public final void sendAnalytics(Context context, String str, String str2, Map<String, ? extends Object> map, String str3, boolean z) {
        k.c(context, "context");
        k.c(str3, "appUniqueId");
        a.a(context, str2, str, (Map<String, Object>) map);
    }
}
