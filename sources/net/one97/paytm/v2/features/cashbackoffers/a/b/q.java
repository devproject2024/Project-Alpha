package net.one97.paytm.v2.features.cashbackoffers.a.b;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.d;
import net.one97.paytm.v2.a.e;

public final class q implements c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f20343a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.v2.a.c> f20344b;

    public q(n nVar, a<net.one97.paytm.v2.a.c> aVar) {
        this.f20343a = nVar;
        this.f20344b = aVar;
    }

    public final /* synthetic */ Object get() {
        net.one97.paytm.v2.a.c cVar = this.f20344b.get();
        k.c(cVar, "remoteDataSource");
        return (d) g.a(new e(cVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
