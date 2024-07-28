package com.squareup.b;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.IOException;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f16101a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16102b;

    /* renamed from: c  reason: collision with root package name */
    private int f16103c = 0;

    static int a(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    static int c(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    static long d(long j) {
        return (j >> 63) ^ (j << 1);
    }

    static int g(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return c(i2);
        }
        return 10;
    }

    public static int a(int i2, q qVar) {
        return (i2 << 3) | qVar.value();
    }

    p(byte[] bArr, int i2) {
        this.f16101a = bArr;
        this.f16102b = i2 + 0;
    }

    static int b(int i2) {
        return c(a(i2, q.VARINT));
    }

    /* access modifiers changed from: package-private */
    public final void a(byte b2) throws IOException {
        int i2 = this.f16103c;
        if (i2 != this.f16102b) {
            byte[] bArr = this.f16101a;
            this.f16103c = i2 + 1;
            bArr[i2] = b2;
            return;
        }
        throw new IOException("Out of space: position=" + this.f16103c + ", limit=" + this.f16102b);
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr, int i2) throws IOException {
        int i3 = this.f16102b;
        int i4 = this.f16103c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, 0, this.f16101a, i4, i2);
            this.f16103c += i2;
            return;
        }
        throw new IOException("Out of space: position=" + this.f16103c + ", limit=" + this.f16102b);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, q qVar) throws IOException {
        e(a(i2, qVar));
    }

    /* access modifiers changed from: package-private */
    public final void d(int i2) throws IOException {
        if (i2 >= 0) {
            e(i2);
        } else {
            b((long) i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            a((byte) ((i2 & 127) | 128));
            i2 >>>= 7;
        }
        a((byte) i2);
    }

    /* access modifiers changed from: package-private */
    public final void b(long j) throws IOException {
        while ((-128 & j) != 0) {
            a((byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        a((byte) ((int) j));
    }

    /* access modifiers changed from: package-private */
    public final void f(int i2) throws IOException {
        a((byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) ((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID));
    }

    /* access modifiers changed from: package-private */
    public final void c(long j) throws IOException {
        a((byte) (((int) j) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 8)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 16)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 24)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 32)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 40)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 48)) & PriceRangeSeekBar.INVALID_POINTER_ID));
        a((byte) (((int) (j >> 56)) & PriceRangeSeekBar.INVALID_POINTER_ID));
    }
}
