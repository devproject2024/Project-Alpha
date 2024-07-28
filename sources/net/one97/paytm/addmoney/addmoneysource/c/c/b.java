package net.one97.paytm.addmoney.addmoneysource.c.c;

import net.one97.paytm.addmoney.h;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48216a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48217b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48218c;

    private b(a aVar, a aVar2) {
        this.f48217b = aVar;
        this.f48218c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48216a == null) {
            f48216a = new b(aVar, aVar2);
        }
        return f48216a;
    }

    public final void a(String str) {
        this.f48218c.a(str);
        this.f48217b.a(str);
        f48216a = null;
    }

    public final void a(String str, h hVar, String str2) {
        this.f48218c.a(str, hVar, str2);
    }

    public final void a(h hVar, String str) {
        this.f48218c.a(hVar, str);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        this.f48218c.a(hVar, str, str2, i2, str3);
    }
}
