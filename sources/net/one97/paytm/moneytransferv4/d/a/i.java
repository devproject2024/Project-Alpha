package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.passbook.b.a.a.a;

public final class i implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<Context> f55387a;

    public i(javax.a.a<Context> aVar) {
        this.f55387a = aVar;
    }

    public final /* synthetic */ Object get() {
        return (a) g.a(g.e(this.f55387a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
