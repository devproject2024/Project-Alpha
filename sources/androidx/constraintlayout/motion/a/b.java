package androidx.constraintlayout.motion.a;

public abstract class b {
    public abstract double a(double d2);

    public abstract void a(double d2, double[] dArr);

    public abstract void a(double d2, float[] fArr);

    public abstract double[] a();

    public abstract double b(double d2);

    public abstract void b(double d2, double[] dArr);

    public static b a(int i2, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i2 = 2;
        }
        if (i2 == 0) {
            return new e(dArr, dArr2);
        }
        if (i2 != 2) {
            return new d(dArr, dArr2);
        }
        return new a(dArr[0], dArr2[0]);
    }

    static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        double f2205a;

        /* renamed from: b  reason: collision with root package name */
        double[] f2206b;

        public final double b(double d2) {
            return 0.0d;
        }

        a(double d2, double[] dArr) {
            this.f2205a = d2;
            this.f2206b = dArr;
        }

        public final void a(double d2, double[] dArr) {
            double[] dArr2 = this.f2206b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public final void a(double d2, float[] fArr) {
            int i2 = 0;
            while (true) {
                double[] dArr = this.f2206b;
                if (i2 < dArr.length) {
                    fArr[i2] = (float) dArr[i2];
                    i2++;
                } else {
                    return;
                }
            }
        }

        public final double a(double d2) {
            return this.f2206b[0];
        }

        public final void b(double d2, double[] dArr) {
            for (int i2 = 0; i2 < this.f2206b.length; i2++) {
                dArr[i2] = 0.0d;
            }
        }

        public final double[] a() {
            return new double[]{this.f2205a};
        }
    }
}
