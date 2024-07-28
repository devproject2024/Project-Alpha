package net.one97.paytm.v2.features.cashbacklanding.a.b;

import android.content.Context;
import dagger.a.c;
import javax.a.a;
import kotlin.g.b.k;

public final class g implements c<net.one97.paytm.v2.a.c> {

    /* renamed from: a  reason: collision with root package name */
    private final e f20133a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20134b;

    public g(e eVar, a<Context> aVar) {
        this.f20133a = eVar;
        this.f20134b = aVar;
    }

    public final /* synthetic */ Object get() {
        Context context = this.f20134b.get();
        k.c(context, "context");
        return (net.one97.paytm.v2.a.c) dagger.a.g.a(new net.one97.paytm.v2.a.c(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
