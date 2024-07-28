package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.i;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.g.a;
import java.util.Collections;
import java.util.List;

public final class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f5810a;

    public e() {
        this.f5810a = Collections.singletonList(new a(new PointF(0.0f, 0.0f)));
    }

    public e(List<a<PointF>> list) {
        this.f5810a = list;
    }

    public final List<a<PointF>> c() {
        return this.f5810a;
    }

    public final boolean b() {
        return this.f5810a.size() == 1 && this.f5810a.get(0).d();
    }

    public final com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        if (this.f5810a.get(0).d()) {
            return new j(this.f5810a);
        }
        return new i(this.f5810a);
    }
}
