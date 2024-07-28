package com.airbnb.lottie.a.b;

import com.airbnb.lottie.g.a;
import com.airbnb.lottie.g.b;
import com.airbnb.lottie.g.c;
import java.util.Collections;

public final class p<K, A> extends a<K, A> {

    /* renamed from: e  reason: collision with root package name */
    private final b<A> f5788e;

    /* renamed from: f  reason: collision with root package name */
    private final A f5789f;

    /* access modifiers changed from: package-private */
    public final float e() {
        return 1.0f;
    }

    public p(c<A> cVar) {
        this(cVar, (Object) null);
    }

    public p(c<A> cVar, A a2) {
        super(Collections.emptyList());
        this.f5788e = new b<>();
        a(cVar);
        this.f5789f = a2;
    }

    public final void a(float f2) {
        this.f5751c = f2;
    }

    public final void a() {
        if (this.f5752d != null) {
            super.a();
        }
    }

    public final A f() {
        c cVar = this.f5752d;
        A a2 = this.f5789f;
        return cVar.a(0.0f, 0.0f, a2, a2, g(), g(), g());
    }

    /* access modifiers changed from: package-private */
    public final A a(a<K> aVar, float f2) {
        return f();
    }
}
