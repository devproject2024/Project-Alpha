package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.b.e;
import java.io.IOException;

public final class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final n f32853a = new n();

    /* renamed from: b  reason: collision with root package name */
    private final e f32854b;

    /* renamed from: c  reason: collision with root package name */
    private long f32855c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f32856d;

    public k(i iVar, l lVar, Format format, int i2, Object obj, e eVar) {
        super(iVar, lVar, 2, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f32854b = eVar;
    }

    public final void a() {
        this.f32856d = true;
    }

    public final void b() throws IOException, InterruptedException {
        d dVar;
        l a2 = this.f32814e.a(this.f32855c);
        try {
            dVar = new d(this.l, a2.f32399e, this.l.a(a2));
            if (this.f32855c == 0) {
                this.f32854b.a((e.b) null, -9223372036854775807L, -9223372036854775807L);
            }
            g gVar = this.f32854b.f32819a;
            int i2 = 0;
            while (i2 == 0 && !this.f32856d) {
                i2 = gVar.a((h) dVar, f32853a);
            }
            boolean z = true;
            if (i2 == 1) {
                z = false;
            }
            a.b(z);
            this.f32855c = dVar.c() - this.f32814e.f32399e;
            ae.a((i) this.l);
        } catch (Throwable th) {
            ae.a((i) this.l);
            throw th;
        }
    }
}
