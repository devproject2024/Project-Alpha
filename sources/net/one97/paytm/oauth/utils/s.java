package net.one97.paytm.oauth.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.c;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f56801a = new s();

    private s() {
    }

    public static HashMap<String, String> a() {
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        c a2 = OauthModule.a();
        k.a((Object) a2, "OauthModule.getConfig()");
        String b3 = a2.b();
        k.a((Object) b3, "OauthModule.getConfig().authorizationValue");
        map.put("Authorization", b3);
        o oVar = o.f56791a;
        if (!o.a()) {
            return hashMap;
        }
        b b4 = OauthModule.b();
        k.a((Object) b4, "OauthModule.getOathDataProvider()");
        String Q = com.paytm.utility.b.Q(b4.getApplicationContext());
        k.a((Object) Q, "CJRAppCommonUtility.getA…der().applicationContext)");
        map.put("x-app-version", Q);
        map.put("x-epoch", String.valueOf(System.currentTimeMillis() / 1000));
        try {
            String str = Build.MANUFACTURER;
            k.a((Object) str, "Build.MANUFACTURER");
            hashMap.put("x-device-manufacturer", p.a(str, " ", "_", false));
            String str2 = Build.MODEL;
            k.a((Object) str2, "Build.MODEL");
            hashMap.put("x-device-name", p.a(str2, " ", "_", false));
            hashMap.put(SDKConstants.X_DEVICE_IDENTIFIER, l.a());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.s(applicationContext))) {
            String s = com.paytm.utility.b.s(applicationContext);
            k.a((Object) s, "CJRAppCommonUtility.getL…itudeFromPref(appContext)");
            map.put("x-latitude", s);
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.t(applicationContext))) {
            String t = com.paytm.utility.b.t(applicationContext);
            k.a((Object) t, "CJRAppCommonUtility.getL…itudeFromPref(appContext)");
            map.put("x-longitude", t);
        }
        return hashMap;
    }
}
