package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import io.branch.referral.m;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

final class aa extends s {

    /* renamed from: h  reason: collision with root package name */
    private c.h f46420h;

    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return false;
    }

    public aa(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(ag agVar, c cVar) {
        try {
            q.a("bnc_session_id", agVar.a().getString(m.a.SessionID.getKey()));
            q.a("bnc_identity_id", agVar.a().getString(m.a.IdentityID.getKey()));
            q.a("bnc_user_url", agVar.a().getString(m.a.Link.getKey()));
            q.a("bnc_install_params", "bnc_no_value");
            q.a("bnc_session_params", "bnc_no_value");
            q.a("bnc_identity", "bnc_no_value");
            Iterator<String> it2 = q.g().iterator();
            while (it2.hasNext()) {
                q.a(it2.next(), 0);
            }
            q.a((ArrayList<String>) new ArrayList());
            Iterator<String> it3 = q.h().iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                ArrayList<String> h2 = q.h();
                if (!h2.contains(next)) {
                    h2.add(next);
                    q.b(h2);
                }
                q.c("bnc_total_base_".concat(String.valueOf(next)), 0);
                q.c("bnc_balance_base_".concat(String.valueOf(next)), 0);
            }
            q.b((ArrayList<String>) new ArrayList());
            if (this.f46420h == null) {
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (this.f46420h != null) {
            }
        }
    }

    public final void a(int i2, String str) {
        if (this.f46420h != null) {
            new f("Logout error. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46420h = null;
    }
}
