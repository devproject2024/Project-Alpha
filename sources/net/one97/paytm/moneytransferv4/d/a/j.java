package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.passbook.b.a.b.a;

public final class j implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<Context> f55388a;

    public j(javax.a.a<Context> aVar) {
        this.f55388a = aVar;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.f(this.f55388a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
