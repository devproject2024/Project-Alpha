package com.google.zxing.b;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f39907a;

    /* renamed from: b  reason: collision with root package name */
    public int f39908b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39909c;

    public c(byte[] bArr) {
        this.f39909c = bArr;
    }

    public final int a(int i2) {
        byte b2;
        if (i2 <= 0 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.f39908b;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int i5 = i2 < i4 ? i2 : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.f39909c;
            int i7 = this.f39907a;
            b2 = (((PriceRangeSeekBar.INVALID_POINTER_ID >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i2 -= i5;
            this.f39908b += i5;
            if (this.f39908b == 8) {
                this.f39908b = 0;
                this.f39907a = i7 + 1;
            }
        } else {
            b2 = 0;
        }
        if (i2 <= 0) {
            return b2;
        }
        while (i2 >= 8) {
            byte[] bArr2 = this.f39909c;
            int i8 = this.f39907a;
            b2 = (b2 << 8) | (bArr2[i8] & 255);
            this.f39907a = i8 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return b2;
        }
        int i9 = 8 - i2;
        int i10 = (b2 << i2) | ((((PriceRangeSeekBar.INVALID_POINTER_ID >> i9) << i9) & this.f39909c[this.f39907a]) >> i9);
        this.f39908b += i2;
        return i10;
    }

    public final int a() {
        return ((this.f39909c.length - this.f39907a) * 8) - this.f39908b;
    }
}
