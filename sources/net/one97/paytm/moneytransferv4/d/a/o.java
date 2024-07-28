package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.upi.registration.b.a.b.a;

public final class o implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final javax.a.a<Context> f55395a;

    public o(javax.a.a<Context> aVar) {
        this.f55395a = aVar;
    }

    public static a a(Context context) {
        return (a) g.a(g.d(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return a(this.f55395a.get());
    }
}
