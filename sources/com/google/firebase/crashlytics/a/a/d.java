package com.google.firebase.crashlytics.a.a;

import android.os.Bundle;
import com.google.firebase.crashlytics.a.b.a;
import com.google.firebase.crashlytics.a.b.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b, b {

    /* renamed from: a  reason: collision with root package name */
    private a f38142a;

    public final void b(String str, Bundle bundle) {
        a aVar = this.f38142a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + a(str, bundle));
            } catch (JSONException unused) {
                com.google.firebase.crashlytics.a.b.a().a(5);
            }
        }
    }

    public final void a(a aVar) {
        this.f38142a = aVar;
        com.google.firebase.crashlytics.a.b.a().a(3);
    }

    private static String a(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
