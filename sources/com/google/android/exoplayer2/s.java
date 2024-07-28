package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.trackselection.j;

final class s {

    /* renamed from: a  reason: collision with root package name */
    public final n f32770a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f32771b;

    /* renamed from: c  reason: collision with root package name */
    public final u[] f32772c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32773d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32774e;

    /* renamed from: f  reason: collision with root package name */
    public t f32775f;

    /* renamed from: g  reason: collision with root package name */
    s f32776g;

    /* renamed from: h  reason: collision with root package name */
    TrackGroupArray f32777h;

    /* renamed from: i  reason: collision with root package name */
    long f32778i;
    private final boolean[] j;
    private final ac[] k;
    private final i l;
    private final o m;
    private j n;

    public s(ac[] acVarArr, long j2, i iVar, b bVar, o oVar, t tVar) {
        this.k = acVarArr;
        this.f32778i = j2;
        this.l = iVar;
        this.m = oVar;
        this.f32771b = tVar.f33411a.f33224a;
        this.f32775f = tVar;
        this.f32772c = new u[acVarArr.length];
        this.j = new boolean[acVarArr.length];
        o.a aVar = tVar.f33411a;
        long j3 = tVar.f33412b;
        long j4 = tVar.f33414d;
        n a2 = oVar.a(aVar, bVar, j3);
        if (!(j4 == -9223372036854775807L || j4 == Long.MIN_VALUE)) {
            a2 = new d(a2, j4);
        }
        this.f32770a = a2;
    }

    public final boolean a() {
        if (this.f32773d) {
            return !this.f32774e || this.f32770a.d() == Long.MIN_VALUE;
        }
        return false;
    }

    public final long b() {
        if (!this.f32773d) {
            return this.f32775f.f33412b;
        }
        long d2 = this.f32774e ? this.f32770a.d() : Long.MIN_VALUE;
        return d2 == Long.MIN_VALUE ? this.f32775f.f33415e : d2;
    }

    public final long c() {
        if (!this.f32773d) {
            return 0;
        }
        return this.f32770a.e();
    }

    public final void a(long j2) {
        a.b(h());
        if (this.f32773d) {
            this.f32770a.a(j2 - this.f32778i);
        }
    }

    public final void b(long j2) {
        a.b(h());
        this.f32770a.c(j2 - this.f32778i);
    }

    public final j a(float f2) throws i {
        j a2 = this.l.a(this.k, e());
        if (a2.a(this.n)) {
            return null;
        }
        for (f fVar : a2.f33511c.a()) {
            if (fVar != null) {
                fVar.a(f2);
            }
        }
        return a2;
    }

    public final long a(j jVar, long j2) {
        return a(jVar, j2, false, new boolean[this.k.length]);
    }

    public final long a(j jVar, long j2, boolean z, boolean[] zArr) {
        j jVar2 = jVar;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= jVar2.f33509a) {
                break;
            }
            boolean[] zArr2 = this.j;
            if (z || !jVar.a(this.n, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        a(this.f32772c);
        this.n = jVar2;
        g();
        g gVar = jVar2.f33511c;
        long a2 = this.f32770a.a(gVar.a(), this.j, this.f32772c, zArr, j2);
        b(this.f32772c);
        this.f32774e = false;
        int i3 = 0;
        while (true) {
            u[] uVarArr = this.f32772c;
            if (i3 >= uVarArr.length) {
                return a2;
            }
            if (uVarArr[i3] != null) {
                a.b(jVar.a(i3));
                if (this.k[i3].a() != 6) {
                    this.f32774e = true;
                }
            } else {
                a.b(gVar.f33505b[i3] == null);
            }
            i3++;
        }
    }

    public final void d() {
        this.n = null;
        long j2 = this.f32775f.f33414d;
        o oVar = this.m;
        n nVar = this.f32770a;
        if (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) {
            oVar.a(nVar);
            return;
        }
        try {
            oVar.a(((d) nVar).f32858a);
        } catch (RuntimeException e2) {
            l.b("Period release failed.", e2);
        }
    }

    public final void a(s sVar) {
        if (sVar != this.f32776g) {
            this.f32776g = sVar;
            g();
        }
    }

    public final TrackGroupArray e() {
        return (TrackGroupArray) a.a(this.f32777h);
    }

    public final j f() {
        return (j) a.a(this.n);
    }

    private void g() {
        j jVar = this.n;
        if (h() && jVar != null) {
            for (int i2 = 0; i2 < jVar.f33509a; i2++) {
                boolean a2 = jVar.a(i2);
                f fVar = jVar.f33511c.f33505b[i2];
                if (a2 && fVar != null) {
                    fVar.d();
                }
            }
        }
    }

    private void a(u[] uVarArr) {
        int i2 = 0;
        while (true) {
            ac[] acVarArr = this.k;
            if (i2 < acVarArr.length) {
                if (acVarArr[i2].a() == 6) {
                    uVarArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void b(u[] uVarArr) {
        j jVar = (j) a.a(this.n);
        int i2 = 0;
        while (true) {
            ac[] acVarArr = this.k;
            if (i2 < acVarArr.length) {
                if (acVarArr[i2].a() == 6 && jVar.a(i2)) {
                    uVarArr[i2] = new com.google.android.exoplayer2.source.i();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private boolean h() {
        return this.f32776g == null;
    }
}
