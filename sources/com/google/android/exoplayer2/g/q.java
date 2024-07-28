package com.google.android.exoplayer2.g;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f32562a;

    /* renamed from: b  reason: collision with root package name */
    public int f32563b;

    /* renamed from: c  reason: collision with root package name */
    public int f32564c;

    /* renamed from: d  reason: collision with root package name */
    private int f32565d;

    public q() {
        this.f32562a = ae.f32504f;
    }

    public q(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public q(byte[] bArr, int i2) {
        this.f32562a = bArr;
        this.f32565d = i2;
    }

    public final void a(byte[] bArr, int i2) {
        this.f32562a = bArr;
        this.f32563b = 0;
        this.f32564c = 0;
        this.f32565d = i2;
    }

    public final int a() {
        return ((this.f32565d - this.f32563b) * 8) - this.f32564c;
    }

    public final int b() {
        return (this.f32563b * 8) + this.f32564c;
    }

    public final int c() {
        a.b(this.f32564c == 0);
        return this.f32563b;
    }

    public final void a(int i2) {
        this.f32563b = i2 / 8;
        this.f32564c = i2 - (this.f32563b * 8);
        g();
    }

    public final void d() {
        int i2 = this.f32564c + 1;
        this.f32564c = i2;
        if (i2 == 8) {
            this.f32564c = 0;
            this.f32563b++;
        }
        g();
    }

    public final void b(int i2) {
        int i3 = i2 / 8;
        this.f32563b += i3;
        this.f32564c += i2 - (i3 * 8);
        int i4 = this.f32564c;
        if (i4 > 7) {
            this.f32563b++;
            this.f32564c = i4 - 8;
        }
        g();
    }

    public final boolean e() {
        boolean z = (this.f32562a[this.f32563b] & (128 >> this.f32564c)) != 0;
        d();
        return z;
    }

    public final int c(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f32564c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f32564c;
            if (i3 <= 8) {
                break;
            }
            this.f32564c = i3 - 8;
            byte[] bArr = this.f32562a;
            int i5 = this.f32563b;
            this.f32563b = i5 + 1;
            i4 |= (bArr[i5] & 255) << this.f32564c;
        }
        byte[] bArr2 = this.f32562a;
        int i6 = this.f32563b;
        int i7 = (-1 >>> (32 - i2)) & (i4 | ((bArr2[i6] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f32564c = 0;
            this.f32563b = i6 + 1;
        }
        g();
        return i7;
    }

    public final void b(byte[] bArr, int i2) {
        int i3 = (i2 >> 3) + 0;
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.f32562a;
            int i5 = this.f32563b;
            this.f32563b = i5 + 1;
            byte b2 = bArr2[i5];
            int i6 = this.f32564c;
            bArr[i4] = (byte) (b2 << i6);
            bArr[i4] = (byte) (((255 & bArr2[this.f32563b]) >> (8 - i6)) | bArr[i4]);
        }
        int i7 = i2 & 7;
        if (i7 != 0) {
            bArr[i3] = (byte) (bArr[i3] & (PriceRangeSeekBar.INVALID_POINTER_ID >> i7));
            int i8 = this.f32564c;
            if (i8 + i7 > 8) {
                byte b3 = bArr[i3];
                byte[] bArr3 = this.f32562a;
                int i9 = this.f32563b;
                this.f32563b = i9 + 1;
                bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
                this.f32564c = i8 - 8;
            }
            this.f32564c += i7;
            byte[] bArr4 = this.f32562a;
            int i10 = this.f32563b;
            int i11 = this.f32564c;
            bArr[i3] = (byte) (((byte) (((bArr4[i10] & 255) >> (8 - i11)) << (8 - i7))) | bArr[i3]);
            if (i11 == 8) {
                this.f32564c = 0;
                this.f32563b = i10 + 1;
            }
            g();
        }
    }

    public final void f() {
        if (this.f32564c != 0) {
            this.f32564c = 0;
            this.f32563b++;
            g();
        }
    }

    public final void c(byte[] bArr, int i2) {
        a.b(this.f32564c == 0);
        System.arraycopy(this.f32562a, this.f32563b, bArr, 0, i2);
        this.f32563b += i2;
        g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f32565d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r2 = this;
            int r0 = r2.f32563b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f32565d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f32564c
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.g.a.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.q.g():void");
    }
}
