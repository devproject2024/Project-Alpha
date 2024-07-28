package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.c.a;
import java.util.ArrayList;
import java.util.List;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f5887a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f5888b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5889c;

    public l(PointF pointF, boolean z, List<a> list) {
        this.f5888b = pointF;
        this.f5889c = z;
        this.f5887a = new ArrayList(list);
    }

    public l() {
        this.f5887a = new ArrayList();
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f5887a.size() + "closed=" + this.f5889c + '}';
    }
}
