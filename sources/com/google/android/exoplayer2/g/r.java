package com.google.android.exoplayer2.g;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f32566a;

    /* renamed from: b  reason: collision with root package name */
    public int f32567b;

    /* renamed from: c  reason: collision with root package name */
    public int f32568c;

    public r() {
        this.f32566a = ae.f32504f;
    }

    public r(int i2) {
        this.f32566a = new byte[i2];
        this.f32568c = i2;
    }

    public r(byte[] bArr) {
        this.f32566a = bArr;
        this.f32568c = bArr.length;
    }

    public r(byte[] bArr, int i2) {
        this.f32566a = bArr;
        this.f32568c = i2;
    }

    public final void a() {
        this.f32567b = 0;
        this.f32568c = 0;
    }

    public final void a(byte[] bArr, int i2) {
        this.f32566a = bArr;
        this.f32568c = i2;
        this.f32567b = 0;
    }

    public final int b() {
        return this.f32568c - this.f32567b;
    }

    public final void b(int i2) {
        a.a(i2 >= 0 && i2 <= this.f32566a.length);
        this.f32568c = i2;
    }

    public final void c(int i2) {
        a.a(i2 >= 0 && i2 <= this.f32568c);
        this.f32567b = i2;
    }

    public final void d(int i2) {
        c(this.f32567b + i2);
    }

    public final void a(q qVar, int i2) {
        a(qVar.f32562a, 0, i2);
        qVar.a(0);
    }

    public final void a(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f32566a, this.f32567b, bArr, i2, i3);
        this.f32567b += i3;
    }

    public final int c() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int d() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public final int e() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public final int f() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        byte b2 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }

    public final long g() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        long j = ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        long j2 = j | ((((long) bArr[i4]) & 255) << 8);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        return j2 | (255 & ((long) bArr[i5]));
    }

    public final long h() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        long j = (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        long j2 = j | ((((long) bArr[i4]) & 255) << 16);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        return j2 | ((255 & ((long) bArr[i5])) << 24);
    }

    public final int i() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 8);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        return (bArr[i5] & 255) | b3;
    }

    public final int j() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        byte b2 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 16);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | b3;
    }

    public final long k() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        long j = ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        long j2 = j | ((((long) bArr[i4]) & 255) << 40);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        long j3 = j2 | ((((long) bArr[i5]) & 255) << 32);
        int i6 = this.f32567b;
        this.f32567b = i6 + 1;
        long j4 = j3 | ((((long) bArr[i6]) & 255) << 24);
        int i7 = this.f32567b;
        this.f32567b = i7 + 1;
        long j5 = j4 | ((((long) bArr[i7]) & 255) << 16);
        int i8 = this.f32567b;
        this.f32567b = i8 + 1;
        long j6 = j5 | ((((long) bArr[i8]) & 255) << 8);
        int i9 = this.f32567b;
        this.f32567b = i9 + 1;
        return j6 | (255 & ((long) bArr[i9]));
    }

    public final long l() {
        byte[] bArr = this.f32566a;
        int i2 = this.f32567b;
        this.f32567b = i2 + 1;
        int i3 = this.f32567b;
        this.f32567b = i3 + 1;
        long j = (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f32567b;
        this.f32567b = i4 + 1;
        long j2 = j | ((((long) bArr[i4]) & 255) << 16);
        int i5 = this.f32567b;
        this.f32567b = i5 + 1;
        long j3 = j2 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.f32567b;
        this.f32567b = i6 + 1;
        long j4 = j3 | ((((long) bArr[i6]) & 255) << 32);
        int i7 = this.f32567b;
        this.f32567b = i7 + 1;
        long j5 = j4 | ((((long) bArr[i7]) & 255) << 40);
        int i8 = this.f32567b;
        this.f32567b = i8 + 1;
        long j6 = j5 | ((((long) bArr[i8]) & 255) << 48);
        int i9 = this.f32567b;
        this.f32567b = i9 + 1;
        return j6 | ((255 & ((long) bArr[i9])) << 56);
    }

    public final int m() {
        return (c() << 21) | (c() << 14) | (c() << 7) | c();
    }

    public final int n() {
        int i2 = i();
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i2)));
    }

    public final int o() {
        int j = j();
        if (j >= 0) {
            return j;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(j)));
    }

    public final long p() {
        long k = k();
        if (k >= 0) {
            return k;
        }
        throw new IllegalStateException("Top bit not zero: ".concat(String.valueOf(k)));
    }

    public final String e(int i2) {
        return a(i2, Charset.forName(AppConstants.UTF_8));
    }

    public final String a(int i2, Charset charset) {
        String str = new String(this.f32566a, this.f32567b, i2, charset);
        this.f32567b += i2;
        return str;
    }

    public final String f(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = (this.f32567b + i2) - 1;
        String a2 = ae.a(this.f32566a, this.f32567b, (i3 >= this.f32568c || this.f32566a[i3] != 0) ? i2 : i2 - 1);
        this.f32567b += i2;
        return a2;
    }

    public final String q() {
        if (b() == 0) {
            return null;
        }
        int i2 = this.f32567b;
        while (i2 < this.f32568c && this.f32566a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f32566a;
        int i3 = this.f32567b;
        String a2 = ae.a(bArr, i3, i2 - i3);
        this.f32567b = i2;
        int i4 = this.f32567b;
        if (i4 < this.f32568c) {
            this.f32567b = i4 + 1;
        }
        return a2;
    }

    public final String r() {
        if (b() == 0) {
            return null;
        }
        int i2 = this.f32567b;
        while (i2 < this.f32568c && !ae.a((int) this.f32566a[i2])) {
            i2++;
        }
        int i3 = this.f32567b;
        if (i2 - i3 >= 3) {
            byte[] bArr = this.f32566a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f32567b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f32566a;
        int i4 = this.f32567b;
        String a2 = ae.a(bArr2, i4, i2 - i4);
        this.f32567b = i2;
        int i5 = this.f32567b;
        int i6 = this.f32568c;
        if (i5 == i6) {
            return a2;
        }
        if (this.f32566a[i5] == 13) {
            this.f32567b = i5 + 1;
            if (this.f32567b == i6) {
                return a2;
            }
        }
        byte[] bArr3 = this.f32566a;
        int i7 = this.f32567b;
        if (bArr3[i7] == 10) {
            this.f32567b = i7 + 1;
        }
        return a2;
    }

    public final void a(int i2) {
        byte[] bArr = this.f32566a;
        if (bArr.length < i2) {
            bArr = new byte[i2];
        }
        a(bArr, i2);
    }
}
