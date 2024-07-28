package io.branch.referral;

import android.content.Context;
import io.branch.referral.c;
import io.branch.referral.m;
import org.json.JSONException;
import org.json.JSONObject;

final class ac extends s {

    /* renamed from: h  reason: collision with root package name */
    c.e f46427h;

    /* renamed from: i  reason: collision with root package name */
    int f46428i = 0;

    public final boolean a() {
        return false;
    }

    public ac(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public final void a(int i2, String str) {
        if (this.f46427h != null) {
            new f("Trouble redeeming rewards. ".concat(String.valueOf(str)), i2);
        }
    }

    public final void b() {
        this.f46427h = null;
    }

    public final void a(ag agVar, c cVar) {
        JSONObject jSONObject = this.f46573b;
        boolean z = false;
        if (jSONObject != null && jSONObject.has(m.a.Bucket.getKey()) && jSONObject.has(m.a.Amount.getKey())) {
            try {
                int i2 = jSONObject.getInt(m.a.Amount.getKey());
                String string = jSONObject.getString(m.a.Bucket.getKey());
                if (i2 > 0) {
                    z = true;
                }
                q.a(string, q.b(string) - i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f46427h != null && !z) {
            new f("Trouble redeeming rewards.", -107);
        }
    }
}
