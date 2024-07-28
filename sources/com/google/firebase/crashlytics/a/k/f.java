package com.google.firebase.crashlytics.a.k;

import com.google.firebase.crashlytics.a.c.q;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final q f38700a;

    public f(q qVar) {
        this.f38700a = qVar;
    }

    public final com.google.firebase.crashlytics.a.k.a.f a(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.f38700a, jSONObject);
    }

    private static g a(int i2) {
        if (i2 != 3) {
            return new b();
        }
        return new h();
    }
}
