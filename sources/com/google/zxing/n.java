package com.google.zxing;

public final class n extends j {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f40567c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40568d;

    /* renamed from: e  reason: collision with root package name */
    private final int f40569e;

    /* renamed from: f  reason: collision with root package name */
    private final int f40570f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40571g;

    public n(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 > i2 || i7 + i5 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f40567c = bArr;
        this.f40568d = i2;
        this.f40569e = i3;
        this.f40570f = i4;
        this.f40571g = i5;
    }

    public final byte[] a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= this.f40563b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int i3 = this.f40562a;
        if (bArr == null || bArr.length < i3) {
            bArr = new byte[i3];
        }
        System.arraycopy(this.f40567c, ((i2 + this.f40571g) * this.f40568d) + this.f40570f, bArr, 0, i3);
        return bArr;
    }

    public final byte[] a() {
        int i2 = this.f40562a;
        int i3 = this.f40563b;
        if (i2 == this.f40568d && i3 == this.f40569e) {
            return this.f40567c;
        }
        int i4 = i2 * i3;
        byte[] bArr = new byte[i4];
        int i5 = this.f40571g;
        int i6 = this.f40568d;
        int i7 = (i5 * i6) + this.f40570f;
        if (i2 == i6) {
            System.arraycopy(this.f40567c, i7, bArr, 0, i4);
            return bArr;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            System.arraycopy(this.f40567c, i7, bArr, i8 * i2, i2);
            i7 += this.f40568d;
        }
        return bArr;
    }

    public final int[] e() {
        int i2 = this.f40562a / 2;
        int i3 = this.f40563b / 2;
        int[] iArr = new int[(i2 * i3)];
        byte[] bArr = this.f40567c;
        int i4 = (this.f40571g * this.f40568d) + this.f40570f;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i5 * i2;
            for (int i7 = 0; i7 < i2; i7++) {
                iArr[i6 + i7] = ((bArr[(i7 << 1) + i4] & 255) * 65793) | -16777216;
            }
            i4 += this.f40568d << 1;
        }
        return iArr;
    }
}
