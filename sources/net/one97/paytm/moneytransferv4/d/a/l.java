package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.profile.b.b.a;

public final class l implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<Context> f55390a;

    public l(javax.a.a<Context> aVar) {
        this.f55390a = aVar;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.a(this.f55390a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
