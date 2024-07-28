package com.google.zxing.c;

import com.google.zxing.a;
import com.google.zxing.c.c.e;
import com.google.zxing.c.c.i;
import com.google.zxing.c.c.j;
import com.google.zxing.c.c.k;
import com.google.zxing.c.c.l;
import com.google.zxing.f;
import com.google.zxing.g;
import com.google.zxing.v;
import java.util.Map;

public final class b implements v {
    public final com.google.zxing.b.b a(String str, a aVar, int i2, int i3, Map<g, ?> map) {
        f fVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i2 + 'x' + i3);
        } else {
            l lVar = l.FORCE_NONE;
            f fVar2 = null;
            if (map != null) {
                l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                fVar = (f) map.get(g.MIN_SIZE);
                if (fVar == null) {
                    fVar = null;
                }
                f fVar3 = (f) map.get(g.MAX_SIZE);
                if (fVar3 != null) {
                    fVar2 = fVar3;
                }
            } else {
                fVar = null;
            }
            String a2 = j.a(str, lVar, fVar, fVar2);
            k a3 = k.a(a2.length(), lVar, fVar, fVar2);
            e eVar = new e(i.a(a2, a3), a3.b(), a3.c());
            eVar.a();
            return a(eVar, a3, i2, i3);
        }
    }

    private static com.google.zxing.b.b a(e eVar, k kVar, int i2, int i3) {
        com.google.zxing.b.b bVar;
        int b2 = kVar.b();
        int c2 = kVar.c();
        com.google.zxing.g.c.b bVar2 = new com.google.zxing.g.c.b(kVar.d(), kVar.e());
        int i4 = 0;
        for (int i5 = 0; i5 < c2; i5++) {
            if (i5 % kVar.f39992e == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < kVar.d(); i7++) {
                    bVar2.a(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < b2; i9++) {
                if (i9 % kVar.f39991d == 0) {
                    bVar2.a(i8, i4, true);
                    i8++;
                }
                bVar2.a(i8, i4, eVar.f39971b[(eVar.f39970a * i5) + i9] == 1);
                i8++;
                if (i9 % kVar.f39991d == kVar.f39991d - 1) {
                    bVar2.a(i8, i4, i5 % 2 == 0);
                    i8++;
                }
            }
            i4++;
            if (i5 % kVar.f39992e == kVar.f39992e - 1) {
                int i10 = 0;
                for (int i11 = 0; i11 < kVar.d(); i11++) {
                    bVar2.a(i10, i4, true);
                    i10++;
                }
                i4++;
            }
        }
        int i12 = bVar2.f40548b;
        int i13 = bVar2.f40549c;
        int max = Math.max(i2, i12);
        int max2 = Math.max(i3, i13);
        int min = Math.min(max / i12, max2 / i13);
        int i14 = (max - (i12 * min)) / 2;
        int i15 = (max2 - (i13 * min)) / 2;
        if (i3 < i13 || i2 < i12) {
            bVar = new com.google.zxing.b.b(i12, i13);
            i14 = 0;
            i15 = 0;
        } else {
            bVar = new com.google.zxing.b.b(i2, i3);
        }
        bVar.a();
        int i16 = 0;
        while (i16 < i13) {
            int i17 = i14;
            int i18 = 0;
            while (i18 < i12) {
                if (bVar2.a(i18, i16) == 1) {
                    bVar.a(i17, i15, min, min);
                }
                i18++;
                i17 += min;
            }
            i16++;
            i15 += min;
        }
        return bVar;
    }
}
