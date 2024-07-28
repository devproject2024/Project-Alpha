package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.hls.d;
import com.google.android.exoplayer2.source.hls.k;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class k implements i, x.a<d>, x.e, t.b, v {
    private final com.google.android.exoplayer2.f.b A;
    private final Format B;
    private final w C;
    private final d.c D = new d.c();
    private final Runnable E = new Runnable() {
        public final void run() {
            k.this.k();
        }
    };
    private final Runnable F = new Runnable() {
        public final void run() {
            k.this.j();
        }
    };
    private int[] G = new int[0];
    private boolean H;
    private int I = -1;
    private boolean J;
    private int K = -1;
    private int L;
    private TrackGroupArray M;
    private boolean N;
    private boolean[] O = new boolean[0];
    private long P;
    private boolean Q;
    private long R;
    private int S;

    /* renamed from: a  reason: collision with root package name */
    final int f33184a;

    /* renamed from: b  reason: collision with root package name */
    final d f33185b;

    /* renamed from: c  reason: collision with root package name */
    final x f33186c = new x("Loader:HlsSampleStreamWrapper");

    /* renamed from: d  reason: collision with root package name */
    final p.a f33187d;

    /* renamed from: e  reason: collision with root package name */
    final ArrayList<h> f33188e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final List<h> f33189f = Collections.unmodifiableList(this.f33188e);

    /* renamed from: g  reason: collision with root package name */
    final Handler f33190g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    final ArrayList<j> f33191h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    final Map<String, DrmInitData> f33192i;
    t[] j = new t[0];
    int k;
    boolean l;
    boolean m;
    int n;
    Format o;
    Format p;
    boolean q;
    TrackGroupArray r;
    int[] s;
    int t;
    boolean[] u = new boolean[0];
    long v;
    boolean w;
    boolean x;
    boolean y;
    private final a z;

    public interface a extends v.a<k> {
        void a(Uri uri);

        void f();
    }

    private static int b(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void a(long j2) {
    }

    public final void a(o oVar) {
    }

    public final /* synthetic */ x.b a(x.d dVar, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        x.b bVar;
        IOException iOException2 = iOException;
        com.google.android.exoplayer2.source.b.d dVar2 = (com.google.android.exoplayer2.source.b.d) dVar;
        long c2 = dVar2.c();
        boolean z3 = dVar2 instanceof h;
        long a2 = this.C.a(iOException2);
        boolean z4 = false;
        if (a2 != -9223372036854775807L) {
            d dVar3 = this.f33185b;
            z2 = dVar3.f33153h.a(dVar3.f33153h.c(dVar3.f33147b.a(dVar2.f32816g)), a2);
        } else {
            z2 = false;
        }
        if (z2) {
            if (z3 && c2 == 0) {
                ArrayList<h> arrayList = this.f33188e;
                if (arrayList.remove(arrayList.size() - 1) == dVar2) {
                    z4 = true;
                }
                com.google.android.exoplayer2.g.a.b(z4);
                if (this.f33188e.isEmpty()) {
                    this.P = this.v;
                }
            }
            bVar = x.f32466c;
        } else {
            long a3 = this.C.a(iOException2, i2);
            bVar = a3 != -9223372036854775807L ? x.a(false, a3) : x.f32467d;
        }
        x.b bVar2 = bVar;
        p.a aVar = this.f33187d;
        l lVar = dVar2.f32814e;
        Uri d2 = dVar2.d();
        Map<String, List<String>> e2 = dVar2.e();
        int i3 = dVar2.f32815f;
        int i4 = this.f33184a;
        Format format = dVar2.f32816g;
        int i5 = dVar2.f32817h;
        Object obj = dVar2.f32818i;
        long j4 = dVar2.j;
        long j5 = dVar2.k;
        aVar.a(lVar, d2, e2, i3, i4, format, i5, obj, j4, j5, j2, j3, c2, iOException, !bVar2.a());
        if (z2) {
            if (!this.m) {
                c(this.v);
            } else {
                this.z.a(this);
            }
        }
        return bVar2;
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
        com.google.android.exoplayer2.source.b.d dVar2 = (com.google.android.exoplayer2.source.b.d) dVar;
        d dVar3 = this.f33185b;
        if (dVar2 instanceof d.a) {
            d.a aVar = (d.a) dVar2;
            dVar3.f33150e = aVar.f32851a;
            dVar3.f33148c.put(aVar.f32814e.f32395a, aVar.f33155b);
        }
        this.f33187d.a(dVar2.f32814e, dVar2.d(), dVar2.e(), dVar2.f32815f, this.f33184a, dVar2.f32816g, dVar2.f32817h, dVar2.f32818i, dVar2.j, dVar2.k, j2, j3, dVar2.c());
        if (!this.m) {
            c(this.v);
        } else {
            this.z.a(this);
        }
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z2) {
        com.google.android.exoplayer2.source.b.d dVar2 = (com.google.android.exoplayer2.source.b.d) dVar;
        p.a aVar = this.f33187d;
        com.google.android.exoplayer2.source.b.d dVar3 = dVar2;
        p.a aVar2 = aVar;
        aVar2.b(dVar2.f32814e, dVar2.d(), dVar2.e(), dVar2.f32815f, this.f33184a, dVar2.f32816g, dVar2.f32817h, dVar2.f32818i, dVar2.j, dVar2.k, j2, j3, dVar3.c());
        if (!z2) {
            c();
            if (this.n > 0) {
                this.z.a(this);
                return;
            }
            return;
        }
    }

    public k(int i2, a aVar, d dVar, Map<String, DrmInitData> map, com.google.android.exoplayer2.f.b bVar, long j2, Format format, w wVar, p.a aVar2) {
        this.f33184a = i2;
        this.z = aVar;
        this.f33185b = dVar;
        this.f33192i = map;
        this.A = bVar;
        this.B = format;
        this.C = wVar;
        this.f33187d = aVar2;
        this.v = j2;
        this.P = j2;
    }

    public final void b() {
        if (!this.m) {
            c(this.v);
        }
    }

    public final void a(TrackGroupArray trackGroupArray, TrackGroupArray trackGroupArray2) {
        this.m = true;
        this.r = trackGroupArray;
        this.M = trackGroupArray2;
        this.t = 0;
        Handler handler = this.f33190g;
        a aVar = this.z;
        aVar.getClass();
        handler.post(new Runnable() {
            public final void run() {
                k.a.this.f();
            }
        });
    }

    public final int a(int i2) {
        int i3 = this.s[i2];
        if (i3 != -1) {
            boolean[] zArr = this.u;
            if (zArr[i3]) {
                return -2;
            }
            zArr[i3] = true;
            return i3;
        } else if (this.M.a(this.r.f32785c[i2]) == -1) {
            return -2;
        } else {
            return -3;
        }
    }

    public final boolean a(long j2, boolean z2) {
        this.v = j2;
        if (h()) {
            this.P = j2;
            return true;
        } else if (this.l && !z2 && d(j2)) {
            return false;
        } else {
            this.P = j2;
            this.y = false;
            this.f33188e.clear();
            if (this.f33186c.c()) {
                this.f33186c.d();
            } else {
                this.f33186c.f32468e = null;
                c();
            }
            return true;
        }
    }

    public final void g() {
        c();
    }

    public final void a(boolean z2) {
        this.f33185b.f33149d = z2;
    }

    public final long d() {
        if (this.y) {
            return Long.MIN_VALUE;
        }
        if (h()) {
            return this.P;
        }
        long j2 = this.v;
        h f2 = f();
        if (!f2.n) {
            if (this.f33188e.size() > 1) {
                ArrayList<h> arrayList = this.f33188e;
                f2 = arrayList.get(arrayList.size() - 2);
            } else {
                f2 = null;
            }
        }
        if (f2 != null) {
            j2 = Math.max(j2, f2.k);
        }
        if (this.l) {
            for (t tVar : this.j) {
                j2 = Math.max(j2, tVar.f33388a.e());
            }
        }
        return j2;
    }

    public final long e() {
        if (h()) {
            return this.P;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return f().k;
    }

    public final boolean c(long j2) {
        List<h> list;
        long max;
        if (this.y || this.f33186c.c() || this.f33186c.b()) {
            return false;
        }
        if (h()) {
            list = Collections.emptyList();
            max = this.P;
        } else {
            list = this.f33189f;
            h f2 = f();
            if (f2.n) {
                max = f2.k;
            } else {
                max = Math.max(this.v, f2.j);
            }
        }
        this.f33185b.a(j2, max, list, this.D);
        boolean z2 = this.D.f33157b;
        com.google.android.exoplayer2.source.b.d dVar = this.D.f33156a;
        Uri uri = this.D.f33158c;
        this.D.a();
        if (z2) {
            this.P = -9223372036854775807L;
            this.y = true;
            return true;
        } else if (dVar == null) {
            if (uri != null) {
                this.z.a(uri);
            }
            return false;
        } else {
            if (dVar instanceof h) {
                this.P = -9223372036854775807L;
                h hVar = (h) dVar;
                hVar.f33171d = this;
                this.f33188e.add(hVar);
                this.o = hVar.f32816g;
            }
            long a2 = this.f33186c.a(dVar, this, this.C.a(dVar.f32815f));
            this.f33187d.a(dVar.f32814e, dVar.f32815f, this.f33184a, dVar.f32816g, dVar.f32817h, dVar.f32818i, dVar.j, dVar.k, a2);
            return true;
        }
    }

    public final void a(int i2, boolean z2, boolean z3) {
        if (!z3) {
            this.H = false;
            this.J = false;
        }
        this.S = i2;
        for (t a2 : this.j) {
            a2.a(i2);
        }
        if (z2) {
            for (t tVar : this.j) {
                tVar.f33389b = true;
            }
        }
    }

    public final q a(int i2, int i3) {
        t[] tVarArr = this.j;
        int length = tVarArr.length;
        boolean z2 = false;
        if (i3 == 1) {
            int i4 = this.I;
            if (i4 != -1) {
                if (!this.H) {
                    this.H = true;
                    this.G[i4] = i2;
                    return tVarArr[i4];
                } else if (this.G[i4] == i2) {
                    return tVarArr[i4];
                } else {
                    return b(i2, i3);
                }
            } else if (this.Q) {
                return b(i2, i3);
            }
        } else if (i3 == 2) {
            int i5 = this.K;
            if (i5 != -1) {
                if (!this.J) {
                    this.J = true;
                    this.G[i5] = i2;
                    return tVarArr[i5];
                } else if (this.G[i5] == i2) {
                    return tVarArr[i5];
                } else {
                    return b(i2, i3);
                }
            } else if (this.Q) {
                return b(i2, i3);
            }
        } else {
            for (int i6 = 0; i6 < length; i6++) {
                if (this.G[i6] == i2) {
                    return this.j[i6];
                }
            }
            if (this.Q) {
                return b(i2, i3);
            }
        }
        b bVar = new b(this.A);
        bVar.b(this.R);
        bVar.a(this.S);
        bVar.f33390c = this;
        int i7 = length + 1;
        this.G = Arrays.copyOf(this.G, i7);
        this.G[length] = i2;
        this.j = (t[]) Arrays.copyOf(this.j, i7);
        this.j[length] = bVar;
        this.O = Arrays.copyOf(this.O, i7);
        boolean[] zArr = this.O;
        if (i3 == 1 || i3 == 2) {
            z2 = true;
        }
        zArr[length] = z2;
        this.N |= this.O[length];
        if (i3 == 1) {
            this.H = true;
            this.I = length;
        } else if (i3 == 2) {
            this.J = true;
            this.K = length;
        }
        if (b(i3) > b(this.L)) {
            this.k = length;
            this.L = i3;
        }
        this.u = Arrays.copyOf(this.u, i7);
        return bVar;
    }

    public final void a() {
        this.Q = true;
        this.f33190g.post(this.F);
    }

    public final void i() {
        this.f33190g.post(this.E);
    }

    public final void b(long j2) {
        this.R = j2;
        for (t b2 : this.j) {
            b2.b(j2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        for (t a2 : this.j) {
            a2.a(this.w);
        }
        this.w = false;
    }

    /* access modifiers changed from: private */
    public void j() {
        this.l = true;
        k();
    }

    /* access modifiers changed from: private */
    public void k() {
        boolean z2;
        if (!this.q && this.s == null && this.l) {
            t[] tVarArr = this.j;
            int length = tVarArr.length;
            boolean z3 = false;
            int i2 = 0;
            while (i2 < length) {
                if (tVarArr[i2].f33388a.d() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            TrackGroupArray trackGroupArray = this.r;
            if (trackGroupArray != null) {
                int i3 = trackGroupArray.f32784b;
                this.s = new int[i3];
                Arrays.fill(this.s, -1);
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = 0;
                    while (true) {
                        t[] tVarArr2 = this.j;
                        if (i5 >= tVarArr2.length) {
                            break;
                        }
                        Format d2 = tVarArr2[i5].f33388a.d();
                        Format format = this.r.f32785c[i4].f32781b[0];
                        String str = d2.f31069i;
                        String str2 = format.f31069i;
                        int g2 = com.google.android.exoplayer2.g.o.g(str);
                        if (g2 == 3 ? ae.a((Object) str, (Object) str2) && ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || d2.B == format.B) : g2 == com.google.android.exoplayer2.g.o.g(str2)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            this.s[i4] = i5;
                            break;
                        }
                        i5++;
                    }
                }
                Iterator<j> it2 = this.f33191h.iterator();
                while (it2.hasNext()) {
                    it2.next().c();
                }
                return;
            }
            int length2 = this.j.length;
            int i6 = 0;
            int i7 = 6;
            int i8 = -1;
            while (true) {
                int i9 = 2;
                if (i6 >= length2) {
                    break;
                }
                String str3 = this.j[i6].f33388a.d().f31069i;
                if (!com.google.android.exoplayer2.g.o.b(str3)) {
                    if (com.google.android.exoplayer2.g.o.a(str3)) {
                        i9 = 1;
                    } else {
                        i9 = com.google.android.exoplayer2.g.o.c(str3) ? 3 : 6;
                    }
                }
                if (b(i9) > b(i7)) {
                    i8 = i6;
                    i7 = i9;
                } else if (i9 == i7 && i8 != -1) {
                    i8 = -1;
                }
                i6++;
            }
            TrackGroup trackGroup = this.f33185b.f33147b;
            int i10 = trackGroup.f32780a;
            this.t = -1;
            this.s = new int[length2];
            for (int i11 = 0; i11 < length2; i11++) {
                this.s[i11] = i11;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            for (int i12 = 0; i12 < length2; i12++) {
                Format d3 = this.j[i12].f33388a.d();
                if (i12 == i8) {
                    Format[] formatArr = new Format[i10];
                    if (i10 == 1) {
                        formatArr[0] = d3.a(trackGroup.f32781b[0]);
                    } else {
                        for (int i13 = 0; i13 < i10; i13++) {
                            formatArr[i13] = a(trackGroup.f32781b[i13], d3, true);
                        }
                    }
                    trackGroupArr[i12] = new TrackGroup(formatArr);
                    this.t = i12;
                } else {
                    trackGroupArr[i12] = new TrackGroup(a((i7 != 2 || !com.google.android.exoplayer2.g.o.a(d3.f31069i)) ? null : this.B, d3, false));
                }
            }
            this.r = new TrackGroupArray(trackGroupArr);
            if (this.M == null) {
                z3 = true;
            }
            com.google.android.exoplayer2.g.a.b(z3);
            this.M = TrackGroupArray.f32783a;
            this.m = true;
            this.z.f();
        }
    }

    /* access modifiers changed from: package-private */
    public final h f() {
        ArrayList<h> arrayList = this.f33188e;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.P != -9223372036854775807L;
    }

    private boolean d(long j2) {
        int length = this.j.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                return true;
            }
            t tVar = this.j[i2];
            tVar.b();
            if (tVar.a(j2, false) == -1) {
                z2 = false;
            }
            if (z2 || (!this.O[i2] && this.N)) {
                i2++;
            }
        }
        return false;
    }

    private static Format a(Format format, Format format2, boolean z2) {
        if (format == null) {
            return format2;
        }
        int i2 = z2 ? format.f31065e : -1;
        int i3 = format.v != -1 ? format.v : format2.v;
        String a2 = ae.a(format.f31066f, com.google.android.exoplayer2.g.o.g(format2.f31069i));
        String f2 = com.google.android.exoplayer2.g.o.f(a2);
        if (f2 == null) {
            f2 = format2.f31069i;
        }
        return format2.a(format.f31061a, format.f31062b, f2, a2, format.f31067g, i2, format.n, format.o, i3, format.f31063c, format.A);
    }

    private static f b(int i2, int i3) {
        StringBuilder sb = new StringBuilder("Unmapped track with id ");
        sb.append(i2);
        sb.append(" of type ");
        sb.append(i3);
        com.google.android.exoplayer2.g.l.c();
        return new f();
    }

    static final class b extends t {
        public b(com.google.android.exoplayer2.f.b bVar) {
            super(bVar);
        }

        public final void a(Format format) {
            Metadata metadata = format.f31067g;
            if (metadata != null) {
                int length = metadata.f32644a.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    }
                    Metadata.Entry entry = metadata.f32644a[i3];
                    if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).f32711a)) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1) {
                    if (length != 1) {
                        Metadata.Entry[] entryArr = new Metadata.Entry[(length - 1)];
                        while (i2 < length) {
                            if (i2 != i3) {
                                entryArr[i2 < i3 ? i2 : i2 - 1] = metadata.f32644a[i2];
                            }
                            i2++;
                        }
                        metadata = new Metadata(entryArr);
                    }
                }
                super.a(format.a(metadata));
            }
            metadata = null;
            super.a(format.a(metadata));
        }
    }
}
