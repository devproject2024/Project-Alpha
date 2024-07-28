package com.bumptech.glide.g;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class d extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private static final Queue<d> f6609b = k.a(0);

    /* renamed from: a  reason: collision with root package name */
    public IOException f6610a;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f6611c;

    public static d a(InputStream inputStream) {
        d poll;
        synchronized (f6609b) {
            poll = f6609b.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.f6611c = inputStream;
        return poll;
    }

    d() {
    }

    public final int available() throws IOException {
        return this.f6611c.available();
    }

    public final void close() throws IOException {
        this.f6611c.close();
    }

    public final void mark(int i2) {
        this.f6611c.mark(i2);
    }

    public final boolean markSupported() {
        return this.f6611c.markSupported();
    }

    public final int read(byte[] bArr) {
        try {
            return this.f6611c.read(bArr);
        } catch (IOException e2) {
            this.f6610a = e2;
            return -1;
        }
    }

    public final int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f6611c.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f6610a = e2;
            return -1;
        }
    }

    public final synchronized void reset() throws IOException {
        this.f6611c.reset();
    }

    public final long skip(long j) {
        try {
            return this.f6611c.skip(j);
        } catch (IOException e2) {
            this.f6610a = e2;
            return 0;
        }
    }

    public final int read() {
        try {
            return this.f6611c.read();
        } catch (IOException e2) {
            this.f6610a = e2;
            return -1;
        }
    }

    public final void a() {
        this.f6610a = null;
        this.f6611c = null;
        synchronized (f6609b) {
            f6609b.offer(this);
        }
    }
}
