package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g<T extends h> implements x.a<d>, x.e, u, v {

    /* renamed from: a  reason: collision with root package name */
    public final int f32837a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32838b;

    /* renamed from: c  reason: collision with root package name */
    final Format[] f32839c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean[] f32840d;

    /* renamed from: e  reason: collision with root package name */
    public final T f32841e;

    /* renamed from: f  reason: collision with root package name */
    final p.a f32842f;

    /* renamed from: g  reason: collision with root package name */
    public final t[] f32843g;

    /* renamed from: h  reason: collision with root package name */
    long f32844h;

    /* renamed from: i  reason: collision with root package name */
    long f32845i;
    boolean j;
    private final v.a<g<T>> k;
    private final w l;
    private final x m = new x("Loader:ChunkSampleStream");
    private final f n = new f();
    private final ArrayList<a> o = new ArrayList<>();
    private final List<a> p = Collections.unmodifiableList(this.o);
    private final t q;
    private final c r;
    private Format s;
    private b<T> t;
    private long u;
    private int v;

    public interface b<T extends h> {
        void a(g<T> gVar);
    }

    public final /* synthetic */ x.b a(x.d dVar, long j2, long j3, IOException iOException, int i2) {
        IOException iOException2 = iOException;
        d dVar2 = (d) dVar;
        long c2 = dVar2.c();
        boolean z = dVar2 instanceof a;
        int size = this.o.size() - 1;
        boolean z2 = c2 == 0 || !z || !a(size);
        x.b bVar = null;
        if (this.f32841e.a(dVar2, z2, (Exception) iOException, z2 ? this.l.a(iOException2) : -9223372036854775807L)) {
            if (z2) {
                bVar = x.f32466c;
                if (z) {
                    com.google.android.exoplayer2.g.a.b(c(size) == dVar2);
                    if (this.o.isEmpty()) {
                        this.u = this.f32844h;
                    }
                }
            } else {
                l.c();
            }
        }
        if (bVar == null) {
            long a2 = this.l.a(iOException2, i2);
            bVar = a2 != -9223372036854775807L ? x.a(false, a2) : x.f32467d;
        }
        x.b bVar2 = bVar;
        boolean z3 = !bVar2.a();
        this.f32842f.a(dVar2.f32814e, dVar2.d(), dVar2.e(), dVar2.f32815f, this.f32837a, dVar2.f32816g, dVar2.f32817h, dVar2.f32818i, dVar2.j, dVar2.k, j2, j3, c2, iOException, z3);
        if (z3) {
            this.k.a(this);
        }
        return bVar2;
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3) {
        d dVar2 = (d) dVar;
        this.f32841e.a(dVar2);
        p.a aVar = this.f32842f;
        d dVar3 = dVar2;
        p.a aVar2 = aVar;
        aVar2.a(dVar2.f32814e, dVar2.d(), dVar2.e(), dVar2.f32815f, this.f32837a, dVar2.f32816g, dVar2.f32817h, dVar2.f32818i, dVar2.j, dVar2.k, j2, j3, dVar3.c());
        this.k.a(this);
    }

    public final /* synthetic */ void a(x.d dVar, long j2, long j3, boolean z) {
        d dVar2 = (d) dVar;
        p.a aVar = this.f32842f;
        aVar.b(dVar2.f32814e, dVar2.d(), dVar2.e(), dVar2.f32815f, this.f32837a, dVar2.f32816g, dVar2.f32817h, dVar2.f32818i, dVar2.j, dVar2.k, j2, j3, dVar2.c());
        if (!z) {
            this.q.a(false);
            for (t a2 : this.f32843g) {
                a2.a(false);
            }
            this.k.a(this);
        }
    }

    public g(int i2, int[] iArr, Format[] formatArr, T t2, v.a<g<T>> aVar, com.google.android.exoplayer2.f.b bVar, long j2, w wVar, p.a aVar2) {
        int i3;
        this.f32837a = i2;
        this.f32838b = iArr;
        this.f32839c = formatArr;
        this.f32841e = t2;
        this.k = aVar;
        this.f32842f = aVar2;
        this.l = wVar;
        int i4 = 0;
        if (iArr == null) {
            i3 = 0;
        } else {
            i3 = iArr.length;
        }
        this.f32843g = new t[i3];
        this.f32840d = new boolean[i3];
        int i5 = i3 + 1;
        int[] iArr2 = new int[i5];
        t[] tVarArr = new t[i5];
        this.q = new t(bVar);
        iArr2[0] = i2;
        tVarArr[0] = this.q;
        while (i4 < i3) {
            t tVar = new t(bVar);
            this.f32843g[i4] = tVar;
            int i6 = i4 + 1;
            tVarArr[i6] = tVar;
            iArr2[i6] = iArr[i4];
            i4 = i6;
        }
        this.r = new c(iArr2, tVarArr);
        this.u = j2;
        this.f32844h = j2;
    }

    public final void a(long j2, boolean z) {
        if (!f()) {
            int i2 = this.q.f33388a.f33293b;
            this.q.a(j2, z, true);
            int i3 = this.q.f33388a.f33293b;
            if (i3 > i2) {
                long g2 = this.q.f33388a.g();
                int i4 = 0;
                while (true) {
                    t[] tVarArr = this.f32843g;
                    if (i4 >= tVarArr.length) {
                        break;
                    }
                    tVarArr[i4].a(g2, z, this.f32840d[i4]);
                    i4++;
                }
            }
            int min = Math.min(a(i3, 0), this.v);
            if (min > 0) {
                ae.a(this.o, 0, min);
                this.v -= min;
            }
        }
    }

    public final long d() {
        if (this.j) {
            return Long.MIN_VALUE;
        }
        if (f()) {
            return this.u;
        }
        long j2 = this.f32844h;
        a i2 = i();
        if (!i2.g()) {
            if (this.o.size() > 1) {
                ArrayList<a> arrayList = this.o;
                i2 = arrayList.get(arrayList.size() - 2);
            } else {
                i2 = null;
            }
        }
        if (i2 != null) {
            j2 = Math.max(j2, i2.k);
        }
        return Math.max(j2, this.q.f33388a.e());
    }

    public final long a(long j2, af afVar) {
        return this.f32841e.a(j2, afVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(long r11) {
        /*
            r10 = this;
            r10.f32844h = r11
            boolean r0 = r10.f()
            if (r0 == 0) goto L_0x000b
            r10.u = r11
            return
        L_0x000b:
            r0 = 0
            r1 = 0
        L_0x000d:
            java.util.ArrayList<com.google.android.exoplayer2.source.b.a> r2 = r10.o
            int r2 = r2.size()
            r3 = 0
            if (r1 >= r2) goto L_0x0035
            java.util.ArrayList<com.google.android.exoplayer2.source.b.a> r2 = r10.o
            java.lang.Object r2 = r2.get(r1)
            com.google.android.exoplayer2.source.b.a r2 = (com.google.android.exoplayer2.source.b.a) r2
            long r4 = r2.j
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x0030
            long r4 = r2.f32805a
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0030
            goto L_0x0036
        L_0x0030:
            if (r6 > 0) goto L_0x0035
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0035:
            r2 = r3
        L_0x0036:
            com.google.android.exoplayer2.source.t r1 = r10.q
            r1.b()
            if (r2 == 0) goto L_0x004e
            com.google.android.exoplayer2.source.t r1 = r10.q
            int[] r2 = r2.f32808d
            r2 = r2[r0]
            com.google.android.exoplayer2.source.s r1 = r1.f33388a
            boolean r1 = r1.b(r2)
            r4 = 0
            r10.f32845i = r4
            goto L_0x006a
        L_0x004e:
            com.google.android.exoplayer2.source.t r1 = r10.q
            long r4 = r10.e()
            r2 = 1
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x005b
            r4 = 1
            goto L_0x005c
        L_0x005b:
            r4 = 0
        L_0x005c:
            int r1 = r1.a((long) r11, (boolean) r4)
            r4 = -1
            if (r1 == r4) goto L_0x0065
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            long r4 = r10.f32844h
            r10.f32845i = r4
        L_0x006a:
            if (r1 == 0) goto L_0x008c
            com.google.android.exoplayer2.source.t r1 = r10.q
            com.google.android.exoplayer2.source.s r1 = r1.f33388a
            int r1 = r1.b()
            int r1 = r10.a((int) r1, (int) r0)
            r10.v = r1
            com.google.android.exoplayer2.source.t[] r1 = r10.f32843g
            int r2 = r1.length
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x008b
            r4 = r1[r3]
            r4.b()
            r4.a((long) r11, (boolean) r0)
            int r3 = r3 + 1
            goto L_0x007e
        L_0x008b:
            return
        L_0x008c:
            r10.u = r11
            r10.j = r0
            java.util.ArrayList<com.google.android.exoplayer2.source.b.a> r11 = r10.o
            r11.clear()
            r10.v = r0
            com.google.android.exoplayer2.f.x r11 = r10.m
            boolean r11 = r11.c()
            if (r11 == 0) goto L_0x00a5
            com.google.android.exoplayer2.f.x r11 = r10.m
            r11.d()
            return
        L_0x00a5:
            com.google.android.exoplayer2.f.x r11 = r10.m
            r11.f32468e = r3
            com.google.android.exoplayer2.source.t r11 = r10.q
            r11.a((boolean) r0)
            com.google.android.exoplayer2.source.t[] r11 = r10.f32843g
            int r12 = r11.length
            r1 = 0
        L_0x00b2:
            if (r1 >= r12) goto L_0x00bc
            r2 = r11[r1]
            r2.a((boolean) r0)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.g.b(long):void");
    }

    public final void c() {
        a((b) null);
    }

    public final void a(b<T> bVar) {
        this.t = bVar;
        this.q.c();
        for (t c2 : this.f32843g) {
            c2.c();
        }
        this.m.a((x.e) this);
    }

    public final void g() {
        this.q.a(false);
        for (t a2 : this.f32843g) {
            a2.a(false);
        }
        b<T> bVar = this.t;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean a() {
        if (!this.j) {
            return !f() && this.q.f33388a.c();
        }
        return true;
    }

    public final void b() throws IOException {
        if (!this.m.c()) {
            this.f32841e.a();
        }
    }

    public final int a(o oVar, e eVar, boolean z) {
        if (f()) {
            return -3;
        }
        h();
        return this.q.a(oVar, eVar, z, this.j, this.f32845i);
    }

    public final int b_(long j2) {
        int i2 = 0;
        if (f()) {
            return 0;
        }
        if (!this.j || j2 <= this.q.f33388a.e()) {
            int a2 = this.q.a(j2, true);
            if (a2 != -1) {
                i2 = a2;
            }
        } else {
            i2 = this.q.f33388a.i();
        }
        h();
        return i2;
    }

    public final boolean c(long j2) {
        long j3;
        List<a> list;
        long j4;
        if (this.j || this.m.c() || this.m.b()) {
            return false;
        }
        boolean f2 = f();
        if (f2) {
            list = Collections.emptyList();
            j3 = this.u;
        } else {
            list = this.p;
            j3 = i().k;
        }
        this.f32841e.a(j2, j3, (List<? extends l>) list, this.n);
        boolean z = this.n.f32836b;
        d dVar = this.n.f32835a;
        f fVar = this.n;
        fVar.f32835a = null;
        fVar.f32836b = false;
        if (z) {
            this.u = -9223372036854775807L;
            this.j = true;
            return true;
        } else if (dVar == null) {
            return false;
        } else {
            if (dVar instanceof a) {
                a aVar = (a) dVar;
                if (f2) {
                    if (aVar.j == this.u) {
                        j4 = 0;
                    } else {
                        j4 = this.u;
                    }
                    this.f32845i = j4;
                    this.u = -9223372036854775807L;
                }
                c cVar = this.r;
                aVar.f32807c = cVar;
                int[] iArr = new int[cVar.f32812a.length];
                for (int i2 = 0; i2 < cVar.f32812a.length; i2++) {
                    if (cVar.f32812a[i2] != null) {
                        iArr[i2] = cVar.f32812a[i2].f33388a.a();
                    }
                }
                aVar.f32808d = iArr;
                this.o.add(aVar);
            }
            this.f32842f.a(dVar.f32814e, dVar.f32815f, this.f32837a, dVar.f32816g, dVar.f32817h, dVar.f32818i, dVar.j, dVar.k, this.m.a(dVar, this, this.l.a(dVar.f32815f)));
            return true;
        }
    }

    public final long e() {
        if (f()) {
            return this.u;
        }
        if (this.j) {
            return Long.MIN_VALUE;
        }
        return i().k;
    }

    public final void a(long j2) {
        int size;
        int a2;
        if (!this.m.c() && !this.m.b() && !f() && (size = this.o.size()) > (a2 = this.f32841e.a(j2, (List<? extends l>) this.p))) {
            while (true) {
                if (a2 >= size) {
                    a2 = size;
                    break;
                } else if (!a(a2)) {
                    break;
                } else {
                    a2++;
                }
            }
            if (a2 != size) {
                long j3 = i().k;
                a c2 = c(a2);
                if (this.o.isEmpty()) {
                    this.u = this.f32844h;
                }
                this.j = false;
                this.f32842f.a(this.f32837a, c2.j, j3);
            }
        }
    }

    private boolean a(int i2) {
        int b2;
        a aVar = this.o.get(i2);
        if (this.q.f33388a.b() > aVar.f32808d[0]) {
            return true;
        }
        int i3 = 0;
        do {
            t[] tVarArr = this.f32843g;
            if (i3 >= tVarArr.length) {
                return false;
            }
            b2 = tVarArr[i3].f33388a.b();
            i3++;
        } while (b2 <= aVar.f32808d[i3]);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.u != -9223372036854775807L;
    }

    private void h() {
        int a2 = a(this.q.f33388a.b(), this.v - 1);
        while (true) {
            int i2 = this.v;
            if (i2 <= a2) {
                this.v = i2 + 1;
                b(i2);
            } else {
                return;
            }
        }
    }

    private void b(int i2) {
        a aVar = this.o.get(i2);
        Format format = aVar.f32816g;
        if (!format.equals(this.s)) {
            this.f32842f.a(this.f32837a, format, aVar.f32817h, aVar.f32818i, aVar.j);
        }
        this.s = format;
    }

    private int a(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.o.size()) {
                return this.o.size() - 1;
            }
        } while (this.o.get(i3).f32808d[0] <= i2);
        return i3 - 1;
    }

    private a i() {
        ArrayList<a> arrayList = this.o;
        return arrayList.get(arrayList.size() - 1);
    }

    private a c(int i2) {
        a aVar = this.o.get(i2);
        ArrayList<a> arrayList = this.o;
        ae.a(arrayList, i2, arrayList.size());
        this.v = Math.max(this.v, this.o.size());
        int i3 = 0;
        this.q.b(aVar.f32808d[0]);
        while (true) {
            t[] tVarArr = this.f32843g;
            if (i3 >= tVarArr.length) {
                return aVar;
            }
            t tVar = tVarArr[i3];
            i3++;
            tVar.b(aVar.f32808d[i3]);
        }
    }

    public final class a implements u {

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f32846a;

        /* renamed from: c  reason: collision with root package name */
        private final t f32848c;

        /* renamed from: d  reason: collision with root package name */
        private final int f32849d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f32850e;

        public final void b() throws IOException {
        }

        public a(g<T> gVar, t tVar, int i2) {
            this.f32846a = gVar;
            this.f32848c = tVar;
            this.f32849d = i2;
        }

        public final boolean a() {
            if (!g.this.j) {
                return !g.this.f() && this.f32848c.f33388a.c();
            }
            return true;
        }

        public final int b_(long j) {
            if (g.this.f()) {
                return 0;
            }
            d();
            if (g.this.j && j > this.f32848c.f33388a.e()) {
                return this.f32848c.f33388a.i();
            }
            int a2 = this.f32848c.a(j, true);
            if (a2 == -1) {
                return 0;
            }
            return a2;
        }

        public final int a(o oVar, e eVar, boolean z) {
            if (g.this.f()) {
                return -3;
            }
            d();
            return this.f32848c.a(oVar, eVar, z, g.this.j, g.this.f32845i);
        }

        public final void c() {
            com.google.android.exoplayer2.g.a.b(g.this.f32840d[this.f32849d]);
            g.this.f32840d[this.f32849d] = false;
        }

        private void d() {
            if (!this.f32850e) {
                g.this.f32842f.a(g.this.f32838b[this.f32849d], g.this.f32839c[this.f32849d], 0, (Object) null, g.this.f32844h);
                this.f32850e = true;
            }
        }
    }
}
