package net.one97.paytm.paymentsBank.widget.croptool;

import android.graphics.RectF;

final class e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f19735a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    float f19736b;

    /* renamed from: c  reason: collision with root package name */
    float f19737c;

    /* renamed from: d  reason: collision with root package name */
    float f19738d;

    /* renamed from: e  reason: collision with root package name */
    float f19739e;

    /* renamed from: f  reason: collision with root package name */
    float f19740f;

    /* renamed from: g  reason: collision with root package name */
    float f19741g;

    /* renamed from: h  reason: collision with root package name */
    float f19742h;

    /* renamed from: i  reason: collision with root package name */
    float f19743i;
    float j = 1.0f;
    float k = 1.0f;
    private final RectF l = new RectF();

    static boolean c(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 > f4 && f2 < f6 && f3 > f5 && f3 < f7;
    }

    e() {
    }

    public final RectF a() {
        this.l.set(this.f19735a);
        return this.l;
    }

    public final float b() {
        return Math.max(this.f19736b, this.f19740f / this.j);
    }

    public final float c() {
        return Math.max(this.f19737c, this.f19741g / this.k);
    }

    public final float d() {
        return Math.min(this.f19738d, this.f19742h / this.j);
    }

    public final float e() {
        return Math.min(this.f19739e, this.f19743i / this.k);
    }

    public final void a(RectF rectF) {
        this.f19735a.set(rectF);
    }

    public final boolean f() {
        return this.f19735a.width() >= 100.0f && this.f19735a.height() >= 100.0f;
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
