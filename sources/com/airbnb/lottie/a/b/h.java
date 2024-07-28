package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g.a;

public final class h extends a<PointF> {

    /* renamed from: a  reason: collision with root package name */
    Path f5767a;
    private final a<PointF> m;

    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.f6135b, aVar.f6136c, aVar.f6137d, aVar.f6138e, aVar.f6139f);
        this.m = aVar;
        a();
    }

    public final void a() {
        boolean z = (this.f6136c == null || this.f6135b == null || !((PointF) this.f6135b).equals(((PointF) this.f6136c).x, ((PointF) this.f6136c).y)) ? false : true;
        if (this.f6136c != null && !z) {
            this.f5767a = com.airbnb.lottie.f.h.a((PointF) this.f6135b, (PointF) this.f6136c, this.m.k, this.m.l);
        }
    }
}
