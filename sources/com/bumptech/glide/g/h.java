package com.bumptech.glide.g;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class h extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f6620a = Integer.MIN_VALUE;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    public final synchronized void mark(int i2) {
        super.mark(i2);
        this.f6620a = i2;
    }

    public final int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = (int) a((long) i3);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, a2);
        b((long) read);
        return read;
    }

    public final synchronized void reset() throws IOException {
        super.reset();
        this.f6620a = Integer.MIN_VALUE;
    }

    public final long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }

    public final int available() throws IOException {
        int i2 = this.f6620a;
        if (i2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i2, super.available());
    }

    private long a(long j) {
        int i2 = this.f6620a;
        if (i2 == 0) {
            return -1;
        }
        return (i2 == Integer.MIN_VALUE || j <= ((long) i2)) ? j : (long) i2;
    }

    private void b(long j) {
        int i2 = this.f6620a;
        if (i2 != Integer.MIN_VALUE && j != -1) {
            this.f6620a = (int) (((long) i2) - j);
        }
    }
}
