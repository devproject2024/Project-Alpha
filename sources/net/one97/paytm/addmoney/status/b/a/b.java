package net.one97.paytm.addmoney.status.b.a;

import net.one97.paytm.addmoney.status.b.a.b.a;

public final class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static b f48639b;

    /* renamed from: a  reason: collision with root package name */
    public final a f48640a;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.addmoney.status.b.a.a.a f48641c;

    private b(net.one97.paytm.addmoney.status.b.a.a.a aVar, a aVar2) {
        this.f48641c = aVar;
        this.f48640a = aVar2;
    }

    public static b a(net.one97.paytm.addmoney.status.b.a.a.a aVar, a aVar2) {
        if (f48639b == null) {
            f48639b = new b(aVar, aVar2);
        }
        return f48639b;
    }

    public final void a(String str) {
        net.one97.paytm.addmoney.status.b.a.a.a.f48637a = null;
        this.f48640a.a(str);
        f48639b = null;
    }
}
