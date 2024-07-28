package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    private float b(a<Float> aVar, float f2) {
        if (aVar.f6135b == null || aVar.f6136c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f5752d != null) {
            Float f3 = (Float) this.f5752d.a(aVar.f6138e, aVar.f6139f.floatValue(), aVar.f6135b, aVar.f6136c, f2, c(), g());
            if (f3 != null) {
                return f3.floatValue();
            }
        }
        if (aVar.f6140g == -3987645.8f) {
            aVar.f6140g = ((Float) aVar.f6135b).floatValue();
        }
        float f4 = aVar.f6140g;
        if (aVar.f6141h == -3987645.8f) {
            aVar.f6141h = ((Float) aVar.f6136c).floatValue();
        }
        return g.a(f4, aVar.f6141h, f2);
    }

    public final float h() {
        return b(b(), d());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(a aVar, float f2) {
        return Float.valueOf(b(aVar, f2));
    }
}
