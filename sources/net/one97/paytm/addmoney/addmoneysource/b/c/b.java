package net.one97.paytm.addmoney.addmoneysource.b.c;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48190a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48191b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48192c;

    private b(a aVar, a aVar2) {
        this.f48191b = aVar;
        this.f48192c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48190a == null) {
            f48190a = new b(aVar, aVar2);
        }
        return f48190a;
    }

    public final void a(String str) {
        this.f48191b.a(str);
        this.f48192c.a(str);
        f48190a = null;
    }

    public final void a(h hVar, String str) {
        this.f48192c.a(hVar, str);
    }
}
