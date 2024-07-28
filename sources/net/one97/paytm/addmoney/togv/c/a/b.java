package net.one97.paytm.addmoney.togv.c.a;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48678a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48679b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48680c;

    private b(a aVar, a aVar2) {
        this.f48679b = aVar;
        this.f48680c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48678a == null) {
            f48678a = new b(aVar, aVar2);
        }
        return f48678a;
    }

    public final void a(String str) {
        this.f48679b.a(str);
        this.f48680c.a(str);
        f48678a = null;
    }

    public final void a(h hVar, String str, String str2) {
        this.f48680c.a(hVar, str, str2);
    }

    public final void a(h hVar, String str, double d2, String str2, boolean z) {
        this.f48680c.a(hVar, str, d2, str2, z);
    }

    public final void a(h hVar, String str, String str2, double d2, String str3, String str4, String str5, boolean z) {
        this.f48680c.a(hVar, str, str2, d2, str3, str4, str5, z);
    }

    public final void a(h hVar, String str, String str2, boolean z) {
        this.f48680c.a(hVar, str, str2, z);
    }

    public final void a(h hVar, String str) {
        this.f48680c.a(hVar, str);
    }
}
