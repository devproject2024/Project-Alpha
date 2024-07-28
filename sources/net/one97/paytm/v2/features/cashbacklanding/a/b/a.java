package net.one97.paytm.v2.features.cashbacklanding.a.b;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.v2.features.cashbackoffers.b.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final int f20126a;

    public a(int i2) {
        this.f20126a = i2;
    }

    public static b a(f fVar) {
        k.c(fVar, "remoteDataSource");
        return new b(fVar);
    }

    public static net.one97.paytm.v2.features.cashbackoffers.b.f a(Context context) {
        k.c(context, "context");
        return new net.one97.paytm.v2.features.cashbackoffers.b.f(new d(context));
    }
}
