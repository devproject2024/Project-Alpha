package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import io.branch.referral.m;
import org.json.JSONException;
import org.json.JSONObject;

final class y extends s {

    /* renamed from: h  reason: collision with root package name */
    c.d f46605h;

    /* renamed from: i  reason: collision with root package name */
    String f46606i = null;

    public final boolean a() {
        return false;
    }

    public final boolean c() {
        return true;
    }

    public y(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(int i2, String str) {
        if (this.f46605h != null) {
            try {
                new JSONObject().put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new f("Trouble setting the user alias. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46605h = null;
    }

    public final void a(ag agVar, c cVar) {
        try {
            if (this.f46573b != null && this.f46573b.has(m.a.Identity.getKey())) {
                q.a("bnc_identity", this.f46573b.getString(m.a.Identity.getKey()));
            }
            q.a("bnc_identity_id", agVar.a().getString(m.a.IdentityID.getKey()));
            q.a("bnc_user_url", agVar.a().getString(m.a.Link.getKey()));
            if (agVar.a().has(m.a.ReferringData.getKey())) {
                q.a("bnc_install_params", agVar.a().getString(m.a.ReferringData.getKey()));
            }
            if (this.f46605h != null) {
                cVar.a(c.a(q.d("bnc_install_params")));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
