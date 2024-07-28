package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    private int b(a<Integer> aVar, float f2) {
        if (aVar.f6135b == null || aVar.f6136c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.f6135b).intValue();
        int intValue2 = ((Integer) aVar.f6136c).intValue();
        if (this.f5752d != null) {
            Integer num = (Integer) this.f5752d.a(aVar.f6138e, aVar.f6139f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, c(), g());
            if (num != null) {
                return num.intValue();
            }
        }
        return com.airbnb.lottie.f.b.a(g.b(f2, 0.0f, 1.0f), intValue, intValue2);
    }

    public final int h() {
        return b(b(), d());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f2) {
        return Integer.valueOf(b(aVar, f2));
    }
}
