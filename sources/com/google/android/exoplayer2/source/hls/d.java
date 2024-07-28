package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.j;
import com.google.android.exoplayer2.source.b.m;
import com.google.android.exoplayer2.source.hls.a.e;
import com.google.android.exoplayer2.trackselection.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final Uri[] f33146a;

    /* renamed from: b  reason: collision with root package name */
    final TrackGroup f33147b;

    /* renamed from: c  reason: collision with root package name */
    final b f33148c = new b();

    /* renamed from: d  reason: collision with root package name */
    boolean f33149d;

    /* renamed from: e  reason: collision with root package name */
    byte[] f33150e;

    /* renamed from: f  reason: collision with root package name */
    IOException f33151f;

    /* renamed from: g  reason: collision with root package name */
    Uri f33152g;

    /* renamed from: h  reason: collision with root package name */
    f f33153h;

    /* renamed from: i  reason: collision with root package name */
    boolean f33154i;
    private final f j;
    private final i k;
    private final i l;
    private final m m;
    private final Format[] n;
    private final com.google.android.exoplayer2.source.hls.a.i o;
    private final List<Format> p;
    private boolean q;
    private long r = -9223372036854775807L;

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public com.google.android.exoplayer2.source.b.d f33156a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f33157b;

        /* renamed from: c  reason: collision with root package name */
        public Uri f33158c;

        public c() {
            a();
        }

        public final void a() {
            this.f33156a = null;
            this.f33157b = false;
            this.f33158c = null;
        }
    }

    public d(f fVar, com.google.android.exoplayer2.source.hls.a.i iVar, Uri[] uriArr, Format[] formatArr, e eVar, ad adVar, m mVar, List<Format> list) {
        this.j = fVar;
        this.o = iVar;
        this.f33146a = uriArr;
        this.n = formatArr;
        this.m = mVar;
        this.p = list;
        this.k = eVar.a();
        if (adVar != null) {
            this.k.a(adVar);
        }
        this.l = eVar.a();
        this.f33147b = new TrackGroup(formatArr);
        int[] iArr = new int[uriArr.length];
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            iArr[i2] = i2;
        }
        this.f33153h = new e(this.f33147b, iArr);
    }

    public final void a() throws IOException {
        IOException iOException = this.f33151f;
        if (iOException == null) {
            Uri uri = this.f33152g;
            if (uri != null && this.f33154i) {
                this.o.b(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r29, long r31, java.util.List<com.google.android.exoplayer2.source.hls.h> r33, com.google.android.exoplayer2.source.hls.d.c r34) {
        /*
            r28 = this;
            r8 = r28
            r6 = r31
            r9 = r34
            boolean r0 = r33.isEmpty()
            r11 = 1
            if (r0 == 0) goto L_0x0011
            r1 = r33
            r4 = 0
            goto L_0x001f
        L_0x0011:
            int r0 = r33.size()
            int r0 = r0 - r11
            r1 = r33
            java.lang.Object r0 = r1.get(r0)
            com.google.android.exoplayer2.source.hls.h r0 = (com.google.android.exoplayer2.source.hls.h) r0
            r4 = r0
        L_0x001f:
            if (r4 != 0) goto L_0x0024
            r0 = -1
            r5 = -1
            goto L_0x002d
        L_0x0024:
            com.google.android.exoplayer2.source.TrackGroup r0 = r8.f33147b
            com.google.android.exoplayer2.Format r2 = r4.f32816g
            int r0 = r0.a(r2)
            r5 = r0
        L_0x002d:
            long r2 = r6 - r29
            long r12 = r8.r
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r14 == 0) goto L_0x003c
            r12 = 1
            goto L_0x003d
        L_0x003c:
            r12 = 0
        L_0x003d:
            if (r12 == 0) goto L_0x0044
            long r12 = r8.r
            long r12 = r12 - r29
            goto L_0x0046
        L_0x0044:
            r12 = r19
        L_0x0046:
            if (r4 == 0) goto L_0x0063
            boolean r14 = r8.q
            if (r14 != 0) goto L_0x0063
            long r14 = r4.k
            long r0 = r4.j
            long r14 = r14 - r0
            long r2 = r2 - r14
            r0 = 0
            long r2 = java.lang.Math.max(r0, r2)
            int r16 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r16 == 0) goto L_0x0063
            long r12 = r12 - r14
            long r0 = java.lang.Math.max(r0, r12)
            r15 = r0
            goto L_0x0064
        L_0x0063:
            r15 = r12
        L_0x0064:
            r13 = r2
            com.google.android.exoplayer2.source.b.m[] r18 = r8.a((com.google.android.exoplayer2.source.hls.h) r4, (long) r6)
            com.google.android.exoplayer2.trackselection.f r12 = r8.f33153h
            r17 = r33
            r12.a(r13, r15, r17, r18)
            com.google.android.exoplayer2.trackselection.f r0 = r8.f33153h
            int r12 = r0.h()
            if (r5 == r12) goto L_0x007a
            r13 = 1
            goto L_0x007b
        L_0x007a:
            r13 = 0
        L_0x007b:
            android.net.Uri[] r0 = r8.f33146a
            r14 = r0[r12]
            com.google.android.exoplayer2.source.hls.a.i r0 = r8.o
            boolean r0 = r0.a((android.net.Uri) r14)
            if (r0 != 0) goto L_0x0097
            r9.f33158c = r14
            boolean r0 = r8.f33154i
            android.net.Uri r1 = r8.f33152g
            boolean r1 = r14.equals(r1)
            r0 = r0 & r1
            r8.f33154i = r0
            r8.f33152g = r14
            return
        L_0x0097:
            com.google.android.exoplayer2.source.hls.a.i r0 = r8.o
            com.google.android.exoplayer2.source.hls.a.e r15 = r0.a(r14, r11)
            boolean r0 = r15.p
            r8.q = r0
            boolean r0 = r15.f33121i
            if (r0 == 0) goto L_0x00a6
            goto L_0x00b2
        L_0x00a6:
            long r0 = r15.a()
            com.google.android.exoplayer2.source.hls.a.i r2 = r8.o
            long r2 = r2.c()
            long r19 = r0 - r2
        L_0x00b2:
            r0 = r19
            r8.r = r0
            long r0 = r15.f33115c
            com.google.android.exoplayer2.source.hls.a.i r2 = r8.o
            long r2 = r2.c()
            long r16 = r0 - r2
            r3 = 0
            r0 = r28
            r1 = r4
            r2 = r13
            r10 = 0
            r3 = r15
            r25 = r4
            r19 = r5
            r4 = r16
            r6 = r31
            long r0 = r0.a(r1, r2, r3, r4, r6)
            long r2 = r15.f33118f
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00fb
            if (r25 == 0) goto L_0x00fb
            if (r13 == 0) goto L_0x00fb
            android.net.Uri[] r0 = r8.f33146a
            r0 = r0[r19]
            com.google.android.exoplayer2.source.hls.a.i r1 = r8.o
            com.google.android.exoplayer2.source.hls.a.e r1 = r1.a(r0, r11)
            long r2 = r1.f33115c
            com.google.android.exoplayer2.source.hls.a.i r4 = r8.o
            long r4 = r4.c()
            long r2 = r2 - r4
            long r4 = r25.f()
            r15 = r2
            r12 = r19
            r3 = r0
            r2 = r1
            r0 = r4
            goto L_0x00ff
        L_0x00fb:
            r3 = r14
            r2 = r15
            r15 = r16
        L_0x00ff:
            long r4 = r2.f33118f
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x010d
            com.google.android.exoplayer2.source.c r0 = new com.google.android.exoplayer2.source.c
            r0.<init>()
            r8.f33151f = r0
            return
        L_0x010d:
            long r4 = r2.f33118f
            long r0 = r0 - r4
            int r1 = (int) r0
            java.util.List<com.google.android.exoplayer2.source.hls.a.e$a> r0 = r2.l
            int r0 = r0.size()
            if (r1 < r0) goto L_0x0130
            boolean r0 = r2.f33121i
            if (r0 == 0) goto L_0x0120
            r9.f33157b = r11
            return
        L_0x0120:
            r9.f33158c = r3
            boolean r0 = r8.f33154i
            android.net.Uri r1 = r8.f33152g
            boolean r1 = r3.equals(r1)
            r0 = r0 & r1
            r8.f33154i = r0
            r8.f33152g = r3
            return
        L_0x0130:
            r8.f33154i = r10
            r0 = 0
            r8.f33152g = r0
            java.util.List<com.google.android.exoplayer2.source.hls.a.e$a> r0 = r2.l
            java.lang.Object r0 = r0.get(r1)
            com.google.android.exoplayer2.source.hls.a.e$a r0 = (com.google.android.exoplayer2.source.hls.a.e.a) r0
            com.google.android.exoplayer2.source.hls.a.e$a r4 = r0.f33123b
            android.net.Uri r4 = a((com.google.android.exoplayer2.source.hls.a.e) r2, (com.google.android.exoplayer2.source.hls.a.e.a) r4)
            com.google.android.exoplayer2.source.b.d r5 = r8.a((android.net.Uri) r4, (int) r12)
            r9.f33156a = r5
            com.google.android.exoplayer2.source.b.d r5 = r9.f33156a
            if (r5 == 0) goto L_0x014e
            return
        L_0x014e:
            android.net.Uri r0 = a((com.google.android.exoplayer2.source.hls.a.e) r2, (com.google.android.exoplayer2.source.hls.a.e.a) r0)
            com.google.android.exoplayer2.source.b.d r5 = r8.a((android.net.Uri) r0, (int) r12)
            r9.f33156a = r5
            com.google.android.exoplayer2.source.b.d r5 = r9.f33156a
            if (r5 == 0) goto L_0x015d
            return
        L_0x015d:
            com.google.android.exoplayer2.source.hls.f r5 = r8.j
            com.google.android.exoplayer2.f.i r13 = r8.k
            com.google.android.exoplayer2.Format[] r6 = r8.n
            r14 = r6[r12]
            java.util.List<com.google.android.exoplayer2.Format> r6 = r8.p
            com.google.android.exoplayer2.trackselection.f r7 = r8.f33153h
            int r21 = r7.b()
            com.google.android.exoplayer2.trackselection.f r7 = r8.f33153h
            java.lang.Object r22 = r7.c()
            boolean r7 = r8.f33149d
            com.google.android.exoplayer2.source.hls.m r10 = r8.m
            com.google.android.exoplayer2.source.hls.d$b r11 = r8.f33148c
            byte[] r26 = r11.get((java.lang.Object) r0)
            com.google.android.exoplayer2.source.hls.d$b r0 = r8.f33148c
            byte[] r27 = r0.get((java.lang.Object) r4)
            r12 = r5
            r17 = r2
            r18 = r1
            r19 = r3
            r20 = r6
            r23 = r7
            r24 = r10
            com.google.android.exoplayer2.source.hls.h r0 = com.google.android.exoplayer2.source.hls.h.a(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r9.f33156a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.d.a(long, long, java.util.List, com.google.android.exoplayer2.source.hls.d$c):void");
    }

    public final m[] a(h hVar, long j2) {
        h hVar2 = hVar;
        int a2 = hVar2 == null ? -1 : this.f33147b.a(hVar2.f32816g);
        m[] mVarArr = new m[this.f33153h.f()];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            int b2 = this.f33153h.b(i2);
            Uri uri = this.f33146a[b2];
            if (!this.o.a(uri)) {
                mVarArr[i2] = m.f32857a;
            } else {
                com.google.android.exoplayer2.source.hls.a.e a3 = this.o.a(uri, false);
                long c2 = a3.f33115c - this.o.c();
                long j3 = c2;
                long a4 = a(hVar, b2 != a2, a3, c2, j2);
                if (a4 < a3.f33118f) {
                    mVarArr[i2] = m.f32857a;
                } else {
                    mVarArr[i2] = new C0548d(a3, j3, (int) (a4 - a3.f33118f));
                }
            }
        }
        return mVarArr;
    }

    private long a(h hVar, boolean z, com.google.android.exoplayer2.source.hls.a.e eVar, long j2, long j3) {
        long a2;
        long j4;
        if (hVar != null && !z) {
            return hVar.f();
        }
        long j5 = eVar.m + j2;
        if (hVar != null && !this.q) {
            j3 = hVar.j;
        }
        if (eVar.f33121i || j3 < j5) {
            a2 = (long) ae.a(eVar.l, Long.valueOf(j3 - j2), !this.o.e() || hVar == null);
            j4 = eVar.f33118f;
        } else {
            a2 = eVar.f33118f;
            j4 = (long) eVar.l.size();
        }
        return a2 + j4;
    }

    private com.google.android.exoplayer2.source.b.d a(Uri uri, int i2) {
        if (uri == null) {
            return null;
        }
        if (this.f33148c.containsKey(uri)) {
            b bVar = this.f33148c;
            bVar.put(uri, (byte[]) bVar.remove(uri));
            return null;
        }
        return new a(this.l, new l(uri, 0, (String) null, 1), this.n[i2], this.f33153h.b(), this.f33153h.c(), this.f33150e);
    }

    private static Uri a(com.google.android.exoplayer2.source.hls.a.e eVar, e.a aVar) {
        if (aVar == null || aVar.f33129h == null) {
            return null;
        }
        return com.google.android.exoplayer2.g.ad.a(eVar.n, aVar.f33129h);
    }

    static final class e extends com.google.android.exoplayer2.trackselection.b {

        /* renamed from: a  reason: collision with root package name */
        private int f33161a;

        public final int b() {
            return 0;
        }

        public final Object c() {
            return null;
        }

        public e(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f33161a = a(trackGroup.f32781b[0]);
        }

        public final void a(long j, long j2, List<? extends com.google.android.exoplayer2.source.b.l> list, m[] mVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f33161a, elapsedRealtime)) {
                for (int i2 = this.f33486d - 1; i2 >= 0; i2--) {
                    if (!b(i2, elapsedRealtime)) {
                        this.f33161a = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public final int a() {
            return this.f33161a;
        }
    }

    static final class a extends j {

        /* renamed from: b  reason: collision with root package name */
        byte[] f33155b;

        public a(i iVar, l lVar, Format format, int i2, Object obj, byte[] bArr) {
            super(iVar, lVar, format, i2, obj, bArr);
        }

        public final void a(byte[] bArr, int i2) {
            this.f33155b = Arrays.copyOf(bArr, i2);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.hls.d$d  reason: collision with other inner class name */
    static final class C0548d extends com.google.android.exoplayer2.source.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.source.hls.a.e f33159b;

        /* renamed from: c  reason: collision with root package name */
        private final long f33160c;

        public C0548d(com.google.android.exoplayer2.source.hls.a.e eVar, long j, int i2) {
            super((long) i2, (long) (eVar.l.size() - 1));
            this.f33159b = eVar;
            this.f33160c = j;
        }
    }

    static final class b extends LinkedHashMap<Uri, byte[]> {
        public b() {
            super(8, 1.0f, false);
        }

        public final byte[] get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (byte[]) super.get(obj);
        }

        public final byte[] put(Uri uri, byte[] bArr) {
            return (byte[]) super.put(uri, com.google.android.exoplayer2.g.a.a(bArr));
        }

        /* access modifiers changed from: protected */
        public final boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > 4;
        }
    }
}
