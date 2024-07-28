package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

public final class x implements ai<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f6060a = new x();

    private x() {
    }

    public final /* synthetic */ Object a(c cVar, float f2) throws IOException {
        c.b f3 = cVar.f();
        if (f3 == c.b.BEGIN_ARRAY) {
            return p.b(cVar, f2);
        }
        if (f3 == c.b.BEGIN_OBJECT) {
            return p.b(cVar, f2);
        }
        if (f3 == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.k()) * f2, ((float) cVar.k()) * f2);
            while (cVar.e()) {
                cVar.m();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(f3)));
    }
}
