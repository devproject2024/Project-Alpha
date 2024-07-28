package net.one97.paytm.phoenix.provider;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.utils.au;

public final class PaytmH5AppAnalyticsProviderImpl implements PaytmH5AppAnalyticsProvider {
    public final void pushDomainToHawkeye(String str, String str2, Context context, String str3) {
        k.c(str, "domain");
        k.c(str2, "appUniqueId");
        k.c(context, "context");
        k.c(str3, "appName");
        q.d(str3);
        au.e eVar = new au.e();
        eVar.a(au.c.ApiLog.stringValue);
        eVar.b(a.c.H5.name());
        eVar.f(str2);
        eVar.d(str);
        eVar.c("domainLog");
        eVar.g(str3);
        eVar.e(au.f.USER_FACING.toString());
        Thread.sleep(2000);
        au.a(eVar, au.c.ApiLog.stringValue, context);
    }

    public final void sendAppAnalytics(Context context, String str, String str2, Map<String, ? extends Object> map, String str3) {
        k.c(context, "context");
        k.c(str2, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str3, "appUniqueId");
        q.d("PaytmH5AppAnalyticsProviderImpl: sendAppAnalytics" + str + str3);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                System.out.println(((String) next.getKey()) + " = " + value);
            }
        }
        net.one97.paytm.j.a.a((Map<String, Object>) map, str2);
    }
}
