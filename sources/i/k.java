package i;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class k implements u {

    /* renamed from: a  reason: collision with root package name */
    private final d f46291a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f46292b;

    /* renamed from: c  reason: collision with root package name */
    private final g f46293c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f46294d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f46295e = new CRC32();

    public k(u uVar) {
        if (uVar != null) {
            this.f46292b = new Deflater(-1, true);
            this.f46291a = n.a(uVar);
            this.f46293c = new g(this.f46291a, this.f46292b);
            c a2 = this.f46291a.a();
            a2.i(8075);
            a2.j(8);
            a2.j(0);
            a2.h(0);
            a2.j(0);
            a2.j(0);
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final void write(c cVar, long j) throws IOException {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (i2 != 0) {
            a(cVar, j);
            this.f46293c.write(cVar, j);
        }
    }

    public final void flush() throws IOException {
        this.f46293c.flush();
    }

    public final w timeout() {
        return this.f46291a.timeout();
    }

    public final void close() throws IOException {
        if (!this.f46294d) {
            Throwable th = null;
            try {
                this.f46293c.a();
                this.f46291a.g((int) this.f46295e.getValue());
                this.f46291a.g((int) this.f46292b.getBytesRead());
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f46292b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f46291a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f46294d = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    private void a(c cVar, long j) {
        r rVar = cVar.f46276a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (rVar.f46322c - rVar.f46321b));
            this.f46295e.update(rVar.f46320a, rVar.f46321b, min);
            j -= (long) min;
            rVar = rVar.f46325f;
        }
    }
}
