package i;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class l implements v {

    /* renamed from: a  reason: collision with root package name */
    private int f46296a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final e f46297b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f46298c;

    /* renamed from: d  reason: collision with root package name */
    private final m f46299d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f46300e = new CRC32();

    public l(v vVar) {
        if (vVar != null) {
            this.f46298c = new Inflater(true);
            this.f46297b = n.a(vVar);
            this.f46299d = new m(this.f46297b, this.f46298c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long read(c cVar, long j) throws IOException {
        long j2;
        c cVar2 = cVar;
        long j3 = j;
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f46296a == 0) {
                this.f46297b.a(10);
                byte c2 = this.f46297b.a().c(3);
                boolean z = ((c2 >> 1) & 1) == 1;
                if (z) {
                    a(this.f46297b.a(), 0, 10);
                }
                a("ID1ID2", 8075, (int) this.f46297b.h());
                this.f46297b.i(8);
                if (((c2 >> 2) & 1) == 1) {
                    this.f46297b.a(2);
                    if (z) {
                        a(this.f46297b.a(), 0, 2);
                    }
                    long k = (long) this.f46297b.a().k();
                    this.f46297b.a(k);
                    if (z) {
                        j2 = k;
                        a(this.f46297b.a(), 0, k);
                    } else {
                        j2 = k;
                    }
                    this.f46297b.i(j2);
                }
                if (((c2 >> 3) & 1) == 1) {
                    long u = this.f46297b.u();
                    if (u != -1) {
                        if (z) {
                            a(this.f46297b.a(), 0, u + 1);
                        }
                        this.f46297b.i(u + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((c2 >> 4) & 1) == 1) {
                    long u2 = this.f46297b.u();
                    if (u2 != -1) {
                        if (z) {
                            a(this.f46297b.a(), 0, u2 + 1);
                        }
                        this.f46297b.i(u2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    a("FHCRC", (int) this.f46297b.k(), (int) (short) ((int) this.f46300e.getValue()));
                    this.f46300e.reset();
                }
                this.f46296a = 1;
            }
            if (this.f46296a == 1) {
                long j4 = cVar2.f46277b;
                long read = this.f46299d.read(cVar2, j3);
                if (read != -1) {
                    a(cVar, j4, read);
                    return read;
                }
                this.f46296a = 2;
            }
            if (this.f46296a == 2) {
                a("CRC", this.f46297b.l(), (int) this.f46300e.getValue());
                a("ISIZE", this.f46297b.l(), (int) this.f46298c.getBytesWritten());
                this.f46296a = 3;
                if (!this.f46297b.d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final w timeout() {
        return this.f46297b.timeout();
    }

    public final void close() throws IOException {
        this.f46299d.close();
    }

    private void a(c cVar, long j, long j2) {
        r rVar = cVar.f46276a;
        while (j >= ((long) (rVar.f46322c - rVar.f46321b))) {
            j -= (long) (rVar.f46322c - rVar.f46321b);
            rVar = rVar.f46325f;
        }
        while (j2 > 0) {
            int i2 = (int) (((long) rVar.f46321b) + j);
            int min = (int) Math.min((long) (rVar.f46322c - i2), j2);
            this.f46300e.update(rVar.f46320a, i2, min);
            j2 -= (long) min;
            rVar = rVar.f46325f;
            j = 0;
        }
    }

    private static void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }
}
