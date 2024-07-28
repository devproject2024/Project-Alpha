package net.one97.paytm.v2.features.offerdetail.a.a;

import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.features.offerdetail.b.b;

public final class c implements dagger.a.c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20440a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.v2.features.offerdetail.b.a> f20441b;

    public c(a aVar, a<net.one97.paytm.v2.features.offerdetail.b.a> aVar2) {
        this.f20440a = aVar;
        this.f20441b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (b) g.a(a.a(this.f20441b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
