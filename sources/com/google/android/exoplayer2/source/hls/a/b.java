package com.google.android.exoplayer2.source.hls.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.source.hls.a.d;
import com.google.android.exoplayer2.source.hls.a.e;
import com.google.android.exoplayer2.source.hls.a.i;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b implements x.a<z<f>>, i {

    /* renamed from: a  reason: collision with root package name */
    public static final i.a f33074a = $$Lambda$XC06283wlCgLIpLEJnw4xhxg9kA.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f33075b;

    /* renamed from: c  reason: collision with root package name */
    private final h f33076c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final w f33077d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<Uri, a> f33078e;

    /* renamed from: f  reason: collision with root package name */
    private final List<i.b> f33079f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final double f33080g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public z.a<f> f33081h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public p.a f33082i;
    private x j;
    /* access modifiers changed from: private */
    public Handler k;
    private i.e l;
    private d m;
    /* access modifiers changed from: private */
    public Uri n;
    private e o;
    private boolean p;
    private long q;

    public final /* bridge */ /* synthetic */ x.b a(x.d dVar, long j2, long j3, IOException iOException, int i2) {
        z zVar = (z) dVar;
        long a2 = this.f33077d.a(iOException, i2);
        boolean z = a2 == -9223372036854775807L;
        long j4 = a2;
        this.f33082i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a, iOException, z);
        if (z) {
            return x.f32467d;
        }
        return x.a(false, j4);
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
        d dVar2;
        z zVar = (z) dVar;
        f fVar = (f) zVar.f32486d;
        boolean z = fVar instanceof e;
        if (z) {
            dVar2 = d.a(fVar.n);
        } else {
            dVar2 = (d) fVar;
        }
        this.m = dVar2;
        this.f33081h = this.f33076c.a(dVar2);
        this.n = dVar2.f33096c.get(0).f33107a;
        List<Uri> list = dVar2.f33095b;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.f33078e.put(uri, new a(uri));
        }
        a aVar = this.f33078e.get(this.n);
        if (z) {
            aVar.a((e) fVar);
        } else {
            aVar.a();
        }
        this.f33082i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a);
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z) {
        z zVar = (z) dVar;
        this.f33082i.b(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a);
    }

    public b(e eVar, w wVar, h hVar) {
        this(eVar, wVar, hVar, (byte) 0);
    }

    private b(e eVar, w wVar, h hVar, byte b2) {
        this.f33075b = eVar;
        this.f33076c = hVar;
        this.f33077d = wVar;
        this.f33080g = 3.5d;
        this.f33079f = new ArrayList();
        this.f33078e = new HashMap<>();
        this.q = -9223372036854775807L;
    }

    public final void a(Uri uri, p.a aVar, i.e eVar) {
        this.k = new Handler();
        this.f33082i = aVar;
        this.l = eVar;
        z zVar = new z(this.f33075b.a(), uri, 4, this.f33076c.a());
        com.google.android.exoplayer2.g.a.b(this.j == null);
        this.j = new x("DefaultHlsPlaylistTracker:MasterPlaylist");
        aVar.a(zVar.f32483a, zVar.f32484b, this.j.a(zVar, this, this.f33077d.a(zVar.f32484b)));
    }

    public final void a() {
        this.n = null;
        this.o = null;
        this.m = null;
        this.q = -9223372036854775807L;
        this.j.a((x.e) null);
        this.j = null;
        for (a aVar : this.f33078e.values()) {
            aVar.f33083a.a((x.e) null);
        }
        this.k.removeCallbacksAndMessages((Object) null);
        this.k = null;
        this.f33078e.clear();
    }

    public final void a(i.b bVar) {
        this.f33079f.add(bVar);
    }

    public final void b(i.b bVar) {
        this.f33079f.remove(bVar);
    }

    public final d b() {
        return this.m;
    }

    public final e a(Uri uri, boolean z) {
        e eVar;
        e eVar2 = this.f33078e.get(uri).f33084b;
        if (eVar2 != null && z && !uri.equals(this.n)) {
            List<d.b> list = this.m.f33096c;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (uri.equals(list.get(i2).f33107a)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2 && ((eVar = this.o) == null || !eVar.f33121i)) {
                this.n = uri;
                this.f33078e.get(this.n).a();
            }
        }
        return eVar2;
    }

    public final long c() {
        return this.q;
    }

    public final boolean a(Uri uri) {
        a aVar = this.f33078e.get(uri);
        if (aVar.f33084b == null) {
            return false;
        }
        return aVar.f33084b.f33121i || aVar.f33084b.f33113a == 2 || aVar.f33084b.f33113a == 1 || aVar.f33085c + Math.max(30000, c.a(aVar.f33084b.m)) > SystemClock.elapsedRealtime();
    }

    public final void d() throws IOException {
        Uri uri = this.n;
        if (uri != null) {
            b(uri);
        }
    }

    public final void b(Uri uri) throws IOException {
        this.f33078e.get(uri);
    }

    public final void c(Uri uri) {
        this.f33078e.get(uri).a();
    }

    public final boolean e() {
        return this.p;
    }

    private static e.a a(e eVar, e eVar2) {
        int i2 = (int) (eVar2.f33118f - eVar.f33118f);
        List<e.a> list = eVar.l;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    final class a implements x.a<z<f>>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final x f33083a = new x("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: b  reason: collision with root package name */
        e f33084b;

        /* renamed from: c  reason: collision with root package name */
        long f33085c;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final Uri f33087e;

        /* renamed from: f  reason: collision with root package name */
        private final z<f> f33088f;

        /* renamed from: g  reason: collision with root package name */
        private long f33089g;

        /* renamed from: h  reason: collision with root package name */
        private long f33090h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public long f33091i;
        private boolean j;
        private IOException k;

        public final /* synthetic */ x.b a(x.d dVar, long j2, long j3, IOException iOException, int i2) {
            x.b bVar;
            IOException iOException2 = iOException;
            z zVar = (z) dVar;
            long a2 = b.this.f33077d.a(iOException2);
            boolean z = a2 != -9223372036854775807L;
            boolean z2 = b.a(b.this, this.f33087e, a2) || !z;
            if (z) {
                z2 |= a(a2);
            }
            if (z2) {
                long a3 = b.this.f33077d.a(iOException2, i2);
                bVar = a3 != -9223372036854775807L ? x.a(false, a3) : x.f32467d;
            } else {
                bVar = x.f32466c;
            }
            x.b bVar2 = bVar;
            b.this.f33082i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a, iOException, !bVar2.a());
            return bVar2;
        }

        public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
            z zVar = (z) dVar;
            f fVar = (f) zVar.f32486d;
            if (fVar instanceof e) {
                a((e) fVar);
                b.this.f33082i.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a);
                return;
            }
            this.k = new v("Loaded playlist has unexpected type.");
        }

        public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z) {
            z zVar = (z) dVar;
            b.this.f33082i.b(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, 4, j2, j3, zVar.f32485c.f32353a);
        }

        public a(Uri uri) {
            this.f33087e = uri;
            this.f33088f = new z<>(b.this.f33075b.a(), uri, 4, b.this.f33081h);
        }

        public final void a() {
            this.f33091i = 0;
            if (!this.j && !this.f33083a.c() && !this.f33083a.b()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f33090h) {
                    this.j = true;
                    b.this.k.postDelayed(this, this.f33090h - elapsedRealtime);
                    return;
                }
                b();
            }
        }

        public final void run() {
            this.j = false;
            b();
        }

        private void b() {
            b.this.f33082i.a(this.f33088f.f32483a, this.f33088f.f32484b, this.f33083a.a(this.f33088f, this, b.this.f33077d.a(this.f33088f.f32484b)));
        }

        /* access modifiers changed from: private */
        public void a(e eVar) {
            e eVar2 = this.f33084b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f33085c = elapsedRealtime;
            this.f33084b = b.a(b.this, eVar2, eVar);
            e eVar3 = this.f33084b;
            if (eVar3 != eVar2) {
                this.k = null;
                this.f33089g = elapsedRealtime;
                b.a(b.this, this.f33087e, eVar3);
            } else if (!eVar3.f33121i) {
                if (eVar.f33118f + ((long) eVar.l.size()) < this.f33084b.f33118f) {
                    this.k = new i.c(this.f33087e);
                    b.a(b.this, this.f33087e, -9223372036854775807L);
                } else if (((double) (elapsedRealtime - this.f33089g)) > ((double) c.a(this.f33084b.f33120h)) * b.this.f33080g) {
                    this.k = new i.d(this.f33087e);
                    long a2 = b.this.f33077d.a(this.k);
                    b.a(b.this, this.f33087e, a2);
                    if (a2 != -9223372036854775807L) {
                        a(a2);
                    }
                }
            }
            e eVar4 = this.f33084b;
            long j2 = eVar4.f33120h;
            if (eVar4 == eVar2) {
                j2 /= 2;
            }
            this.f33090h = elapsedRealtime + c.a(j2);
            if (this.f33087e.equals(b.this.n) && !this.f33084b.f33121i) {
                a();
            }
        }

        private boolean a(long j2) {
            this.f33091i = SystemClock.elapsedRealtime() + j2;
            return this.f33087e.equals(b.this.n) && !b.h(b.this);
        }
    }

    static /* synthetic */ boolean a(b bVar, Uri uri, long j2) {
        int size = bVar.f33079f.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            z |= !bVar.f33079f.get(i2).a(uri, j2);
        }
        return z;
    }

    static /* synthetic */ e a(b bVar, e eVar, e eVar2) {
        long j2;
        int i2;
        e.a a2;
        int size;
        int size2;
        b bVar2 = bVar;
        e eVar3 = eVar;
        e eVar4 = eVar2;
        boolean z = true;
        if (eVar3 != null && eVar4.f33118f <= eVar3.f33118f && (eVar4.f33118f < eVar3.f33118f || ((size = eVar4.l.size()) <= (size2 = eVar3.l.size()) && (size != size2 || !eVar4.f33121i || eVar3.f33121i)))) {
            z = false;
        }
        if (z) {
            if (eVar4.j) {
                j2 = eVar4.f33115c;
            } else {
                e eVar5 = bVar2.o;
                j2 = eVar5 != null ? eVar5.f33115c : 0;
                if (eVar3 != null) {
                    int size3 = eVar3.l.size();
                    e.a a3 = a(eVar, eVar2);
                    if (a3 != null) {
                        j2 = eVar3.f33115c + a3.f33127f;
                    } else if (((long) size3) == eVar4.f33118f - eVar3.f33118f) {
                        j2 = eVar.a();
                    }
                }
            }
            long j3 = j2;
            if (eVar4.f33116d) {
                i2 = eVar4.f33117e;
            } else {
                e eVar6 = bVar2.o;
                i2 = eVar6 != null ? eVar6.f33117e : 0;
                if (!(eVar3 == null || (a2 = a(eVar, eVar2)) == null)) {
                    i2 = (eVar3.f33117e + a2.f33126e) - eVar4.l.get(0).f33126e;
                }
            }
            return new e(eVar4.f33113a, eVar4.n, eVar4.o, eVar4.f33114b, j3, true, i2, eVar4.f33118f, eVar4.f33119g, eVar4.f33120h, eVar4.p, eVar4.f33121i, eVar4.j, eVar4.k, eVar4.l);
        } else if (!eVar4.f33121i || eVar3.f33121i) {
            return eVar3;
        } else {
            return new e(eVar3.f33113a, eVar3.n, eVar3.o, eVar3.f33114b, eVar3.f33115c, eVar3.f33116d, eVar3.f33117e, eVar3.f33118f, eVar3.f33119g, eVar3.f33120h, eVar3.p, true, eVar3.j, eVar3.k, eVar3.l);
        }
    }

    static /* synthetic */ void a(b bVar, Uri uri, e eVar) {
        if (uri.equals(bVar.n)) {
            if (bVar.o == null) {
                bVar.p = !eVar.f33121i;
                bVar.q = eVar.f33115c;
            }
            bVar.o = eVar;
            bVar.l.a(eVar);
        }
        int size = bVar.f33079f.size();
        for (int i2 = 0; i2 < size; i2++) {
            bVar.f33079f.get(i2).g();
        }
    }

    static /* synthetic */ boolean h(b bVar) {
        List<d.b> list = bVar.m.f33096c;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = bVar.f33078e.get(list.get(i2).f33107a);
            if (elapsedRealtime > aVar.f33091i) {
                bVar.n = aVar.f33087e;
                aVar.a();
                return true;
            }
        }
        return false;
    }
}
