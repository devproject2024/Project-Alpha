package com.google.zxing.g;

import com.google.zxing.a;
import com.google.zxing.g;
import com.google.zxing.g.a.f;
import com.google.zxing.g.c.c;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.Map;

public final class b implements v {
    public final com.google.zxing.b.b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        } else {
            f fVar = f.L;
            int i4 = 4;
            if (map != null) {
                if (map.containsKey(g.ERROR_CORRECTION)) {
                    fVar = f.valueOf(map.get(g.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(g.MARGIN)) {
                    i4 = Integer.parseInt(map.get(g.MARGIN).toString());
                }
            }
            return a(c.a(str, fVar, map), i2, i3, i4);
        }
    }

    private static com.google.zxing.b.b a(com.google.zxing.g.c.f fVar, int i2, int i3, int i4) {
        com.google.zxing.g.c.b bVar = fVar.f40560e;
        if (bVar != null) {
            int i5 = bVar.f40548b;
            int i6 = bVar.f40549c;
            int i7 = i4 << 1;
            int i8 = i5 + i7;
            int i9 = i7 + i6;
            int max = Math.max(i2, i8);
            int max2 = Math.max(i3, i9);
            int min = Math.min(max / i8, max2 / i9);
            int i10 = (max - (i5 * min)) / 2;
            int i11 = (max2 - (i6 * min)) / 2;
            com.google.zxing.b.b bVar2 = new com.google.zxing.b.b(max, max2);
            int i12 = 0;
            while (i12 < i6) {
                int i13 = i10;
                int i14 = 0;
                while (i14 < i5) {
                    if (bVar.a(i14, i12) == 1) {
                        bVar2.a(i13, i11, min, min);
                    }
                    i14++;
                    i13 += min;
                }
                i12++;
                i11 += min;
            }
            return bVar2;
        }
        throw new IllegalStateException();
    }
}
