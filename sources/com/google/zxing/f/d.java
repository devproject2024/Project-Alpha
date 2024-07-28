package com.google.zxing.f;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.f.c.c;
import com.google.zxing.f.c.e;
import com.google.zxing.g;
import com.google.zxing.v;
import com.google.zxing.w;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class d implements v {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        boolean z;
        if (aVar == a.PDF_417) {
            e eVar = new e();
            int i4 = 30;
            int i5 = 2;
            if (map != null) {
                if (map.containsKey(g.PDF417_COMPACT)) {
                    eVar.f40484b = Boolean.valueOf(map.get(g.PDF417_COMPACT).toString()).booleanValue();
                }
                if (map.containsKey(g.PDF417_COMPACTION)) {
                    eVar.f40485c = c.valueOf(map.get(g.PDF417_COMPACTION).toString());
                }
                if (map.containsKey(g.PDF417_DIMENSIONS)) {
                    com.google.zxing.f.c.d dVar = (com.google.zxing.f.c.d) map.get(g.PDF417_DIMENSIONS);
                    int i6 = dVar.f40479b;
                    int i7 = dVar.f40478a;
                    int i8 = dVar.f40481d;
                    int i9 = dVar.f40480c;
                    eVar.f40488f = i6;
                    eVar.f40487e = i7;
                    eVar.f40489g = i8;
                    eVar.f40490h = i9;
                }
                if (map.containsKey(g.MARGIN)) {
                    i4 = Integer.parseInt(map.get(g.MARGIN).toString());
                }
                if (map.containsKey(g.ERROR_CORRECTION)) {
                    i5 = Integer.parseInt(map.get(g.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(g.CHARACTER_SET)) {
                    eVar.f40486d = Charset.forName(map.get(g.CHARACTER_SET).toString());
                }
            }
            eVar.a(str, i5);
            byte[][] a2 = eVar.f40483a.a(1, 4);
            if ((i3 > i2) != (a2[0].length < a2.length)) {
                a2 = a(a2);
                z = true;
            } else {
                z = false;
            }
            int length = i2 / a2[0].length;
            int length2 = i3 / a2.length;
            if (length >= length2) {
                length = length2;
            }
            if (length <= 1) {
                return a(a2, i4);
            }
            byte[][] a3 = eVar.f40483a.a(length, length << 2);
            if (z) {
                a3 = a(a3);
            }
            return a(a3, i4);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
    }

    private static b a(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        b bVar = new b(bArr[0].length + i3, bArr.length + i3);
        bVar.a();
        int i4 = (bVar.f39890b - i2) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    bVar.b(i6 + i2, i4);
                }
            }
            i5++;
            i4--;
        }
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }
}
