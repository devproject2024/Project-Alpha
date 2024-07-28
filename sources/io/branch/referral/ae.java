package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import io.branch.referral.m;
import org.json.JSONException;
import org.json.JSONObject;

final class ae extends z {

    /* renamed from: h  reason: collision with root package name */
    c.d f46429h;

    public final boolean a() {
        return false;
    }

    public final String n() {
        return "install";
    }

    ae(Context context) {
        super(context, m.d.RegisterInstall.getPath());
        this.f46429h = null;
        try {
            a(new JSONObject());
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f46577f = true;
        }
    }

    ae(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void j() {
        super.j();
        long c2 = q.c("bnc_referrer_click_ts");
        long c3 = q.c("bnc_install_begin_ts");
        if (c2 > 0) {
            try {
                this.f46573b.put(m.a.ClickedReferrerTimeStamp.getKey(), c2);
            } catch (JSONException unused) {
                return;
            }
        }
        if (c3 > 0) {
            this.f46573b.put(m.a.InstallBeginTimeStamp.getKey(), c3);
        }
        if (!p.a().equals("bnc_no_value")) {
            this.f46573b.put(m.a.LinkClickID.getKey(), p.a());
        }
    }

    public final void a(ag agVar, c cVar) {
        super.a(agVar, cVar);
        try {
            q.a("bnc_user_url", agVar.a().getString(m.a.Link.getKey()));
            if (agVar.a().has(m.a.Data.getKey())) {
                JSONObject jSONObject = new JSONObject(agVar.a().getString(m.a.Data.getKey()));
                if (jSONObject.has(m.a.Clicked_Branch_Link.getKey()) && jSONObject.getBoolean(m.a.Clicked_Branch_Link.getKey()) && q.d("bnc_install_params").equals("bnc_no_value") && q.f() == 1) {
                    q.a("bnc_install_params", agVar.a().getString(m.a.Data.getKey()));
                }
            }
            if (agVar.a().has(m.a.LinkClickID.getKey())) {
                q.a("bnc_link_click_id", agVar.a().getString(m.a.LinkClickID.getKey()));
            } else {
                q.a("bnc_link_click_id", "bnc_no_value");
            }
            if (agVar.a().has(m.a.Data.getKey())) {
                q.a("bnc_session_params", agVar.a().getString(m.a.Data.getKey()));
            } else {
                q.a("bnc_session_params", "bnc_no_value");
            }
            if (this.f46429h != null) {
                cVar.g();
            }
            q.a("bnc_app_version", ah.a(n.a().f46549b));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b(agVar, cVar);
    }

    public final void a(int i2, String str) {
        if (this.f46429h != null) {
            try {
                new JSONObject().put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new f("Trouble initializing Branch. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46429h = null;
    }
}
