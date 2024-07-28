package com.google.zxing.c.a;

import com.google.zxing.c.a.e;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int f39944a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f39945b;

    private b(int i2, byte[] bArr) {
        this.f39944a = i2;
        this.f39945b = bArr;
    }

    static b[] a(byte[] bArr, e eVar) {
        e.b bVar = eVar.f39959f;
        e.a[] aVarArr = bVar.f39964b;
        int i2 = 0;
        for (e.a aVar : aVarArr) {
            i2 += aVar.f39961a;
        }
        b[] bVarArr = new b[i2];
        int length = aVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            e.a aVar2 = aVarArr[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < aVar2.f39961a) {
                int i7 = aVar2.f39962b;
                bVarArr[i5] = new b(i7, new byte[(bVar.f39963a + i7)]);
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        int length2 = bVarArr[0].f39945b.length - bVar.f39963a;
        int i8 = length2 - 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i10;
            int i12 = 0;
            while (i12 < i4) {
                bVarArr[i12].f39945b[i9] = bArr[i11];
                i12++;
                i11++;
            }
            i9++;
            i10 = i11;
        }
        boolean z = eVar.f39954a == 24;
        int i13 = z ? 8 : i4;
        int i14 = i10;
        int i15 = 0;
        while (i15 < i13) {
            bVarArr[i15].f39945b[i8] = bArr[i14];
            i15++;
            i14++;
        }
        int length3 = bVarArr[0].f39945b.length;
        while (length2 < length3) {
            int i16 = 0;
            while (i16 < i4) {
                int i17 = z ? (i16 + 8) % i4 : i16;
                bVarArr[i17].f39945b[(!z || i17 <= 7) ? length2 : length2 - 1] = bArr[i14];
                i16++;
                i14++;
            }
            length2++;
        }
        if (i14 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }
}
