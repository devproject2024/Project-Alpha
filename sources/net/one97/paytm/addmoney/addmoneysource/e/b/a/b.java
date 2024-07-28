package net.one97.paytm.addmoney.addmoneysource.e.b.a;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48287a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48288b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48289c;

    private b(a aVar, a aVar2) {
        this.f48288b = aVar;
        this.f48289c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48287a == null) {
            f48287a = new b(aVar, aVar2);
        }
        return f48287a;
    }

    public final void a(String str) {
        this.f48288b.a(str);
        this.f48289c.a(str);
        f48287a = null;
    }

    public final void a(String str, String str2, String str3, String str4, h hVar) {
        this.f48289c.a(str, str2, str3, str4, hVar);
    }
}
