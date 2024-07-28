package com.bumptech.glide.load.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6698a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final int f6699b = 29;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6700c = 31;

    /* renamed from: d  reason: collision with root package name */
    private final byte f6701d;

    /* renamed from: e  reason: collision with root package name */
    private int f6702e;

    public final boolean markSupported() {
        return false;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: ".concat(String.valueOf(i2)));
        }
        this.f6701d = (byte) i2;
    }

    public final void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public final int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.f6702e;
        if (i4 < 2 || i4 > (i3 = f6700c)) {
            i2 = super.read();
        } else if (i4 == i3) {
            i2 = this.f6701d;
        } else {
            i2 = f6698a[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f6702e++;
        }
        return i2;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f6702e;
        int i6 = f6700c;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f6701d;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f6698a, this.f6702e - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f6702e += i4;
        }
        return i4;
    }

    public final long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f6702e = (int) (((long) this.f6702e) + skip);
        }
        return skip;
    }

    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
