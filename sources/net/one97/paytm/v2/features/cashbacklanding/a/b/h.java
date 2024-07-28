package net.one97.paytm.v2.features.cashbacklanding.a.b;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.d;
import net.one97.paytm.v2.a.e;

public final class h implements c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final e f20135a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.v2.a.c> f20136b;

    public h(e eVar, a<net.one97.paytm.v2.a.c> aVar) {
        this.f20135a = eVar;
        this.f20136b = aVar;
    }

    public final /* synthetic */ Object get() {
        net.one97.paytm.v2.a.c cVar = this.f20136b.get();
        k.c(cVar, "remoteDataSource");
        return (d) g.a(new e(cVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
