package com.google.firebase.crashlytics.a.k;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.firebase.crashlytics.a.c.q;
import com.google.firebase.crashlytics.a.k.a.c;
import com.google.firebase.crashlytics.a.k.a.d;
import com.google.firebase.crashlytics.a.k.a.f;
import org.json.JSONException;
import org.json.JSONObject;

final class b implements g {
    b() {
    }

    public final f a(q qVar, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt("settings_version", 0);
        int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        JSONObject jSONObject3 = jSONObject2.getJSONObject(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        return new f(a(qVar, (long) optInt2, jSONObject2), new com.google.firebase.crashlytics.a.k.a.b(jSONObject3.getString("status"), jSONObject3.getString("url"), jSONObject3.getString("reports_url"), jSONObject3.getString("ndk_reports_url"), jSONObject3.optBoolean("update_required", false)), b(jSONObject2.getJSONObject("session")), a(jSONObject2.getJSONObject("features")), optInt, optInt2);
    }

    static c a(JSONObject jSONObject) {
        return new c(jSONObject.optBoolean("collect_reports", true));
    }

    static d b(JSONObject jSONObject) {
        return new d(jSONObject.optInt("max_custom_exception_events", 8));
    }

    static long a(q qVar, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return qVar.a() + (j * 1000);
    }
}
