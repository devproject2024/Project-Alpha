package net.one97.paytm.dynamic.module.h5sdk;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.j.c;

public class PaytmH5GtmDataLoader {
    private static PaytmH5GtmDataLoader instance = new PaytmH5GtmDataLoader();

    public static PaytmH5GtmDataLoader getInstance() {
        return instance;
    }

    private PaytmH5GtmDataLoader() {
    }

    public Map<String, String> getAppsData() {
        Map<String, String> ad = c.a().ad();
        if (ad == null) {
            ad = new HashMap<>();
        }
        Map<String, String> ae = c.a().ae();
        if (ae != null) {
            ad.putAll(ae);
        }
        return ad;
    }

    public List<String> getWhitelistAid(String str) {
        return c.a().d(str);
    }

    public boolean isDomainWhitelisted(String str) {
        if (!TextUtils.isEmpty(str)) {
            String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
            c.a();
            List<String> E = c.E();
            if (E != null) {
                for (int i2 = 0; i2 < E.size(); i2++) {
                    if (!TextUtils.isEmpty(E.get(i2)) && uri.contains(E.get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
