package net.one97.paytm.verifier.a;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.utility.k;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.verifier.CJRVerifierDoView;
import net.one97.paytm.j.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessToken", "234567a");
        jSONObject.put("reqTime", d());
        jSONObject.put("reqMsgId", c());
        jSONObject.put("clientSecret", b());
        jSONObject.put("clientId", a());
        jSONObject.put("function", str);
        jSONObject.put("version", "fixed-a");
        return jSONObject;
    }

    private static String a() {
        return c.a() ? "2018040508184500175622" : "2017090121251700085138";
    }

    private static String b() {
        if (c.a()) {
            return "HNkkbmqyXD2IWyO1QhObMCWDWnSLfqTA";
        }
        if (k.b()) {
            return "9a071762-a499-4bd9-914a-4361e7c3f4bc";
        }
        return com.paytm.utility.b.l();
    }

    private static String c() {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return UUID.randomUUID().toString() + format;
    }

    private static String d() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date());
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, String str, String str2) {
        String str3;
        c.a();
        String P = c.P();
        if (URLUtil.isValidUrl(P)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            try {
                str3 = a(context, str, str2);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
                str3 = "";
            }
            d.a(context, P, bVar, hashMap, (Map<String, String>) null, a.C0715a.POST, str3, new CJRVerifierDoView(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    private static String a(Context context, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("verifyId", str);
        jSONObject.put("method", str2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("head", a("alipayplus.risk.identify.doView"));
        jSONObject2.put("body", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("request", jSONObject2);
        jSONObject3.put("signature", a.a(context, jSONObject2.toString()));
        return jSONObject3.toString();
    }
}
