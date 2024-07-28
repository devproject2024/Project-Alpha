package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import java.util.ArrayList;
import java.util.List;

public final class s implements c, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5742a;

    /* renamed from: b  reason: collision with root package name */
    final q.a f5743b;

    /* renamed from: c  reason: collision with root package name */
    public final a<?, Float> f5744c;

    /* renamed from: d  reason: collision with root package name */
    public final a<?, Float> f5745d;

    /* renamed from: e  reason: collision with root package name */
    public final a<?, Float> f5746e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5747f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a.C0083a> f5748g = new ArrayList();

    public final void a(List<c> list, List<c> list2) {
    }

    public s(com.airbnb.lottie.c.c.a aVar, q qVar) {
        this.f5747f = qVar.f5914a;
        this.f5742a = qVar.f5919f;
        this.f5743b = qVar.f5915b;
        this.f5744c = qVar.f5916c.a();
        this.f5745d = qVar.f5917d.a();
        this.f5746e = qVar.f5918e.a();
        aVar.a((a<?, ?>) this.f5744c);
        aVar.a((a<?, ?>) this.f5745d);
        aVar.a((a<?, ?>) this.f5746e);
        this.f5744c.a((a.C0083a) this);
        this.f5745d.a((a.C0083a) this);
        this.f5746e.a((a.C0083a) this);
    }

    public final void a() {
        for (int i2 = 0; i2 < this.f5748g.size(); i2++) {
            this.f5748g.get(i2).a();
        }
    }

    public final String b() {
        return this.f5747f;
    }

    /* access modifiers changed from: package-private */
    public final void a(a.C0083a aVar) {
        this.f5748g.add(aVar);
    }
}
