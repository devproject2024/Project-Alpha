package i;

import java.io.IOException;
import java.nio.ByteBuffer;

final class p implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f46313a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final u f46314b;

    /* renamed from: c  reason: collision with root package name */
    boolean f46315c;

    p(u uVar) {
        if (uVar != null) {
            this.f46314b = uVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public final c a() {
        return this.f46313a;
    }

    public final void write(c cVar, long j) throws IOException {
        if (!this.f46315c) {
            this.f46313a.write(cVar, j);
            x();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final d d(f fVar) throws IOException {
        if (!this.f46315c) {
            this.f46313a.d(fVar);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d b(String str) throws IOException {
        if (!this.f46315c) {
            this.f46313a.b(str);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d b(String str, int i2, int i3) throws IOException {
        if (!this.f46315c) {
            this.f46313a.b(str, i2, i3);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d c(byte[] bArr) throws IOException {
        if (!this.f46315c) {
            this.f46313a.c(bArr);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f46315c) {
            this.f46313a.c(bArr, i2, i3);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f46315c) {
            int write = this.f46313a.write(byteBuffer);
            x();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public final long a(v vVar) throws IOException {
        if (vVar != null) {
            long j = 0;
            while (true) {
                long read = vVar.read(this.f46313a, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                x();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final d j(int i2) throws IOException {
        if (!this.f46315c) {
            this.f46313a.j(i2);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d i(int i2) throws IOException {
        if (!this.f46315c) {
            this.f46313a.i(i2);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d h(int i2) throws IOException {
        if (!this.f46315c) {
            this.f46313a.h(i2);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d g(int i2) throws IOException {
        if (!this.f46315c) {
            this.f46313a.g(i2);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d n(long j) throws IOException {
        if (!this.f46315c) {
            this.f46313a.n(j);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d m(long j) throws IOException {
        if (!this.f46315c) {
            this.f46313a.m(j);
            return x();
        }
        throw new IllegalStateException("closed");
    }

    public final d x() throws IOException {
        if (!this.f46315c) {
            long f2 = this.f46313a.f();
            if (f2 > 0) {
                this.f46314b.write(this.f46313a, f2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final d c() throws IOException {
        if (!this.f46315c) {
            long j = this.f46313a.f46277b;
            if (j > 0) {
                this.f46314b.write(this.f46313a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final void flush() throws IOException {
        if (!this.f46315c) {
            if (this.f46313a.f46277b > 0) {
                u uVar = this.f46314b;
                c cVar = this.f46313a;
                uVar.write(cVar, cVar.f46277b);
            }
            this.f46314b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean isOpen() {
        return !this.f46315c;
    }

    public final void close() throws IOException {
        if (!this.f46315c) {
            Throwable th = null;
            try {
                if (this.f46313a.f46277b > 0) {
                    this.f46314b.write(this.f46313a, this.f46313a.f46277b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f46314b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f46315c = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    public final w timeout() {
        return this.f46314b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f46314b + ")";
    }
}
