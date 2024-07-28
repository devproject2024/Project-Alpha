package com.google.zxing.d;

import com.google.zxing.b.b;
import com.google.zxing.d;
import com.google.zxing.d.a.c;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f40298a = new t[0];

    /* renamed from: b  reason: collision with root package name */
    private final c f40299b = new c();

    public final void a() {
    }

    public final r a(com.google.zxing.c cVar, Map<e, ?> map) throws m, d, h {
        byte[] bArr;
        Map<e, ?> map2 = map;
        if (map2 == null || !map2.containsKey(e.PURE_BARCODE)) {
            throw m.getNotFoundInstance();
        }
        b b2 = cVar.b();
        int i2 = b2.f39889a;
        int i3 = -1;
        int i4 = b2.f39890b;
        int i5 = -1;
        int i6 = i2;
        int i7 = 0;
        while (i7 < b2.f39890b) {
            int i8 = i4;
            int i9 = i6;
            for (int i10 = 0; i10 < b2.f39891c; i10++) {
                int i11 = b2.f39892d[(b2.f39891c * i7) + i10];
                if (i11 != 0) {
                    if (i7 < i8) {
                        i8 = i7;
                    }
                    if (i7 > i5) {
                        i5 = i7;
                    }
                    int i12 = i10 << 5;
                    int i13 = 31;
                    if (i12 < i9) {
                        int i14 = 0;
                        while ((i11 << (31 - i14)) == 0) {
                            i14++;
                        }
                        int i15 = i14 + i12;
                        if (i15 < i9) {
                            i9 = i15;
                        }
                    }
                    if (i12 + 31 > i3) {
                        while ((i11 >>> i13) == 0) {
                            i13--;
                        }
                        int i16 = i12 + i13;
                        if (i16 > i3) {
                            i3 = i16;
                        }
                    }
                }
            }
            i7++;
            i6 = i9;
            i4 = i8;
        }
        int[] iArr = (i3 < i6 || i5 < i4) ? null : new int[]{i6, i4, (i3 - i6) + 1, (i5 - i4) + 1};
        if (iArr != null) {
            int i17 = iArr[0];
            int i18 = iArr[1];
            int i19 = iArr[2];
            int i20 = iArr[3];
            b bVar = new b(30, 33);
            int i21 = 0;
            for (int i22 = 33; i21 < i22; i22 = 33) {
                int i23 = (((i21 * i20) + (i20 / 2)) / i22) + i18;
                for (int i24 = 0; i24 < 30; i24++) {
                    if (b2.a(i17 + ((((i24 * i19) + (i19 / 2)) + (((i21 & 1) * i19) / 2)) / 30), i23)) {
                        bVar.b(i24, i21);
                    }
                }
                i21++;
            }
            c cVar2 = this.f40299b;
            com.google.zxing.d.a.a aVar = new com.google.zxing.d.a.a(bVar);
            byte[] bArr2 = new byte[144];
            int i25 = aVar.f40301b.f39890b;
            int i26 = aVar.f40301b.f39889a;
            for (int i27 = 0; i27 < i25; i27++) {
                int[] iArr2 = com.google.zxing.d.a.a.f40300a[i27];
                for (int i28 = 0; i28 < i26; i28++) {
                    int i29 = iArr2[i28];
                    if (i29 >= 0 && aVar.f40301b.a(i28, i27)) {
                        int i30 = i29 / 6;
                        bArr2[i30] = (byte) (bArr2[i30] | ((byte) (1 << (5 - (i29 % 6)))));
                    }
                }
            }
            cVar2.a(bArr2, 0, 10, 10, 0);
            byte b3 = bArr2[0] & 15;
            if (b3 == 2 || b3 == 3 || b3 == 4) {
                c cVar3 = cVar2;
                byte[] bArr3 = bArr2;
                cVar3.a(bArr3, 20, 84, 40, 1);
                cVar3.a(bArr3, 20, 84, 40, 2);
                bArr = new byte[94];
            } else if (b3 == 5) {
                c cVar4 = cVar2;
                byte[] bArr4 = bArr2;
                cVar4.a(bArr4, 20, 68, 56, 1);
                cVar4.a(bArr4, 20, 68, 56, 2);
                bArr = new byte[78];
            } else {
                throw h.getFormatInstance();
            }
            System.arraycopy(bArr2, 0, bArr, 0, 10);
            System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
            com.google.zxing.b.e a2 = com.google.zxing.d.a.b.a(bArr, (int) b3);
            r rVar = new r(a2.f39912c, a2.f39910a, f40298a, com.google.zxing.a.MAXICODE);
            String str = a2.f39914e;
            if (str != null) {
                rVar.a(s.ERROR_CORRECTION_LEVEL, str);
            }
            return rVar;
        }
        throw m.getNotFoundInstance();
    }
}
