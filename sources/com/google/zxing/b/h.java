package com.google.zxing.b;

import com.google.zxing.b;
import com.google.zxing.j;
import com.google.zxing.m;

public class h extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f39921b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private byte[] f39922c = f39921b;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f39923d = new int[32];

    public h(j jVar) {
        super(jVar);
    }

    public b a(j jVar) {
        return new h(jVar);
    }

    private void a(int i2) {
        if (this.f39922c.length < i2) {
            this.f39922c = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f39923d[i3] = 0;
        }
    }

    private static int a(int[] iArr) throws m {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 > i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i6 - i4 > length / 16) {
            int i12 = i6 - 1;
            int i13 = i12;
            int i14 = -1;
            while (i12 > i4) {
                int i15 = i12 - i4;
                int i16 = i15 * i15 * (i6 - i12) * (i3 - iArr[i12]);
                if (i16 > i14) {
                    i13 = i12;
                    i14 = i16;
                }
                i12--;
            }
            return i13 << 3;
        }
        throw m.getNotFoundInstance();
    }

    public final a a(int i2, a aVar) throws m {
        j jVar = this.f39879a;
        int i3 = jVar.f40562a;
        if (aVar == null || aVar.f39881b < i3) {
            aVar = new a(i3);
        } else {
            aVar.b();
        }
        a(i3);
        byte[] a2 = jVar.a(i2, this.f39922c);
        int[] iArr = this.f39923d;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (a2[i4] & 255) >> 3;
            iArr[i5] = iArr[i5] + 1;
        }
        int a3 = a(iArr);
        if (i3 < 3) {
            for (int i6 = 0; i6 < i3; i6++) {
                if ((a2[i6] & 255) < a3) {
                    aVar.b(i6);
                }
            }
        } else {
            byte b2 = a2[1] & 255;
            byte b3 = a2[0] & 255;
            int i7 = 1;
            while (i7 < i3 - 1) {
                int i8 = i7 + 1;
                byte b4 = a2[i8] & 255;
                if ((((b2 << 2) - b3) - b4) / 2 < a3) {
                    aVar.b(i7);
                }
                b3 = b2;
                i7 = i8;
                b2 = b4;
            }
        }
        return aVar;
    }

    public b a() throws m {
        j jVar = this.f39879a;
        int i2 = jVar.f40562a;
        int i3 = jVar.f40563b;
        b bVar = new b(i2, i3);
        a(i2);
        int[] iArr = this.f39923d;
        for (int i4 = 1; i4 < 5; i4++) {
            byte[] a2 = jVar.a((i3 * i4) / 5, this.f39922c);
            int i5 = (i2 << 2) / 5;
            for (int i6 = i2 / 5; i6 < i5; i6++) {
                int i7 = (a2[i6] & 255) >> 3;
                iArr[i7] = iArr[i7] + 1;
            }
        }
        int a3 = a(iArr);
        byte[] a4 = jVar.a();
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 * i2;
            for (int i10 = 0; i10 < i2; i10++) {
                if ((a4[i9 + i10] & 255) < a3) {
                    bVar.b(i10, i8);
                }
            }
        }
        return bVar;
    }
}
