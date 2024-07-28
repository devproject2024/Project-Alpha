package net.one97.paytm.v2.features.cashbacklanding.a.b;

import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.v2.a.f;

public final class c implements dagger.a.c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20129a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f> f20130b;

    public c(a aVar, a<f> aVar2) {
        this.f20129a = aVar;
        this.f20130b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (b) g.a(a.a(this.f20130b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
