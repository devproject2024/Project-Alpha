package com.google.zxing.a;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.v;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class c implements v {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i4 = 33;
        int i5 = 0;
        if (map != null) {
            if (map.containsKey(g.CHARACTER_SET)) {
                charset = Charset.forName(map.get(g.CHARACTER_SET).toString());
            }
            if (map.containsKey(g.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(g.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(g.AZTEC_LAYERS)) {
                i5 = Integer.parseInt(map.get(g.AZTEC_LAYERS).toString());
            }
        }
        if (aVar == a.AZTEC) {
            return a(com.google.zxing.a.c.c.a(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static b a(com.google.zxing.a.c.a aVar, int i2, int i3) {
        b bVar = aVar.f39860e;
        if (bVar != null) {
            int i4 = bVar.f39889a;
            int i5 = bVar.f39890b;
            int max = Math.max(i2, i4);
            int max2 = Math.max(i3, i5);
            int min = Math.min(max / i4, max2 / i5);
            int i6 = (max - (i4 * min)) / 2;
            int i7 = (max2 - (i5 * min)) / 2;
            b bVar2 = new b(max, max2);
            int i8 = 0;
            while (i8 < i5) {
                int i9 = i6;
                int i10 = 0;
                while (i10 < i4) {
                    if (bVar.a(i10, i8)) {
                        bVar2.a(i9, i7, min, min);
                    }
                    i10++;
                    i9 += min;
                }
                i8++;
                i7 += min;
            }
            return bVar2;
        }
        throw new IllegalStateException();
    }
}
