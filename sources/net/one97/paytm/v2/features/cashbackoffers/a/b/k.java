package net.one97.paytm.v2.features.cashbackoffers.a.b;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;

public final class k implements c<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final j f20336a;

    private k(j jVar) {
        this.f20336a = jVar;
    }

    public static k a(j jVar) {
        return new k(jVar);
    }

    public static Context b(j jVar) {
        return (Context) g.a(jVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return b(this.f20336a);
    }
}
