package net.one97.paytm.landingpage.utils.croptool;

import android.graphics.RectF;

final class e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f52994a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    float f52995b;

    /* renamed from: c  reason: collision with root package name */
    float f52996c;

    /* renamed from: d  reason: collision with root package name */
    float f52997d;

    /* renamed from: e  reason: collision with root package name */
    float f52998e;

    /* renamed from: f  reason: collision with root package name */
    float f52999f;

    /* renamed from: g  reason: collision with root package name */
    float f53000g;

    /* renamed from: h  reason: collision with root package name */
    float f53001h;

    /* renamed from: i  reason: collision with root package name */
    float f53002i;
    float j = 1.0f;
    float k = 1.0f;
    private final RectF l = new RectF();

    static boolean c(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f6 && f3 > f5 && f3 < f7;
    }

    e() {
    }

    public final RectF a() {
        this.l.set(this.f52994a);
        return this.l;
    }

    public final float b() {
        return Math.max(this.f52995b, this.f52999f / this.j);
    }

    public final float c() {
        return Math.max(this.f52996c, this.f53000g / this.k);
    }

    public final float d() {
        return Math.min(this.f52997d, this.f53001h / this.j);
    }

    public final float e() {
        return Math.min(this.f52998e, this.f53002i / this.k);
    }

    public final void a(RectF rectF) {
        this.f52994a.set(rectF);
    }

    public final boolean f() {
        return this.f52994a.width() >= 100.0f && this.f52994a.height() >= 100.0f;
    }

    static boolean a(float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f2 - f4) <= f6 && Math.abs(f3 - f5) <= f6;
    }

    static boolean a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f5 && Math.abs(f3 - f6) <= f7;
    }

    static boolean b(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.abs(f2 - f4) <= f7 && f3 > f5 && f3 < f6;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return !f();
    }
}
