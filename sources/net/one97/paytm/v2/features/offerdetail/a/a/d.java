package net.one97.paytm.v2.features.offerdetail.a.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.v2.features.offerdetail.b.a;

public final class d implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20442a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<Context> f20443b;

    public d(a aVar, javax.a.a<Context> aVar2) {
        this.f20442a = aVar;
        this.f20443b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(a.a(this.f20443b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
