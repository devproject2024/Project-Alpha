package net.one97.paytm.v2.features.cashbackoffers.a.b;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.v2.a.f;

public final class h implements c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final f f20331a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f> f20332b;

    public h(f fVar, a<f> aVar) {
        this.f20331a = fVar;
        this.f20332b = aVar;
    }

    public final /* synthetic */ Object get() {
        return (b) g.a(f.a(this.f20332b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
