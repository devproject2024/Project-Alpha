package net.one97.paytm.addmoney.addmoneysource.a.c;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48133a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48134b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48135c;

    private b(a aVar, a aVar2) {
        this.f48134b = aVar;
        this.f48135c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48133a == null) {
            f48133a = new b(aVar, aVar2);
        }
        return f48133a;
    }

    public final void a(String str) {
        this.f48135c.a(str);
        this.f48134b.a(str);
        f48133a = null;
    }

    public final void a(h hVar, String str) {
        this.f48135c.a(hVar, str);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        this.f48135c.a(hVar, str, str2, i2, str3);
    }

    public final void a(String str, String str2, h hVar, String str3) {
        this.f48135c.a(str, str2, hVar, str3);
    }
}
