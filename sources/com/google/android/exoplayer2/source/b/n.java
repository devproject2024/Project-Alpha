package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.ae;
import java.io.IOException;

public final class n extends a {
    private final int n;
    private final Format o;
    private long p;
    private boolean q;

    public final void a() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(i iVar, l lVar, Format format, int i2, Object obj, long j, long j2, long j3, int i3, Format format2) {
        super(iVar, lVar, format, i2, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.n = i3;
        this.o = format2;
    }

    public final boolean g() {
        return this.q;
    }

    /* JADX INFO: finally extract failed */
    public final void b() throws IOException, InterruptedException {
        try {
            long a2 = this.l.a(this.f32814e.a(this.p));
            if (a2 != -1) {
                a2 += this.p;
            }
            d dVar = new d(this.l, this.p, a2);
            c cVar = this.f32807c;
            cVar.a(0);
            q a3 = cVar.a(this.n);
            a3.a(this.o);
            for (int i2 = 0; i2 != -1; i2 = a3.a(dVar, Integer.MAX_VALUE, true)) {
                this.p += (long) i2;
            }
            a3.a(this.j, 1, (int) this.p, 0, (q.a) null);
            ae.a((i) this.l);
            this.q = true;
        } catch (Throwable th) {
            ae.a((i) this.l);
            throw th;
        }
    }
}
