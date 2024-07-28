package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

public final class l extends a<com.airbnb.lottie.c.b.l, Path> {

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.c.b.l f5774e = new com.airbnb.lottie.c.b.l();

    /* renamed from: f  reason: collision with root package name */
    private final Path f5775f = new Path();

    public l(List<a<com.airbnb.lottie.c.b.l>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(a aVar, float f2) {
        com.airbnb.lottie.c.b.l lVar = (com.airbnb.lottie.c.b.l) aVar.f6135b;
        com.airbnb.lottie.c.b.l lVar2 = (com.airbnb.lottie.c.b.l) aVar.f6136c;
        com.airbnb.lottie.c.b.l lVar3 = this.f5774e;
        if (lVar3.f5888b == null) {
            lVar3.f5888b = new PointF();
        }
        lVar3.f5889c = lVar.f5889c || lVar2.f5889c;
        if (lVar.f5887a.size() != lVar2.f5887a.size()) {
            d.a("Curves must have the same number of control points. Shape 1: " + lVar.f5887a.size() + "\tShape 2: " + lVar2.f5887a.size());
        }
        int min = Math.min(lVar.f5887a.size(), lVar2.f5887a.size());
        if (lVar3.f5887a.size() < min) {
            for (int size = lVar3.f5887a.size(); size < min; size++) {
                lVar3.f5887a.add(new com.airbnb.lottie.c.a());
            }
        } else if (lVar3.f5887a.size() > min) {
            for (int size2 = lVar3.f5887a.size() - 1; size2 >= min; size2--) {
                lVar3.f5887a.remove(lVar3.f5887a.size() - 1);
            }
        }
        PointF pointF = lVar.f5888b;
        PointF pointF2 = lVar2.f5888b;
        float a2 = g.a(pointF.x, pointF2.x, f2);
        float a3 = g.a(pointF.y, pointF2.y, f2);
        if (lVar3.f5888b == null) {
            lVar3.f5888b = new PointF();
        }
        lVar3.f5888b.set(a2, a3);
        for (int size3 = lVar3.f5887a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.c.a aVar2 = lVar.f5887a.get(size3);
            com.airbnb.lottie.c.a aVar3 = lVar2.f5887a.get(size3);
            PointF pointF3 = aVar2.f5807a;
            PointF pointF4 = aVar2.f5808b;
            PointF pointF5 = aVar2.f5809c;
            PointF pointF6 = aVar3.f5807a;
            PointF pointF7 = aVar3.f5808b;
            PointF pointF8 = aVar3.f5809c;
            lVar3.f5887a.get(size3).f5807a.set(g.a(pointF3.x, pointF6.x, f2), g.a(pointF3.y, pointF6.y, f2));
            lVar3.f5887a.get(size3).f5808b.set(g.a(pointF4.x, pointF7.x, f2), g.a(pointF4.y, pointF7.y, f2));
            lVar3.f5887a.get(size3).f5809c.set(g.a(pointF5.x, pointF8.x, f2), g.a(pointF5.y, pointF8.y, f2));
        }
        g.a(this.f5774e, this.f5775f);
        return this.f5775f;
    }
}
