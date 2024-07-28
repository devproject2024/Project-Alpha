package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class i extends f<PointF> {

    /* renamed from: e  reason: collision with root package name */
    private final PointF f5768e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private final float[] f5769f = new float[2];

    /* renamed from: g  reason: collision with root package name */
    private h f5770g;

    /* renamed from: h  reason: collision with root package name */
    private PathMeasure f5771h = new PathMeasure();

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f2) {
        h hVar = (h) aVar;
        Path path = hVar.f5767a;
        if (path == null) {
            return (PointF) aVar.f6135b;
        }
        if (this.f5752d != null) {
            PointF pointF = (PointF) this.f5752d.a(hVar.f6138e, hVar.f6139f.floatValue(), hVar.f6135b, hVar.f6136c, c(), f2, g());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f5770g != hVar) {
            this.f5771h.setPath(path, false);
            this.f5770g = hVar;
        }
        PathMeasure pathMeasure = this.f5771h;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f5769f, (float[]) null);
        PointF pointF2 = this.f5768e;
        float[] fArr = this.f5769f;
        pointF2.set(fArr[0], fArr[1]);
        return this.f5768e;
    }
}
