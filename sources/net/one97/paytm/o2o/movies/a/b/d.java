package net.one97.paytm.o2o.movies.a.b;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.e.a;

public final class d implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f73880a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<Context> f73881b;

    public d(c cVar, javax.a.a<Context> aVar) {
        this.f73880a = cVar;
        this.f73881b = aVar;
    }

    public final /* synthetic */ Object get() {
        Context context = this.f73881b.get();
        k.c(context, "context");
        return (a) g.a(new a(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
