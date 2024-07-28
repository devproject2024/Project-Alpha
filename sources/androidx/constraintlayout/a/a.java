package androidx.constraintlayout.a;

import androidx.constraintlayout.a.b;
import java.util.Arrays;

public final class a implements b.a {
    private static float l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int f1991a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected final c f1992b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1993c;

    /* renamed from: d  reason: collision with root package name */
    private int f1994d = 8;

    /* renamed from: e  reason: collision with root package name */
    private h f1995e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1996f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f1997g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f1998h;

    /* renamed from: i  reason: collision with root package name */
    private int f1999i;
    private int j;
    private boolean k;

    a(b bVar, c cVar) {
        int i2 = this.f1994d;
        this.f1996f = new int[i2];
        this.f1997g = new int[i2];
        this.f1998h = new float[i2];
        this.f1999i = -1;
        this.j = -1;
        this.k = false;
        this.f1993c = bVar;
        this.f1992b = cVar;
    }

    public final void a(h hVar, float f2) {
        if (f2 == 0.0f) {
            a(hVar, true);
            return;
        }
        int i2 = this.f1999i;
        if (i2 == -1) {
            this.f1999i = 0;
            float[] fArr = this.f1998h;
            int i3 = this.f1999i;
            fArr[i3] = f2;
            this.f1996f[i3] = hVar.f2167b;
            this.f1997g[this.f1999i] = -1;
            hVar.l++;
            hVar.a(this.f1993c);
            this.f1991a++;
            if (!this.k) {
                this.j++;
                int i4 = this.j;
                int[] iArr = this.f1996f;
                if (i4 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i5 = 0;
        int i6 = -1;
        while (i2 != -1 && i5 < this.f1991a) {
            if (this.f1996f[i2] == hVar.f2167b) {
                this.f1998h[i2] = f2;
                return;
            }
            if (this.f1996f[i2] < hVar.f2167b) {
                i6 = i2;
            }
            i2 = this.f1997g[i2];
            i5++;
        }
        int i7 = this.j;
        int i8 = i7 + 1;
        if (this.k) {
            int[] iArr2 = this.f1996f;
            if (iArr2[i7] != -1) {
                i7 = iArr2.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr3 = this.f1996f;
        if (i7 >= iArr3.length && this.f1991a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f1996f;
                if (i9 >= iArr4.length) {
                    break;
                } else if (iArr4[i9] == -1) {
                    i7 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr5 = this.f1996f;
        if (i7 >= iArr5.length) {
            i7 = iArr5.length;
            this.f1994d *= 2;
            this.k = false;
            this.j = i7 - 1;
            this.f1998h = Arrays.copyOf(this.f1998h, this.f1994d);
            this.f1996f = Arrays.copyOf(this.f1996f, this.f1994d);
            this.f1997g = Arrays.copyOf(this.f1997g, this.f1994d);
        }
        this.f1996f[i7] = hVar.f2167b;
        this.f1998h[i7] = f2;
        if (i6 != -1) {
            int[] iArr6 = this.f1997g;
            iArr6[i7] = iArr6[i6];
            iArr6[i6] = i7;
        } else {
            this.f1997g[i7] = this.f1999i;
            this.f1999i = i7;
        }
        hVar.l++;
        hVar.a(this.f1993c);
        this.f1991a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f1991a >= this.f1996f.length) {
            this.k = true;
        }
        int i10 = this.j;
        int[] iArr7 = this.f1996f;
        if (i10 >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    public final void a(h hVar, float f2, boolean z) {
        float f3 = l;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f1999i;
            if (i2 == -1) {
                this.f1999i = 0;
                float[] fArr = this.f1998h;
                int i3 = this.f1999i;
                fArr[i3] = f2;
                this.f1996f[i3] = hVar.f2167b;
                this.f1997g[this.f1999i] = -1;
                hVar.l++;
                hVar.a(this.f1993c);
                this.f1991a++;
                if (!this.k) {
                    this.j++;
                    int i4 = this.j;
                    int[] iArr = this.f1996f;
                    if (i4 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            int i6 = -1;
            while (i2 != -1 && i5 < this.f1991a) {
                if (this.f1996f[i2] == hVar.f2167b) {
                    float f4 = this.f1998h[i2] + f2;
                    float f5 = l;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    this.f1998h[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.f1999i) {
                            this.f1999i = this.f1997g[i2];
                        } else {
                            int[] iArr2 = this.f1997g;
                            iArr2[i6] = iArr2[i2];
                        }
                        if (z) {
                            hVar.b(this.f1993c);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        hVar.l--;
                        this.f1991a--;
                        return;
                    }
                    return;
                }
                if (this.f1996f[i2] < hVar.f2167b) {
                    i6 = i2;
                }
                i2 = this.f1997g[i2];
                i5++;
            }
            int i7 = this.j;
            int i8 = i7 + 1;
            if (this.k) {
                int[] iArr3 = this.f1996f;
                if (iArr3[i7] != -1) {
                    i7 = iArr3.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr4 = this.f1996f;
            if (i7 >= iArr4.length && this.f1991a < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.f1996f;
                    if (i9 >= iArr5.length) {
                        break;
                    } else if (iArr5[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr6 = this.f1996f;
            if (i7 >= iArr6.length) {
                i7 = iArr6.length;
                this.f1994d *= 2;
                this.k = false;
                this.j = i7 - 1;
                this.f1998h = Arrays.copyOf(this.f1998h, this.f1994d);
                this.f1996f = Arrays.copyOf(this.f1996f, this.f1994d);
                this.f1997g = Arrays.copyOf(this.f1997g, this.f1994d);
            }
            this.f1996f[i7] = hVar.f2167b;
            this.f1998h[i7] = f2;
            if (i6 != -1) {
                int[] iArr7 = this.f1997g;
                iArr7[i7] = iArr7[i6];
                iArr7[i6] = i7;
            } else {
                this.f1997g[i7] = this.f1999i;
                this.f1999i = i7;
            }
            hVar.l++;
            hVar.a(this.f1993c);
            this.f1991a++;
            if (!this.k) {
                this.j++;
            }
            int i10 = this.j;
            int[] iArr8 = this.f1996f;
            if (i10 >= iArr8.length) {
                this.k = true;
                this.j = iArr8.length - 1;
            }
        }
    }

    public final float a(b bVar, boolean z) {
        float b2 = b(bVar.f2128a);
        a(bVar.f2128a, z);
        b.a aVar = bVar.f2132e;
        int c2 = aVar.c();
        for (int i2 = 0; i2 < c2; i2++) {
            h a2 = aVar.a(i2);
            a(a2, aVar.b(a2) * b2, z);
        }
        return b2;
    }

    public final float a(h hVar, boolean z) {
        if (this.f1995e == hVar) {
            this.f1995e = null;
        }
        int i2 = this.f1999i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f1991a) {
            if (this.f1996f[i2] == hVar.f2167b) {
                if (i2 == this.f1999i) {
                    this.f1999i = this.f1997g[i2];
                } else {
                    int[] iArr = this.f1997g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    hVar.b(this.f1993c);
                }
                hVar.l--;
                this.f1991a--;
                this.f1996f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.f1998h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1997g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.f1999i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            h hVar = this.f1992b.f2137d[this.f1996f[i2]];
            if (hVar != null) {
                hVar.b(this.f1993c);
            }
            i2 = this.f1997g[i2];
            i3++;
        }
        this.f1999i = -1;
        this.j = -1;
        this.k = false;
        this.f1991a = 0;
    }

    public final boolean a(h hVar) {
        int i2 = this.f1999i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            if (this.f1996f[i2] == hVar.f2167b) {
                return true;
            }
            i2 = this.f1997g[i2];
            i3++;
        }
        return false;
    }

    public final void b() {
        int i2 = this.f1999i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            float[] fArr = this.f1998h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1997g[i2];
            i3++;
        }
    }

    public final void a(float f2) {
        int i2 = this.f1999i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            float[] fArr = this.f1998h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1997g[i2];
            i3++;
        }
    }

    public final int c() {
        return this.f1991a;
    }

    public final h a(int i2) {
        int i3 = this.f1999i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1991a) {
            if (i4 == i2) {
                return this.f1992b.f2137d[this.f1996f[i3]];
            }
            i3 = this.f1997g[i3];
            i4++;
        }
        return null;
    }

    public final float b(int i2) {
        int i3 = this.f1999i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1991a) {
            if (i4 == i2) {
                return this.f1998h[i3];
            }
            i3 = this.f1997g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float b(h hVar) {
        int i2 = this.f1999i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            if (this.f1996f[i2] == hVar.f2167b) {
                return this.f1998h[i2];
            }
            i2 = this.f1997g[i2];
            i3++;
        }
        return 0.0f;
    }

    public final String toString() {
        int i2 = this.f1999i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1991a) {
            str = ((str + " -> ") + this.f1998h[i2] + " : ") + this.f1992b.f2137d[this.f1996f[i2]];
            i2 = this.f1997g[i2];
            i3++;
        }
        return str;
    }
}
