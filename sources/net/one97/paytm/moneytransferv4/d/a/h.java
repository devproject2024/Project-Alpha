package net.one97.paytm.moneytransferv4.d.a;

import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.passbook.b.a.a;

public final class h implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<net.one97.paytm.upi.passbook.b.a.b.a> f55385a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<net.one97.paytm.upi.passbook.b.a.a.a> f55386b;

    public h(javax.a.a<net.one97.paytm.upi.passbook.b.a.b.a> aVar, javax.a.a<net.one97.paytm.upi.passbook.b.a.a.a> aVar2) {
        this.f55385a = aVar;
        this.f55386b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.a(this.f55385a.get(), this.f55386b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
