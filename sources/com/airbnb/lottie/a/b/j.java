package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class j extends f<PointF> {

    /* renamed from: e  reason: collision with root package name */
    private final PointF f5772e = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f2) {
        if (aVar.f6135b == null || aVar.f6136c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.f6135b;
        PointF pointF2 = (PointF) aVar.f6136c;
        if (this.f5752d != null) {
            PointF pointF3 = (PointF) this.f5752d.a(aVar.f6138e, aVar.f6139f.floatValue(), pointF, pointF2, f2, c(), g());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.f5772e.set(pointF.x + ((pointF2.x - pointF.x) * f2), pointF.y + (f2 * (pointF2.y - pointF.y)));
        return this.f5772e;
    }
}
