package net.one97.paytm.addmoney.addmoneysource.netbanking.c;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48328a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48329b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48330c;

    private b(a aVar, a aVar2) {
        this.f48329b = aVar;
        this.f48330c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48328a == null) {
            f48328a = new b(aVar, aVar2);
        }
        return f48328a;
    }

    public final void a(String str) {
        this.f48329b.a(str);
        this.f48330c.a(str);
        f48328a = null;
    }

    public final void a(h hVar, String str) {
        this.f48330c.a(hVar, str);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        this.f48330c.a(hVar, str, str2, i2, str3);
    }
}
