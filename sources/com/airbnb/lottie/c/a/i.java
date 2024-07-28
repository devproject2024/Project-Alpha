package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.m;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f5811a;

    /* renamed from: b  reason: collision with root package name */
    private final b f5812b;

    public i(b bVar, b bVar2) {
        this.f5811a = bVar;
        this.f5812b = bVar2;
    }

    public final List<a<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public final boolean b() {
        return this.f5811a.b() && this.f5812b.b();
    }

    public final com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        return new m(this.f5811a.a(), this.f5812b.a());
    }
}
