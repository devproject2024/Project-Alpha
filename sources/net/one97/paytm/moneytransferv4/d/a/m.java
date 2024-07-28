package net.one97.paytm.moneytransferv4.d.a;

import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.b;

public final class m implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<net.one97.paytm.upi.profile.b.b.a> f55391a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<net.one97.paytm.upi.profile.b.a.a> f55392b;

    /* renamed from: c  reason: collision with root package name */
    private final javax.a.a<b> f55393c;

    public m(javax.a.a<net.one97.paytm.upi.profile.b.b.a> aVar, javax.a.a<net.one97.paytm.upi.profile.b.a.a> aVar2, javax.a.a<b> aVar3) {
        this.f55391a = aVar;
        this.f55392b = aVar2;
        this.f55393c = aVar3;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.a(this.f55391a.get(), this.f55392b.get(), this.f55393c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
