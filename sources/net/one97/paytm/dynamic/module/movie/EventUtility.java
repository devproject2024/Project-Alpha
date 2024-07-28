package net.one97.paytm.dynamic.module.movie;

import net.one97.paytm.deeplink.k;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class EventUtility {
    private static String DEFAULT_WEEX_JS_VERSION = "v8.5";
    private static String FIX_VERSION = "v1.1";

    public static String getJsVersion() {
        String c2 = k.c();
        if ("release".equalsIgnoreCase(c2)) {
            c.a();
            return getVersion(c.a("weex_events_pdp_v3", (String) null));
        } else if (SDKConstants.KEY_STAGING_API.equalsIgnoreCase(c2)) {
            c.a();
            return getVersion(c.a("debug_weex_events_pdp_v3", (String) null));
        } else if (!"debug".equalsIgnoreCase(c2)) {
            return DEFAULT_WEEX_JS_VERSION;
        } else {
            c.a();
            return getVersion(c.a("debug_weex_events_pdp_v3", (String) null));
        }
    }

    public static String getFixVersion() {
        return FIX_VERSION;
    }

    private static String getVersion(String str) {
        String[] split = str.split("/");
        if (split.length > 2) {
            return split[split.length - 2];
        }
        return DEFAULT_WEEX_JS_VERSION;
    }
}
