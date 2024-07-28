package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.hls.a.e;
import com.google.android.exoplayer2.source.hls.f;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class h extends l {
    private static final AtomicInteger o = new AtomicInteger();
    private final r A;
    private final boolean B;
    private final boolean C;
    private g D;
    private boolean E;
    private int F;
    private boolean G;
    private volatile boolean H;

    /* renamed from: a  reason: collision with root package name */
    public final int f33168a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33169b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f33170c;

    /* renamed from: d  reason: collision with root package name */
    k f33171d;
    boolean n;
    private final i p;
    private final com.google.android.exoplayer2.f.l q;
    private final boolean r;
    private final boolean s;
    private final ab t;
    private final boolean u;
    private final f v;
    private final List<Format> w;
    private final DrmInitData x;
    private final g y;
    private final a z;

    public static h a(f fVar, i iVar, Format format, long j, e eVar, int i2, Uri uri, List<Format> list, int i3, Object obj, boolean z2, m mVar, h hVar, byte[] bArr, byte[] bArr2) {
        i iVar2;
        com.google.android.exoplayer2.f.l lVar;
        boolean z3;
        boolean z4;
        r rVar;
        a aVar;
        g gVar;
        i iVar3 = iVar;
        e eVar2 = eVar;
        int i4 = i2;
        m mVar2 = mVar;
        h hVar2 = hVar;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        e.a aVar2 = eVar2.l.get(i4);
        com.google.android.exoplayer2.f.l lVar2 = new com.google.android.exoplayer2.f.l(ad.a(eVar2.n, aVar2.f33122a), aVar2.j, aVar2.k, (String) null);
        boolean z5 = bArr3 != null;
        i a2 = a(iVar3, bArr3, z5 ? a(aVar2.f33130i) : null);
        e.a aVar3 = aVar2.f33123b;
        if (aVar3 != null) {
            boolean z6 = bArr4 != null;
            byte[] a3 = z6 ? a(aVar3.f33130i) : null;
            com.google.android.exoplayer2.f.l lVar3 = new com.google.android.exoplayer2.f.l(ad.a(eVar2.n, aVar3.f33122a), aVar3.j, aVar3.k, (String) null);
            iVar2 = a(iVar3, bArr4, a3);
            lVar = lVar3;
            z3 = z6;
        } else {
            z3 = false;
            lVar = null;
            iVar2 = null;
        }
        long j2 = j + aVar2.f33127f;
        long j3 = j2 + aVar2.f33124c;
        int i5 = eVar2.f33117e + aVar2.f33126e;
        if (hVar2 != null) {
            a aVar4 = hVar2.z;
            r rVar2 = hVar2.A;
            boolean z7 = !uri.equals(hVar2.f33170c) || !hVar2.n;
            aVar = aVar4;
            rVar = rVar2;
            z4 = z7;
            gVar = (!hVar2.E || hVar2.f33169b != i5 || z7) ? null : hVar2.D;
        } else {
            Uri uri2 = uri;
            aVar = new a();
            rVar = new r(10);
            gVar = null;
            z4 = false;
        }
        long j4 = eVar2.f33118f + ((long) i4);
        boolean z8 = aVar2.l;
        ab abVar = mVar2.f33193a.get(i5);
        if (abVar == null) {
            abVar = new ab(Long.MAX_VALUE);
            mVar2.f33193a.put(i5, abVar);
        }
        return new h(fVar, a2, lVar2, format, z5, iVar2, lVar, z3, uri, list, i3, obj, j2, j3, j4, i5, z8, z2, abVar, aVar2.f33128g, gVar, aVar, rVar, z4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(f fVar, i iVar, com.google.android.exoplayer2.f.l lVar, Format format, boolean z2, i iVar2, com.google.android.exoplayer2.f.l lVar2, boolean z3, Uri uri, List<Format> list, int i2, Object obj, long j, long j2, long j3, int i3, boolean z4, boolean z5, ab abVar, DrmInitData drmInitData, g gVar, a aVar, r rVar, boolean z6) {
        super(iVar, lVar, format, i2, obj, j, j2, j3);
        com.google.android.exoplayer2.f.l lVar3 = lVar2;
        this.B = z2;
        this.f33169b = i3;
        this.p = iVar2;
        this.q = lVar3;
        this.C = z3;
        this.f33170c = uri;
        this.r = z5;
        this.t = abVar;
        this.s = z4;
        this.v = fVar;
        this.w = list;
        this.x = drmInitData;
        this.y = gVar;
        this.z = aVar;
        this.A = rVar;
        this.u = z6;
        this.G = lVar3 != null;
        this.f33168a = o.getAndIncrement();
    }

    public final boolean g() {
        return this.n;
    }

    public final void a() {
        this.H = true;
    }

    public final void b() throws IOException, InterruptedException {
        g gVar;
        if (this.D == null && (gVar = this.y) != null) {
            this.D = gVar;
            this.E = true;
            this.G = false;
            this.f33171d.a(this.f33168a, this.u, true);
        }
        if (this.G) {
            a(this.p, this.q, this.C);
            this.F = 0;
            this.G = false;
        }
        if (!this.H) {
            if (!this.s) {
                if (!this.r) {
                    this.t.b();
                } else if (this.t.f32496a == Long.MAX_VALUE) {
                    this.t.a(this.j);
                }
                a((i) this.l, this.f32814e, this.B);
            }
            this.n = true;
        }
    }

    private void a(i iVar, com.google.android.exoplayer2.f.l lVar, boolean z2) throws IOException, InterruptedException {
        com.google.android.exoplayer2.f.l lVar2;
        boolean z3;
        d a2;
        int i2 = 0;
        if (z2) {
            z3 = this.F != 0;
            lVar2 = lVar;
        } else {
            lVar2 = lVar.a((long) this.F);
            z3 = false;
        }
        try {
            a2 = a(iVar, lVar2);
            if (z3) {
                a2.b(this.F);
            }
            while (i2 == 0) {
                if (this.H) {
                    break;
                }
                i2 = this.D.a((com.google.android.exoplayer2.extractor.h) a2, (n) null);
            }
            this.F = (int) (a2.c() - lVar.f32399e);
            ae.a(iVar);
        } catch (Throwable th) {
            ae.a(iVar);
            throw th;
        }
    }

    private d a(i iVar, com.google.android.exoplayer2.f.l lVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.f.l lVar2 = lVar;
        d dVar = new d(iVar, lVar2.f32399e, iVar.a(lVar));
        if (this.D != null) {
            return dVar;
        }
        long a2 = a((com.google.android.exoplayer2.extractor.h) dVar);
        dVar.f31754a = 0;
        f fVar = this.v;
        g gVar = this.y;
        Uri uri = lVar2.f32395a;
        Format format = this.f32816g;
        List<Format> list = this.w;
        DrmInitData drmInitData = this.x;
        ab abVar = this.t;
        iVar.b();
        d dVar2 = dVar;
        f.a a3 = fVar.a(gVar, uri, format, list, drmInitData, abVar, dVar);
        this.D = a3.f33163a;
        this.E = a3.f33165c;
        if (a3.f33164b) {
            this.f33171d.b(a2 != -9223372036854775807L ? this.t.b(a2) : this.j);
        } else {
            this.f33171d.b(0);
        }
        this.f33171d.a(this.f33168a, this.u, false);
        this.D.a((com.google.android.exoplayer2.extractor.i) this.f33171d);
        return dVar2;
    }

    private long a(com.google.android.exoplayer2.extractor.h hVar) throws IOException, InterruptedException {
        hVar.a();
        try {
            hVar.c(this.A.f32566a, 0, 10);
            this.A.a(10);
            if (this.A.f() != a.f32718b) {
                return -9223372036854775807L;
            }
            this.A.d(3);
            int m = this.A.m();
            int i2 = m + 10;
            if (i2 > this.A.f32566a.length) {
                byte[] bArr = this.A.f32566a;
                this.A.a(i2);
                System.arraycopy(bArr, 0, this.A.f32566a, 0, 10);
            }
            hVar.c(this.A.f32566a, 10, m);
            Metadata a2 = this.z.a(this.A.f32566a, m);
            if (a2 == null) {
                return -9223372036854775807L;
            }
            for (Metadata.Entry entry : a2.f32644a) {
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f32711a)) {
                        System.arraycopy(privFrame.f32712b, 0, this.A.f32566a, 0, 8);
                        this.A.a(8);
                        return this.A.k() & 8589934591L;
                    }
                }
            }
            return -9223372036854775807L;
        } catch (EOFException unused) {
        }
    }

    private static byte[] a(String str) {
        if (ae.d(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static i a(i iVar, byte[] bArr, byte[] bArr2) {
        return bArr != null ? new a(iVar, bArr, bArr2) : iVar;
    }
}
