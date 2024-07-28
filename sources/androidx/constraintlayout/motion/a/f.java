package androidx.constraintlayout.motion.a;

import java.util.Arrays;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f2222a = "Oscillator";

    /* renamed from: b  reason: collision with root package name */
    public float[] f2223b = new float[0];

    /* renamed from: c  reason: collision with root package name */
    public double[] f2224c = new double[0];

    /* renamed from: d  reason: collision with root package name */
    public double[] f2225d;

    /* renamed from: e  reason: collision with root package name */
    public int f2226e;

    /* renamed from: f  reason: collision with root package name */
    double f2227f = 6.283185307179586d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2228g = false;

    public final String toString() {
        return "pos =" + Arrays.toString(this.f2224c) + " period=" + Arrays.toString(this.f2223b);
    }

    public final void a(double d2, float f2) {
        int length = this.f2223b.length + 1;
        int binarySearch = Arrays.binarySearch(this.f2224c, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f2224c = Arrays.copyOf(this.f2224c, length);
        this.f2223b = Arrays.copyOf(this.f2223b, length);
        this.f2225d = new double[length];
        double[] dArr = this.f2224c;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f2224c[binarySearch] = d2;
        this.f2223b[binarySearch] = f2;
        this.f2228g = false;
    }

    private double c(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f2224c, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i2 = (-binarySearch) - 1;
        float[] fArr = this.f2223b;
        int i3 = i2 - 1;
        double d3 = (double) (fArr[i2] - fArr[i3]);
        double[] dArr = this.f2224c;
        double d4 = d3 / (dArr[i2] - dArr[i3]);
        return this.f2225d[i3] + ((((double) fArr[i3]) - (dArr[i3] * d4)) * (d2 - dArr[i3])) + ((d4 * ((d2 * d2) - (dArr[i3] * dArr[i3]))) / 2.0d);
    }

    public final double a(double d2) {
        double abs;
        switch (this.f2226e) {
            case 1:
                return Math.signum(0.5d - (c(d2) % 1.0d));
            case 2:
                abs = Math.abs((((c(d2) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c(d2) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c(d2) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f2227f * c(d2));
            case 6:
                double abs2 = 1.0d - Math.abs(((c(d2) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.f2227f * c(d2));
        }
        return 1.0d - abs;
    }

    private double d(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f2224c, d2);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i2 = (-binarySearch) - 1;
        float[] fArr = this.f2223b;
        int i3 = i2 - 1;
        double d3 = (double) (fArr[i2] - fArr[i3]);
        double[] dArr = this.f2224c;
        double d4 = d3 / (dArr[i2] - dArr[i3]);
        return (((double) fArr[i3]) - (d4 * dArr[i3])) + (d2 * d4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        return r10 * 2.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        return r0 * r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        return r5 * r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double b(double r10) {
        /*
            r9 = this;
            int r0 = r9.f2226e
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            r3 = 4616189618054758400(0x4010000000000000, double:4.0)
            switch(r0) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0055;
                case 3: goto L_0x0050;
                case 4: goto L_0x0048;
                case 5: goto L_0x0032;
                case 6: goto L_0x0020;
                default: goto L_0x0009;
            }
        L_0x0009:
            double r0 = r9.f2227f
            double r2 = r9.d(r10)
            double r0 = r0 * r2
            double r2 = r9.f2227f
            double r10 = r9.c(r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.cos(r2)
        L_0x001d:
            double r0 = r0 * r10
            return r0
        L_0x0020:
            double r5 = r9.d(r10)
            double r5 = r5 * r3
            double r10 = r9.c(r10)
            double r10 = r10 * r3
            double r10 = r10 + r1
            double r10 = r10 % r3
            double r10 = r10 - r1
        L_0x002f:
            double r5 = r5 * r10
            return r5
        L_0x0032:
            double r0 = r9.f2227f
            double r0 = -r0
            double r2 = r9.d(r10)
            double r0 = r0 * r2
            double r2 = r9.f2227f
            double r10 = r9.c(r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.sin(r2)
            goto L_0x001d
        L_0x0048:
            double r10 = r9.d(r10)
            double r10 = -r10
        L_0x004d:
            double r10 = r10 * r1
            return r10
        L_0x0050:
            double r10 = r9.d(r10)
            goto L_0x004d
        L_0x0055:
            double r5 = r9.d(r10)
            double r5 = r5 * r3
            double r10 = r9.c(r10)
            double r10 = r10 * r3
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r10 = r10 + r7
            double r10 = r10 % r3
            double r10 = r10 - r1
            double r10 = java.lang.Math.signum(r10)
            goto L_0x002f
        L_0x006b:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.a.f.b(double):double");
    }
}
