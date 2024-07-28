package net.one97.paytm.v2.features.cashbackoffers.a.b;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import kotlin.g.b.k;

public final class p implements c<net.one97.paytm.v2.a.c> {

    /* renamed from: a  reason: collision with root package name */
    private final n f20341a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20342b;

    public p(n nVar, a<Context> aVar) {
        this.f20341a = nVar;
        this.f20342b = aVar;
    }

    public final /* synthetic */ Object get() {
        Context context = this.f20342b.get();
        k.c(context, "context");
        return (net.one97.paytm.v2.a.c) g.a(new net.one97.paytm.v2.a.c(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
