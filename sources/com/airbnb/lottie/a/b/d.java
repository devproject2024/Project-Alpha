package com.airbnb.lottie.a.b;

import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.f.b;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class d extends f<c> {

    /* renamed from: e  reason: collision with root package name */
    private final c f5763e;

    public d(List<a<c>> list) {
        super(list);
        int i2 = 0;
        c cVar = (c) list.get(0).f6135b;
        i2 = cVar != null ? cVar.f5842b.length : i2;
        this.f5763e = new c(new float[i2], new int[i2]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f2) {
        c cVar = this.f5763e;
        c cVar2 = (c) aVar.f6135b;
        c cVar3 = (c) aVar.f6136c;
        if (cVar2.f5842b.length == cVar3.f5842b.length) {
            for (int i2 = 0; i2 < cVar2.f5842b.length; i2++) {
                cVar.f5841a[i2] = g.a(cVar2.f5841a[i2], cVar3.f5841a[i2], f2);
                cVar.f5842b[i2] = b.a(f2, cVar2.f5842b[i2], cVar3.f5842b[i2]);
            }
            return this.f5763e;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar2.f5842b.length + " vs " + cVar3.f5842b.length + ")");
    }
}
