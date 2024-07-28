package net.one97.paytm.moneytransferv4.d.a;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import net.one97.paytm.upi.registration.b.a.b;

public final class p implements c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<net.one97.paytm.upi.registration.b.a.a.a> f55396a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.upi.registration.b.a.b.a> f55397b;

    /* renamed from: c  reason: collision with root package name */
    private final a<net.one97.paytm.upi.h.a> f55398c;

    public p(a<net.one97.paytm.upi.registration.b.a.a.a> aVar, a<net.one97.paytm.upi.registration.b.a.b.a> aVar2, a<net.one97.paytm.upi.h.a> aVar3) {
        this.f55396a = aVar;
        this.f55397b = aVar2;
        this.f55398c = aVar3;
    }

    public static b a(net.one97.paytm.upi.registration.b.a.a.a aVar, net.one97.paytm.upi.registration.b.a.b.a aVar2, net.one97.paytm.upi.h.a aVar3) {
        return (b) g.a(g.a(aVar, aVar2, aVar3), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return a(this.f55396a.get(), this.f55397b.get(), this.f55398c.get());
    }
}
