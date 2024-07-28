package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import java.util.Collections;

public final class m extends a<PointF, PointF> {

    /* renamed from: e  reason: collision with root package name */
    private final PointF f5776e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private final a<Float, Float> f5777f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Float, Float> f5778g;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f5777f = aVar;
        this.f5778g = aVar2;
        a(g());
    }

    public final void a(float f2) {
        this.f5777f.a(f2);
        this.f5778g.a(f2);
        this.f5776e.set(this.f5777f.f().floatValue(), this.f5778g.f().floatValue());
        for (int i2 = 0; i2 < this.f5749a.size(); i2++) {
            ((a.C0083a) this.f5749a.get(i2)).a();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object a(com.airbnb.lottie.g.a aVar, float f2) {
        return this.f5776e;
    }

    public final /* bridge */ /* synthetic */ Object f() {
        return this.f5776e;
    }
}
