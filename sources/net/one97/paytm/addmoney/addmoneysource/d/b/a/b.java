package net.one97.paytm.addmoney.addmoneysource.d.b.a;

import net.one97.paytm.addmoney.i;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48240a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48241b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48242c;

    private b(a aVar, a aVar2) {
        this.f48241b = aVar;
        this.f48242c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48240a == null) {
            f48240a = new b(aVar, aVar2);
        }
        return f48240a;
    }

    public final void a(String str) {
        this.f48241b.a(str);
        this.f48242c.a(str);
        f48240a = null;
    }

    public final void a(i iVar, String str) {
        this.f48242c.a(iVar, str);
    }

    public final boolean b(String str) {
        return this.f48241b.b(str);
    }
}
