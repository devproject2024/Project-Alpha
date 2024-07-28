package net.one97.paytm.h5.b;

import java.util.List;
import java.util.Map;
import net.one97.paytm.dynamic.module.h5sdk.PaytmH5GtmDataLoader;
import net.one97.paytm.h5paytmsdk.c.ae;

public final class j implements ae {
    public final String a(String str) {
        return PaytmH5GtmDataLoader.getInstance().getAppsData().get(str);
    }

    public final Map<String, String> a() {
        return PaytmH5GtmDataLoader.getInstance().getAppsData();
    }

    public final boolean b(String str) {
        return a(str, "whitelisted_aids_auth");
    }

    public static boolean a(String str, String str2) {
        List<String> whitelistAid = PaytmH5GtmDataLoader.getInstance().getWhitelistAid(str2);
        if (whitelistAid != null) {
            return whitelistAid.contains(str);
        }
        return false;
    }

    public final boolean c(String str) {
        return PaytmH5GtmDataLoader.getInstance().isDomainWhitelisted(str);
    }
}
