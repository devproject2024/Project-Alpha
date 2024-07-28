package com.bumptech.glide.g;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f6607a;

    /* renamed from: b  reason: collision with root package name */
    private int f6608b;

    public static InputStream a(InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.f6607a = j;
    }

    public final synchronized int available() throws IOException {
        return (int) Math.max(this.f6607a - ((long) this.f6608b), (long) this.in.available());
    }

    public final synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f6608b += i2;
        } else if (this.f6607a - ((long) this.f6608b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6607a + ", but read: " + this.f6608b);
        }
        return i2;
    }
}
