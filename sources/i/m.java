package i;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class m implements v {

    /* renamed from: a  reason: collision with root package name */
    private final e f46301a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f46302b;

    /* renamed from: c  reason: collision with root package name */
    private int f46303c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f46304d;

    public m(v vVar, Inflater inflater) {
        this(n.a(vVar), inflater);
    }

    m(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f46301a = eVar;
            this.f46302b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final long read(c cVar, long j) throws IOException {
        r f2;
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f46304d) {
            throw new IllegalStateException("closed");
        } else if (i2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    f2 = cVar.f(1);
                    int inflate = this.f46302b.inflate(f2.f46320a, f2.f46322c, (int) Math.min(j, (long) (8192 - f2.f46322c)));
                    if (inflate > 0) {
                        f2.f46322c += inflate;
                        long j2 = (long) inflate;
                        cVar.f46277b += j2;
                        return j2;
                    } else if (this.f46302b.finished()) {
                        break;
                    } else if (this.f46302b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            b();
            if (f2.f46321b != f2.f46322c) {
                return -1;
            }
            cVar.f46276a = f2.c();
            s.a(f2);
            return -1;
        }
    }

    public final boolean a() throws IOException {
        if (!this.f46302b.needsInput()) {
            return false;
        }
        b();
        if (this.f46302b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f46301a.d()) {
            return true;
        } else {
            r rVar = this.f46301a.a().f46276a;
            this.f46303c = rVar.f46322c - rVar.f46321b;
            this.f46302b.setInput(rVar.f46320a, rVar.f46321b, this.f46303c);
            return false;
        }
    }

    private void b() throws IOException {
        int i2 = this.f46303c;
        if (i2 != 0) {
            int remaining = i2 - this.f46302b.getRemaining();
            this.f46303c -= remaining;
            this.f46301a.i((long) remaining);
        }
    }

    public final w timeout() {
        return this.f46301a.timeout();
    }

    public final void close() throws IOException {
        if (!this.f46304d) {
            this.f46302b.end();
            this.f46304d = true;
            this.f46301a.close();
        }
    }
}
