package io.branch.referral;

import android.content.Context;
import io.branch.indexing.a;
import io.branch.referral.m;
import org.json.JSONException;
import org.json.JSONObject;

final class ad extends s {
    public final void a(int i2, String str) {
    }

    public final boolean a() {
        return false;
    }

    public final void b() {
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return false;
    }

    public ad(Context context) {
        super(context, m.d.RegisterClose.getPath());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m.a.DeviceFingerprintID.getKey(), q.d("bnc_device_fingerprint_id"));
            jSONObject.put(m.a.IdentityID.getKey(), q.d("bnc_identity_id"));
            jSONObject.put(m.a.SessionID.getKey(), q.d("bnc_session_id"));
            if (!q.d("bnc_link_click_id").equals("bnc_no_value")) {
                jSONObject.put(m.a.LinkClickID.getKey(), q.d("bnc_link_click_id"));
            }
            JSONObject a2 = a.a().a(context);
            if (a2 != null) {
                jSONObject.put(m.a.ContentDiscovery.getKey(), a2);
            }
            if (n.a() != null) {
                jSONObject.put(m.a.AppVersion.getKey(), ah.a(n.a().f46549b));
            }
            a(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f46577f = true;
        }
    }

    public ad(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(ag agVar, c cVar) {
        q.a("bnc_session_params", "bnc_no_value");
    }
}
