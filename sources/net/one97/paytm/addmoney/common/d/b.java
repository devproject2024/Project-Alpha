package net.one97.paytm.addmoney.common.d;

import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.i;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f48463a;

    /* renamed from: b  reason: collision with root package name */
    private final a f48464b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48465c;

    private b(a aVar, a aVar2) {
        this.f48464b = aVar;
        this.f48465c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f48463a == null) {
            f48463a = new b(aVar, aVar2);
        }
        return f48463a;
    }

    public final void a(String str) {
        this.f48464b.a(str);
        this.f48465c.a(str);
        f48463a = null;
    }

    public final void a(i iVar, String str) {
        this.f48465c.a(iVar, str);
    }

    public final void b(i iVar, String str) {
        this.f48465c.b(iVar, str);
    }

    public final void a(h hVar, String str) {
        this.f48465c.a(hVar, str);
    }

    public final void b(h hVar, String str) {
        this.f48465c.b(hVar, str);
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        this.f48465c.a(hVar, str, str2, i2, str3);
    }

    public final void b(h hVar, String str, String str2, int i2, String str3) {
        this.f48465c.b(hVar, str, str2, i2, str3);
    }

    public final void c(h hVar, String str) {
        this.f48465c.c(hVar, str);
    }

    public final void a(String str, String str2, String str3, h hVar, String str4) {
        this.f48465c.a(str, str2, str3, hVar, str4);
    }

    public final void a(String str, String str2, String str3, h hVar) {
        this.f48465c.a(str, str2, str3, hVar);
    }

    public final void a(String str, String str2, h hVar) {
        this.f48465c.a(str, str2, hVar);
    }

    public final void a(String str, h hVar) {
        this.f48465c.a(str, hVar);
    }
}
