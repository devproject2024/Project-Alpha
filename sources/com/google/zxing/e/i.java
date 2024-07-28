package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.m;

public final class i extends y {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f40377a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: g  reason: collision with root package name */
    private final int[] f40378g = new int[4];

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f40378g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f39881b;
        int i3 = iArr[1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 6 && i3 < i2) {
            int a2 = a(aVar, iArr2, i3, f40406f);
            sb.append((char) ((a2 % 10) + 48));
            int i6 = i3;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            if (a2 >= 10) {
                i5 = (1 << (5 - i4)) | i5;
            }
            i4++;
            i3 = i6;
        }
        for (int i8 = 0; i8 < 10; i8++) {
            if (i5 == f40377a[i8]) {
                sb.insert(0, (char) (i8 + 48));
                int i9 = a(aVar, i3, true, f40403c)[1];
                int i10 = 0;
                while (i10 < 6 && i9 < i2) {
                    sb.append((char) (a(aVar, iArr2, i9, f40405e) + 48));
                    int i11 = i9;
                    for (int i12 : iArr2) {
                        i11 += i12;
                    }
                    i10++;
                    i9 = i11;
                }
                return i9;
            }
        }
        throw m.getNotFoundInstance();
    }

    /* access modifiers changed from: package-private */
    public final com.google.zxing.a b() {
        return com.google.zxing.a.EAN_13;
    }
}
