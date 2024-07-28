package com.google.zxing.b;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    final float f39926a;

    /* renamed from: b  reason: collision with root package name */
    final float f39927b;

    /* renamed from: c  reason: collision with root package name */
    final float f39928c;

    /* renamed from: d  reason: collision with root package name */
    final float f39929d;

    /* renamed from: e  reason: collision with root package name */
    final float f39930e;

    /* renamed from: f  reason: collision with root package name */
    final float f39931f;

    /* renamed from: g  reason: collision with root package name */
    final float f39932g;

    /* renamed from: h  reason: collision with root package name */
    final float f39933h;

    /* renamed from: i  reason: collision with root package name */
    final float f39934i;

    private k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f39926a = f2;
        this.f39927b = f5;
        this.f39928c = f8;
        this.f39929d = f3;
        this.f39930e = f6;
        this.f39931f = f9;
        this.f39932g = f4;
        this.f39933h = f7;
        this.f39934i = f10;
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return a(f10, f11, f12, f13, f14, f15, f16, f17).a(b(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    private static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new k((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    private static k b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return a(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    private k a() {
        float f2 = this.f39930e;
        float f3 = this.f39934i;
        float f4 = this.f39931f;
        float f5 = this.f39933h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.f39932g;
        float f8 = this.f39929d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.f39928c;
        float f12 = this.f39927b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.f39926a;
        return new k(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    private k a(k kVar) {
        k kVar2 = kVar;
        float f2 = this.f39926a;
        float f3 = kVar2.f39926a;
        float f4 = this.f39929d;
        float f5 = kVar2.f39927b;
        float f6 = this.f39932g;
        float f7 = kVar2.f39928c;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = kVar2.f39929d;
        float f10 = kVar2.f39930e;
        float f11 = kVar2.f39931f;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = kVar2.f39932g;
        float f14 = kVar2.f39933h;
        float f15 = kVar2.f39934i;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.f39927b;
        float f18 = f16;
        float f19 = this.f39930e;
        float f20 = f12;
        float f21 = this.f39933h;
        float f22 = (f17 * f3) + (f19 * f5) + (f21 * f7);
        float f23 = (f21 * f15) + (f17 * f13) + (f19 * f14);
        float f24 = this.f39928c;
        float f25 = this.f39931f;
        float f26 = (f3 * f24) + (f5 * f25);
        float f27 = this.f39934i;
        float f28 = (f24 * f13) + (f25 * f14) + (f27 * f15);
        return new k(f8, f20, f18, f22, (f17 * f9) + (f19 * f10) + (f21 * f11), f23, (f7 * f27) + f26, (f9 * f24) + (f10 * f25) + (f11 * f27), f28);
    }
}
