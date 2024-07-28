package androidx.constraintlayout.a;

import androidx.constraintlayout.a.b;
import java.util.Arrays;

public final class i implements b.a {
    private static float j = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int[] f2175a;

    /* renamed from: b  reason: collision with root package name */
    int[] f2176b;

    /* renamed from: c  reason: collision with root package name */
    int[] f2177c;

    /* renamed from: d  reason: collision with root package name */
    float[] f2178d;

    /* renamed from: e  reason: collision with root package name */
    int[] f2179e;

    /* renamed from: f  reason: collision with root package name */
    int[] f2180f;

    /* renamed from: g  reason: collision with root package name */
    int f2181g;

    /* renamed from: h  reason: collision with root package name */
    int f2182h;

    /* renamed from: i  reason: collision with root package name */
    protected final c f2183i;
    private final int k = -1;
    private int l = 16;
    private int m = 16;
    private final b n;

    i(b bVar, c cVar) {
        int i2 = this.l;
        this.f2175a = new int[i2];
        this.f2176b = new int[i2];
        this.f2177c = new int[i2];
        this.f2178d = new float[i2];
        this.f2179e = new int[i2];
        this.f2180f = new int[i2];
        this.f2181g = 0;
        this.f2182h = -1;
        this.n = bVar;
        this.f2183i = cVar;
        a();
    }

    public final int c() {
        return this.f2181g;
    }

    public final h a(int i2) {
        int i3 = this.f2181g;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f2182h;
        int i5 = 0;
        while (i5 < i3) {
            if (i5 != i2 || i4 == -1) {
                i4 = this.f2180f[i4];
                if (i4 == -1) {
                    break;
                }
                i5++;
            } else {
                return this.f2183i.f2137d[this.f2177c[i4]];
            }
        }
        return null;
    }

    public final float b(int i2) {
        int i3 = this.f2181g;
        int i4 = this.f2182h;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f2178d[i4];
            }
            i4 = this.f2180f[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final boolean a(h hVar) {
        return c(hVar) != -1;
    }

    private int c(h hVar) {
        if (!(this.f2181g == 0 || hVar == null)) {
            int i2 = hVar.f2167b;
            int i3 = this.f2175a[i2 % this.m];
            if (i3 == -1) {
                return -1;
            }
            if (this.f2177c[i3] == i2) {
                return i3;
            }
            while (true) {
                int[] iArr = this.f2176b;
                if (iArr[i3] == -1 || this.f2177c[iArr[i3]] == i2) {
                    int[] iArr2 = this.f2176b;
                } else {
                    i3 = iArr[i3];
                }
            }
            int[] iArr22 = this.f2176b;
            if (iArr22[i3] != -1 && this.f2177c[iArr22[i3]] == i2) {
                return iArr22[i3];
            }
        }
        return -1;
    }

    public final float b(h hVar) {
        int c2 = c(hVar);
        if (c2 != -1) {
            return this.f2178d[c2];
        }
        return 0.0f;
    }

    public final String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i2 = this.f2181g;
        for (int i3 = 0; i3 < i2; i3++) {
            h a2 = a(i3);
            if (a2 != null) {
                String str4 = str3 + a2 + " = " + b(i3) + " ";
                int c2 = c(a2);
                String str5 = str4 + "[p: ";
                if (this.f2179e[c2] != -1) {
                    str = str5 + this.f2183i.f2137d[this.f2177c[this.f2179e[c2]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f2180f[c2] != -1) {
                    str2 = str6 + this.f2183i.f2137d[this.f2177c[this.f2180f[c2]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public final void a() {
        int i2 = this.f2181g;
        for (int i3 = 0; i3 < i2; i3++) {
            h a2 = a(i3);
            if (a2 != null) {
                a2.b(this.n);
            }
        }
        for (int i4 = 0; i4 < this.l; i4++) {
            this.f2177c[i4] = -1;
            this.f2176b[i4] = -1;
        }
        for (int i5 = 0; i5 < this.m; i5++) {
            this.f2175a[i5] = -1;
        }
        this.f2181g = 0;
        this.f2182h = -1;
    }

    private void a(h hVar, int i2) {
        int[] iArr;
        int i3 = hVar.f2167b % this.m;
        int[] iArr2 = this.f2175a;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f2176b;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.f2176b[i2] = -1;
    }

    private void d(h hVar) {
        int i2 = hVar.f2167b % this.m;
        int i3 = this.f2175a[i2];
        if (i3 != -1) {
            int i4 = hVar.f2167b;
            if (this.f2177c[i3] == i4) {
                int[] iArr = this.f2175a;
                int[] iArr2 = this.f2176b;
                iArr[i2] = iArr2[i3];
                iArr2[i3] = -1;
                return;
            }
            while (true) {
                int[] iArr3 = this.f2176b;
                if (iArr3[i3] == -1 || this.f2177c[iArr3[i3]] == i4) {
                    int[] iArr4 = this.f2176b;
                    int i5 = iArr4[i3];
                } else {
                    i3 = iArr3[i3];
                }
            }
            int[] iArr42 = this.f2176b;
            int i52 = iArr42[i3];
            if (i52 != -1 && this.f2177c[i52] == i4) {
                iArr42[i3] = iArr42[i52];
                iArr42[i52] = -1;
            }
        }
    }

    private void a(int i2, h hVar, float f2) {
        this.f2177c[i2] = hVar.f2167b;
        this.f2178d[i2] = f2;
        this.f2179e[i2] = -1;
        this.f2180f[i2] = -1;
        hVar.a(this.n);
        hVar.l++;
        this.f2181g++;
    }

    public final void a(h hVar, float f2) {
        float f3 = j;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = 0;
            if (this.f2181g == 0) {
                a(0, hVar, f2);
                a(hVar, 0);
                this.f2182h = 0;
                return;
            }
            int c2 = c(hVar);
            if (c2 != -1) {
                this.f2178d[c2] = f2;
                return;
            }
            int i3 = this.f2181g + 1;
            int i4 = this.l;
            if (i3 >= i4) {
                int i5 = i4 * 2;
                this.f2177c = Arrays.copyOf(this.f2177c, i5);
                this.f2178d = Arrays.copyOf(this.f2178d, i5);
                this.f2179e = Arrays.copyOf(this.f2179e, i5);
                this.f2180f = Arrays.copyOf(this.f2180f, i5);
                this.f2176b = Arrays.copyOf(this.f2176b, i5);
                for (int i6 = this.l; i6 < i5; i6++) {
                    this.f2177c[i6] = -1;
                    this.f2176b[i6] = -1;
                }
                this.l = i5;
            }
            int i7 = this.f2181g;
            int i8 = this.f2182h;
            int i9 = 0;
            int i10 = -1;
            while (i9 < i7) {
                if (this.f2177c[i8] != hVar.f2167b) {
                    if (this.f2177c[i8] < hVar.f2167b) {
                        i10 = i8;
                    }
                    i8 = this.f2180f[i8];
                    if (i8 == -1) {
                        break;
                    }
                    i9++;
                } else {
                    this.f2178d[i8] = f2;
                    return;
                }
            }
            while (true) {
                if (i2 >= this.l) {
                    i2 = -1;
                    break;
                } else if (this.f2177c[i2] == -1) {
                    break;
                } else {
                    i2++;
                }
            }
            a(i2, hVar, f2);
            if (i10 != -1) {
                this.f2179e[i2] = i10;
                int[] iArr = this.f2180f;
                iArr[i2] = iArr[i10];
                iArr[i10] = i2;
            } else {
                this.f2179e[i2] = -1;
                if (this.f2181g > 0) {
                    this.f2180f[i2] = this.f2182h;
                    this.f2182h = i2;
                } else {
                    this.f2180f[i2] = -1;
                }
            }
            int[] iArr2 = this.f2180f;
            if (iArr2[i2] != -1) {
                this.f2179e[iArr2[i2]] = i2;
            }
            a(hVar, i2);
            return;
        }
        a(hVar, true);
    }

    public final float a(h hVar, boolean z) {
        int c2 = c(hVar);
        if (c2 == -1) {
            return 0.0f;
        }
        d(hVar);
        float f2 = this.f2178d[c2];
        if (this.f2182h == c2) {
            this.f2182h = this.f2180f[c2];
        }
        this.f2177c[c2] = -1;
        int[] iArr = this.f2179e;
        if (iArr[c2] != -1) {
            int[] iArr2 = this.f2180f;
            iArr2[iArr[c2]] = iArr2[c2];
        }
        int[] iArr3 = this.f2180f;
        if (iArr3[c2] != -1) {
            int[] iArr4 = this.f2179e;
            iArr4[iArr3[c2]] = iArr4[c2];
        }
        this.f2181g--;
        hVar.l--;
        if (z) {
            hVar.b(this.n);
        }
        return f2;
    }

    public final void a(h hVar, float f2, boolean z) {
        float f3 = j;
        if (f2 <= (-f3) || f2 >= f3) {
            int c2 = c(hVar);
            if (c2 == -1) {
                a(hVar, f2);
                return;
            }
            float[] fArr = this.f2178d;
            fArr[c2] = fArr[c2] + f2;
            float f4 = fArr[c2];
            float f5 = j;
            if (f4 > (-f5) && fArr[c2] < f5) {
                fArr[c2] = 0.0f;
                a(hVar, z);
            }
        }
    }

    public final float a(b bVar, boolean z) {
        float b2 = b(bVar.f2128a);
        a(bVar.f2128a, z);
        i iVar = (i) bVar.f2132e;
        int i2 = iVar.f2181g;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (iVar.f2177c[i4] != -1) {
                a(this.f2183i.f2137d[iVar.f2177c[i4]], iVar.f2178d[i4] * b2, z);
                i3++;
            }
            i4++;
        }
        return b2;
    }

    public final void b() {
        int i2 = this.f2181g;
        int i3 = this.f2182h;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f2178d;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.f2180f[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public final void a(float f2) {
        int i2 = this.f2181g;
        int i3 = this.f2182h;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f2178d;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f2180f[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }
}
