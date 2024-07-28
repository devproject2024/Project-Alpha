package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import com.airbnb.lottie.g.d;
import java.util.List;

public final class k extends f<d> {

    /* renamed from: e  reason: collision with root package name */
    private final d f5773e = new d();

    public k(List<a<d>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f2) {
        if (aVar.f6135b == null || aVar.f6136c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) aVar.f6135b;
        d dVar2 = (d) aVar.f6136c;
        if (this.f5752d != null) {
            d dVar3 = (d) this.f5752d.a(aVar.f6138e, aVar.f6139f.floatValue(), dVar, dVar2, f2, c(), g());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        d dVar4 = this.f5773e;
        float a2 = g.a(dVar.f6153a, dVar2.f6153a, f2);
        float a3 = g.a(dVar.f6154b, dVar2.f6154b, f2);
        dVar4.f6153a = a2;
        dVar4.f6154b = a3;
        return this.f5773e;
    }
}
