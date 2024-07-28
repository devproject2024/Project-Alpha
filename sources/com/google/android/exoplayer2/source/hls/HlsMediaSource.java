package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.s;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.hls.a.c;
import com.google.android.exoplayer2.source.hls.a.e;
import com.google.android.exoplayer2.source.hls.a.h;
import com.google.android.exoplayer2.source.hls.a.i;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.t;
import java.io.IOException;
import java.util.List;

public final class HlsMediaSource extends b implements i.e {

    /* renamed from: b  reason: collision with root package name */
    private final f f33045b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f33046c;

    /* renamed from: d  reason: collision with root package name */
    private final e f33047d;

    /* renamed from: e  reason: collision with root package name */
    private final g f33048e;

    /* renamed from: f  reason: collision with root package name */
    private final w f33049f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f33050g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f33051h;

    /* renamed from: i  reason: collision with root package name */
    private final i f33052i;
    private final Object j;
    private ad k;

    /* synthetic */ HlsMediaSource(Uri uri, e eVar, f fVar, g gVar, w wVar, i iVar, boolean z, boolean z2, Object obj, byte b2) {
        this(uri, eVar, fVar, gVar, wVar, iVar, z, z2, obj);
    }

    static {
        n.a("goog.exo.hls");
    }

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final e f33053a;

        /* renamed from: b  reason: collision with root package name */
        private f f33054b;

        /* renamed from: c  reason: collision with root package name */
        private h f33055c;

        /* renamed from: d  reason: collision with root package name */
        private List<StreamKey> f33056d;

        /* renamed from: e  reason: collision with root package name */
        private i.a f33057e;

        /* renamed from: f  reason: collision with root package name */
        private g f33058f;

        /* renamed from: g  reason: collision with root package name */
        private w f33059g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f33060h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f33061i;
        private boolean j;
        private Object k;

        public Factory(i.a aVar) {
            this((e) new b(aVar));
        }

        private Factory(e eVar) {
            this.f33053a = (e) a.a(eVar);
            this.f33055c = new com.google.android.exoplayer2.source.hls.a.a();
            this.f33057e = com.google.android.exoplayer2.source.hls.a.b.f33074a;
            this.f33054b = f.f33162a;
            this.f33059g = new s();
            this.f33058f = new com.google.android.exoplayer2.source.h();
        }

        public final Factory setStreamKeys(List<StreamKey> list) {
            a.b(!this.j);
            this.f33056d = list;
            return this;
        }

        public final HlsMediaSource createMediaSource(Uri uri) {
            this.j = true;
            List<StreamKey> list = this.f33056d;
            if (list != null) {
                this.f33055c = new c(this.f33055c, list);
            }
            e eVar = this.f33053a;
            f fVar = this.f33054b;
            g gVar = this.f33058f;
            w wVar = this.f33059g;
            return new HlsMediaSource(uri, eVar, fVar, gVar, wVar, this.f33057e.createTracker(eVar, wVar, this.f33055c), this.f33060h, this.f33061i, this.k, (byte) 0);
        }
    }

    private HlsMediaSource(Uri uri, e eVar, f fVar, g gVar, w wVar, com.google.android.exoplayer2.source.hls.a.i iVar, boolean z, boolean z2, Object obj) {
        this.f33046c = uri;
        this.f33047d = eVar;
        this.f33045b = fVar;
        this.f33048e = gVar;
        this.f33049f = wVar;
        this.f33052i = iVar;
        this.f33050g = z;
        this.f33051h = z2;
        this.j = obj;
    }

    public final void a(ad adVar) {
        this.k = adVar;
        this.f33052i.a(this.f33046c, a((o.a) null), this);
    }

    public final void b() throws IOException {
        this.f33052i.d();
    }

    public final com.google.android.exoplayer2.source.n a(o.a aVar, com.google.android.exoplayer2.f.b bVar, long j2) {
        return new i(this.f33045b, this.f33052i, this.f33047d, this.k, this.f33049f, a(aVar), bVar, this.f33048e, this.f33050g, this.f33051h);
    }

    public final void a(com.google.android.exoplayer2.source.n nVar) {
        i iVar = (i) nVar;
        iVar.f33172a.b((i.b) iVar);
        for (k kVar : iVar.f33175d) {
            if (kVar.m) {
                for (t c2 : kVar.j) {
                    c2.c();
                }
            }
            kVar.f33186c.a((x.e) kVar);
            kVar.f33190g.removeCallbacksAndMessages((Object) null);
            kVar.q = true;
            kVar.f33191h.clear();
        }
        iVar.f33174c = null;
        iVar.f33173b.b();
    }

    public final void a() {
        this.f33052i.a();
    }

    public final void a(e eVar) {
        com.google.android.exoplayer2.source.x xVar;
        long j2;
        long j3;
        e eVar2 = eVar;
        long a2 = eVar2.j ? com.google.android.exoplayer2.c.a(eVar2.f33115c) : -9223372036854775807L;
        long j4 = (eVar2.f33113a == 2 || eVar2.f33113a == 1) ? a2 : -9223372036854775807L;
        long j5 = eVar2.f33114b;
        if (this.f33052i.e()) {
            long c2 = eVar2.f33115c - this.f33052i.c();
            long j6 = eVar2.f33121i ? c2 + eVar2.m : -9223372036854775807L;
            List<e.a> list = eVar2.l;
            if (j5 == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j3 = 0;
                } else {
                    j3 = list.get(Math.max(0, list.size() - 3)).f33127f;
                }
                j2 = j3;
            } else {
                j2 = j5;
            }
            xVar = new com.google.android.exoplayer2.source.x(j4, a2, j6, eVar2.m, c2, j2, true, !eVar2.f33121i, this.j);
        } else {
            xVar = new com.google.android.exoplayer2.source.x(j4, a2, eVar2.m, eVar2.m, 0, j5 == -9223372036854775807L ? 0 : j5, true, false, this.j);
        }
        a((ah) xVar, (Object) new g(this.f33052i.b(), eVar2));
    }
}
