package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import org.json.JSONObject;

final class w extends s {

    /* renamed from: h  reason: collision with root package name */
    c.b f46603h;

    public final void a(ag agVar, c cVar) {
    }

    public final boolean a() {
        return false;
    }

    public w(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(int i2, String str) {
        if (this.f46603h != null) {
            new f("Trouble retrieving user credit history. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46603h = null;
    }
}
