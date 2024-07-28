package net.one97.paytm.phoenix.provider;

import android.content.Context;
import com.alibaba.a.e;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.j.a;

public final class PaytmH5BridgeInterceptProviderImpl implements PhoenixBridgeInterceptorProvider {
    public final void onBridgeCalled(Context context, String str, String str2, String str3, boolean z, String str4) {
        Map map;
        k.c(context, "context");
        k.c(str3, "appUniqueId");
        if (k.a((Object) str, (Object) "paytmPayment")) {
            map = new HashMap();
            try {
                Object obj = e.parseObject(str2).get("mid");
                if (obj != null) {
                    map.put("mid", (String) obj);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else {
            map = null;
        }
        String str5 = str;
        String str6 = str3;
        a.a(str5, str6, H5PartnerAppsDataProvider.getAppName(str3), (Map<String, Object>) map, context, str4);
    }
}
