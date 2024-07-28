package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.n;
import java.io.IOException;

public final class d implements n, n.a {

    /* renamed from: a  reason: collision with root package name */
    public final n f32858a;

    /* renamed from: b  reason: collision with root package name */
    long f32859b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f32860c;

    /* renamed from: d  reason: collision with root package name */
    private n.a f32861d;

    /* renamed from: e  reason: collision with root package name */
    private a[] f32862e = new a[0];

    /* renamed from: f  reason: collision with root package name */
    private long f32863f = 0;

    public d(n nVar, long j) {
        this.f32858a = nVar;
        this.f32860c = j;
    }

    public final void a(n.a aVar, long j) {
        this.f32861d = aVar;
        this.f32858a.a((n.a) this, j);
    }

    public final void i_() throws IOException {
        this.f32858a.i_();
    }

    public final TrackGroupArray b() {
        return this.f32858a.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (r1 > r5) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.google.android.exoplayer2.trackselection.f[] r16, boolean[] r17, com.google.android.exoplayer2.source.u[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r18
            int r1 = r9.length
            com.google.android.exoplayer2.source.d$a[] r1 = new com.google.android.exoplayer2.source.d.a[r1]
            r0.f32862e = r1
            int r1 = r9.length
            com.google.android.exoplayer2.source.u[] r10 = new com.google.android.exoplayer2.source.u[r1]
            r11 = 0
            r1 = 0
        L_0x000f:
            int r2 = r9.length
            r12 = 0
            if (r1 >= r2) goto L_0x0028
            com.google.android.exoplayer2.source.d$a[] r2 = r0.f32862e
            r3 = r9[r1]
            com.google.android.exoplayer2.source.d$a r3 = (com.google.android.exoplayer2.source.d.a) r3
            r2[r1] = r3
            r3 = r2[r1]
            if (r3 == 0) goto L_0x0023
            r2 = r2[r1]
            com.google.android.exoplayer2.source.u r12 = r2.f32864a
        L_0x0023:
            r10[r1] = r12
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0028:
            com.google.android.exoplayer2.source.n r1 = r0.f32858a
            r2 = r16
            r3 = r17
            r4 = r10
            r5 = r19
            r6 = r20
            long r1 = r1.a(r2, r3, r4, r5, r6)
            boolean r3 = r15.f()
            r4 = 1
            if (r3 == 0) goto L_0x0068
            long r5 = r0.f32859b
            int r3 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0068
            r13 = 0
            int r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0063
            int r3 = r8.length
            r5 = 0
        L_0x004c:
            if (r5 >= r3) goto L_0x0063
            r6 = r8[r5]
            if (r6 == 0) goto L_0x0060
            com.google.android.exoplayer2.Format r6 = r6.g()
            java.lang.String r6 = r6.f31069i
            boolean r6 = com.google.android.exoplayer2.g.o.a((java.lang.String) r6)
            if (r6 != 0) goto L_0x0060
            r3 = 1
            goto L_0x0064
        L_0x0060:
            int r5 = r5 + 1
            goto L_0x004c
        L_0x0063:
            r3 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x0068
            r5 = r1
            goto L_0x006d
        L_0x0068:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x006d:
            r0.f32863f = r5
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0087
            long r5 = r0.f32859b
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0086
            long r5 = r0.f32860c
            r7 = -9223372036854775808
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0087
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r4 = 0
        L_0x0087:
            com.google.android.exoplayer2.g.a.b(r4)
        L_0x008a:
            int r3 = r9.length
            if (r11 >= r3) goto L_0x00b8
            r3 = r10[r11]
            if (r3 != 0) goto L_0x0096
            com.google.android.exoplayer2.source.d$a[] r3 = r0.f32862e
            r3[r11] = r12
            goto L_0x00af
        L_0x0096:
            r3 = r9[r11]
            if (r3 == 0) goto L_0x00a4
            com.google.android.exoplayer2.source.d$a[] r3 = r0.f32862e
            r3 = r3[r11]
            com.google.android.exoplayer2.source.u r3 = r3.f32864a
            r4 = r10[r11]
            if (r3 == r4) goto L_0x00af
        L_0x00a4:
            com.google.android.exoplayer2.source.d$a[] r3 = r0.f32862e
            com.google.android.exoplayer2.source.d$a r4 = new com.google.android.exoplayer2.source.d$a
            r5 = r10[r11]
            r4.<init>(r5)
            r3[r11] = r4
        L_0x00af:
            com.google.android.exoplayer2.source.d$a[] r3 = r0.f32862e
            r3 = r3[r11]
            r9[r11] = r3
            int r11 = r11 + 1
            goto L_0x008a
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.d.a(com.google.android.exoplayer2.trackselection.f[], boolean[], com.google.android.exoplayer2.source.u[], boolean[], long):long");
    }

    public final void a(long j, boolean z) {
        this.f32858a.a(j, z);
    }

    public final void a(long j) {
        this.f32858a.a(j);
    }

    public final long c() {
        if (f()) {
            long j = this.f32863f;
            this.f32863f = -9223372036854775807L;
            long c2 = c();
            return c2 != -9223372036854775807L ? c2 : j;
        }
        long c3 = this.f32858a.c();
        if (c3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.google.android.exoplayer2.g.a.b(c3 >= this.f32859b);
        long j2 = this.f32860c;
        if (j2 != Long.MIN_VALUE && c3 > j2) {
            z = false;
        }
        com.google.android.exoplayer2.g.a.b(z);
        return c3;
    }

    public final long d() {
        long d2 = this.f32858a.d();
        if (d2 != Long.MIN_VALUE) {
            long j = this.f32860c;
            if (j == Long.MIN_VALUE || d2 < j) {
                return d2;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 > r7) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long b(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f32863f = r0
            com.google.android.exoplayer2.source.d$a[] r0 = r6.f32862e
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0017
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0014
            r4.f32865b = r2
        L_0x0014:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0017:
            com.google.android.exoplayer2.source.n r0 = r6.f32858a
            long r0 = r0.b(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            long r7 = r6.f32859b
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0034
            long r7 = r6.f32860c
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0033
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            com.google.android.exoplayer2.g.a.b(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.d.b(long):long");
    }

    public final long a(long j, af afVar) {
        long j2 = this.f32859b;
        if (j == j2) {
            return j2;
        }
        long a2 = ae.a(afVar.f31111f, 0, j - this.f32859b);
        long j3 = afVar.f31112g;
        long j4 = this.f32860c;
        long a3 = ae.a(j3, 0, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j);
        if (!(a2 == afVar.f31111f && a3 == afVar.f31112g)) {
            afVar = new af(a2, a3);
        }
        return this.f32858a.a(j, afVar);
    }

    public final long e() {
        long e2 = this.f32858a.e();
        if (e2 != Long.MIN_VALUE) {
            long j = this.f32860c;
            if (j == Long.MIN_VALUE || e2 < j) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final boolean c(long j) {
        return this.f32858a.c(j);
    }

    public final void a(n nVar) {
        this.f32861d.a(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f32863f != -9223372036854775807L;
    }

    final class a implements u {

        /* renamed from: a  reason: collision with root package name */
        public final u f32864a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32865b;

        public a(u uVar) {
            this.f32864a = uVar;
        }

        public final boolean a() {
            return !d.this.f() && this.f32864a.a();
        }

        public final void b() throws IOException {
            this.f32864a.b();
        }

        public final int a(o oVar, e eVar, boolean z) {
            if (d.this.f()) {
                return -3;
            }
            if (this.f32865b) {
                eVar.f31289a = 4;
                return -4;
            }
            int a2 = this.f32864a.a(oVar, eVar, z);
            if (a2 == -5) {
                Format format = oVar.f32757a;
                if (!(format.y == 0 && format.z == 0)) {
                    int i2 = 0;
                    int i3 = d.this.f32859b != 0 ? 0 : format.y;
                    if (d.this.f32860c == Long.MIN_VALUE) {
                        i2 = format.z;
                    }
                    oVar.f32757a = format.a(i3, i2);
                }
                return -5;
            } else if (d.this.f32860c == Long.MIN_VALUE || ((a2 != -4 || eVar.f31312d < d.this.f32860c) && (a2 != -3 || d.this.d() != Long.MIN_VALUE))) {
                return a2;
            } else {
                eVar.a();
                eVar.f31289a = 4;
                this.f32865b = true;
                return -4;
            }
        }

        public final int b_(long j) {
            if (d.this.f()) {
                return -3;
            }
            return this.f32864a.b_(j);
        }
    }

    public final /* bridge */ /* synthetic */ void a(v vVar) {
        this.f32861d.a(this);
    }
}
