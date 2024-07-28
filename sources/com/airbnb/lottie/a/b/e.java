package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    private int b(a<Integer> aVar, float f2) {
        if (aVar.f6135b == null || aVar.f6136c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f5752d != null) {
            Integer num = (Integer) this.f5752d.a(aVar.f6138e, aVar.f6139f.floatValue(), aVar.f6135b, aVar.f6136c, f2, c(), g());
            if (num != null) {
                return num.intValue();
            }
        }
        if (aVar.f6142i == 784923401) {
            aVar.f6142i = ((Integer) aVar.f6135b).intValue();
        }
        int i2 = aVar.f6142i;
        if (aVar.j == 784923401) {
            aVar.j = ((Integer) aVar.f6136c).intValue();
        }
        return g.a(i2, aVar.j, f2);
    }

    public final int h() {
        return b(b(), d());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f2) {
        return Integer.valueOf(b(aVar, f2));
    }
}
