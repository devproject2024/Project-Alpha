package androidx.appcompat.app;

final class k {

    /* renamed from: a  reason: collision with root package name */
    static k f1132a;

    /* renamed from: b  reason: collision with root package name */
    public long f1133b;

    /* renamed from: c  reason: collision with root package name */
    public long f1134c;

    /* renamed from: d  reason: collision with root package name */
    public int f1135d;

    k() {
    }

    public final void a(long j, double d2, double d3) {
        float f2 = ((float) (j - 946728000000L)) / 8.64E7f;
        float f3 = (0.01720197f * f2) + 6.24006f;
        double d4 = (double) f3;
        double sin = (Math.sin(d4) * 0.03341960161924362d) + d4 + (Math.sin((double) (2.0f * f3)) * 3.4906598739326E-4d) + (Math.sin((double) (f3 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d5 = (-d3) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f2 - 9.0E-4f)) - d5)) + 9.0E-4f)) + d5 + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f1135d = 1;
            this.f1133b = -1;
            this.f1134c = -1;
        } else if (sin2 <= -1.0d) {
            this.f1135d = 0;
            this.f1133b = -1;
            this.f1134c = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.f1133b = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            this.f1134c = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            if (this.f1134c >= j || this.f1133b <= j) {
                this.f1135d = 1;
            } else {
                this.f1135d = 0;
            }
        }
    }
}
