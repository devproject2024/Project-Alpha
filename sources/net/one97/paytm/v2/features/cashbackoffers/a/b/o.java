package net.one97.paytm.v2.features.cashbackoffers.a.b;

import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbackoffers.a;

public final class o implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final n f20339a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<net.one97.paytm.v2.features.cashbackoffers.c.a> f20340b;

    public o(n nVar, javax.a.a<net.one97.paytm.v2.features.cashbackoffers.c.a> aVar) {
        this.f20339a = nVar;
        this.f20340b = aVar;
    }

    public final /* synthetic */ Object get() {
        net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20340b.get();
        k.c(aVar, "viewModel");
        return (a) g.a(new a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
