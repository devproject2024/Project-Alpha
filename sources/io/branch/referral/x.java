package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

final class x extends s {

    /* renamed from: h  reason: collision with root package name */
    c.e f46604h;

    public final boolean a() {
        return true;
    }

    public x(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final String f() {
        return super.f() + q.d("bnc_identity_id");
    }

    public final void a(ag agVar, c cVar) {
        Iterator<String> keys = agVar.a().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                int i2 = agVar.a().getInt(next);
                q.b(next);
                q.a(next, i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(int i2, String str) {
        if (this.f46604h != null) {
            new f("Trouble retrieving user credits. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46604h = null;
    }
}
