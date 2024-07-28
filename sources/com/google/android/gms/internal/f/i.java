package com.google.android.gms.internal.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class i extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f9471a;

    /* renamed from: b  reason: collision with root package name */
    private long f9472b = -1;

    i(InputStream inputStream) {
        super(inputStream);
        d.a(inputStream);
        this.f9471a = 1048577;
    }

    public final int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.f9471a);
    }

    public final synchronized void mark(int i2) {
        this.in.mark(i2);
        this.f9472b = this.f9471a;
    }

    public final int read() throws IOException {
        if (this.f9471a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f9471a--;
        }
        return read;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = this.f9471a;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i2, (int) Math.min((long) i3, j));
        if (read != -1) {
            this.f9471a -= (long) read;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f9472b != -1) {
            this.in.reset();
            this.f9471a = this.f9472b;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.f9471a));
        this.f9471a -= skip;
        return skip;
    }
}
