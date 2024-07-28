package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.f.ab;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class q implements i, x.a<a>, x.e, n, t.b {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Format f33248d = Format.b("icy", "application/x-icy", Long.MAX_VALUE);
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private long F;
    private long G;
    private long H;
    private boolean I;
    private int J;
    private boolean K;

    /* renamed from: a  reason: collision with root package name */
    t[] f33249a;

    /* renamed from: b  reason: collision with root package name */
    long f33250b;

    /* renamed from: c  reason: collision with root package name */
    boolean f33251c;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f33252e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.f.i f33253f;

    /* renamed from: g  reason: collision with root package name */
    private final w f33254g;

    /* renamed from: h  reason: collision with root package name */
    private final p.a f33255h;

    /* renamed from: i  reason: collision with root package name */
    private final c f33256i;
    private final com.google.android.exoplayer2.f.b j;
    /* access modifiers changed from: private */
    public final String k;
    /* access modifiers changed from: private */
    public final long l;
    private final x m = new x("Loader:ProgressiveMediaPeriod");
    private final b n;
    private final com.google.android.exoplayer2.g.e o;
    private final Runnable p;
    /* access modifiers changed from: private */
    public final Runnable q;
    /* access modifiers changed from: private */
    public final Handler r;
    private n.a s;
    private o t;
    /* access modifiers changed from: private */
    public IcyHeaders u;
    private f[] v;
    private boolean w;
    private boolean x;
    private d y;
    private boolean z;

    interface c {
        void a(long j, boolean z);
    }

    public final void a(long j2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.exoplayer2.f.x.b a(com.google.android.exoplayer2.f.x.d r25, long r26, long r28, java.io.IOException r30, int r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            com.google.android.exoplayer2.source.q$a r1 = (com.google.android.exoplayer2.source.q.a) r1
            r0.a((com.google.android.exoplayer2.source.q.a) r1)
            com.google.android.exoplayer2.f.w r2 = r0.f33254g
            r14 = r30
            r3 = r31
            long r2 = r2.a(r14, r3)
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x0020
            com.google.android.exoplayer2.f.x$b r2 = com.google.android.exoplayer2.f.x.f32467d
            goto L_0x0076
        L_0x0020:
            int r7 = r24.n()
            int r8 = r0.J
            r9 = 0
            if (r7 <= r8) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            long r10 = r0.G
            r12 = -1
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 != 0) goto L_0x006a
            com.google.android.exoplayer2.extractor.o r10 = r0.t
            if (r10 == 0) goto L_0x0041
            long r10 = r10.b()
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0041
            goto L_0x006a
        L_0x0041:
            boolean r4 = r0.x
            if (r4 == 0) goto L_0x004e
            boolean r4 = r24.h()
            if (r4 != 0) goto L_0x004e
            r0.I = r6
            goto L_0x006d
        L_0x004e:
            boolean r4 = r0.x
            r0.C = r4
            r4 = 0
            r0.f33250b = r4
            r0.J = r9
            com.google.android.exoplayer2.source.t[] r7 = r0.f33249a
            int r10 = r7.length
            r11 = 0
        L_0x005c:
            if (r11 >= r10) goto L_0x0066
            r12 = r7[r11]
            r12.a((boolean) r9)
            int r11 = r11 + 1
            goto L_0x005c
        L_0x0066:
            r1.a(r4, r4)
            goto L_0x006c
        L_0x006a:
            r0.J = r7
        L_0x006c:
            r9 = 1
        L_0x006d:
            if (r9 == 0) goto L_0x0074
            com.google.android.exoplayer2.f.x$b r2 = com.google.android.exoplayer2.f.x.a((boolean) r8, (long) r2)
            goto L_0x0076
        L_0x0074:
            com.google.android.exoplayer2.f.x$b r2 = com.google.android.exoplayer2.f.x.f32466c
        L_0x0076:
            com.google.android.exoplayer2.source.p$a r3 = r0.f33255h
            com.google.android.exoplayer2.f.l r4 = r1.f33259c
            com.google.android.exoplayer2.f.ab r5 = r1.f33257a
            android.net.Uri r5 = r5.f32354b
            com.google.android.exoplayer2.f.ab r7 = r1.f33257a
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r7.f32355c
            r8 = 1
            r9 = -1
            r10 = 0
            long r12 = r1.f33258b
            r15 = r12
            long r11 = r0.F
            com.google.android.exoplayer2.f.ab r1 = r1.f33257a
            r17 = r11
            long r11 = r1.f32353a
            boolean r1 = r2.a()
            r23 = r1 ^ 1
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r1 = 0
            r10 = r1
            r20 = r11
            r1 = 0
            r11 = r1
            r12 = r15
            r14 = r17
            r16 = r26
            r18 = r28
            r22 = r30
            r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r18, r20, r22, r23)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.q.a(com.google.android.exoplayer2.f.x$d, long, long, java.io.IOException, int):com.google.android.exoplayer2.f.x$b");
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
        o oVar;
        a aVar = (a) dVar;
        if (this.F == -9223372036854775807L && (oVar = this.t) != null) {
            boolean h_ = oVar.h_();
            long o2 = o();
            this.F = o2 == Long.MIN_VALUE ? 0 : o2 + 10000;
            this.f33256i.a(this.F, h_);
        }
        this.f33255h.a(aVar.f33259c, aVar.f33257a.f32354b, aVar.f33257a.f32355c, 1, -1, (Format) null, 0, (Object) null, aVar.f33258b, this.F, j2, j3, aVar.f33257a.f32353a);
        a(aVar);
        this.f33251c = true;
        ((n.a) com.google.android.exoplayer2.g.a.a(this.s)).a(this);
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z2) {
        a aVar = (a) dVar;
        p.a aVar2 = this.f33255h;
        l lVar = aVar.f33259c;
        Uri uri = aVar.f33257a.f32354b;
        Map<String, List<String>> map = aVar.f33257a.f32355c;
        long j4 = aVar.f33258b;
        long j5 = this.F;
        a aVar3 = aVar;
        aVar2.b(lVar, uri, map, 1, -1, (Format) null, 0, (Object) null, j4, j5, j2, j3, aVar.f33257a.f32353a);
        if (!z2) {
            a aVar4 = aVar3;
            a(aVar4);
            for (t a2 : this.f33249a) {
                a2.a(false);
            }
            if (this.E > 0) {
                ((n.a) com.google.android.exoplayer2.g.a.a(this.s)).a(this);
                return;
            }
            return;
        }
    }

    public q(Uri uri, com.google.android.exoplayer2.f.i iVar, g[] gVarArr, w wVar, p.a aVar, c cVar, com.google.android.exoplayer2.f.b bVar, String str, int i2) {
        this.f33252e = uri;
        this.f33253f = iVar;
        this.f33254g = wVar;
        this.f33255h = aVar;
        this.f33256i = cVar;
        this.j = bVar;
        this.k = str;
        this.l = (long) i2;
        this.n = new b(gVarArr);
        this.o = new com.google.android.exoplayer2.g.e();
        this.p = new Runnable() {
            public final void run() {
                q.this.k();
            }
        };
        this.q = new Runnable() {
            public final void run() {
                q.this.q();
            }
        };
        this.r = new Handler();
        this.v = new f[0];
        this.f33249a = new t[0];
        this.H = -9223372036854775807L;
        this.G = -1;
        this.F = -9223372036854775807L;
        this.A = 1;
        aVar.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (!this.K) {
            ((n.a) com.google.android.exoplayer2.g.a.a(this.s)).a(this);
        }
    }

    public final void f() {
        if (this.x) {
            for (t c2 : this.f33249a) {
                c2.c();
            }
        }
        this.m.a((x.e) this);
        this.r.removeCallbacksAndMessages((Object) null);
        this.s = null;
        this.K = true;
        this.f33255h.b();
    }

    public final void g() {
        for (t a2 : this.f33249a) {
            a2.a(false);
        }
        b bVar = this.n;
        if (bVar.f33266a != null) {
            bVar.f33266a = null;
        }
    }

    public final void a(n.a aVar, long j2) {
        this.s = aVar;
        this.o.a();
        m();
    }

    public final void i_() throws IOException {
        if (this.f33251c && !this.x) {
            throw new v("Loading finished before preparation is complete.");
        }
    }

    public final TrackGroupArray b() {
        return l().f33269b;
    }

    public final long a(com.google.android.exoplayer2.trackselection.f[] fVarArr, boolean[] zArr, u[] uVarArr, boolean[] zArr2, long j2) {
        d l2 = l();
        TrackGroupArray trackGroupArray = l2.f33269b;
        boolean[] zArr3 = l2.f33271d;
        int i2 = this.E;
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (uVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                int i5 = uVarArr[i4].f33273a;
                com.google.android.exoplayer2.g.a.b(zArr3[i5]);
                this.E--;
                zArr3[i5] = false;
                uVarArr[i4] = null;
            }
        }
        boolean z2 = !this.B ? j2 != 0 : i2 == 0;
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            if (uVarArr[i6] == null && fVarArr[i6] != null) {
                com.google.android.exoplayer2.trackselection.f fVar = fVarArr[i6];
                com.google.android.exoplayer2.g.a.b(fVar.f() == 1);
                com.google.android.exoplayer2.g.a.b(fVar.b(0) == 0);
                int a2 = trackGroupArray.a(fVar.e());
                com.google.android.exoplayer2.g.a.b(!zArr3[a2]);
                this.E++;
                zArr3[a2] = true;
                uVarArr[i6] = new e(a2);
                zArr2[i6] = true;
                if (!z2) {
                    t tVar = this.f33249a[a2];
                    tVar.b();
                    z2 = tVar.a(j2, true) == -1 && tVar.f33388a.b() != 0;
                }
            }
        }
        if (this.E == 0) {
            this.I = false;
            this.C = false;
            if (this.m.c()) {
                t[] tVarArr = this.f33249a;
                int length = tVarArr.length;
                while (i3 < length) {
                    tVarArr[i3].c();
                    i3++;
                }
                this.m.d();
            } else {
                for (t a3 : this.f33249a) {
                    a3.a(false);
                }
            }
        } else if (z2) {
            j2 = b(j2);
            while (i3 < uVarArr.length) {
                if (uVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.B = true;
        return j2;
    }

    public final void a(long j2, boolean z2) {
        if (!p()) {
            boolean[] zArr = l().f33271d;
            int length = this.f33249a.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f33249a[i2].a(j2, z2, zArr[i2]);
            }
        }
    }

    public final boolean c(long j2) {
        if (this.f33251c || this.m.b() || this.I) {
            return false;
        }
        if (this.x && this.E == 0) {
            return false;
        }
        boolean a2 = this.o.a();
        if (this.m.c()) {
            return a2;
        }
        m();
        return true;
    }

    public final long e() {
        if (this.E == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final long c() {
        if (!this.D) {
            this.f33255h.c();
            this.D = true;
        }
        if (!this.C) {
            return -9223372036854775807L;
        }
        if (!this.f33251c && n() <= this.J) {
            return -9223372036854775807L;
        }
        this.C = false;
        return this.f33250b;
    }

    public final long d() {
        long j2;
        boolean[] zArr = l().f33270c;
        if (this.f33251c) {
            return Long.MIN_VALUE;
        }
        if (p()) {
            return this.H;
        }
        if (this.z) {
            int length = this.f33249a.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i2] && !this.f33249a[i2].f33388a.f()) {
                    j2 = Math.min(j2, this.f33249a[i2].f33388a.e());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = o();
        }
        return j2 == Long.MIN_VALUE ? this.f33250b : j2;
    }

    public final long b(long j2) {
        d l2 = l();
        o oVar = l2.f33268a;
        boolean[] zArr = l2.f33270c;
        if (!oVar.h_()) {
            j2 = 0;
        }
        this.C = false;
        this.f33250b = j2;
        if (p()) {
            this.H = j2;
            return j2;
        } else if (this.A != 7 && a(zArr, j2)) {
            return j2;
        } else {
            this.I = false;
            this.H = j2;
            this.f33251c = false;
            if (this.m.c()) {
                this.m.d();
            } else {
                this.m.f32468e = null;
                for (t a2 : this.f33249a) {
                    a2.a(false);
                }
            }
            return j2;
        }
    }

    public final long a(long j2, af afVar) {
        o oVar = l().f33268a;
        if (!oVar.h_()) {
            return 0;
        }
        o.a a2 = oVar.a(j2);
        return ae.a(j2, afVar, a2.f32289a.f32294b, a2.f32290b.f32294b);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        d l2 = l();
        boolean[] zArr = l2.f33272e;
        if (!zArr[i2]) {
            Format format = l2.f33269b.f32785c[i2].f32781b[0];
            this.f33255h.a(com.google.android.exoplayer2.g.o.g(format.f31069i), format, 0, (Object) null, this.f33250b);
            zArr[i2] = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        boolean[] zArr = l().f33270c;
        if (this.I && zArr[i2] && !this.f33249a[i2].f33388a.c()) {
            this.H = 0;
            this.I = false;
            this.C = true;
            this.f33250b = 0;
            this.J = 0;
            for (t a2 : this.f33249a) {
                a2.a(false);
            }
            ((n.a) com.google.android.exoplayer2.g.a.a(this.s)).a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.C || p();
    }

    public final com.google.android.exoplayer2.extractor.q a(int i2, int i3) {
        return a(new f(i2, false));
    }

    public final void a() {
        this.w = true;
        this.r.post(this.p);
    }

    public final void a(o oVar) {
        if (this.u != null) {
            oVar = new o.b(-9223372036854775807L);
        }
        this.t = oVar;
        this.r.post(this.p);
    }

    public final void i() {
        this.r.post(this.p);
    }

    /* access modifiers changed from: package-private */
    public final com.google.android.exoplayer2.extractor.q a(f fVar) {
        int length = this.f33249a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (fVar.equals(this.v[i2])) {
                return this.f33249a[i2];
            }
        }
        t tVar = new t(this.j);
        tVar.f33390c = this;
        int i3 = length + 1;
        f[] fVarArr = (f[]) Arrays.copyOf(this.v, i3);
        fVarArr[length] = fVar;
        this.v = (f[]) ae.a((T[]) fVarArr);
        t[] tVarArr = (t[]) Arrays.copyOf(this.f33249a, i3);
        tVarArr[length] = tVar;
        this.f33249a = (t[]) ae.a((T[]) tVarArr);
        return tVar;
    }

    /* access modifiers changed from: private */
    public void k() {
        Metadata metadata;
        o oVar = this.t;
        if (!this.K && !this.x && this.w && oVar != null) {
            t[] tVarArr = this.f33249a;
            int length = tVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (tVarArr[i2].f33388a.d() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.o.b();
            int length2 = this.f33249a.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            this.F = oVar.b();
            for (int i3 = 0; i3 < length2; i3++) {
                Format d2 = this.f33249a[i3].f33388a.d();
                String str = d2.f31069i;
                boolean a2 = com.google.android.exoplayer2.g.o.a(str);
                boolean z2 = a2 || com.google.android.exoplayer2.g.o.b(str);
                zArr[i3] = z2;
                this.z = z2 | this.z;
                IcyHeaders icyHeaders = this.u;
                if (icyHeaders != null) {
                    if (a2 || this.v[i3].f33276b) {
                        Metadata metadata2 = d2.f31067g;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders);
                        } else {
                            metadata = metadata2.a(icyHeaders);
                        }
                        d2 = d2.a(metadata);
                    }
                    if (a2 && d2.f31065e == -1 && icyHeaders.f32670a != -1) {
                        d2 = new Format(d2.f31061a, d2.f31062b, d2.f31063c, d2.f31064d, icyHeaders.f32670a, d2.f31066f, d2.f31067g, d2.f31068h, d2.f31069i, d2.j, d2.k, d2.l, d2.m, d2.n, d2.o, d2.p, d2.q, d2.r, d2.t, d2.s, d2.u, d2.v, d2.w, d2.x, d2.y, d2.z, d2.A, d2.B);
                    }
                }
                trackGroupArr[i3] = new TrackGroup(d2);
            }
            this.A = (this.G == -1 && oVar.b() == -9223372036854775807L) ? 7 : 1;
            this.y = new d(oVar, new TrackGroupArray(trackGroupArr), zArr);
            this.x = true;
            this.f33256i.a(this.F, oVar.h_());
            ((n.a) com.google.android.exoplayer2.g.a.a(this.s)).a(this);
        }
    }

    private d l() {
        return (d) com.google.android.exoplayer2.g.a.a(this.y);
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f33260d;
        }
    }

    private void m() {
        a aVar = new a(this.f33252e, this.f33253f, this.n, this, this.o);
        if (this.x) {
            o oVar = l().f33268a;
            com.google.android.exoplayer2.g.a.b(p());
            long j2 = this.F;
            if (j2 == -9223372036854775807L || this.H <= j2) {
                aVar.a(oVar.a(this.H).f32289a.f32295c, this.H);
                this.H = -9223372036854775807L;
            } else {
                this.f33251c = true;
                this.H = -9223372036854775807L;
                return;
            }
        }
        this.J = n();
        long a2 = this.m.a(aVar, this, this.f33254g.a(this.A));
        this.f33255h.a(aVar.f33259c, 1, -1, (Format) null, 0, (Object) null, aVar.f33258b, this.F, a2);
    }

    private boolean a(boolean[] zArr, long j2) {
        int length = this.f33249a.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                return true;
            }
            t tVar = this.f33249a[i2];
            tVar.b();
            if (tVar.a(j2, false) == -1) {
                z2 = false;
            }
            if (z2 || (!zArr[i2] && this.z)) {
                i2++;
            }
        }
        return false;
    }

    private int n() {
        int i2 = 0;
        for (t tVar : this.f33249a) {
            i2 += tVar.f33388a.a();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public long o() {
        long j2 = Long.MIN_VALUE;
        for (t tVar : this.f33249a) {
            j2 = Math.max(j2, tVar.f33388a.e());
        }
        return j2;
    }

    private boolean p() {
        return this.H != -9223372036854775807L;
    }

    final class e implements u {

        /* renamed from: a  reason: collision with root package name */
        final int f33273a;

        public final void b() throws IOException {
        }

        public e(int i2) {
            this.f33273a = i2;
        }

        public final boolean a() {
            q qVar = q.this;
            int i2 = this.f33273a;
            if (!qVar.h()) {
                return qVar.f33251c || qVar.f33249a[i2].f33388a.c();
            }
            return false;
        }

        public final int a(com.google.android.exoplayer2.o oVar, com.google.android.exoplayer2.c.e eVar, boolean z) {
            q qVar = q.this;
            int i2 = this.f33273a;
            if (qVar.h()) {
                return -3;
            }
            qVar.a(i2);
            int a2 = qVar.f33249a[i2].a(oVar, eVar, z, qVar.f33251c, qVar.f33250b);
            if (a2 == -3) {
                qVar.b(i2);
            }
            return a2;
        }

        public final int b_(long j) {
            q qVar = q.this;
            int i2 = this.f33273a;
            int i3 = 0;
            if (qVar.h()) {
                return 0;
            }
            qVar.a(i2);
            t tVar = qVar.f33249a[i2];
            if (!qVar.f33251c || j <= tVar.f33388a.e()) {
                int a2 = tVar.a(j, true);
                if (a2 != -1) {
                    i3 = a2;
                }
            } else {
                i3 = tVar.f33388a.i();
            }
            if (i3 == 0) {
                qVar.b(i2);
            }
            return i3;
        }
    }

    final class a implements x.d, l.a {

        /* renamed from: a  reason: collision with root package name */
        final ab f33257a;

        /* renamed from: b  reason: collision with root package name */
        long f33258b;

        /* renamed from: c  reason: collision with root package name */
        com.google.android.exoplayer2.f.l f33259c = a(0);

        /* renamed from: d  reason: collision with root package name */
        long f33260d = -1;

        /* renamed from: f  reason: collision with root package name */
        private final Uri f33262f;

        /* renamed from: g  reason: collision with root package name */
        private final b f33263g;

        /* renamed from: h  reason: collision with root package name */
        private final i f33264h;

        /* renamed from: i  reason: collision with root package name */
        private final com.google.android.exoplayer2.g.e f33265i;
        private final com.google.android.exoplayer2.extractor.n j = new com.google.android.exoplayer2.extractor.n();
        private volatile boolean k;
        private boolean l = true;
        private com.google.android.exoplayer2.extractor.q m;
        private boolean n;

        public a(Uri uri, com.google.android.exoplayer2.f.i iVar, b bVar, i iVar2, com.google.android.exoplayer2.g.e eVar) {
            this.f33262f = uri;
            this.f33257a = new ab(iVar);
            this.f33263g = bVar;
            this.f33264h = iVar2;
            this.f33265i = eVar;
        }

        public final void a() {
            this.k = true;
        }

        public final void b() throws IOException, InterruptedException {
            int i2 = 0;
            while (i2 == 0 && !this.k) {
                com.google.android.exoplayer2.extractor.d dVar = null;
                try {
                    long j2 = this.j.f32288a;
                    this.f33259c = a(j2);
                    this.f33260d = this.f33257a.a(this.f33259c);
                    if (this.f33260d != -1) {
                        this.f33260d += j2;
                    }
                    Uri uri = (Uri) com.google.android.exoplayer2.g.a.a(this.f33257a.a());
                    IcyHeaders unused = q.this.u = IcyHeaders.a(this.f33257a.b());
                    com.google.android.exoplayer2.f.i iVar = this.f33257a;
                    if (!(q.this.u == null || q.this.u.f32675f == -1)) {
                        iVar = new l(this.f33257a, q.this.u.f32675f, this);
                        this.m = q.this.a(new f(0, true));
                        this.m.a(q.f33248d);
                    }
                    com.google.android.exoplayer2.extractor.d dVar2 = new com.google.android.exoplayer2.extractor.d(iVar, j2, this.f33260d);
                    try {
                        g a2 = this.f33263g.a(dVar2, this.f33264h, uri);
                        if (this.l) {
                            a2.a(j2, this.f33258b);
                            this.l = false;
                        }
                        while (i2 == 0 && !this.k) {
                            this.f33265i.c();
                            i2 = a2.a((h) dVar2, this.j);
                            if (dVar2.c() > q.this.l + j2) {
                                j2 = dVar2.c();
                                this.f33265i.b();
                                q.this.r.post(q.this.q);
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.j.f32288a = dVar2.c();
                        }
                        ae.a((com.google.android.exoplayer2.f.i) this.f33257a);
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        if (!(i2 == 1 || dVar == null)) {
                            this.j.f32288a = dVar.c();
                        }
                        ae.a((com.google.android.exoplayer2.f.i) this.f33257a);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.j.f32288a = dVar.c();
                    ae.a((com.google.android.exoplayer2.f.i) this.f33257a);
                    throw th;
                }
            }
        }

        public final void a(r rVar) {
            long j2;
            if (!this.n) {
                j2 = this.f33258b;
            } else {
                j2 = Math.max(q.this.o(), this.f33258b);
            }
            int b2 = rVar.b();
            com.google.android.exoplayer2.extractor.q qVar = (com.google.android.exoplayer2.extractor.q) com.google.android.exoplayer2.g.a.a(this.m);
            qVar.a(rVar, b2);
            qVar.a(j2, 1, b2, 0, (q.a) null);
            this.n = true;
        }

        private com.google.android.exoplayer2.f.l a(long j2) {
            return new com.google.android.exoplayer2.f.l(this.f33262f, j2, q.this.k, 14);
        }

        /* access modifiers changed from: package-private */
        public final void a(long j2, long j3) {
            this.j.f32288a = j2;
            this.f33258b = j3;
            this.l = true;
            this.n = false;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        g f33266a;

        /* renamed from: b  reason: collision with root package name */
        private final g[] f33267b;

        public b(g[] gVarArr) {
            this.f33267b = gVarArr;
        }

        public final g a(h hVar, i iVar, Uri uri) throws IOException, InterruptedException {
            g gVar = this.f33266a;
            if (gVar != null) {
                return gVar;
            }
            g[] gVarArr = this.f33267b;
            int i2 = 0;
            if (gVarArr.length == 1) {
                this.f33266a = gVarArr[0];
            } else {
                int length = gVarArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    g gVar2 = gVarArr[i2];
                    try {
                        if (gVar2.a(hVar)) {
                            this.f33266a = gVar2;
                            hVar.a();
                            break;
                        }
                        hVar.a();
                        i2++;
                    } catch (EOFException unused) {
                    } catch (Throwable th) {
                        hVar.a();
                        throw th;
                    }
                }
                if (this.f33266a == null) {
                    throw new y("None of the available extractors (" + ae.b((Object[]) this.f33267b) + ") could read the stream.", uri);
                }
            }
            this.f33266a.a(iVar);
            return this.f33266a;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final o f33268a;

        /* renamed from: b  reason: collision with root package name */
        public final TrackGroupArray f33269b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f33270c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f33271d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f33272e;

        public d(o oVar, TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f33268a = oVar;
            this.f33269b = trackGroupArray;
            this.f33270c = zArr;
            this.f33271d = new boolean[trackGroupArray.f32784b];
            this.f33272e = new boolean[trackGroupArray.f32784b];
        }
    }

    static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f33275a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33276b;

        public f(int i2, boolean z) {
            this.f33275a = i2;
            this.f33276b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                f fVar = (f) obj;
                return this.f33275a == fVar.f33275a && this.f33276b == fVar.f33276b;
            }
        }

        public final int hashCode() {
            return (this.f33275a * 31) + (this.f33276b ? 1 : 0);
        }
    }
}
