package net.one97.paytm.fastag.dependencies;

import com.google.gson.f;
import com.google.gsonhtcfix.c.a;
import net.one97.paytm.fastag.model.RiskExtendedInfo;

public final class p {

    /* renamed from: c  reason: collision with root package name */
    private static p f13754c;

    /* renamed from: a  reason: collision with root package name */
    public RiskExtendedInfo f13755a = new RiskExtendedInfo();

    /* renamed from: b  reason: collision with root package name */
    public boolean f13756b;

    p() {
    }

    public static p a() {
        if (f13754c == null) {
            f13754c = new p();
        }
        return f13754c;
    }

    public final void b() {
        f13754c = null;
        this.f13755a = null;
    }

    public final String c() {
        if (this.f13755a != null) {
            try {
                return new f().a((Object) a().f13755a, new a<RiskExtendedInfo>() {
                }.getType());
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
