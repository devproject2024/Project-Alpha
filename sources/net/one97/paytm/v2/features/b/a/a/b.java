package net.one97.paytm.v2.features.b.a.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;

public final class b implements c<net.one97.paytm.v2.a.c> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20068a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20069b;

    public b(a aVar, a<Context> aVar2) {
        this.f20068a = aVar;
        this.f20069b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (net.one97.paytm.v2.a.c) g.a(a.a(this.f20069b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
