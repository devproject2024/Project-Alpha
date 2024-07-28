package net.one97.paytm.recharge.automatic;

import kotlin.g.b.k;
import net.one97.paytm.recharge.di.d;
import net.one97.paytm.recharge.di.f;

public final class b implements net.one97.paytm.recharge.automatic.c.b {

    /* renamed from: a  reason: collision with root package name */
    private d f60236a = f.f62644a.a();

    public final String a(String str) {
        k.c(str, "key");
        return this.f60236a.getString(str);
    }

    public final String a(String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        return this.f60236a.getString(str, str2);
    }

    public final boolean a(String str, boolean z) {
        k.c(str, "key");
        return this.f60236a.getBoolean(str, z);
    }

    public final int a(String str, int i2) {
        k.c(str, "key");
        return this.f60236a.getInteger(str, i2);
    }
}
