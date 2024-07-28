package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.m;

public final class k extends y {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f40379a = new int[4];

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f40379a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f39881b;
        int i3 = iArr[1];
        int i4 = 0;
        while (i4 < 4 && i3 < i2) {
            sb.append((char) (a(aVar, iArr2, i3, f40405e) + 48));
            int i5 = i3;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            i4++;
            i3 = i5;
        }
        int i7 = a(aVar, i3, true, f40403c)[1];
        int i8 = 0;
        while (i8 < 4 && i7 < i2) {
            sb.append((char) (a(aVar, iArr2, i7, f40405e) + 48));
            int i9 = i7;
            for (int i10 : iArr2) {
                i9 += i10;
            }
            i8++;
            i7 = i9;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public final com.google.zxing.a b() {
        return com.google.zxing.a.EAN_8;
    }
}
