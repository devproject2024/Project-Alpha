package net.one97.paytm.h5.b;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.h;
import net.one97.paytm.j.a;

public final class o implements h {
    public final void a(Context context, String str, String str2, Map<String, ? extends Object> map, String str3) {
        k.c(context, "context");
        k.c(str2, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str3, "appUniqueId");
        StringBuilder sb = new StringBuilder("PaytmH5AppAnalyticsProviderImpl: sendAppAnalytics");
        sb.append(str);
        sb.append(str3);
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            System.out.println(((String) next.getKey()) + " = " + value);
        }
        a.a((Map<String, Object>) map, str2);
    }
}
