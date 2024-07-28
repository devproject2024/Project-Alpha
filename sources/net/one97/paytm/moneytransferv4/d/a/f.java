package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.moneytransferv4.d.a.e;
import net.one97.paytm.upi.h.a;

public final class f implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f55382a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<Context> f55383b;

    public f(e eVar, javax.a.a<Context> aVar) {
        this.f55382a = eVar;
        this.f55383b = aVar;
    }

    public final /* synthetic */ Object get() {
        Context context = this.f55383b.get();
        k.c(context, "context");
        a a2 = a.a(context, new e.a());
        k.a((Object) a2, "NpciServices.getInstance…\n            }\n        })");
        return (a) g.a(a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
