package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f39284a;

    /* renamed from: b  reason: collision with root package name */
    private final t f39285b;

    /* renamed from: c  reason: collision with root package name */
    private final zzbg f39286c;

    /* renamed from: d  reason: collision with root package name */
    private long f39287d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f39288e;

    /* renamed from: f  reason: collision with root package name */
    private long f39289f = -1;

    public b(InputStream inputStream, t tVar, zzbg zzbg) {
        this.f39286c = zzbg;
        this.f39284a = inputStream;
        this.f39285b = tVar;
        this.f39288e = this.f39285b.f9726a.d();
    }

    public final int available() throws IOException {
        try {
            return this.f39284a.available();
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final void close() throws IOException {
        long b2 = this.f39286c.b();
        if (this.f39289f == -1) {
            this.f39289f = b2;
        }
        try {
            this.f39284a.close();
            if (this.f39287d != -1) {
                this.f39285b.e(this.f39287d);
            }
            if (this.f39288e != -1) {
                this.f39285b.c(this.f39288e);
            }
            this.f39285b.d(this.f39289f);
            this.f39285b.b();
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final void mark(int i2) {
        this.f39284a.mark(i2);
    }

    public final boolean markSupported() {
        return this.f39284a.markSupported();
    }

    public final int read() throws IOException {
        try {
            int read = this.f39284a.read();
            long b2 = this.f39286c.b();
            if (this.f39288e == -1) {
                this.f39288e = b2;
            }
            if (read == -1 && this.f39289f == -1) {
                this.f39289f = b2;
                this.f39285b.d(this.f39289f);
                this.f39285b.b();
            } else {
                this.f39287d++;
                this.f39285b.e(this.f39287d);
            }
            return read;
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            int read = this.f39284a.read(bArr, i2, i3);
            long b2 = this.f39286c.b();
            if (this.f39288e == -1) {
                this.f39288e = b2;
            }
            if (read == -1 && this.f39289f == -1) {
                this.f39289f = b2;
                this.f39285b.d(this.f39289f);
                this.f39285b.b();
            } else {
                this.f39287d += (long) read;
                this.f39285b.e(this.f39287d);
            }
            return read;
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.f39284a.read(bArr);
            long b2 = this.f39286c.b();
            if (this.f39288e == -1) {
                this.f39288e = b2;
            }
            if (read == -1 && this.f39289f == -1) {
                this.f39289f = b2;
                this.f39285b.d(this.f39289f);
                this.f39285b.b();
            } else {
                this.f39287d += (long) read;
                this.f39285b.e(this.f39287d);
            }
            return read;
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final void reset() throws IOException {
        try {
            this.f39284a.reset();
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.f39284a.skip(j);
            long b2 = this.f39286c.b();
            if (this.f39288e == -1) {
                this.f39288e = b2;
            }
            if (skip == -1 && this.f39289f == -1) {
                this.f39289f = b2;
                this.f39285b.d(this.f39289f);
            } else {
                this.f39287d += skip;
                this.f39285b.e(this.f39287d);
            }
            return skip;
        } catch (IOException e2) {
            this.f39285b.d(this.f39286c.b());
            g.a(this.f39285b);
            throw e2;
        }
    }
}
