package com.google.zxing.g.a;

import com.google.zxing.g.a.j;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int f40504a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f40505b;

    private b(int i2, byte[] bArr) {
        this.f40504a = i2;
        this.f40505b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.f40517c) {
            j.b a2 = jVar.a(fVar);
            j.a[] aVarArr = a2.f40522b;
            int i2 = 0;
            for (j.a aVar : aVarArr) {
                i2 += aVar.f40519a;
            }
            b[] bVarArr = new b[i2];
            int length = aVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                j.a aVar2 = aVarArr[i3];
                int i5 = i4;
                int i6 = 0;
                while (i6 < aVar2.f40519a) {
                    int i7 = aVar2.f40520b;
                    bVarArr[i5] = new b(i7, new byte[(a2.f40521a + i7)]);
                    i6++;
                    i5++;
                }
                i3++;
                i4 = i5;
            }
            int length2 = bVarArr[0].f40505b.length;
            int length3 = bVarArr.length - 1;
            while (length3 >= 0 && bVarArr[length3].f40505b.length != length2) {
                length3--;
            }
            int i8 = length3 + 1;
            int i9 = length2 - a2.f40521a;
            int i10 = 0;
            int i11 = 0;
            while (i10 < i9) {
                int i12 = i11;
                int i13 = 0;
                while (i13 < i4) {
                    bVarArr[i13].f40505b[i10] = bArr[i12];
                    i13++;
                    i12++;
                }
                i10++;
                i11 = i12;
            }
            int i14 = i8;
            while (i14 < i4) {
                bVarArr[i14].f40505b[i9] = bArr[i11];
                i14++;
                i11++;
            }
            int length4 = bVarArr[0].f40505b.length;
            while (i9 < length4) {
                int i15 = i11;
                int i16 = 0;
                while (i16 < i4) {
                    bVarArr[i16].f40505b[i16 < i8 ? i9 : i9 + 1] = bArr[i15];
                    i16++;
                    i15++;
                }
                i9++;
                i11 = i15;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }
}
