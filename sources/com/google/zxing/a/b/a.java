package com.google.zxing.a.b;

import com.google.zxing.b.b;
import com.google.zxing.b.b.c;
import com.google.zxing.b.b.e;
import com.google.zxing.b.i;
import com.google.zxing.m;
import com.google.zxing.t;
import com.j256.ormlite.stmt.query.SimpleComparison;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f39847a = {3808, 476, 2107, 1799};

    /* renamed from: b  reason: collision with root package name */
    private final b f39848b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39849c;

    /* renamed from: d  reason: collision with root package name */
    private int f39850d;

    /* renamed from: e  reason: collision with root package name */
    private int f39851e;

    /* renamed from: f  reason: collision with root package name */
    private int f39852f;

    /* renamed from: g  reason: collision with root package name */
    private int f39853g;

    public a(b bVar) {
        this.f39848b = bVar;
    }

    public final com.google.zxing.a.a a(boolean z) throws m {
        t[] a2 = a(a());
        if (z) {
            t tVar = a2[0];
            a2[0] = a2[2];
            a2[2] = tVar;
        }
        a(a2);
        b bVar = this.f39848b;
        int i2 = this.f39853g;
        return new com.google.zxing.a.a(a(bVar, a2[i2 % 4], a2[(i2 + 1) % 4], a2[(i2 + 2) % 4], a2[(i2 + 3) % 4]), b(a2), this.f39849c, this.f39851e, this.f39850d);
    }

    private void a(t[] tVarArr) throws m {
        long j;
        long j2;
        if (!a(tVarArr[0]) || !a(tVarArr[1]) || !a(tVarArr[2]) || !a(tVarArr[3])) {
            throw m.getNotFoundInstance();
        }
        int i2 = this.f39852f * 2;
        int[] iArr = {a(tVarArr[0], tVarArr[1], i2), a(tVarArr[1], tVarArr[2], i2), a(tVarArr[2], tVarArr[3], i2), a(tVarArr[3], tVarArr[0], i2)};
        this.f39853g = a(iArr, i2);
        long j3 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f39853g + i3) % 4];
            if (this.f39849c) {
                j2 = j3 << 7;
                j = (long) ((i4 >> 1) & 127);
            } else {
                j2 = j3 << 10;
                j = (long) (((i4 >> 2) & 992) + ((i4 >> 1) & 31));
            }
            j3 = j2 + j;
        }
        int a2 = a(j3, this.f39849c);
        if (this.f39849c) {
            this.f39850d = (a2 >> 6) + 1;
            this.f39851e = (a2 & 63) + 1;
            return;
        }
        this.f39850d = (a2 >> 11) + 1;
        this.f39851e = (a2 & 2047) + 1;
    }

    private static int a(int[] iArr, int i2) throws m {
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = iArr[i4];
            i3 = (i3 << 3) + ((i5 >> (i2 - 2)) << 1) + (i5 & 1);
        }
        int i6 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i7 = 0; i7 < 4; i7++) {
            if (Integer.bitCount(f39847a[i7] ^ i6) <= 2) {
                return i7;
            }
        }
        throw m.getNotFoundInstance();
    }

    private static int a(long j, boolean z) throws m {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(com.google.zxing.b.b.a.f39896d).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (e unused) {
            throw m.getNotFoundInstance();
        }
    }

    private t[] a(C0671a aVar) throws m {
        this.f39852f = 1;
        C0671a aVar2 = aVar;
        C0671a aVar3 = aVar2;
        C0671a aVar4 = aVar3;
        C0671a aVar5 = aVar4;
        boolean z = true;
        while (this.f39852f < 9) {
            C0671a a2 = a(aVar2, z, 1, -1);
            C0671a a3 = a(aVar3, z, 1, 1);
            C0671a a4 = a(aVar4, z, -1, 1);
            C0671a a5 = a(aVar5, z, -1, -1);
            if (this.f39852f > 2) {
                double b2 = (double) ((b(a5, a2) * ((float) this.f39852f)) / (b(aVar5, aVar2) * ((float) (this.f39852f + 2))));
                if (b2 < 0.75d || b2 > 1.25d || !a(a2, a3, a4, a5)) {
                    break;
                }
            }
            z = !z;
            this.f39852f++;
            aVar5 = a5;
            aVar2 = a2;
            aVar3 = a3;
            aVar4 = a4;
        }
        int i2 = this.f39852f;
        if (i2 == 5 || i2 == 7) {
            this.f39849c = this.f39852f == 5;
            t[] tVarArr = {new t(((float) aVar2.f39854a) + 0.5f, ((float) aVar2.f39855b) - 0.5f), new t(((float) aVar3.f39854a) + 0.5f, ((float) aVar3.f39855b) + 0.5f), new t(((float) aVar4.f39854a) - 0.5f, ((float) aVar4.f39855b) + 0.5f), new t(((float) aVar5.f39854a) - 0.5f, ((float) aVar5.f39855b) - 0.5f)};
            int i3 = this.f39852f;
            return a(tVarArr, (i3 * 2) - 3, i3 * 2);
        }
        throw m.getNotFoundInstance();
    }

    private C0671a a() {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        try {
            t[] a2 = new com.google.zxing.b.a.b(this.f39848b).a();
            tVar3 = a2[0];
            tVar2 = a2[1];
            tVar = a2[2];
            tVar4 = a2[3];
        } catch (m unused) {
            int i2 = this.f39848b.f39889a / 2;
            int i3 = this.f39848b.f39890b / 2;
            int i4 = i2 + 7;
            int i5 = i3 - 7;
            t a3 = a(new C0671a(i4, i5), false, 1, -1).a();
            int i6 = i3 + 7;
            t a4 = a(new C0671a(i4, i6), false, 1, 1).a();
            int i7 = i2 - 7;
            t a5 = a(new C0671a(i7, i6), false, -1, 1).a();
            tVar4 = a(new C0671a(i7, i5), false, -1, -1).a();
            t tVar9 = a4;
            tVar = a5;
            tVar3 = a3;
            tVar2 = tVar9;
        }
        int a6 = com.google.zxing.b.a.a.a((((tVar3.f40584a + tVar4.f40584a) + tVar2.f40584a) + tVar.f40584a) / 4.0f);
        int a7 = com.google.zxing.b.a.a.a((((tVar3.f40585b + tVar4.f40585b) + tVar2.f40585b) + tVar.f40585b) / 4.0f);
        try {
            t[] a8 = new com.google.zxing.b.a.b(this.f39848b, 15, a6, a7).a();
            tVar6 = a8[0];
            tVar5 = a8[1];
            tVar7 = a8[2];
            tVar8 = a8[3];
        } catch (m unused2) {
            int i8 = a6 + 7;
            int i9 = a7 - 7;
            tVar6 = a(new C0671a(i8, i9), false, 1, -1).a();
            int i10 = a7 + 7;
            tVar5 = a(new C0671a(i8, i10), false, 1, 1).a();
            int i11 = a6 - 7;
            tVar7 = a(new C0671a(i11, i10), false, -1, 1).a();
            tVar8 = a(new C0671a(i11, i9), false, -1, -1).a();
        }
        return new C0671a(com.google.zxing.b.a.a.a((((tVar6.f40584a + tVar8.f40584a) + tVar5.f40584a) + tVar7.f40584a) / 4.0f), com.google.zxing.b.a.a.a((((tVar6.f40585b + tVar8.f40585b) + tVar5.f40585b) + tVar7.f40585b) / 4.0f));
    }

    private t[] b(t[] tVarArr) {
        return a(tVarArr, this.f39852f * 2, b());
    }

    private b a(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        t tVar5 = tVar;
        t tVar6 = tVar2;
        t tVar7 = tVar3;
        t tVar8 = tVar4;
        i a2 = i.a();
        int b2 = b();
        int i2 = b2;
        int i3 = b2;
        float f2 = ((float) b2) / 2.0f;
        int i4 = this.f39852f;
        float f3 = f2 - ((float) i4);
        float f4 = f2 + ((float) i4);
        return a2.a(bVar, i3, i2, f3, f3, f4, f3, f4, f4, f3, f4, tVar5.f40584a, tVar5.f40585b, tVar6.f40584a, tVar6.f40585b, tVar7.f40584a, tVar7.f40585b, tVar8.f40584a, tVar8.f40585b);
    }

    private int a(t tVar, t tVar2, int i2) {
        float a2 = a(tVar, tVar2);
        float f2 = a2 / ((float) i2);
        float f3 = tVar.f40584a;
        float f4 = tVar.f40585b;
        float f5 = ((tVar2.f40584a - tVar.f40584a) * f2) / a2;
        float f6 = (f2 * (tVar2.f40585b - tVar.f40585b)) / a2;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f7 = (float) i4;
            if (this.f39848b.a(com.google.zxing.b.a.a.a((f7 * f5) + f3), com.google.zxing.b.a.a.a((f7 * f6) + f4))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean a(C0671a aVar, C0671a aVar2, C0671a aVar3, C0671a aVar4) {
        C0671a aVar5 = new C0671a(aVar.f39854a - 3, aVar.f39855b + 3);
        C0671a aVar6 = new C0671a(aVar2.f39854a - 3, aVar2.f39855b - 3);
        C0671a aVar7 = new C0671a(aVar3.f39854a + 3, aVar3.f39855b - 3);
        C0671a aVar8 = new C0671a(aVar4.f39854a + 3, aVar4.f39855b + 3);
        int a2 = a(aVar8, aVar5);
        if (a2 != 0 && a(aVar5, aVar6) == a2 && a(aVar6, aVar7) == a2 && a(aVar7, aVar8) == a2) {
            return true;
        }
        return false;
    }

    private int a(C0671a aVar, C0671a aVar2) {
        float b2 = b(aVar, aVar2);
        float f2 = ((float) (aVar2.f39854a - aVar.f39854a)) / b2;
        float f3 = ((float) (aVar2.f39855b - aVar.f39855b)) / b2;
        boolean a2 = this.f39848b.a(aVar.f39854a, aVar.f39855b);
        int ceil = (int) Math.ceil((double) b2);
        boolean z = false;
        float f4 = (float) aVar.f39854a;
        float f5 = (float) aVar.f39855b;
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            f4 += f2;
            f5 += f3;
            if (this.f39848b.a(com.google.zxing.b.a.a.a(f4), com.google.zxing.b.a.a.a(f5)) != a2) {
                i2++;
            }
        }
        float f6 = ((float) i2) / b2;
        if (f6 > 0.1f && f6 < 0.9f) {
            return 0;
        }
        if (f6 <= 0.1f) {
            z = true;
        }
        return z == a2 ? 1 : -1;
    }

    private static t[] a(t[] tVarArr, int i2, int i3) {
        float f2 = ((float) i3) / (((float) i2) * 2.0f);
        float f3 = tVarArr[0].f40584a - tVarArr[2].f40584a;
        float f4 = tVarArr[0].f40585b - tVarArr[2].f40585b;
        float f5 = (tVarArr[0].f40584a + tVarArr[2].f40584a) / 2.0f;
        float f6 = (tVarArr[0].f40585b + tVarArr[2].f40585b) / 2.0f;
        float f7 = f3 * f2;
        float f8 = f4 * f2;
        t tVar = new t(f5 + f7, f6 + f8);
        t tVar2 = new t(f5 - f7, f6 - f8);
        float f9 = tVarArr[1].f40584a - tVarArr[3].f40584a;
        float f10 = tVarArr[1].f40585b - tVarArr[3].f40585b;
        float f11 = (tVarArr[1].f40584a + tVarArr[3].f40584a) / 2.0f;
        float f12 = (tVarArr[1].f40585b + tVarArr[3].f40585b) / 2.0f;
        float f13 = f9 * f2;
        float f14 = f2 * f10;
        return new t[]{tVar, new t(f11 + f13, f12 + f14), tVar2, new t(f11 - f13, f12 - f14)};
    }

    private boolean a(int i2, int i3) {
        return i2 >= 0 && i2 < this.f39848b.f39889a && i3 > 0 && i3 < this.f39848b.f39890b;
    }

    private int b() {
        if (this.f39849c) {
            return (this.f39850d * 4) + 11;
        }
        int i2 = this.f39850d;
        if (i2 <= 4) {
            return (i2 * 4) + 15;
        }
        return (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    /* renamed from: com.google.zxing.a.b.a$a  reason: collision with other inner class name */
    static final class C0671a {

        /* renamed from: a  reason: collision with root package name */
        final int f39854a;

        /* renamed from: b  reason: collision with root package name */
        final int f39855b;

        /* access modifiers changed from: package-private */
        public final t a() {
            return new t((float) this.f39854a, (float) this.f39855b);
        }

        C0671a(int i2, int i3) {
            this.f39854a = i2;
            this.f39855b = i3;
        }

        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + this.f39854a + ' ' + this.f39855b + '>';
        }
    }

    private C0671a a(C0671a aVar, boolean z, int i2, int i3) {
        int i4 = aVar.f39854a + i2;
        int i5 = aVar.f39855b;
        while (true) {
            i5 += i3;
            if (!a(i4, i5) || this.f39848b.a(i4, i5) != z) {
                int i6 = i4 - i2;
                int i7 = i5 - i3;
            } else {
                i4 += i2;
            }
        }
        int i62 = i4 - i2;
        int i72 = i5 - i3;
        while (a(i62, i72) && this.f39848b.a(i62, i72) == z) {
            i62 += i2;
        }
        int i8 = i62 - i2;
        while (a(i8, i72) && this.f39848b.a(i8, i72) == z) {
            i72 += i3;
        }
        return new C0671a(i8, i72 - i3);
    }

    private boolean a(t tVar) {
        return a(com.google.zxing.b.a.a.a(tVar.f40584a), com.google.zxing.b.a.a.a(tVar.f40585b));
    }

    private static float b(C0671a aVar, C0671a aVar2) {
        return com.google.zxing.b.a.a.a(aVar.f39854a, aVar.f39855b, aVar2.f39854a, aVar2.f39855b);
    }

    private static float a(t tVar, t tVar2) {
        return com.google.zxing.b.a.a.a(tVar.f40584a, tVar.f40585b, tVar2.f40584a, tVar2.f40585b);
    }
}
