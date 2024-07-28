package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b.g;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.a.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;

final class c implements n, v.a<g<b>> {

    /* renamed from: a  reason: collision with root package name */
    final p.a f33379a;

    /* renamed from: b  reason: collision with root package name */
    n.a f33380b;

    /* renamed from: c  reason: collision with root package name */
    g<b>[] f33381c = new g[0];

    /* renamed from: d  reason: collision with root package name */
    private final b.a f33382d;

    /* renamed from: e  reason: collision with root package name */
    private final ad f33383e;

    /* renamed from: f  reason: collision with root package name */
    private final y f33384f;

    /* renamed from: g  reason: collision with root package name */
    private final w f33385g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.f.b f33386h;

    /* renamed from: i  reason: collision with root package name */
    private final TrackGroupArray f33387i;
    private final com.google.android.exoplayer2.source.g j;
    private a k;
    private v l;
    private boolean m;

    public c(a aVar, b.a aVar2, ad adVar, com.google.android.exoplayer2.source.g gVar, w wVar, p.a aVar3, y yVar, com.google.android.exoplayer2.f.b bVar) {
        this.k = aVar;
        this.f33382d = aVar2;
        this.f33383e = adVar;
        this.f33384f = yVar;
        this.f33385g = wVar;
        this.f33379a = aVar3;
        this.f33386h = bVar;
        this.j = gVar;
        this.f33387i = b(aVar);
        this.l = gVar.a(this.f33381c);
        aVar3.a();
    }

    public final void a(a aVar) {
        this.k = aVar;
        for (g<b> gVar : this.f33381c) {
            ((b) gVar.f32841e).a(aVar);
        }
        this.f33380b.a(this);
    }

    public final void a(n.a aVar, long j2) {
        this.f33380b = aVar;
        aVar.a(this);
    }

    public final void i_() throws IOException {
        this.f33384f.a();
    }

    public final TrackGroupArray b() {
        return this.f33387i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.google.android.exoplayer2.trackselection.f[] r17, boolean[] r18, com.google.android.exoplayer2.source.u[] r19, boolean[] r20, long r21) {
        /*
            r16 = this;
            r11 = r16
            r12 = r17
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r0 = 0
            r14 = 0
        L_0x000b:
            int r0 = r12.length
            if (r14 >= r0) goto L_0x0078
            r0 = r19[r14]
            if (r0 == 0) goto L_0x0032
            r0 = r19[r14]
            com.google.android.exoplayer2.source.b.g r0 = (com.google.android.exoplayer2.source.b.g) r0
            r1 = r12[r14]
            if (r1 == 0) goto L_0x002c
            boolean r1 = r18[r14]
            if (r1 != 0) goto L_0x001f
            goto L_0x002c
        L_0x001f:
            T r1 = r0.f32841e
            com.google.android.exoplayer2.source.smoothstreaming.b r1 = (com.google.android.exoplayer2.source.smoothstreaming.b) r1
            r2 = r12[r14]
            r1.a((com.google.android.exoplayer2.trackselection.f) r2)
            r13.add(r0)
            goto L_0x0032
        L_0x002c:
            r0.c()
            r0 = 0
            r19[r14] = r0
        L_0x0032:
            r0 = r19[r14]
            if (r0 != 0) goto L_0x0075
            r0 = r12[r14]
            if (r0 == 0) goto L_0x0075
            r5 = r12[r14]
            com.google.android.exoplayer2.source.TrackGroupArray r0 = r11.f33387i
            com.google.android.exoplayer2.source.TrackGroup r1 = r5.e()
            int r0 = r0.a(r1)
            com.google.android.exoplayer2.source.smoothstreaming.b$a r1 = r11.f33382d
            com.google.android.exoplayer2.f.y r2 = r11.f33384f
            com.google.android.exoplayer2.source.smoothstreaming.a.a r3 = r11.k
            com.google.android.exoplayer2.f.ad r6 = r11.f33383e
            r4 = r0
            com.google.android.exoplayer2.source.smoothstreaming.b r4 = r1.a(r2, r3, r4, r5, r6)
            com.google.android.exoplayer2.source.b.g r15 = new com.google.android.exoplayer2.source.b.g
            com.google.android.exoplayer2.source.smoothstreaming.a.a r1 = r11.k
            com.google.android.exoplayer2.source.smoothstreaming.a.a$b[] r1 = r1.f33335f
            r0 = r1[r0]
            int r1 = r0.f33341a
            r2 = 0
            r3 = 0
            com.google.android.exoplayer2.f.b r6 = r11.f33386h
            com.google.android.exoplayer2.f.w r9 = r11.f33385g
            com.google.android.exoplayer2.source.p$a r10 = r11.f33379a
            r0 = r15
            r5 = r16
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10)
            r13.add(r15)
            r19[r14] = r15
            r0 = 1
            r20[r14] = r0
        L_0x0075:
            int r14 = r14 + 1
            goto L_0x000b
        L_0x0078:
            int r0 = r13.size()
            com.google.android.exoplayer2.source.b.g[] r0 = new com.google.android.exoplayer2.source.b.g[r0]
            r11.f33381c = r0
            com.google.android.exoplayer2.source.b.g<com.google.android.exoplayer2.source.smoothstreaming.b>[] r0 = r11.f33381c
            r13.toArray(r0)
            com.google.android.exoplayer2.source.g r0 = r11.j
            com.google.android.exoplayer2.source.b.g<com.google.android.exoplayer2.source.smoothstreaming.b>[] r1 = r11.f33381c
            com.google.android.exoplayer2.source.v r0 = r0.a(r1)
            r11.l = r0
            return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.c.a(com.google.android.exoplayer2.trackselection.f[], boolean[], com.google.android.exoplayer2.source.u[], boolean[], long):long");
    }

    public final void a(long j2, boolean z) {
        for (g<b> a2 : this.f33381c) {
            a2.a(j2, z);
        }
    }

    public final void a(long j2) {
        this.l.a(j2);
    }

    public final boolean c(long j2) {
        return this.l.c(j2);
    }

    public final long e() {
        return this.l.e();
    }

    public final long c() {
        if (this.m) {
            return -9223372036854775807L;
        }
        this.f33379a.c();
        this.m = true;
        return -9223372036854775807L;
    }

    public final long d() {
        return this.l.d();
    }

    public final long b(long j2) {
        for (g<b> b2 : this.f33381c) {
            b2.b(j2);
        }
        return j2;
    }

    public final long a(long j2, af afVar) {
        for (g<b> gVar : this.f33381c) {
            if (gVar.f32837a == 2) {
                return gVar.a(j2, afVar);
            }
        }
        return j2;
    }

    private static TrackGroupArray b(a aVar) {
        TrackGroup[] trackGroupArr = new TrackGroup[aVar.f33335f.length];
        for (int i2 = 0; i2 < aVar.f33335f.length; i2++) {
            trackGroupArr[i2] = new TrackGroup(aVar.f33335f[i2].j);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    public final /* bridge */ /* synthetic */ void a(v vVar) {
        this.f33380b.a(this);
    }
}
