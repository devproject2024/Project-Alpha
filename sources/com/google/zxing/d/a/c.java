package com.google.zxing.d.a;

import com.google.zxing.b.b.a;
import com.google.zxing.b.b.e;
import com.google.zxing.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.b.b.c f40303a = new com.google.zxing.b.b.c(a.f39900h);

    public final void a(byte[] bArr, int i2, int i3, int i4, int i5) throws d {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[(i6 / i7)];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & 255;
            }
        }
        try {
            this.f40303a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (e unused) {
            throw d.getChecksumInstance();
        }
    }
}
