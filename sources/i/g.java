package i;

import java.io.IOException;
import java.util.zip.Deflater;

public final class g implements u {

    /* renamed from: a  reason: collision with root package name */
    private final d f46287a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f46288b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f46289c;

    public g(u uVar, Deflater deflater) {
        this(n.a(uVar), deflater);
    }

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f46287a = dVar;
            this.f46288b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final void write(c cVar, long j) throws IOException {
        x.a(cVar.f46277b, 0, j);
        while (j > 0) {
            r rVar = cVar.f46276a;
            int min = (int) Math.min(j, (long) (rVar.f46322c - rVar.f46321b));
            this.f46288b.setInput(rVar.f46320a, rVar.f46321b, min);
            a(false);
            long j2 = (long) min;
            cVar.f46277b -= j2;
            rVar.f46321b += min;
            if (rVar.f46321b == rVar.f46322c) {
                cVar.f46276a = rVar.c();
                s.a(rVar);
            }
            j -= j2;
        }
    }

    private void a(boolean z) throws IOException {
        r f2;
        int i2;
        c a2 = this.f46287a.a();
        while (true) {
            f2 = a2.f(1);
            if (z) {
                i2 = this.f46288b.deflate(f2.f46320a, f2.f46322c, 8192 - f2.f46322c, 2);
            } else {
                i2 = this.f46288b.deflate(f2.f46320a, f2.f46322c, 8192 - f2.f46322c);
            }
            if (i2 > 0) {
                f2.f46322c += i2;
                a2.f46277b += (long) i2;
                this.f46287a.x();
            } else if (this.f46288b.needsInput()) {
                break;
            }
        }
        if (f2.f46321b == f2.f46322c) {
            a2.f46276a = f2.c();
            s.a(f2);
        }
    }

    public final void flush() throws IOException {
        a(true);
        this.f46287a.flush();
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        this.f46288b.finish();
        a(false);
    }

    public final void close() throws IOException {
        if (!this.f46289c) {
            Throwable th = null;
            try {
                a();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f46288b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f46287a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f46289c = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    public final w timeout() {
        return this.f46287a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f46287a + ")";
    }
}
