package com.google.zxing.f.c;

import java.lang.reflect.Array;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    int f40472a;

    /* renamed from: b  reason: collision with root package name */
    private final b[] f40473b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40474c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40475d;

    a(int i2, int i3) {
        this.f40473b = new b[i2];
        int length = this.f40473b.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f40473b[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f40475d = i3 * 17;
        this.f40474c = i2;
        this.f40472a = -1;
    }

    /* access modifiers changed from: package-private */
    public final b a() {
        return this.f40473b[this.f40472a];
    }

    public final byte[][] a(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f40474c * i3, this.f40475d * i2});
        int i4 = this.f40474c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i4 - i5) - 1;
            b bVar = this.f40473b[i5 / i3];
            byte[] bArr2 = new byte[(bVar.f40476a.length * i2)];
            for (int i7 = 0; i7 < bArr2.length; i7++) {
                bArr2[i7] = bVar.f40476a[i7 / i2];
            }
            bArr[i6] = bArr2;
        }
        return bArr;
    }
}
