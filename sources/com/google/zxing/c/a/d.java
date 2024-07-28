package com.google.zxing.c.a;

import com.google.zxing.b.b;
import com.google.zxing.b.b.a;
import com.google.zxing.b.b.c;
import com.google.zxing.b.e;
import com.google.zxing.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f39952a = new c(a.f39898f);

    public final e a(b bVar) throws h, com.google.zxing.d {
        a aVar = new a(bVar);
        b[] a2 = b.a(aVar.a(), aVar.f39941a);
        int i2 = 0;
        for (b bVar2 : a2) {
            i2 += bVar2.f39944a;
        }
        byte[] bArr = new byte[i2];
        int length = a2.length;
        for (int i3 = 0; i3 < length; i3++) {
            b bVar3 = a2[i3];
            byte[] bArr2 = bVar3.f39945b;
            int i4 = bVar3.f39944a;
            a(bArr2, i4);
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[(i5 * length) + i3] = bArr2[i5];
            }
        }
        return c.a(bArr);
    }

    private void a(byte[] bArr, int i2) throws com.google.zxing.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f39952a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (com.google.zxing.b.b.e unused) {
            throw com.google.zxing.d.getChecksumInstance();
        }
    }
}
