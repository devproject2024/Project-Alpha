package net.one97.paytm.v2.features.cashbacklanding.a.b;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import net.one97.paytm.v2.features.cashbackoffers.b.f;

public final class d implements c<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20131a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20132b;

    public d(a aVar, a<Context> aVar2) {
        this.f20131a = aVar;
        this.f20132b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return (f) g.a(a.a(this.f20132b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
