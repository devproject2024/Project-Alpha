package androidx.dynamicanimation.a;

import androidx.dynamicanimation.a.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    double f14571a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    double f14572b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    double f14573c;

    /* renamed from: d  reason: collision with root package name */
    double f14574d;

    /* renamed from: e  reason: collision with root package name */
    double f14575e = Double.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14576f = false;

    /* renamed from: g  reason: collision with root package name */
    private double f14577g;

    /* renamed from: h  reason: collision with root package name */
    private double f14578h;

    /* renamed from: i  reason: collision with root package name */
    private double f14579i;
    private final b.a j = new b.a();

    public final e a() {
        this.f14571a = Math.sqrt(50.0d);
        this.f14576f = false;
        return this;
    }

    public final e b() {
        this.f14572b = 0.20000000298023224d;
        this.f14576f = false;
        return this;
    }

    public final e c() {
        this.f14575e = 0.0d;
        return this;
    }

    private void d() {
        if (!this.f14576f) {
            if (this.f14575e != Double.MAX_VALUE) {
                double d2 = this.f14572b;
                if (d2 > 1.0d) {
                    double d3 = this.f14571a;
                    this.f14577g = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                    double d4 = this.f14572b;
                    double d5 = this.f14571a;
                    this.f14578h = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
                } else if (d2 >= 0.0d && d2 < 1.0d) {
                    this.f14579i = this.f14571a * Math.sqrt(1.0d - (d2 * d2));
                }
                this.f14576f = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    /* access modifiers changed from: package-private */
    public final b.a a(double d2, double d3, long j2) {
        double d4;
        double d5;
        d();
        double d6 = ((double) j2) / 1000.0d;
        double d7 = d2 - this.f14575e;
        double d8 = this.f14572b;
        if (d8 > 1.0d) {
            double d9 = this.f14578h;
            double d10 = this.f14577g;
            double d11 = d7 - (((d9 * d7) - d3) / (d9 - d10));
            double d12 = ((d7 * d9) - d3) / (d9 - d10);
            d5 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f14577g * d6) * d12);
            double d13 = this.f14578h;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f14577g;
            d4 = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f14571a;
            double d16 = d3 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d5 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f14571a) * d6);
            double d18 = this.f14571a;
            d4 = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f14579i;
            double d20 = this.f14571a;
            double d21 = d19 * ((d8 * d20 * d7) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.f14579i * d6) * d7) + (Math.sin(this.f14579i * d6) * d21));
            double d22 = this.f14571a;
            double d23 = this.f14572b;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.f14579i;
            double d26 = pow3;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d27 = this.f14579i;
            d4 = d24 + (pow4 * (sin + (d21 * d27 * Math.cos(d27 * d6))));
            d5 = d26;
        }
        b.a aVar = this.j;
        aVar.f14568a = (float) (d5 + this.f14575e);
        aVar.f14569b = (float) d4;
        return aVar;
    }
}
