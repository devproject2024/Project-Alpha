package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import java.io.IOException;

public final class i extends a {
    private static final n n = new n();
    private final int o;
    private final long p;
    private final e q;
    private long r;
    private volatile boolean s;
    private boolean t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(com.google.android.exoplayer2.f.i iVar, l lVar, Format format, int i2, Object obj, long j, long j2, long j3, long j4, long j5, int i3, long j6, e eVar) {
        super(iVar, lVar, format, i2, obj, j, j2, j3, j4, j5);
        this.o = i3;
        this.p = j6;
        this.q = eVar;
    }

    public final long f() {
        return this.m + ((long) this.o);
    }

    public final boolean g() {
        return this.t;
    }

    public final void a() {
        this.s = true;
    }

    public final void b() throws IOException, InterruptedException {
        d dVar;
        l a2 = this.f32814e.a(this.r);
        try {
            dVar = new d(this.l, a2.f32399e, this.l.a(a2));
            if (this.r == 0) {
                c cVar = this.f32807c;
                cVar.a(this.p);
                this.q.a(cVar, this.f32805a == -9223372036854775807L ? -9223372036854775807L : this.f32805a - this.p, this.f32806b == -9223372036854775807L ? -9223372036854775807L : this.f32806b - this.p);
            }
            g gVar = this.q.f32819a;
            boolean z = false;
            int i2 = 0;
            while (i2 == 0 && !this.s) {
                i2 = gVar.a((h) dVar, n);
            }
            if (i2 != 1) {
                z = true;
            }
            a.b(z);
            this.r = dVar.c() - this.f32814e.f32399e;
            ae.a((com.google.android.exoplayer2.f.i) this.l);
            this.t = true;
        } catch (Throwable th) {
            ae.a((com.google.android.exoplayer2.f.i) this.l);
            throw th;
        }
    }
}
