package net.one97.paytm.v2.features.cashbackoffers.a.b;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.features.cashbackoffers.b.f;

public final class i implements c<f> {

    /* renamed from: a  reason: collision with root package name */
    private final f f20333a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20334b;

    public i(f fVar, a<Context> aVar) {
        this.f20333a = fVar;
        this.f20334b = aVar;
    }

    public final /* synthetic */ Object get() {
        return (f) g.a(f.a(this.f20334b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
