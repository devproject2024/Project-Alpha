package com.google.android.exoplayer2.extractor.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ab implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31899a = $$Lambda$ab$lyEIv5YnvSt1EFZ_OiK1ym0KGfs.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final long f31900b = ((long) ae.h("AC-3"));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f31901c = ((long) ae.h("EAC3"));
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final long f31902d = ((long) ae.h("AC-4"));
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final long f31903e = ((long) ae.h("HEVC"));
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f31904f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final List<com.google.android.exoplayer2.g.ab> f31905g;

    /* renamed from: h  reason: collision with root package name */
    private final r f31906h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseIntArray f31907i;
    /* access modifiers changed from: private */
    public final ac.c j;
    /* access modifiers changed from: private */
    public final SparseArray<ac> k;
    /* access modifiers changed from: private */
    public final SparseBooleanArray l;
    /* access modifiers changed from: private */
    public final SparseBooleanArray m;
    private final aa n;
    private z o;
    /* access modifiers changed from: private */
    public i p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public boolean r;
    private boolean s;
    private boolean t;
    /* access modifiers changed from: private */
    public ac u;
    private int v;
    /* access modifiers changed from: private */
    public int w;

    static /* synthetic */ int b(ab abVar) {
        int i2 = abVar.q;
        abVar.q = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] f() {
        return new g[]{new ab()};
    }

    public ab() {
        this((byte) 0);
    }

    private ab(byte b2) {
        this(1, 0);
    }

    public ab(int i2, int i3) {
        this(i2, new com.google.android.exoplayer2.g.ab(0), new g(i3));
    }

    public ab(int i2, com.google.android.exoplayer2.g.ab abVar, ac.c cVar) {
        this.j = (ac.c) com.google.android.exoplayer2.g.a.a(cVar);
        this.f31904f = i2;
        if (i2 == 1 || i2 == 2) {
            this.f31905g = Collections.singletonList(abVar);
        } else {
            this.f31905g = new ArrayList();
            this.f31905g.add(abVar);
        }
        this.f31906h = new r(new byte[9400], 0);
        this.l = new SparseBooleanArray();
        this.m = new SparseBooleanArray();
        this.k = new SparseArray<>();
        this.f31907i = new SparseIntArray();
        this.n = new aa();
        this.w = -1;
        e();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        boolean z;
        byte[] bArr = this.f31906h.f32566a;
        hVar.c(bArr, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z = true;
                    break;
                } else if (bArr[(i3 * 188) + i2] != 71) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                hVar.b(i2);
                return true;
            }
        }
        return false;
    }

    public final void a(i iVar) {
        this.p = iVar;
    }

    public final void a(long j2, long j3) {
        z zVar;
        com.google.android.exoplayer2.g.a.b(this.f31904f != 2);
        int size = this.f31905g.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.g.ab abVar = this.f31905g.get(i2);
            if ((abVar.a() == -9223372036854775807L) || !(abVar.a() == 0 || abVar.f32496a == j3)) {
                abVar.f32498c = -9223372036854775807L;
                abVar.a(j3);
            }
        }
        if (!(j3 == 0 || (zVar = this.o) == null)) {
            zVar.a(j3);
        }
        this.f31906h.a();
        this.f31907i.clear();
        for (int i3 = 0; i3 < this.k.size(); i3++) {
            this.k.valueAt(i3).a();
        }
        this.v = 0;
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        boolean z;
        boolean z2;
        h hVar2 = hVar;
        n nVar2 = nVar;
        long d2 = hVar.d();
        if (this.r) {
            long j2 = -9223372036854775807L;
            if (!((d2 == -1 || this.f31904f == 2) ? false : true) || this.n.f31893c) {
                if (!this.s) {
                    this.s = true;
                    if (this.n.f31898h != -9223372036854775807L) {
                        z zVar = r3;
                        z = false;
                        z zVar2 = new z(this.n.f31891a, this.n.f31898h, d2, this.w);
                        this.o = zVar;
                        this.p.a(this.o.a());
                    } else {
                        z = false;
                        this.p.a(new o.b(this.n.f31898h));
                    }
                } else {
                    z = false;
                }
                if (this.t) {
                    this.t = z;
                    a(0, 0);
                    if (hVar.c() != 0) {
                        nVar2.f32288a = 0;
                        return 1;
                    }
                }
                z zVar3 = this.o;
                if (zVar3 != null && zVar3.b()) {
                    return this.o.a(hVar2, nVar2);
                }
            } else {
                aa aaVar = this.n;
                int i2 = this.w;
                if (i2 <= 0) {
                    return aaVar.a(hVar2);
                }
                if (!aaVar.f31895e) {
                    long d3 = hVar.d();
                    int min = (int) Math.min(112800, d3);
                    long j3 = d3 - ((long) min);
                    if (hVar.c() != j3) {
                        nVar2.f32288a = j3;
                        return 1;
                    }
                    aaVar.f31892b.a(min);
                    hVar.a();
                    hVar2.c(aaVar.f31892b.f32566a, 0, min);
                    r rVar = aaVar.f31892b;
                    int i3 = rVar.f32567b;
                    int i4 = rVar.f32568c - 1;
                    while (true) {
                        if (i4 < i3) {
                            break;
                        }
                        if (rVar.f32566a[i4] == 71) {
                            long a2 = ad.a(rVar, i4, i2);
                            if (a2 != -9223372036854775807L) {
                                j2 = a2;
                                break;
                            }
                        }
                        i4--;
                    }
                    aaVar.f31897g = j2;
                    aaVar.f31895e = true;
                    return 0;
                } else if (aaVar.f31897g == -9223372036854775807L) {
                    return aaVar.a(hVar2);
                } else {
                    if (!aaVar.f31894d) {
                        int min2 = (int) Math.min(112800, hVar.d());
                        if (hVar.c() != 0) {
                            nVar2.f32288a = 0;
                            return 1;
                        }
                        aaVar.f31892b.a(min2);
                        hVar.a();
                        hVar2.c(aaVar.f31892b.f32566a, 0, min2);
                        r rVar2 = aaVar.f31892b;
                        int i5 = rVar2.f32567b;
                        int i6 = rVar2.f32568c;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            if (rVar2.f32566a[i5] == 71) {
                                long a3 = ad.a(rVar2, i5, i2);
                                if (a3 != -9223372036854775807L) {
                                    j2 = a3;
                                    break;
                                }
                            }
                            i5++;
                        }
                        aaVar.f31896f = j2;
                        aaVar.f31894d = true;
                        return 0;
                    } else if (aaVar.f31896f == -9223372036854775807L) {
                        return aaVar.a(hVar2);
                    } else {
                        aaVar.f31898h = aaVar.f31891a.b(aaVar.f31897g) - aaVar.f31891a.b(aaVar.f31896f);
                        return aaVar.a(hVar2);
                    }
                }
            }
        } else {
            z = false;
        }
        byte[] bArr = this.f31906h.f32566a;
        if (9400 - this.f31906h.f32567b < 188) {
            int b2 = this.f31906h.b();
            if (b2 > 0) {
                System.arraycopy(bArr, this.f31906h.f32567b, bArr, z, b2);
            }
            this.f31906h.a(bArr, b2);
        }
        while (true) {
            if (this.f31906h.b() >= 188) {
                z2 = true;
                break;
            }
            int i7 = this.f31906h.f32568c;
            int a4 = hVar2.a(bArr, i7, 9400 - i7);
            if (a4 == -1) {
                z2 = false;
                break;
            }
            this.f31906h.b(i7 + a4);
        }
        if (!z2) {
            return -1;
        }
        int i8 = this.f31906h.f32567b;
        int i9 = this.f31906h.f32568c;
        int a5 = ad.a(this.f31906h.f32566a, i8, i9);
        this.f31906h.c(a5);
        int i10 = a5 + 188;
        if (i10 > i9) {
            this.v += a5 - i8;
            if (this.f31904f == 2 && this.v > 376) {
                throw new v("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.v = z;
        }
        int i11 = this.f31906h.f32568c;
        if (i10 > i11) {
            return z;
        }
        int i12 = this.f31906h.i();
        if ((8388608 & i12) != 0) {
            this.f31906h.c(i10);
            return z;
        }
        boolean z3 = ((4194304 & i12) != 0) | z;
        int i13 = (2096896 & i12) >> 8;
        boolean z4 = (i12 & 32) != 0;
        ac acVar = (i12 & 16) != 0 ? this.k.get(i13) : null;
        if (acVar == null) {
            this.f31906h.c(i10);
            return z;
        }
        if (this.f31904f != 2) {
            int i14 = i12 & 15;
            int i15 = this.f31907i.get(i13, i14 - 1);
            this.f31907i.put(i13, i14);
            if (i15 == i14) {
                this.f31906h.c(i10);
                return z;
            } else if (i14 != ((i15 + 1) & 15)) {
                acVar.a();
            }
        }
        if (z4) {
            int c2 = this.f31906h.c();
            z3 |= (this.f31906h.c() & 64) != 0 ? (char) 2 : 0;
            this.f31906h.d(c2 - 1);
        }
        boolean z5 = this.r;
        if (this.f31904f == 2 || z5 || !this.m.get(i13, z)) {
            this.f31906h.b(i10);
            acVar.a(this.f31906h, z3 ? 1 : 0);
            this.f31906h.b(i11);
        }
        if (this.f31904f != 2 && !z5 && this.r && d2 != -1) {
            this.t = true;
        }
        this.f31906h.c(i10);
        return z ? 1 : 0;
    }

    private void e() {
        this.l.clear();
        this.k.clear();
        SparseArray<ac> a2 = this.j.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.k.put(0, new w(new a()));
        this.u = null;
    }

    class a implements v {

        /* renamed from: b  reason: collision with root package name */
        private final q f31909b = new q(new byte[4]);

        public final void a(com.google.android.exoplayer2.g.ab abVar, i iVar, ac.d dVar) {
        }

        public a() {
        }

        public final void a(r rVar) {
            if (rVar.c() == 0) {
                rVar.d(7);
                int b2 = rVar.b() / 4;
                for (int i2 = 0; i2 < b2; i2++) {
                    rVar.a(this.f31909b, 4);
                    int c2 = this.f31909b.c(16);
                    this.f31909b.b(3);
                    if (c2 == 0) {
                        this.f31909b.b(13);
                    } else {
                        int c3 = this.f31909b.c(13);
                        ab.this.k.put(c3, new w(new b(c3)));
                        ab.b(ab.this);
                    }
                }
                if (ab.this.f31904f != 2) {
                    ab.this.k.remove(0);
                }
            }
        }
    }

    class b implements v {

        /* renamed from: b  reason: collision with root package name */
        private final q f31911b = new q(new byte[5]);

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<ac> f31912c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        private final SparseIntArray f31913d = new SparseIntArray();

        /* renamed from: e  reason: collision with root package name */
        private final int f31914e;

        public final void a(com.google.android.exoplayer2.g.ab abVar, i iVar, ac.d dVar) {
        }

        public b(int i2) {
            this.f31914e = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:108:0x0243 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0236  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.google.android.exoplayer2.g.r r28) {
            /*
                r27 = this;
                r0 = r27
                r1 = r28
                int r2 = r28.c()
                r3 = 2
                if (r2 == r3) goto L_0x000c
                return
            L_0x000c:
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                int r2 = r2.f31904f
                r4 = 0
                r5 = 1
                if (r2 == r5) goto L_0x0044
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                int r2 = r2.f31904f
                if (r2 == r3) goto L_0x0044
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                int r2 = r2.q
                if (r2 != r5) goto L_0x0027
                goto L_0x0044
            L_0x0027:
                com.google.android.exoplayer2.g.ab r2 = new com.google.android.exoplayer2.g.ab
                com.google.android.exoplayer2.extractor.g.ab r6 = com.google.android.exoplayer2.extractor.g.ab.this
                java.util.List r6 = r6.f31905g
                java.lang.Object r6 = r6.get(r4)
                com.google.android.exoplayer2.g.ab r6 = (com.google.android.exoplayer2.g.ab) r6
                long r6 = r6.f32496a
                r2.<init>(r6)
                com.google.android.exoplayer2.extractor.g.ab r6 = com.google.android.exoplayer2.extractor.g.ab.this
                java.util.List r6 = r6.f31905g
                r6.add(r2)
                goto L_0x0050
            L_0x0044:
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                java.util.List r2 = r2.f31905g
                java.lang.Object r2 = r2.get(r4)
                com.google.android.exoplayer2.g.ab r2 = (com.google.android.exoplayer2.g.ab) r2
            L_0x0050:
                r1.d(r3)
                int r6 = r28.d()
                r7 = 3
                r1.d(r7)
                com.google.android.exoplayer2.g.q r8 = r0.f31911b
                r1.a((com.google.android.exoplayer2.g.q) r8, (int) r3)
                com.google.android.exoplayer2.g.q r8 = r0.f31911b
                r8.b(r7)
                com.google.android.exoplayer2.extractor.g.ab r8 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.g.q r9 = r0.f31911b
                r10 = 13
                int r9 = r9.c(r10)
                int unused = r8.w = r9
                com.google.android.exoplayer2.g.q r8 = r0.f31911b
                r1.a((com.google.android.exoplayer2.g.q) r8, (int) r3)
                com.google.android.exoplayer2.g.q r8 = r0.f31911b
                r9 = 4
                r8.b(r9)
                com.google.android.exoplayer2.g.q r8 = r0.f31911b
                r11 = 12
                int r8 = r8.c(r11)
                r1.d(r8)
                com.google.android.exoplayer2.extractor.g.ab r8 = com.google.android.exoplayer2.extractor.g.ab.this
                int r8 = r8.f31904f
                r12 = 8192(0x2000, float:1.14794E-41)
                r13 = 0
                r14 = 21
                if (r8 != r3) goto L_0x00c5
                com.google.android.exoplayer2.extractor.g.ab r8 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac r8 = r8.u
                if (r8 != 0) goto L_0x00c5
                com.google.android.exoplayer2.extractor.g.ac$b r8 = new com.google.android.exoplayer2.extractor.g.ac$b
                byte[] r15 = com.google.android.exoplayer2.g.ae.f32504f
                r8.<init>(r14, r13, r13, r15)
                com.google.android.exoplayer2.extractor.g.ab r15 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac$c r13 = r15.j
                com.google.android.exoplayer2.extractor.g.ac r8 = r13.a(r14, r8)
                com.google.android.exoplayer2.extractor.g.ac unused = r15.u = r8
                com.google.android.exoplayer2.extractor.g.ab r8 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac r8 = r8.u
                com.google.android.exoplayer2.extractor.g.ab r13 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.i r13 = r13.p
                com.google.android.exoplayer2.extractor.g.ac$d r15 = new com.google.android.exoplayer2.extractor.g.ac$d
                r15.<init>(r6, r14, r12)
                r8.a(r2, r13, r15)
            L_0x00c5:
                android.util.SparseArray<com.google.android.exoplayer2.extractor.g.ac> r8 = r0.f31912c
                r8.clear()
                android.util.SparseIntArray r8 = r0.f31913d
                r8.clear()
                int r8 = r28.b()
            L_0x00d3:
                if (r8 <= 0) goto L_0x0254
                com.google.android.exoplayer2.g.q r13 = r0.f31911b
                r15 = 5
                r1.a((com.google.android.exoplayer2.g.q) r13, (int) r15)
                com.google.android.exoplayer2.g.q r13 = r0.f31911b
                r5 = 8
                int r5 = r13.c(r5)
                com.google.android.exoplayer2.g.q r13 = r0.f31911b
                r13.b(r7)
                com.google.android.exoplayer2.g.q r13 = r0.f31911b
                int r13 = r13.c(r10)
                com.google.android.exoplayer2.g.q r10 = r0.f31911b
                r10.b(r9)
                com.google.android.exoplayer2.g.q r10 = r0.f31911b
                int r10 = r10.c(r11)
                int r11 = r1.f32567b
                int r12 = r11 + r10
                r16 = -1
                r3 = -1
                r17 = 0
                r18 = 0
            L_0x0104:
                int r4 = r1.f32567b
                if (r4 >= r12) goto L_0x01cf
                int r4 = r28.c()
                int r19 = r28.c()
                int r9 = r1.f32567b
                int r9 = r9 + r19
                r7 = 89
                r20 = 172(0xac, float:2.41E-43)
                r21 = 135(0x87, float:1.89E-43)
                r22 = 129(0x81, float:1.81E-43)
                if (r4 != r15) goto L_0x014c
                long r23 = r28.g()
                long r25 = com.google.android.exoplayer2.extractor.g.ab.f31900b
                int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
                if (r4 != 0) goto L_0x012b
                goto L_0x0150
            L_0x012b:
                long r25 = com.google.android.exoplayer2.extractor.g.ab.f31901c
                int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
                if (r4 != 0) goto L_0x0134
                goto L_0x015b
            L_0x0134:
                long r21 = com.google.android.exoplayer2.extractor.g.ab.f31902d
                int r4 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
                if (r4 != 0) goto L_0x0141
                r21 = r2
                r3 = 172(0xac, float:2.41E-43)
                goto L_0x0154
            L_0x0141:
                long r20 = com.google.android.exoplayer2.extractor.g.ab.f31903e
                int r4 = (r23 > r20 ? 1 : (r23 == r20 ? 0 : -1))
                if (r4 != 0) goto L_0x0173
                r3 = 36
                goto L_0x0173
            L_0x014c:
                r15 = 106(0x6a, float:1.49E-43)
                if (r4 != r15) goto L_0x0157
            L_0x0150:
                r21 = r2
                r3 = 129(0x81, float:1.81E-43)
            L_0x0154:
                r15 = 4
                goto L_0x01c0
            L_0x0157:
                r15 = 122(0x7a, float:1.71E-43)
                if (r4 != r15) goto L_0x0160
            L_0x015b:
                r21 = r2
                r3 = 135(0x87, float:1.89E-43)
                goto L_0x0154
            L_0x0160:
                r15 = 127(0x7f, float:1.78E-43)
                if (r4 != r15) goto L_0x016d
                int r4 = r28.c()
                if (r4 != r14) goto L_0x0173
                r3 = 172(0xac, float:2.41E-43)
                goto L_0x0173
            L_0x016d:
                r15 = 123(0x7b, float:1.72E-43)
                if (r4 != r15) goto L_0x0176
                r3 = 138(0x8a, float:1.93E-43)
            L_0x0173:
                r21 = r2
                goto L_0x0154
            L_0x0176:
                r15 = 10
                if (r4 != r15) goto L_0x0188
                r15 = 3
                java.lang.String r4 = r1.e(r15)
                java.lang.String r4 = r4.trim()
                r21 = r2
                r17 = r4
                goto L_0x0154
            L_0x0188:
                r15 = 3
                if (r4 != r7) goto L_0x0173
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
            L_0x0190:
                int r4 = r1.f32567b
                if (r4 >= r9) goto L_0x01b9
                java.lang.String r4 = r1.e(r15)
                java.lang.String r4 = r4.trim()
                int r7 = r28.c()
                r15 = 4
                byte[] r14 = new byte[r15]
                r21 = r2
                r2 = 0
                r1.a(r14, r2, r15)
                com.google.android.exoplayer2.extractor.g.ac$a r2 = new com.google.android.exoplayer2.extractor.g.ac$a
                r2.<init>(r4, r7, r14)
                r3.add(r2)
                r2 = r21
                r7 = 89
                r14 = 21
                r15 = 3
                goto L_0x0190
            L_0x01b9:
                r21 = r2
                r15 = 4
                r18 = r3
                r3 = 89
            L_0x01c0:
                int r2 = r1.f32567b
                int r9 = r9 - r2
                r1.d(r9)
                r2 = r21
                r7 = 3
                r9 = 4
                r14 = 21
                r15 = 5
                goto L_0x0104
            L_0x01cf:
                r21 = r2
                r15 = 4
                r1.c(r12)
                com.google.android.exoplayer2.extractor.g.ac$b r2 = new com.google.android.exoplayer2.extractor.g.ac$b
                byte[] r4 = r1.f32566a
                byte[] r4 = java.util.Arrays.copyOfRange(r4, r11, r12)
                r7 = r17
                r9 = r18
                r2.<init>(r3, r7, r9, r4)
                r3 = 6
                if (r5 != r3) goto L_0x01e9
                int r5 = r2.f31918a
            L_0x01e9:
                int r10 = r10 + 5
                int r8 = r8 - r10
                com.google.android.exoplayer2.extractor.g.ab r3 = com.google.android.exoplayer2.extractor.g.ab.this
                int r3 = r3.f31904f
                r4 = 2
                if (r3 != r4) goto L_0x01f7
                r3 = r5
                goto L_0x01f8
            L_0x01f7:
                r3 = r13
            L_0x01f8:
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                android.util.SparseBooleanArray r7 = r7.l
                boolean r7 = r7.get(r3)
                if (r7 != 0) goto L_0x0241
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                int r7 = r7.f31904f
                if (r7 != r4) goto L_0x0217
                r4 = 21
                if (r5 != r4) goto L_0x0219
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac r2 = r2.u
                goto L_0x0223
            L_0x0217:
                r4 = 21
            L_0x0219:
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac$c r7 = r7.j
                com.google.android.exoplayer2.extractor.g.ac r2 = r7.a(r5, r2)
            L_0x0223:
                com.google.android.exoplayer2.extractor.g.ab r5 = com.google.android.exoplayer2.extractor.g.ab.this
                int r5 = r5.f31904f
                r7 = 2
                if (r5 != r7) goto L_0x0236
                android.util.SparseIntArray r5 = r0.f31913d
                r7 = 8192(0x2000, float:1.14794E-41)
                int r5 = r5.get(r3, r7)
                if (r13 >= r5) goto L_0x0243
            L_0x0236:
                android.util.SparseIntArray r5 = r0.f31913d
                r5.put(r3, r13)
                android.util.SparseArray<com.google.android.exoplayer2.extractor.g.ac> r5 = r0.f31912c
                r5.put(r3, r2)
                goto L_0x0243
            L_0x0241:
                r4 = 21
            L_0x0243:
                r2 = r21
                r3 = 2
                r4 = 0
                r5 = 1
                r7 = 3
                r9 = 4
                r10 = 13
                r11 = 12
                r12 = 8192(0x2000, float:1.14794E-41)
                r14 = 21
                goto L_0x00d3
            L_0x0254:
                r21 = r2
                android.util.SparseIntArray r1 = r0.f31913d
                int r1 = r1.size()
                r2 = 0
            L_0x025d:
                if (r2 >= r1) goto L_0x02ba
                android.util.SparseIntArray r3 = r0.f31913d
                int r3 = r3.keyAt(r2)
                android.util.SparseIntArray r4 = r0.f31913d
                int r4 = r4.valueAt(r2)
                com.google.android.exoplayer2.extractor.g.ab r5 = com.google.android.exoplayer2.extractor.g.ab.this
                android.util.SparseBooleanArray r5 = r5.l
                r7 = 1
                r5.put(r3, r7)
                com.google.android.exoplayer2.extractor.g.ab r5 = com.google.android.exoplayer2.extractor.g.ab.this
                android.util.SparseBooleanArray r5 = r5.m
                r5.put(r4, r7)
                android.util.SparseArray<com.google.android.exoplayer2.extractor.g.ac> r5 = r0.f31912c
                java.lang.Object r5 = r5.valueAt(r2)
                com.google.android.exoplayer2.extractor.g.ac r5 = (com.google.android.exoplayer2.extractor.g.ac) r5
                if (r5 == 0) goto L_0x02b1
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.g.ac r7 = r7.u
                if (r5 == r7) goto L_0x02a3
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.i r7 = r7.p
                com.google.android.exoplayer2.extractor.g.ac$d r8 = new com.google.android.exoplayer2.extractor.g.ac$d
                r9 = 8192(0x2000, float:1.14794E-41)
                r8.<init>(r6, r3, r9)
                r3 = r21
                r5.a(r3, r7, r8)
                goto L_0x02a7
            L_0x02a3:
                r3 = r21
                r9 = 8192(0x2000, float:1.14794E-41)
            L_0x02a7:
                com.google.android.exoplayer2.extractor.g.ab r7 = com.google.android.exoplayer2.extractor.g.ab.this
                android.util.SparseArray r7 = r7.k
                r7.put(r4, r5)
                goto L_0x02b5
            L_0x02b1:
                r3 = r21
                r9 = 8192(0x2000, float:1.14794E-41)
            L_0x02b5:
                int r2 = r2 + 1
                r21 = r3
                goto L_0x025d
            L_0x02ba:
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                int r1 = r1.f31904f
                r2 = 2
                if (r1 != r2) goto L_0x02e0
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                boolean r1 = r1.r
                if (r1 != 0) goto L_0x0318
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.i r1 = r1.p
                r1.a()
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                r2 = 0
                int unused = r1.q = r2
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                boolean unused = r1.r = true
                return
            L_0x02e0:
                r2 = 0
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                android.util.SparseArray r1 = r1.k
                int r3 = r0.f31914e
                r1.remove(r3)
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                int r3 = r1.f31904f
                r4 = 1
                if (r3 != r4) goto L_0x02f6
                goto L_0x02ff
            L_0x02f6:
                com.google.android.exoplayer2.extractor.g.ab r2 = com.google.android.exoplayer2.extractor.g.ab.this
                int r2 = r2.q
                int r4 = r2 + -1
                r2 = r4
            L_0x02ff:
                int unused = r1.q = r2
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                int r1 = r1.q
                if (r1 != 0) goto L_0x0318
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                com.google.android.exoplayer2.extractor.i r1 = r1.p
                r1.a()
                com.google.android.exoplayer2.extractor.g.ab r1 = com.google.android.exoplayer2.extractor.g.ab.this
                boolean unused = r1.r = true
            L_0x0318:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.ab.b.a(com.google.android.exoplayer2.g.r):void");
        }
    }
}
