package com.google.zxing.b.a;

import com.google.zxing.m;
import com.google.zxing.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.b.b f39882a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39883b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39884c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39885d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39886e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39887f;

    /* renamed from: g  reason: collision with root package name */
    private final int f39888g;

    public b(com.google.zxing.b.b bVar, int i2, int i3, int i4) throws m {
        this.f39882a = bVar;
        this.f39883b = bVar.f39890b;
        this.f39884c = bVar.f39889a;
        int i5 = i2 / 2;
        this.f39885d = i3 - i5;
        this.f39886e = i3 + i5;
        this.f39888g = i4 - i5;
        this.f39887f = i4 + i5;
        if (this.f39888g < 0 || this.f39885d < 0 || this.f39887f >= this.f39883b || this.f39886e >= this.f39884c) {
            throw m.getNotFoundInstance();
        }
    }

    public final t[] a() throws m {
        int i2 = this.f39885d;
        int i3 = this.f39886e;
        int i4 = this.f39888g;
        int i5 = this.f39887f;
        boolean z = false;
        int i6 = 1;
        int i7 = i2;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.f39884c) {
                    z8 = a(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 >= this.f39884c) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i5 < this.f39883b) {
                    z10 = a(i7, i3, i5, true);
                    if (z10) {
                        i5++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i5++;
                    }
                }
            }
            if (i5 >= this.f39883b) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i7 >= 0) {
                    z11 = a(i4, i5, i7, false);
                    if (z11) {
                        i7--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i7--;
                    }
                }
            }
            if (i7 < 0) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i4 >= 0) {
                    z12 = a(i7, i3, i4, true);
                    if (z12) {
                        i4--;
                        z7 = true;
                        z9 = true;
                    } else if (!z7) {
                        i4--;
                    }
                }
            }
            if (i4 < 0) {
                break;
            }
            if (z9) {
                z6 = true;
            }
            z2 = z9;
        }
        z = true;
        if (z || !z6) {
            throw m.getNotFoundInstance();
        }
        int i8 = i3 - i7;
        t tVar = null;
        t tVar2 = null;
        int i9 = 1;
        while (tVar2 == null && i9 < i8) {
            tVar2 = a((float) i7, (float) (i5 - i9), (float) (i7 + i9), (float) i5);
            i9++;
        }
        if (tVar2 != null) {
            t tVar3 = null;
            int i10 = 1;
            while (tVar3 == null && i10 < i8) {
                tVar3 = a((float) i7, (float) (i4 + i10), (float) (i7 + i10), (float) i4);
                i10++;
            }
            if (tVar3 != null) {
                t tVar4 = null;
                int i11 = 1;
                while (tVar4 == null && i11 < i8) {
                    tVar4 = a((float) i3, (float) (i4 + i11), (float) (i3 - i11), (float) i4);
                    i11++;
                }
                if (tVar4 != null) {
                    while (tVar == null && i6 < i8) {
                        tVar = a((float) i3, (float) (i5 - i6), (float) (i3 - i6), (float) i5);
                        i6++;
                    }
                    if (tVar != null) {
                        return a(tVar, tVar2, tVar4, tVar3);
                    }
                    throw m.getNotFoundInstance();
                }
                throw m.getNotFoundInstance();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private t a(float f2, float f3, float f4, float f5) {
        int a2 = a.a(a.a(f2, f3, f4, f5));
        float f6 = (float) a2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < a2; i2++) {
            float f9 = (float) i2;
            int a3 = a.a((f9 * f7) + f2);
            int a4 = a.a((f9 * f8) + f3);
            if (this.f39882a.a(a3, a4)) {
                return new t((float) a3, (float) a4);
            }
        }
        return null;
    }

    private boolean a(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.f39882a.a(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f39882a.a(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public b(com.google.zxing.b.b bVar) throws m {
        this(bVar, 10, bVar.f39889a / 2, bVar.f39890b / 2);
    }

    private t[] a(t tVar, t tVar2, t tVar3, t tVar4) {
        float f2 = tVar.f40584a;
        float f3 = tVar.f40585b;
        float f4 = tVar2.f40584a;
        float f5 = tVar2.f40585b;
        float f6 = tVar3.f40584a;
        float f7 = tVar3.f40585b;
        float f8 = tVar4.f40584a;
        float f9 = tVar4.f40585b;
        if (f2 < ((float) this.f39884c) / 2.0f) {
            return new t[]{new t(f8 - 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 + 1.0f), new t(f6 - 1.0f, f7 - 1.0f), new t(f2 + 1.0f, f3 - 1.0f)};
        }
        return new t[]{new t(f8 + 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 - 1.0f), new t(f6 - 1.0f, f7 + 1.0f), new t(f2 - 1.0f, f3 - 1.0f)};
    }
}
