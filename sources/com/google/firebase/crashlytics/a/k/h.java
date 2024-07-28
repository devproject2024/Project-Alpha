package com.google.firebase.crashlytics.a.k;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.firebase.crashlytics.a.c.q;
import com.google.firebase.crashlytics.a.k.a.b;
import com.google.firebase.crashlytics.a.k.a.c;
import com.google.firebase.crashlytics.a.k.a.d;
import com.google.firebase.crashlytics.a.k.a.f;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

final class h implements g {
    h() {
    }

    public final f a(q qVar, JSONObject jSONObject) throws JSONException {
        String str;
        long j;
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt("settings_version", 0);
        int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("fabric");
        JSONObject jSONObject4 = jSONObject2.getJSONObject(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        String string = jSONObject4.getString("status");
        boolean equals = "new".equals(string);
        String string2 = jSONObject3.getString("bundle_id");
        String string3 = jSONObject3.getString("org_id");
        if (equals) {
            str = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
        } else {
            str = String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", new Object[]{string2});
        }
        b bVar = new b(string, str, String.format(Locale.US, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", new Object[]{string2}), String.format(Locale.US, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", new Object[]{string2}), string2, string3, jSONObject4.optBoolean("update_required", false), jSONObject4.optInt("report_upload_variant", 0), jSONObject4.optInt("native_report_upload_variant", 0));
        d dVar = new d(8);
        c cVar = new c(jSONObject2.getJSONObject("features").optBoolean("collect_reports", true));
        long j2 = (long) optInt2;
        if (jSONObject2.has("expires_at")) {
            j = jSONObject2.optLong("expires_at");
        } else {
            j = qVar.a() + (j2 * 1000);
        }
        return new f(j, bVar, dVar, cVar, optInt, optInt2);
    }
}
