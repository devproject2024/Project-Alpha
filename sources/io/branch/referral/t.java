package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import io.branch.referral.k;
import io.branch.referral.m;
import org.json.JSONException;
import org.json.JSONObject;

final class t extends s {

    /* renamed from: h  reason: collision with root package name */
    private final k.b f46581h = null;

    public final void a(int i2, String str) {
    }

    public final boolean a() {
        return false;
    }

    public final void b() {
    }

    public final boolean c() {
        return true;
    }

    public t(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(ag agVar, c cVar) {
        if (agVar.a() != null && agVar.a().has(m.a.BranchViewData.getKey()) && c.a().n != null && c.a().n.get() != null) {
            String str = "";
            try {
                JSONObject jSONObject = this.f46573b;
                if (jSONObject != null && jSONObject.has(m.a.Event.getKey())) {
                    str = jSONObject.getString(m.a.Event.getKey());
                }
                if (c.a().n != null) {
                    JSONObject jSONObject2 = agVar.a().getJSONObject(m.a.BranchViewData.getKey());
                    k.a().a(jSONObject2, str, (Activity) c.a().n.get(), this.f46581h);
                }
            } catch (JSONException unused) {
                k.b bVar = this.f46581h;
                if (bVar != null) {
                    bVar.d(str);
                }
            }
        }
    }
}
