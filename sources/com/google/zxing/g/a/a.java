package com.google.zxing.g.a;

import com.google.zxing.b.b;
import com.google.zxing.h;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final b f40500a;

    /* renamed from: b  reason: collision with root package name */
    j f40501b;

    /* renamed from: c  reason: collision with root package name */
    g f40502c;

    /* renamed from: d  reason: collision with root package name */
    boolean f40503d;

    a(b bVar) throws h {
        int i2 = bVar.f39890b;
        if (i2 < 21 || (i2 & 3) != 1) {
            throw h.getFormatInstance();
        }
        this.f40500a = bVar;
    }

    /* access modifiers changed from: package-private */
    public final g a() throws h {
        g gVar = this.f40502c;
        if (gVar != null) {
            return gVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a2 = a(8, i5, a2);
        }
        int i6 = this.f40500a.f39890b;
        int i7 = i6 - 7;
        for (int i8 = i6 - 1; i8 >= i7; i8--) {
            i2 = a(8, i8, i2);
        }
        for (int i9 = i6 - 8; i9 < i6; i9++) {
            i2 = a(i9, 8, i2);
        }
        this.f40502c = g.b(a2, i2);
        g gVar2 = this.f40502c;
        if (gVar2 != null) {
            return gVar2;
        }
        throw h.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    public final j b() throws h {
        j jVar = this.f40501b;
        if (jVar != null) {
            return jVar;
        }
        int i2 = this.f40500a.f39890b;
        int i3 = (i2 - 17) / 4;
        if (i3 <= 6) {
            return j.b(i3);
        }
        int i4 = i2 - 11;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = i2 - 9; i8 >= i4; i8--) {
                i6 = a(i8, i7, i6);
            }
        }
        j c2 = j.c(i6);
        if (c2 == null || c2.a() != i2) {
            for (int i9 = 5; i9 >= 0; i9--) {
                for (int i10 = i2 - 9; i10 >= i4; i10--) {
                    i5 = a(i9, i10, i5);
                }
            }
            j c3 = j.c(i5);
            if (c3 == null || c3.a() != i2) {
                throw h.getFormatInstance();
            }
            this.f40501b = c3;
            return c3;
        }
        this.f40501b = c2;
        return c2;
    }

    private int a(int i2, int i3, int i4) {
        return this.f40503d ? this.f40500a.a(i3, i2) : this.f40500a.a(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    /* access modifiers changed from: package-private */
    public final byte[] c() throws h {
        int i2;
        g a2 = a();
        j b2 = b();
        c cVar = c.values()[a2.f40511b];
        int i3 = this.f40500a.f39890b;
        cVar.unmaskBitMatrix(this.f40500a, i3);
        int a3 = b2.a();
        b bVar = new b(a3);
        bVar.a(0, 0, 9, 9);
        int i4 = a3 - 8;
        bVar.a(i4, 0, 8, 9);
        bVar.a(0, i4, 9, 8);
        int length = b2.f40516b.length;
        int i5 = 0;
        while (true) {
            i2 = 2;
            if (i5 >= length) {
                break;
            }
            int i6 = b2.f40516b[i5] - 2;
            for (int i7 = 0; i7 < length; i7++) {
                if (!((i5 == 0 && (i7 == 0 || i7 == length - 1)) || (i5 == length - 1 && i7 == 0))) {
                    bVar.a(b2.f40516b[i7] - 2, i6, 5, 5);
                }
            }
            i5++;
        }
        int i8 = a3 - 17;
        int i9 = 6;
        bVar.a(6, 9, 1, i8);
        bVar.a(9, 6, i8, 1);
        if (b2.f40515a > 6) {
            int i10 = a3 - 11;
            bVar.a(i10, 0, 3, 6);
            bVar.a(0, i10, 6, 3);
        }
        byte[] bArr = new byte[b2.f40517c];
        int i11 = i3 - 1;
        int i12 = i11;
        int i13 = 0;
        boolean z = true;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == i9) {
                i12--;
            }
            int i16 = i15;
            int i17 = i14;
            int i18 = i13;
            int i19 = 0;
            while (i19 < i3) {
                int i20 = z ? i11 - i19 : i19;
                int i21 = i16;
                int i22 = i17;
                int i23 = i18;
                int i24 = 0;
                while (i24 < i2) {
                    int i25 = i12 - i24;
                    if (!bVar.a(i25, i20)) {
                        i22++;
                        int i26 = i21 << 1;
                        int i27 = this.f40500a.a(i25, i20) ? i26 | 1 : i26;
                        if (i22 == 8) {
                            bArr[i23] = (byte) i27;
                            i23++;
                            i22 = 0;
                            i21 = 0;
                        } else {
                            i21 = i27;
                        }
                    }
                    i24++;
                    i2 = 2;
                }
                i19++;
                i18 = i23;
                i17 = i22;
                i16 = i21;
                i2 = 2;
            }
            z = !z;
            i12 -= 2;
            i13 = i18;
            i14 = i17;
            i15 = i16;
            i9 = 6;
            i2 = 2;
        }
        if (i13 == b2.f40517c) {
            return bArr;
        }
        throw h.getFormatInstance();
    }
}
