package androidx.constraintlayout.motion.a;

import java.util.Arrays;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    C0031a[] f2194a;

    /* renamed from: b  reason: collision with root package name */
    private final double[] f2195b;

    public final void a(double d2, double[] dArr) {
        if (d2 < this.f2194a[0].f2198c) {
            d2 = this.f2194a[0].f2198c;
        }
        C0031a[] aVarArr = this.f2194a;
        if (d2 > aVarArr[aVarArr.length - 1].f2199d) {
            C0031a[] aVarArr2 = this.f2194a;
            d2 = aVarArr2[aVarArr2.length - 1].f2199d;
        }
        int i2 = 0;
        while (true) {
            C0031a[] aVarArr3 = this.f2194a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f2199d) {
                i2++;
            } else if (this.f2194a[i2].r) {
                dArr[0] = this.f2194a[i2].b(d2);
                dArr[1] = this.f2194a[i2].c(d2);
                return;
            } else {
                this.f2194a[i2].a(d2);
                dArr[0] = this.f2194a[i2].a();
                dArr[1] = this.f2194a[i2].b();
                return;
            }
        }
    }

    public final void a(double d2, float[] fArr) {
        if (d2 < this.f2194a[0].f2198c) {
            d2 = this.f2194a[0].f2198c;
        } else {
            C0031a[] aVarArr = this.f2194a;
            if (d2 > aVarArr[aVarArr.length - 1].f2199d) {
                C0031a[] aVarArr2 = this.f2194a;
                d2 = aVarArr2[aVarArr2.length - 1].f2199d;
            }
        }
        int i2 = 0;
        while (true) {
            C0031a[] aVarArr3 = this.f2194a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f2199d) {
                i2++;
            } else if (this.f2194a[i2].r) {
                fArr[0] = (float) this.f2194a[i2].b(d2);
                fArr[1] = (float) this.f2194a[i2].c(d2);
                return;
            } else {
                this.f2194a[i2].a(d2);
                fArr[0] = (float) this.f2194a[i2].a();
                fArr[1] = (float) this.f2194a[i2].b();
                return;
            }
        }
    }

    public final void b(double d2, double[] dArr) {
        if (d2 < this.f2194a[0].f2198c) {
            d2 = this.f2194a[0].f2198c;
        } else {
            C0031a[] aVarArr = this.f2194a;
            if (d2 > aVarArr[aVarArr.length - 1].f2199d) {
                C0031a[] aVarArr2 = this.f2194a;
                d2 = aVarArr2[aVarArr2.length - 1].f2199d;
            }
        }
        int i2 = 0;
        while (true) {
            C0031a[] aVarArr3 = this.f2194a;
            if (i2 >= aVarArr3.length) {
                return;
            }
            if (d2 > aVarArr3[i2].f2199d) {
                i2++;
            } else if (this.f2194a[i2].r) {
                dArr[0] = this.f2194a[i2].l;
                dArr[1] = this.f2194a[i2].m;
                return;
            } else {
                this.f2194a[i2].a(d2);
                dArr[0] = this.f2194a[i2].c();
                C0031a aVar = this.f2194a[i2];
                double d3 = aVar.j * aVar.p;
                double d4 = (-aVar.k) * aVar.o;
                double hypot = aVar.n / Math.hypot(d3, d4);
                dArr[1] = aVar.q ? (-d4) * hypot : d4 * hypot;
                return;
            }
        }
    }

    public final double a(double d2) {
        int i2 = 0;
        if (d2 < this.f2194a[0].f2198c) {
            d2 = this.f2194a[0].f2198c;
        } else {
            C0031a[] aVarArr = this.f2194a;
            if (d2 > aVarArr[aVarArr.length - 1].f2199d) {
                C0031a[] aVarArr2 = this.f2194a;
                d2 = aVarArr2[aVarArr2.length - 1].f2199d;
            }
        }
        while (true) {
            C0031a[] aVarArr3 = this.f2194a;
            if (i2 >= aVarArr3.length) {
                return Double.NaN;
            }
            if (d2 > aVarArr3[i2].f2199d) {
                i2++;
            } else if (this.f2194a[i2].r) {
                return this.f2194a[i2].b(d2);
            } else {
                this.f2194a[i2].a(d2);
                return this.f2194a[i2].a();
            }
        }
    }

    public final double b(double d2) {
        int i2 = 0;
        if (d2 < this.f2194a[0].f2198c) {
            d2 = this.f2194a[0].f2198c;
        }
        C0031a[] aVarArr = this.f2194a;
        if (d2 > aVarArr[aVarArr.length - 1].f2199d) {
            C0031a[] aVarArr2 = this.f2194a;
            d2 = aVarArr2[aVarArr2.length - 1].f2199d;
        }
        while (true) {
            C0031a[] aVarArr3 = this.f2194a;
            if (i2 >= aVarArr3.length) {
                return Double.NaN;
            }
            if (d2 > aVarArr3[i2].f2199d) {
                i2++;
            } else if (this.f2194a[i2].r) {
                return this.f2194a[i2].l;
            } else {
                this.f2194a[i2].a(d2);
                return this.f2194a[i2].c();
            }
        }
    }

    public final double[] a() {
        return this.f2195b;
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        this.f2195b = dArr3;
        this.f2194a = new C0031a[(dArr3.length - 1)];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < this.f2194a.length) {
            int i5 = iArr[i2];
            int i6 = 2;
            if (i5 == 0) {
                i6 = 3;
            } else if (i5 == 1) {
                i3 = 1;
                i6 = 1;
            } else if (i5 == 2) {
                i3 = 2;
            } else if (i5 != 3) {
                i6 = i4;
            } else {
                i6 = i3 != 1 ? 1 : i6;
                i3 = i6;
            }
            int i7 = i2 + 1;
            this.f2194a[i2] = new C0031a(i6, dArr3[i2], dArr3[i7], dArr2[i2][0], dArr2[i2][1], dArr2[i7][0], dArr2[i7][1]);
            i2 = i7;
            i4 = i6;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.a.a$a  reason: collision with other inner class name */
    static class C0031a {
        private static double[] s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        double[] f2196a;

        /* renamed from: b  reason: collision with root package name */
        double f2197b;

        /* renamed from: c  reason: collision with root package name */
        double f2198c;

        /* renamed from: d  reason: collision with root package name */
        double f2199d;

        /* renamed from: e  reason: collision with root package name */
        double f2200e;

        /* renamed from: f  reason: collision with root package name */
        double f2201f;

        /* renamed from: g  reason: collision with root package name */
        double f2202g;

        /* renamed from: h  reason: collision with root package name */
        double f2203h;

        /* renamed from: i  reason: collision with root package name */
        double f2204i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r = false;

        C0031a(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i3 = i2;
            double d8 = d4;
            double d9 = d5;
            double d10 = d6;
            double d11 = d7;
            boolean z = false;
            this.q = i3 == 1 ? true : z;
            this.f2198c = d2;
            this.f2199d = d3;
            this.f2204i = 1.0d / (this.f2199d - this.f2198c);
            if (3 == i3) {
                this.r = true;
            }
            double d12 = d10 - d8;
            double d13 = d5;
            double d14 = d11 - d13;
            if (this.r || Math.abs(d12) < 0.001d || Math.abs(d14) < 0.001d) {
                this.r = true;
                this.f2200e = d8;
                this.f2201f = d10;
                this.f2202g = d13;
                this.f2203h = d11;
                this.f2197b = Math.hypot(d14, d12);
                this.n = this.f2197b * this.f2204i;
                double d15 = this.f2199d;
                double d16 = this.f2198c;
                this.l = d12 / (d15 - d16);
                this.m = d14 / (d15 - d16);
                return;
            }
            this.f2196a = new double[101];
            this.j = d12 * ((double) (this.q ? -1 : 1));
            this.k = d14 * ((double) (this.q ? 1 : -1));
            this.l = this.q ? d10 : d8;
            this.m = this.q ? d13 : d11;
            a(d4, d5, d6, d7);
            this.n = this.f2197b * this.f2204i;
        }

        /* access modifiers changed from: package-private */
        public final void a(double d2) {
            double d3 = d((this.q ? this.f2199d - d2 : d2 - this.f2198c) * this.f2204i) * 1.5707963267948966d;
            this.o = Math.sin(d3);
            this.p = Math.cos(d3);
        }

        /* access modifiers changed from: package-private */
        public final double a() {
            return this.l + (this.j * this.o);
        }

        /* access modifiers changed from: package-private */
        public final double b() {
            return this.m + (this.k * this.p);
        }

        /* access modifiers changed from: package-private */
        public final double c() {
            double d2 = this.j * this.p;
            double hypot = this.n / Math.hypot(d2, (-this.k) * this.o);
            return this.q ? (-d2) * hypot : d2 * hypot;
        }

        public final double b(double d2) {
            double d3 = (d2 - this.f2198c) * this.f2204i;
            double d4 = this.f2200e;
            return d4 + (d3 * (this.f2201f - d4));
        }

        public final double c(double d2) {
            double d3 = (d2 - this.f2198c) * this.f2204i;
            double d4 = this.f2202g;
            return d4 + (d3 * (this.f2203h - d4));
        }

        private double d(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f2196a;
            double length = d2 * ((double) (dArr.length - 1));
            int i2 = (int) length;
            return dArr[i2] + ((length - ((double) i2)) * (dArr[i2 + 1] - dArr[i2]));
        }

        private void a(double d2, double d3, double d4, double d5) {
            double d6;
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            while (true) {
                double[] dArr = s;
                if (i2 >= dArr.length) {
                    break;
                }
                double d12 = d9;
                double radians = Math.toRadians((((double) i2) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = d12 + Math.hypot(sin - d10, cos - d11);
                    s[i2] = d6;
                } else {
                    d6 = d12;
                }
                i2++;
                d11 = cos;
                double d13 = sin;
                d9 = d6;
                d10 = d13;
            }
            double d14 = d9;
            this.f2197b = d14;
            int i3 = 0;
            while (true) {
                double[] dArr2 = s;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d14;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.f2196a;
                if (i4 < dArr3.length) {
                    double length = ((double) i4) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(s, length);
                    if (binarySearch >= 0) {
                        this.f2196a[i4] = (double) (binarySearch / (s.length - 1));
                    } else if (binarySearch == -1) {
                        this.f2196a[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double[] dArr4 = s;
                        this.f2196a[i4] = (((double) i6) + ((length - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6]))) / ((double) (dArr4.length - 1));
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }
    }
}
