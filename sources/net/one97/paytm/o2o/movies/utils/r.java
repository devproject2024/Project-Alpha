package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.common.b.b;

public final class r {
    public static final void a(Context context) {
        k.c(context, "context");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
            hashMap.put(b.f75007b, b.s);
            hashMap.put(b.f75008c, "City Button Clicked");
            hashMap.put(b.p, b.r);
            if (com.paytm.utility.b.r(context)) {
                hashMap.put(b.q, com.paytm.utility.b.n(context));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(b.f75006a, hashMap, context);
        } catch (Exception unused) {
        }
    }
}
