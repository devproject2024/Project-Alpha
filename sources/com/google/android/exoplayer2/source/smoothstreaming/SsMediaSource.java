package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.s;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.b.g;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.a.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SsMediaSource extends b implements x.a<z<a>> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33304b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f33305c;

    /* renamed from: d  reason: collision with root package name */
    private final i.a f33306d;

    /* renamed from: e  reason: collision with root package name */
    private final b.a f33307e;

    /* renamed from: f  reason: collision with root package name */
    private final g f33308f;

    /* renamed from: g  reason: collision with root package name */
    private final w f33309g;

    /* renamed from: h  reason: collision with root package name */
    private final long f33310h;

    /* renamed from: i  reason: collision with root package name */
    private final p.a f33311i;
    private final z.a<? extends a> j;
    private final ArrayList<c> k;
    private final Object l;
    private i m;
    private x n;
    private y o;
    private ad p;
    private long q;
    private a r;
    private Handler s;

    /* synthetic */ SsMediaSource(Uri uri, i.a aVar, z.a aVar2, b.a aVar3, g gVar, w wVar, long j2, Object obj, byte b2) {
        this(uri, aVar, aVar2, aVar3, gVar, wVar, j2, obj);
    }

    public final /* bridge */ /* synthetic */ x.b a(x.d dVar, long j2, long j3, IOException iOException, int i2) {
        x.b bVar;
        z zVar = (z) dVar;
        long a2 = this.f33309g.a(iOException, i2);
        if (a2 == -9223372036854775807L) {
            bVar = x.f32467d;
        } else {
            bVar = x.a(false, a2);
        }
        this.f33311i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j2, j3, zVar.f32485c.f32353a, iOException, !bVar.a());
        return bVar;
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
        z zVar = (z) dVar;
        this.f33311i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j2, j3, zVar.f32485c.f32353a);
        this.r = (a) zVar.f32486d;
        this.q = j2 - j3;
        c();
        if (this.r.f33333d) {
            this.s.postDelayed(new Runnable() {
                public final void run() {
                    SsMediaSource.this.d();
                }
            }, Math.max(0, (this.q + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z) {
        z zVar = (z) dVar;
        this.f33311i.b(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j2, j3, zVar.f32485c.f32353a);
    }

    static {
        n.a("goog.exo.smoothstreaming");
    }

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final b.a f33312a;

        /* renamed from: b  reason: collision with root package name */
        private final i.a f33313b;

        /* renamed from: c  reason: collision with root package name */
        private z.a<? extends a> f33314c;

        /* renamed from: d  reason: collision with root package name */
        private List<StreamKey> f33315d;

        /* renamed from: e  reason: collision with root package name */
        private g f33316e;

        /* renamed from: f  reason: collision with root package name */
        private w f33317f;

        /* renamed from: g  reason: collision with root package name */
        private long f33318g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f33319h;

        /* renamed from: i  reason: collision with root package name */
        private Object f33320i;

        public Factory(i.a aVar) {
            this(new a.C0550a(aVar), aVar);
        }

        public Factory(b.a aVar, i.a aVar2) {
            this.f33312a = (b.a) com.google.android.exoplayer2.g.a.a(aVar);
            this.f33313b = aVar2;
            this.f33317f = new s();
            this.f33318g = 30000;
            this.f33316e = new h();
        }

        public final Factory setStreamKeys(List<StreamKey> list) {
            com.google.android.exoplayer2.g.a.b(!this.f33319h);
            this.f33315d = list;
            return this;
        }

        public final SsMediaSource createMediaSource(Uri uri) {
            this.f33319h = true;
            if (this.f33314c == null) {
                this.f33314c = new com.google.android.exoplayer2.source.smoothstreaming.a.b();
            }
            List<StreamKey> list = this.f33315d;
            if (list != null) {
                this.f33314c = new com.google.android.exoplayer2.offline.b(this.f33314c, list);
            }
            return new SsMediaSource((Uri) com.google.android.exoplayer2.g.a.a(uri), this.f33313b, this.f33314c, this.f33312a, this.f33316e, this.f33317f, this.f33318g, this.f33320i, (byte) 0);
        }
    }

    private SsMediaSource(Uri uri, i.a aVar, z.a<? extends com.google.android.exoplayer2.source.smoothstreaming.a.a> aVar2, b.a aVar3, g gVar, w wVar, long j2, Object obj) {
        com.google.android.exoplayer2.g.a.b(true);
        this.r = null;
        if (uri == null) {
            uri = null;
        } else {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null || !ae.d(lastPathSegment).matches("manifest(\\(.+\\))?")) {
                uri = Uri.withAppendedPath(uri, "Manifest");
            }
        }
        this.f33305c = uri;
        this.f33306d = aVar;
        this.j = aVar2;
        this.f33307e = aVar3;
        this.f33308f = gVar;
        this.f33309g = wVar;
        this.f33310h = j2;
        this.f33311i = a((o.a) null);
        this.l = obj;
        this.f33304b = false;
        this.k = new ArrayList<>();
    }

    public final void a(ad adVar) {
        this.p = adVar;
        if (this.f33304b) {
            this.o = new y.a();
            c();
            return;
        }
        this.m = this.f33306d.a();
        this.n = new x("Loader:Manifest");
        this.o = this.n;
        this.s = new Handler();
        d();
    }

    public final void b() throws IOException {
        this.o.a();
    }

    public final com.google.android.exoplayer2.source.n a(o.a aVar, com.google.android.exoplayer2.f.b bVar, long j2) {
        c cVar = new c(this.r, this.f33307e, this.p, this.f33308f, this.f33309g, a(aVar), this.o, bVar);
        this.k.add(cVar);
        return cVar;
    }

    public final void a(com.google.android.exoplayer2.source.n nVar) {
        c cVar = (c) nVar;
        for (com.google.android.exoplayer2.source.b.g<b> a2 : cVar.f33381c) {
            a2.a((g.b<b>) null);
        }
        cVar.f33380b = null;
        cVar.f33379a.b();
        this.k.remove(nVar);
    }

    public final void a() {
        this.r = this.f33304b ? this.r : null;
        this.m = null;
        this.q = 0;
        x xVar = this.n;
        if (xVar != null) {
            xVar.a((x.e) null);
            this.n = null;
        }
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.s = null;
        }
    }

    private void c() {
        com.google.android.exoplayer2.source.x xVar;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.k.get(i2).a(this.r);
        }
        long j2 = Long.MIN_VALUE;
        long j3 = Long.MAX_VALUE;
        for (a.b bVar : this.r.f33335f) {
            if (bVar.k > 0) {
                long min = Math.min(j3, bVar.o[0]);
                j2 = Math.max(j2, bVar.o[bVar.k - 1] + bVar.a(bVar.k - 1));
                j3 = min;
            }
        }
        if (j3 == Long.MAX_VALUE) {
            xVar = new com.google.android.exoplayer2.source.x(this.r.f33333d ? -9223372036854775807L : 0, 0, 0, 0, true, this.r.f33333d, this.l);
        } else if (this.r.f33333d) {
            if (this.r.f33337h != -9223372036854775807L && this.r.f33337h > 0) {
                j3 = Math.max(j3, j2 - this.r.f33337h);
            }
            long j4 = j3;
            long j5 = j2 - j4;
            long b2 = j5 - c.b(this.f33310h);
            if (b2 < 5000000) {
                b2 = Math.min(5000000, j5 / 2);
            }
            xVar = new com.google.android.exoplayer2.source.x(-9223372036854775807L, j5, j4, b2, true, true, this.l);
        } else {
            long j6 = this.r.f33336g != -9223372036854775807L ? this.r.f33336g : j2 - j3;
            xVar = new com.google.android.exoplayer2.source.x(j3 + j6, j6, j3, 0, true, false, this.l);
        }
        a((ah) xVar, (Object) this.r);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (!this.n.b()) {
            z zVar = new z(this.m, this.f33305c, 4, this.j);
            this.f33311i.a(zVar.f32483a, zVar.f32484b, this.n.a(zVar, this, this.f33309g.a(zVar.f32484b)));
        }
    }
}
