package com.google.android.material.bottomappbar;

import com.google.android.material.k.f;
import com.google.android.material.k.o;

public final class a extends f implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    float f35951a;

    /* renamed from: b  reason: collision with root package name */
    float f35952b;

    /* renamed from: c  reason: collision with root package name */
    float f35953c;

    /* renamed from: d  reason: collision with root package name */
    float f35954d;

    /* renamed from: e  reason: collision with root package name */
    float f35955e = 0.0f;

    public a(float f2, float f3, float f4) {
        this.f35952b = f2;
        this.f35951a = f3;
        a(f4);
    }

    public final void a(float f2, float f3, float f4, o oVar) {
        float f5 = f2;
        o oVar2 = oVar;
        float f6 = this.f35953c;
        if (f6 == 0.0f) {
            oVar2.b(f5, 0.0f);
            return;
        }
        float f7 = ((this.f35952b * 2.0f) + f6) / 2.0f;
        float f8 = f4 * this.f35951a;
        float f9 = f3 + this.f35955e;
        float f10 = (this.f35954d * f4) + ((1.0f - f4) * f7);
        if (f10 / f7 >= 1.0f) {
            oVar2.b(f5, 0.0f);
            return;
        }
        float f11 = f7 + f8;
        float f12 = f10 + f8;
        float sqrt = (float) Math.sqrt((double) ((f11 * f11) - (f12 * f12)));
        float f13 = f9 - sqrt;
        float f14 = f9 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f12)));
        float f15 = 90.0f - degrees;
        oVar2.b(f13, 0.0f);
        float f16 = f8 * 2.0f;
        float f17 = degrees;
        oVar.a(f13 - f8, 0.0f, f13 + f8, f16, 270.0f, degrees);
        oVar.a(f9 - f7, (-f7) - f10, f9 + f7, f7 - f10, 180.0f - f15, (f15 * 2.0f) - 180.0f);
        oVar.a(f14 - f8, 0.0f, f14 + f8, f16, 270.0f - f17, f17);
        oVar2.b(f5, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (f2 >= 0.0f) {
            this.f35954d = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }
}
