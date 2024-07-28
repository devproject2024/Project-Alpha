package net.one97.paytm.v2.features.b.a.a;

import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.a.d;

public final class c implements dagger.a.c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20070a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.v2.a.c> f20071b;

    public c(a aVar, a<net.one97.paytm.v2.a.c> aVar2) {
        this.f20070a = aVar;
        this.f20071b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (d) g.a(a.a(this.f20071b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
