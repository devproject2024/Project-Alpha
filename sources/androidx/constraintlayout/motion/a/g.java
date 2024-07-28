package androidx.constraintlayout.motion.a;

import androidx.constraintlayout.motion.widget.o;

public final class g extends o {

    /* renamed from: a  reason: collision with root package name */
    private float f2229a;

    /* renamed from: b  reason: collision with root package name */
    private float f2230b;

    /* renamed from: c  reason: collision with root package name */
    private float f2231c;

    /* renamed from: d  reason: collision with root package name */
    private float f2232d;

    /* renamed from: e  reason: collision with root package name */
    private float f2233e;

    /* renamed from: f  reason: collision with root package name */
    private float f2234f;

    /* renamed from: g  reason: collision with root package name */
    private float f2235g;

    /* renamed from: h  reason: collision with root package name */
    private float f2236h;

    /* renamed from: i  reason: collision with root package name */
    private float f2237i;
    private int j;
    private String k;
    private boolean l = false;
    private float m;
    private float n;

    private float a(float f2) {
        float f3 = this.f2232d;
        if (f2 <= f3) {
            float f4 = this.f2229a;
            return f4 + (((this.f2230b - f4) * f2) / f3);
        }
        int i2 = this.j;
        if (i2 == 1) {
            return 0.0f;
        }
        float f5 = f2 - f3;
        float f6 = this.f2233e;
        if (f5 < f6) {
            float f7 = this.f2230b;
            return f7 + (((this.f2231c - f7) * f5) / f6);
        } else if (i2 == 2) {
            return this.f2236h;
        } else {
            float f8 = f5 - f6;
            float f9 = this.f2234f;
            if (f8 >= f9) {
                return this.f2237i;
            }
            float f10 = this.f2231c;
            return f10 - ((f8 * f10) / f9);
        }
    }

    public final void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.m = f2;
        this.l = f2 > f3;
        if (this.l) {
            a(-f4, f2 - f3, f6, f7, f5);
        } else {
            a(f4, f3 - f2, f6, f7, f5);
        }
    }

    public final float a() {
        return this.l ? -a(this.n) : a(this.n);
    }

    private void a(float f2, float f3, float f4, float f5, float f6) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.f2229a = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4));
            if (sqrt < f5) {
                this.k = "backward accelerate, decelerate";
                this.j = 2;
                this.f2229a = f2;
                this.f2230b = sqrt;
                this.f2231c = 0.0f;
                this.f2232d = (sqrt - f2) / f4;
                this.f2233e = sqrt / f4;
                this.f2235g = ((f2 + sqrt) * this.f2232d) / 2.0f;
                this.f2236h = f3;
                this.f2237i = f3;
                return;
            }
            this.k = "backward accelerate cruse decelerate";
            this.j = 3;
            this.f2229a = f2;
            this.f2230b = f5;
            this.f2231c = f5;
            this.f2232d = (f5 - f2) / f4;
            this.f2234f = f5 / f4;
            float f9 = ((f2 + f5) * this.f2232d) / 2.0f;
            float f10 = (this.f2234f * f5) / 2.0f;
            this.f2233e = ((f3 - f9) - f10) / f5;
            this.f2235g = f9;
            this.f2236h = f3 - f10;
            this.f2237i = f3;
        } else if (f8 >= f3) {
            this.k = "hard stop";
            this.j = 1;
            this.f2229a = f2;
            this.f2230b = 0.0f;
            this.f2235g = f3;
            this.f2232d = (2.0f * f3) / f2;
        } else {
            float f11 = f3 - f8;
            float f12 = f11 / f2;
            if (f12 + f7 < f6) {
                this.k = "cruse decelerate";
                this.j = 2;
                this.f2229a = f2;
                this.f2230b = f2;
                this.f2231c = 0.0f;
                this.f2235g = f11;
                this.f2236h = f3;
                this.f2232d = f12;
                this.f2233e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f3) + ((f2 * f2) / 2.0f)));
            float f13 = (sqrt2 - f2) / f4;
            this.f2232d = f13;
            float f14 = sqrt2 / f4;
            this.f2233e = f14;
            if (sqrt2 < f5) {
                this.k = "accelerate decelerate";
                this.j = 2;
                this.f2229a = f2;
                this.f2230b = sqrt2;
                this.f2231c = 0.0f;
                this.f2232d = f13;
                this.f2233e = f14;
                this.f2235g = ((f2 + sqrt2) * this.f2232d) / 2.0f;
                this.f2236h = f3;
                return;
            }
            this.k = "accelerate cruse decelerate";
            this.j = 3;
            this.f2229a = f2;
            this.f2230b = f5;
            this.f2231c = f5;
            this.f2232d = (f5 - f2) / f4;
            this.f2234f = f5 / f4;
            float f15 = ((f2 + f5) * this.f2232d) / 2.0f;
            float f16 = (this.f2234f * f5) / 2.0f;
            this.f2233e = ((f3 - f15) - f16) / f5;
            this.f2235g = f15;
            this.f2236h = f3 - f16;
            this.f2237i = f3;
        }
    }

    public final float getInterpolation(float f2) {
        float f3;
        float f4 = this.f2232d;
        if (f2 <= f4) {
            float f5 = this.f2229a;
            f3 = (f5 * f2) + ((((this.f2230b - f5) * f2) * f2) / (f4 * 2.0f));
        } else {
            int i2 = this.j;
            if (i2 == 1) {
                f3 = this.f2235g;
            } else {
                float f6 = f2 - f4;
                float f7 = this.f2233e;
                if (f6 < f7) {
                    float f8 = this.f2235g;
                    float f9 = this.f2230b;
                    f3 = f8 + (f9 * f6) + ((((this.f2231c - f9) * f6) * f6) / (f7 * 2.0f));
                } else if (i2 == 2) {
                    f3 = this.f2236h;
                } else {
                    float f10 = f6 - f7;
                    float f11 = this.f2234f;
                    if (f10 < f11) {
                        float f12 = this.f2236h;
                        float f13 = this.f2231c;
                        f3 = (f12 + (f13 * f10)) - (((f13 * f10) * f10) / (f11 * 2.0f));
                    } else {
                        f3 = this.f2237i;
                    }
                }
            }
        }
        this.n = f2;
        return this.l ? this.m - f3 : this.m + f3;
    }
}
