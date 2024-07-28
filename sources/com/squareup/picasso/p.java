package com.squareup.picasso;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class p extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    boolean f45431a;

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f45432b;

    /* renamed from: c  reason: collision with root package name */
    private long f45433c;

    /* renamed from: d  reason: collision with root package name */
    private long f45434d;

    /* renamed from: e  reason: collision with root package name */
    private long f45435e;

    /* renamed from: f  reason: collision with root package name */
    private long f45436f;

    /* renamed from: g  reason: collision with root package name */
    private int f45437g;

    p(InputStream inputStream) {
        this(inputStream, (byte) 0);
    }

    private p(InputStream inputStream, byte b2) {
        this(inputStream, 0);
    }

    private p(InputStream inputStream, char c2) {
        this.f45436f = -1;
        this.f45431a = true;
        this.f45437g = -1;
        this.f45432b = !inputStream.markSupported() ? new BufferedInputStream(inputStream, 4096) : inputStream;
        this.f45437g = TarConstants.EOF_BLOCK;
    }

    public final void mark(int i2) {
        this.f45436f = a(i2);
    }

    public final long a(int i2) {
        long j = this.f45433c + ((long) i2);
        if (this.f45435e < j) {
            b(j);
        }
        return this.f45433c;
    }

    private void b(long j) {
        try {
            if (this.f45434d >= this.f45433c || this.f45433c > this.f45435e) {
                this.f45434d = this.f45433c;
                this.f45432b.mark((int) (j - this.f45433c));
            } else {
                this.f45432b.reset();
                this.f45432b.mark((int) (j - this.f45434d));
                a(this.f45434d, this.f45433c);
            }
            this.f45435e = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: ".concat(String.valueOf(e2)));
        }
    }

    public final void reset() throws IOException {
        a(this.f45436f);
    }

    public final void a(long j) throws IOException {
        if (this.f45433c > this.f45435e || j < this.f45434d) {
            throw new IOException("Cannot reset");
        }
        this.f45432b.reset();
        a(this.f45434d, j);
        this.f45433c = j;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f45432b.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public final int read() throws IOException {
        if (!this.f45431a) {
            long j = this.f45435e;
            if (this.f45433c + 1 > j) {
                b(j + ((long) this.f45437g));
            }
        }
        int read = this.f45432b.read();
        if (read != -1) {
            this.f45433c++;
        }
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        if (!this.f45431a) {
            long j = this.f45433c;
            if (((long) bArr.length) + j > this.f45435e) {
                b(j + ((long) bArr.length) + ((long) this.f45437g));
            }
        }
        int read = this.f45432b.read(bArr);
        if (read != -1) {
            this.f45433c += (long) read;
        }
        return read;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f45431a) {
            long j = this.f45433c;
            long j2 = (long) i3;
            if (j + j2 > this.f45435e) {
                b(j + j2 + ((long) this.f45437g));
            }
        }
        int read = this.f45432b.read(bArr, i2, i3);
        if (read != -1) {
            this.f45433c += (long) read;
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        if (!this.f45431a) {
            long j2 = this.f45433c;
            if (j2 + j > this.f45435e) {
                b(j2 + j + ((long) this.f45437g));
            }
        }
        long skip = this.f45432b.skip(j);
        this.f45433c += skip;
        return skip;
    }

    public final int available() throws IOException {
        return this.f45432b.available();
    }

    public final void close() throws IOException {
        this.f45432b.close();
    }

    public final boolean markSupported() {
        return this.f45432b.markSupported();
    }
}
