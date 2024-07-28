package com.google.android.exoplayer2.g;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f32569a;

    /* renamed from: b  reason: collision with root package name */
    private int f32570b;

    /* renamed from: c  reason: collision with root package name */
    private int f32571c;

    /* renamed from: d  reason: collision with root package name */
    private int f32572d;

    public s(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3);
    }

    public final void a(byte[] bArr, int i2, int i3) {
        this.f32569a = bArr;
        this.f32571c = i2;
        this.f32570b = i3;
        this.f32572d = 0;
        f();
    }

    public final void a() {
        int i2 = 1;
        int i3 = this.f32572d + 1;
        this.f32572d = i3;
        if (i3 == 8) {
            this.f32572d = 0;
            int i4 = this.f32571c;
            if (d(i4 + 1)) {
                i2 = 2;
            }
            this.f32571c = i4 + i2;
        }
        f();
    }

    public final void a(int i2) {
        int i3 = this.f32571c;
        int i4 = i2 / 8;
        this.f32571c = i3 + i4;
        this.f32572d += i2 - (i4 * 8);
        int i5 = this.f32572d;
        if (i5 > 7) {
            this.f32571c++;
            this.f32572d = i5 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f32571c) {
                f();
                return;
            } else if (d(i3)) {
                this.f32571c++;
                i3 += 2;
            }
        }
    }

    public final boolean b(int i2) {
        int i3 = this.f32571c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f32572d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f32570b) {
                int i7 = this.f32570b;
            } else if (d(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f32570b;
        if (i5 < i72) {
            return true;
        }
        if (i5 == i72 && i6 == 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        boolean z = (this.f32569a[this.f32571c] & (128 >> this.f32572d)) != 0;
        a();
        return z;
    }

    public final int c(int i2) {
        int i3;
        int i4;
        this.f32572d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f32572d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            this.f32572d = i3 - 8;
            byte[] bArr = this.f32569a;
            int i6 = this.f32571c;
            i5 |= (bArr[i6] & 255) << this.f32572d;
            if (!d(i6 + 1)) {
                i4 = 1;
            }
            this.f32571c = i6 + i4;
        }
        byte[] bArr2 = this.f32569a;
        int i7 = this.f32571c;
        int i8 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f32572d = 0;
            if (!d(i7 + 1)) {
                i4 = 1;
            }
            this.f32571c = i7 + i4;
        }
        f();
        return i8;
    }

    public final boolean c() {
        int i2 = this.f32571c;
        int i3 = this.f32572d;
        int i4 = 0;
        while (this.f32571c < this.f32570b && !b()) {
            i4++;
        }
        boolean z = this.f32571c == this.f32570b;
        this.f32571c = i2;
        this.f32572d = i3;
        if (z || !b((i4 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public final int d() {
        int e2 = e();
        return (e2 % 2 == 0 ? -1 : 1) * ((e2 + 1) / 2);
    }

    public final int e() {
        int i2 = 0;
        int i3 = 0;
        while (!b()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = c(i3);
        }
        return i4 + i2;
    }

    private boolean d(int i2) {
        if (2 > i2 || i2 >= this.f32570b) {
            return false;
        }
        byte[] bArr = this.f32569a;
        return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f32570b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r2 = this;
            int r0 = r2.f32571c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f32570b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f32572d
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.s.f():void");
    }
}
