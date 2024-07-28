package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.profile.b.a.a;

public final class k implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<Context> f55389a;

    public k(javax.a.a<Context> aVar) {
        this.f55389a = aVar;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.b(this.f55389a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
