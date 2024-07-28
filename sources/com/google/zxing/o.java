package com.google.zxing;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class o extends j {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f40572c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40573d;

    /* renamed from: e  reason: collision with root package name */
    private final int f40574e;

    /* renamed from: f  reason: collision with root package name */
    private final int f40575f = 0;

    /* renamed from: g  reason: collision with root package name */
    private final int f40576g = 0;

    public o(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f40573d = i2;
        this.f40574e = i3;
        int i4 = i2 * i3;
        this.f40572c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.f40572c[i5] = (byte) (((((i6 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID) + ((i6 >> 7) & 510)) + (i6 & PriceRangeSeekBar.INVALID_POINTER_ID)) / 4);
        }
    }

    public final byte[] a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= this.f40563b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int i3 = this.f40562a;
        if (bArr == null || bArr.length < i3) {
            bArr = new byte[i3];
        }
        System.arraycopy(this.f40572c, ((i2 + this.f40576g) * this.f40573d) + this.f40575f, bArr, 0, i3);
        return bArr;
    }

    public final byte[] a() {
        int i2 = this.f40562a;
        int i3 = this.f40563b;
        if (i2 == this.f40573d && i3 == this.f40574e) {
            return this.f40572c;
        }
        int i4 = i2 * i3;
        byte[] bArr = new byte[i4];
        int i5 = this.f40576g;
        int i6 = this.f40573d;
        int i7 = (i5 * i6) + this.f40575f;
        if (i2 == i6) {
            System.arraycopy(this.f40572c, i7, bArr, 0, i4);
            return bArr;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            System.arraycopy(this.f40572c, i7, bArr, i8 * i2, i2);
            i7 += this.f40573d;
        }
        return bArr;
    }
}
