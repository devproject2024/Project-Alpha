package i;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class q implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f46316a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final v f46317b;

    /* renamed from: c  reason: collision with root package name */
    boolean f46318c;

    q(v vVar) {
        if (vVar != null) {
            this.f46317b = vVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final c a() {
        return this.f46316a;
    }

    public final c b() {
        return this.f46316a;
    }

    public final long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f46318c) {
            throw new IllegalStateException("closed");
        } else if (this.f46316a.f46277b == 0 && this.f46317b.read(this.f46316a, 8192) == -1) {
            return -1;
        } else {
            return this.f46316a.read(cVar, Math.min(j, this.f46316a.f46277b));
        }
    }

    public final boolean d() throws IOException {
        if (!this.f46318c) {
            return this.f46316a.d() && this.f46317b.read(this.f46316a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public final boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (!this.f46318c) {
            while (this.f46316a.f46277b < j) {
                if (this.f46317b.read(this.f46316a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final byte g() throws IOException {
        a(1);
        return this.f46316a.g();
    }

    public final f d(long j) throws IOException {
        a(j);
        return this.f46316a.d(j);
    }

    public final int a(o oVar) throws IOException {
        if (!this.f46318c) {
            do {
                int a2 = this.f46316a.a(oVar, true);
                if (a2 == -1) {
                    return -1;
                }
                if (a2 != -2) {
                    this.f46316a.i((long) oVar.f46311a[a2].size());
                    return a2;
                }
            } while (this.f46317b.read(this.f46316a, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public final byte[] s() throws IOException {
        this.f46316a.a(this.f46317b);
        return this.f46316a.s();
    }

    public final byte[] h(long j) throws IOException {
        a(j);
        return this.f46316a.h(j);
    }

    public final void a(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.f46316a.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.f46316a.f46277b > 0) {
                c cVar = this.f46316a;
                int a2 = cVar.a(bArr, i2, (int) cVar.f46277b);
                if (a2 != -1) {
                    i2 += a2;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f46316a.f46277b == 0 && this.f46317b.read(this.f46316a, 8192) == -1) {
            return -1;
        }
        return this.f46316a.read(byteBuffer);
    }

    public final void a(c cVar, long j) throws IOException {
        try {
            a(j);
            this.f46316a.a(cVar, j);
        } catch (EOFException e2) {
            cVar.a((v) this.f46316a);
            throw e2;
        }
    }

    public final long a(u uVar) throws IOException {
        long j = 0;
        while (this.f46317b.read(this.f46316a, 8192) != -1) {
            long f2 = this.f46316a.f();
            if (f2 > 0) {
                j += f2;
                uVar.write(this.f46316a, f2);
            }
        }
        if (this.f46316a.f46277b <= 0) {
            return j;
        }
        long j2 = j + this.f46316a.f46277b;
        c cVar = this.f46316a;
        uVar.write(cVar, cVar.f46277b);
        return j2;
    }

    public final String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f46316a.a(this.f46317b);
            return this.f46316a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String a(long j, Charset charset) throws IOException {
        a(j);
        if (charset != null) {
            return this.f46316a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String r() throws IOException {
        return f(Long.MAX_VALUE);
    }

    public final String f(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return this.f46316a.g(a2);
            }
            if (j2 < Long.MAX_VALUE && b(j2) && this.f46316a.c(j2 - 1) == 13 && b(1 + j2) && this.f46316a.c(j2) == 10) {
                return this.f46316a.g(j2);
            }
            c cVar = new c();
            c cVar2 = this.f46316a;
            cVar2.a(cVar, 0, Math.min(32, cVar2.f46277b));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f46316a.f46277b, j) + " content=" + cVar.p().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    public final short h() throws IOException {
        a(2);
        return this.f46316a.h();
    }

    public final short k() throws IOException {
        a(2);
        return x.a(this.f46316a.h());
    }

    public final int i() throws IOException {
        a(4);
        return this.f46316a.i();
    }

    public final int l() throws IOException {
        a(4);
        return x.a(this.f46316a.i());
    }

    public final long j() throws IOException {
        a(8);
        return this.f46316a.j();
    }

    public final long m() throws IOException {
        a(8);
        return x.a(this.f46316a.j());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long n() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a((long) r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.b((long) r3)
            if (r3 == 0) goto L_0x0040
            i.c r3 = r6.f46316a
            long r4 = (long) r1
            byte r3 = r3.c((long) r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            i.c r0 = r6.f46316a
            long r0 = r0.n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.q.n():long");
    }

    public final long o() throws IOException {
        a(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!b((long) i3)) {
                break;
            }
            byte c2 = this.f46316a.c((long) i2);
            if ((c2 >= 48 && c2 <= 57) || ((c2 >= 97 && c2 <= 102) || (c2 >= 65 && c2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(c2)}));
            }
        }
        return this.f46316a.o();
    }

    public final void i(long j) throws IOException {
        if (!this.f46318c) {
            while (j > 0) {
                if (this.f46316a.f46277b == 0 && this.f46317b.read(this.f46316a, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f46316a.f46277b);
                this.f46316a.i(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final long u() throws IOException {
        return a((byte) 0, 0, Long.MAX_VALUE);
    }

    private long a(byte b2, long j, long j2) throws IOException {
        if (this.f46318c) {
            throw new IllegalStateException("closed");
        } else if (j2 >= 0) {
            while (j < j2) {
                long a2 = this.f46316a.a(b2, j, j2);
                if (a2 == -1) {
                    long j3 = this.f46316a.f46277b;
                    if (j3 >= j2 || this.f46317b.read(this.f46316a, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a2;
                }
            }
            return -1;
        } else {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{0L, Long.valueOf(j2)}));
        }
    }

    public final boolean a(long j, f fVar) throws IOException {
        int size = fVar.size();
        if (this.f46318c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || size < 0 || fVar.size() - 0 < size) {
            return false;
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                long j2 = ((long) i2) + j;
                if (!b(1 + j2) || this.f46316a.c(j2) != fVar.getByte(i2 + 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final InputStream e() {
        return new InputStream() {
            public final int read() throws IOException {
                if (q.this.f46318c) {
                    throw new IOException("closed");
                } else if (q.this.f46316a.f46277b == 0 && q.this.f46317b.read(q.this.f46316a, 8192) == -1) {
                    return -1;
                } else {
                    return q.this.f46316a.g() & 255;
                }
            }

            public final int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!q.this.f46318c) {
                    x.a((long) bArr.length, (long) i2, (long) i3);
                    if (q.this.f46316a.f46277b == 0 && q.this.f46317b.read(q.this.f46316a, 8192) == -1) {
                        return -1;
                    }
                    return q.this.f46316a.a(bArr, i2, i3);
                }
                throw new IOException("closed");
            }

            public final int available() throws IOException {
                if (!q.this.f46318c) {
                    return (int) Math.min(q.this.f46316a.f46277b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public final void close() throws IOException {
                q.this.close();
            }

            public final String toString() {
                return q.this + ".inputStream()";
            }
        };
    }

    public final boolean isOpen() {
        return !this.f46318c;
    }

    public final void close() throws IOException {
        if (!this.f46318c) {
            this.f46318c = true;
            this.f46317b.close();
            this.f46316a.t();
        }
    }

    public final w timeout() {
        return this.f46317b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f46317b + ")";
    }

    public final long b(f fVar) throws IOException {
        if (!this.f46318c) {
            long j = 0;
            while (true) {
                long a2 = this.f46316a.a(fVar, j);
                if (a2 != -1) {
                    return a2;
                }
                long j2 = this.f46316a.f46277b;
                if (this.f46317b.read(this.f46316a, 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, (j2 - ((long) fVar.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final long c(f fVar) throws IOException {
        if (!this.f46318c) {
            long j = 0;
            while (true) {
                long b2 = this.f46316a.b(fVar, j);
                if (b2 != -1) {
                    return b2;
                }
                long j2 = this.f46316a.f46277b;
                if (this.f46317b.read(this.f46316a, 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }
}
