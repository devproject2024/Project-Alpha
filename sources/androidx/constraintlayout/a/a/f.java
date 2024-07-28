package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.a.b;
import androidx.constraintlayout.a.a.a.c;
import androidx.constraintlayout.a.a.a.j;
import androidx.constraintlayout.a.a.a.p;
import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.d;
import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class f extends m {
    static int bg;

    /* renamed from: a  reason: collision with root package name */
    b f2103a = new b(this);
    public e aL;
    protected d aM = new d();
    int aN;
    int aO;
    int aP;
    int aQ;
    public int aR = 0;
    public int aS = 0;
    c[] aT = new c[4];
    c[] aU = new c[4];
    public boolean aV = false;
    public boolean aW = false;
    public boolean aX = false;
    public int aY = 0;
    public int aZ = 0;

    /* renamed from: b  reason: collision with root package name */
    public androidx.constraintlayout.a.a.a.e f2104b = new androidx.constraintlayout.a.a.a.e(this);
    public int ba = 257;
    public boolean bb = false;
    public boolean bc = false;
    public boolean bd = false;
    int be = 0;
    public b.a bf = new b.a();
    private WeakReference<d> bi = null;
    private WeakReference<d> bj = null;
    private WeakReference<d> bk = null;
    private WeakReference<d> bl = null;

    /* renamed from: c  reason: collision with root package name */
    protected b.C0030b f2105c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2106d = false;

    public final void d() {
        this.f2104b.f2019b = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0159 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(boolean r11, int r12) {
        /*
            r10 = this;
            androidx.constraintlayout.a.a.a.e r0 = r10.f2104b
            r1 = 1
            r11 = r11 & r1
            androidx.constraintlayout.a.a.f r2 = r0.f2018a
            r3 = 0
            androidx.constraintlayout.a.a.e$a r2 = r2.l(r3)
            androidx.constraintlayout.a.a.f r4 = r0.f2018a
            androidx.constraintlayout.a.a.e$a r4 = r4.l(r1)
            androidx.constraintlayout.a.a.f r5 = r0.f2018a
            int r5 = r5.l()
            androidx.constraintlayout.a.a.f r6 = r0.f2018a
            int r6 = r6.m()
            if (r11 == 0) goto L_0x0097
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r2 == r7) goto L_0x0027
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r4 != r7) goto L_0x0097
        L_0x0027:
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r7 = r0.f2022e
            java.util.Iterator r7 = r7.iterator()
        L_0x002d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0044
            java.lang.Object r8 = r7.next()
            androidx.constraintlayout.a.a.a.p r8 = (androidx.constraintlayout.a.a.a.p) r8
            int r9 = r8.f2070h
            if (r9 != r12) goto L_0x002d
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x002d
            r11 = 0
        L_0x0044:
            if (r12 != 0) goto L_0x006f
            if (r11 == 0) goto L_0x0097
            androidx.constraintlayout.a.a.e$a r11 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r2 != r11) goto L_0x0097
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.FIXED
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11[r3] = r7
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.f r7 = r0.f2018a
            int r7 = r0.a(r7, r3)
            r11.g(r7)
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.a.l r11 = r11.f2100i
            androidx.constraintlayout.a.a.a.g r11 = r11.f2069g
            androidx.constraintlayout.a.a.f r7 = r0.f2018a
            int r7 = r7.n()
            r11.a(r7)
            goto L_0x0097
        L_0x006f:
            if (r11 == 0) goto L_0x0097
            androidx.constraintlayout.a.a.e$a r11 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r4 != r11) goto L_0x0097
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.FIXED
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11[r1] = r7
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.f r7 = r0.f2018a
            int r7 = r0.a(r7, r1)
            r11.h(r7)
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.a.n r11 = r11.j
            androidx.constraintlayout.a.a.a.g r11 = r11.f2069g
            androidx.constraintlayout.a.a.f r7 = r0.f2018a
            int r7 = r7.o()
            r11.a(r7)
        L_0x0097:
            if (r12 != 0) goto L_0x00c8
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11 = r11[r3]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.FIXED
            if (r11 == r6) goto L_0x00ad
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11 = r11[r3]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT
            if (r11 != r6) goto L_0x00dd
        L_0x00ad:
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            int r11 = r11.n()
            int r11 = r11 + r5
            androidx.constraintlayout.a.a.f r6 = r0.f2018a
            androidx.constraintlayout.a.a.a.l r6 = r6.f2100i
            androidx.constraintlayout.a.a.a.f r6 = r6.k
            r6.a((int) r11)
            androidx.constraintlayout.a.a.f r6 = r0.f2018a
            androidx.constraintlayout.a.a.a.l r6 = r6.f2100i
            androidx.constraintlayout.a.a.a.g r6 = r6.f2069g
            int r11 = r11 - r5
            r6.a(r11)
            goto L_0x00f9
        L_0x00c8:
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11 = r11[r1]
            androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.FIXED
            if (r11 == r5) goto L_0x00df
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r11 = r11.U
            r11 = r11[r1]
            androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT
            if (r11 != r5) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r11 = 0
            goto L_0x00fa
        L_0x00df:
            androidx.constraintlayout.a.a.f r11 = r0.f2018a
            int r11 = r11.o()
            int r11 = r11 + r6
            androidx.constraintlayout.a.a.f r5 = r0.f2018a
            androidx.constraintlayout.a.a.a.n r5 = r5.j
            androidx.constraintlayout.a.a.a.f r5 = r5.k
            r5.a((int) r11)
            androidx.constraintlayout.a.a.f r5 = r0.f2018a
            androidx.constraintlayout.a.a.a.n r5 = r5.j
            androidx.constraintlayout.a.a.a.g r5 = r5.f2069g
            int r11 = r11 - r6
            r5.a(r11)
        L_0x00f9:
            r11 = 1
        L_0x00fa:
            r0.a()
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r5 = r0.f2022e
            java.util.Iterator r5 = r5.iterator()
        L_0x0103:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0121
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.a.a.a.p r6 = (androidx.constraintlayout.a.a.a.p) r6
            int r7 = r6.f2070h
            if (r7 != r12) goto L_0x0103
            androidx.constraintlayout.a.a.e r7 = r6.f2066d
            androidx.constraintlayout.a.a.f r8 = r0.f2018a
            if (r7 != r8) goto L_0x011d
            boolean r7 = r6.f2071i
            if (r7 == 0) goto L_0x0103
        L_0x011d:
            r6.e()
            goto L_0x0103
        L_0x0121:
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r5 = r0.f2022e
            java.util.Iterator r5 = r5.iterator()
        L_0x0127:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0159
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.a.a.a.p r6 = (androidx.constraintlayout.a.a.a.p) r6
            int r7 = r6.f2070h
            if (r7 != r12) goto L_0x0127
            if (r11 != 0) goto L_0x013f
            androidx.constraintlayout.a.a.e r7 = r6.f2066d
            androidx.constraintlayout.a.a.f r8 = r0.f2018a
            if (r7 == r8) goto L_0x0127
        L_0x013f:
            androidx.constraintlayout.a.a.a.f r7 = r6.j
            boolean r7 = r7.j
            if (r7 != 0) goto L_0x0147
        L_0x0145:
            r11 = 0
            goto L_0x015a
        L_0x0147:
            androidx.constraintlayout.a.a.a.f r7 = r6.k
            boolean r7 = r7.j
            if (r7 != 0) goto L_0x014e
            goto L_0x0145
        L_0x014e:
            boolean r7 = r6 instanceof androidx.constraintlayout.a.a.a.c
            if (r7 != 0) goto L_0x0127
            androidx.constraintlayout.a.a.a.g r6 = r6.f2069g
            boolean r6 = r6.j
            if (r6 != 0) goto L_0x0127
            goto L_0x0145
        L_0x0159:
            r11 = 1
        L_0x015a:
            androidx.constraintlayout.a.a.f r12 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r12 = r12.U
            r12[r3] = r2
            androidx.constraintlayout.a.a.f r12 = r0.f2018a
            androidx.constraintlayout.a.a.e$a[] r12 = r12.U
            r12[r1] = r4
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.a(boolean, int):boolean");
    }

    public final long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        b.C0030b bVar;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        boolean z4;
        int i13;
        b.C0030b bVar2;
        int i14;
        int i15;
        int i16;
        b.C0030b bVar3;
        boolean z5;
        int i17;
        int i18;
        boolean z6;
        int i19;
        int i20;
        boolean z7;
        boolean z8;
        int i21 = i2;
        int i22 = i3;
        int i23 = i5;
        this.aN = i7;
        this.aO = i8;
        b bVar4 = this.f2103a;
        b.C0030b bVar5 = this.f2105c;
        int size = this.bh.size();
        int n = n();
        int o = o();
        boolean a2 = k.a(i21, 128);
        char c2 = 1;
        char c3 = 0;
        boolean z9 = a2 || k.a(i21, 64);
        if (z9) {
            int i24 = 0;
            while (true) {
                if (i24 >= size) {
                    break;
                }
                e eVar = (e) this.bh.get(i24);
                boolean z10 = (eVar.U[c3] == e.a.MATCH_CONSTRAINT) && (eVar.U[c2] == e.a.MATCH_CONSTRAINT) && eVar.Y > 0.0f;
                if ((!eVar.v() || !z10) && ((!eVar.w() || !z10) && !(eVar instanceof l) && !eVar.v() && !eVar.w())) {
                    i24++;
                    c2 = 1;
                    c3 = 0;
                }
            }
            z9 = false;
        }
        if (z9 && d.o != null) {
            d.o.f2150c++;
        }
        boolean z11 = z9 & ((i22 == 1073741824 && i23 == 1073741824) || a2);
        if (z11) {
            int min = Math.min(this.C[0], i4);
            int min2 = Math.min(this.C[1], i6);
            if (i22 == 1073741824 && n() != min) {
                g(min);
                d();
            }
            if (i23 == 1073741824 && o() != min2) {
                h(min2);
                d();
            }
            if (i22 == 1073741824 && i23 == 1073741824) {
                androidx.constraintlayout.a.a.a.e eVar2 = this.f2104b;
                boolean z12 = a2 & true;
                if (eVar2.f2019b || eVar2.f2020c) {
                    Iterator it2 = eVar2.f2018a.bh.iterator();
                    while (it2.hasNext()) {
                        e eVar3 = (e) it2.next();
                        eVar3.k();
                        eVar3.f2096e = false;
                        eVar3.f2100i.g();
                        eVar3.j.g();
                    }
                    i20 = 0;
                    eVar2.f2018a.k();
                    eVar2.f2018a.f2096e = false;
                    eVar2.f2018a.f2100i.g();
                    eVar2.f2018a.j.g();
                    eVar2.f2020c = false;
                } else {
                    i20 = 0;
                }
                eVar2.a(eVar2.f2021d);
                eVar2.f2018a.e(i20);
                eVar2.f2018a.f(i20);
                e.a l = eVar2.f2018a.l(i20);
                e.a l2 = eVar2.f2018a.l(1);
                if (eVar2.f2019b) {
                    eVar2.b();
                }
                int l3 = eVar2.f2018a.l();
                int m = eVar2.f2018a.m();
                eVar2.f2018a.f2100i.j.a(l3);
                eVar2.f2018a.j.j.a(m);
                eVar2.a();
                if (l == e.a.WRAP_CONTENT || l2 == e.a.WRAP_CONTENT) {
                    if (z12) {
                        Iterator<p> it3 = eVar2.f2022e.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (!it3.next().a()) {
                                    z12 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (!z12 || l != e.a.WRAP_CONTENT) {
                        z = z11;
                        bVar = bVar5;
                    } else {
                        z = z11;
                        eVar2.f2018a.U[0] = e.a.FIXED;
                        bVar = bVar5;
                        eVar2.f2018a.g(eVar2.a(eVar2.f2018a, 0));
                        eVar2.f2018a.f2100i.f2069g.a(eVar2.f2018a.n());
                    }
                    if (z12 && l2 == e.a.WRAP_CONTENT) {
                        eVar2.f2018a.U[1] = e.a.FIXED;
                        eVar2.f2018a.h(eVar2.a(eVar2.f2018a, 1));
                        eVar2.f2018a.j.f2069g.a(eVar2.f2018a.o());
                    }
                } else {
                    z = z11;
                    bVar = bVar5;
                }
                if (eVar2.f2018a.U[0] == e.a.FIXED || eVar2.f2018a.U[0] == e.a.MATCH_PARENT) {
                    int n2 = eVar2.f2018a.n() + l3;
                    eVar2.f2018a.f2100i.k.a(n2);
                    eVar2.f2018a.f2100i.f2069g.a(n2 - l3);
                    eVar2.a();
                    if (eVar2.f2018a.U[1] == e.a.FIXED || eVar2.f2018a.U[1] == e.a.MATCH_PARENT) {
                        int o2 = eVar2.f2018a.o() + m;
                        eVar2.f2018a.j.k.a(o2);
                        eVar2.f2018a.j.f2069g.a(o2 - m);
                    }
                    eVar2.a();
                    z7 = true;
                } else {
                    z7 = false;
                }
                Iterator<p> it4 = eVar2.f2022e.iterator();
                while (it4.hasNext()) {
                    p next = it4.next();
                    if (next.f2066d != eVar2.f2018a || next.f2071i) {
                        next.e();
                    }
                }
                Iterator<p> it5 = eVar2.f2022e.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        z8 = true;
                        break;
                    }
                    p next2 = it5.next();
                    if ((z7 || next2.f2066d != eVar2.f2018a) && (!next2.j.j || ((!next2.k.j && !(next2 instanceof j)) || (!next2.f2069g.j && !(next2 instanceof c) && !(next2 instanceof j))))) {
                        z8 = false;
                    }
                }
                z8 = false;
                eVar2.f2018a.U[0] = l;
                eVar2.f2018a.U[1] = l2;
                z2 = z8;
                i17 = 1073741824;
                i9 = 2;
            } else {
                z = z11;
                bVar = bVar5;
                androidx.constraintlayout.a.a.a.e eVar4 = this.f2104b;
                if (eVar4.f2019b) {
                    Iterator it6 = eVar4.f2018a.bh.iterator();
                    while (it6.hasNext()) {
                        e eVar5 = (e) it6.next();
                        eVar5.k();
                        eVar5.f2096e = false;
                        eVar5.f2100i.f2069g.j = false;
                        eVar5.f2100i.f2071i = false;
                        eVar5.f2100i.g();
                        eVar5.j.f2069g.j = false;
                        eVar5.j.f2071i = false;
                        eVar5.j.g();
                    }
                    i18 = 0;
                    eVar4.f2018a.k();
                    eVar4.f2018a.f2096e = false;
                    eVar4.f2018a.f2100i.f2069g.j = false;
                    eVar4.f2018a.f2100i.f2071i = false;
                    eVar4.f2018a.f2100i.g();
                    eVar4.f2018a.j.f2069g.j = false;
                    eVar4.f2018a.j.f2071i = false;
                    eVar4.f2018a.j.g();
                    eVar4.b();
                } else {
                    i18 = 0;
                }
                eVar4.a(eVar4.f2021d);
                eVar4.f2018a.e(i18);
                eVar4.f2018a.f(i18);
                eVar4.f2018a.f2100i.j.a(i18);
                eVar4.f2018a.j.j.a(i18);
                i17 = 1073741824;
                if (i22 == 1073741824) {
                    i19 = 1;
                    z6 = a(a2, i18) & true;
                    i9 = 1;
                } else {
                    i19 = 1;
                    i9 = 0;
                    z6 = true;
                }
                if (i23 == 1073741824) {
                    i9++;
                    z2 = a(a2, i19) & z6;
                } else {
                    z2 = z6;
                }
            }
            if (z2) {
                a(i22 == i17, i23 == i17);
            }
        } else {
            z = z11;
            bVar = bVar5;
            i9 = 0;
            z2 = false;
        }
        if (z2 && i9 == 2) {
            return 0;
        }
        int i25 = this.ba;
        if (size > 0) {
            int size2 = this.bh.size();
            boolean p = p(64);
            b.C0030b bVar6 = this.f2105c;
            for (int i26 = 0; i26 < size2; i26++) {
                e eVar6 = (e) this.bh.get(i26);
                if (!(eVar6 instanceof h) && !(eVar6 instanceof a) && !eVar6.G && (!p || eVar6.f2100i == null || eVar6.j == null || !eVar6.f2100i.f2069g.j || !eVar6.j.f2069g.j)) {
                    e.a l4 = eVar6.l(0);
                    e.a l5 = eVar6.l(1);
                    boolean z13 = l4 == e.a.MATCH_CONSTRAINT && eVar6.p != 1 && l5 == e.a.MATCH_CONSTRAINT && eVar6.q != 1;
                    if (z13 || !p(1) || (eVar6 instanceof l)) {
                        z5 = z13;
                    } else {
                        if (l4 == e.a.MATCH_CONSTRAINT && eVar6.p == 0 && l5 != e.a.MATCH_CONSTRAINT && !eVar6.v()) {
                            z13 = true;
                        }
                        z5 = (l5 != e.a.MATCH_CONSTRAINT || eVar6.q != 0 || l4 == e.a.MATCH_CONSTRAINT || eVar6.v()) ? z13 : true;
                        if (l4 == e.a.MATCH_CONSTRAINT || l5 == e.a.MATCH_CONSTRAINT) {
                            if (eVar6.Y > 0.0f) {
                                z5 = true;
                            }
                        }
                    }
                    if (!z5) {
                        bVar4.a(bVar6, eVar6, b.a.f2007a);
                        androidx.constraintlayout.a.e eVar7 = this.aL;
                        if (eVar7 != null) {
                            eVar7.f2148a++;
                        }
                    }
                }
            }
            bVar6.a();
        }
        bVar4.a(this);
        int size3 = bVar4.f2004a.size();
        if (size > 0) {
            bVar4.a(this, n, o);
        }
        if (size3 > 0) {
            boolean z14 = this.U[0] == e.a.WRAP_CONTENT;
            boolean z15 = this.U[1] == e.a.WRAP_CONTENT;
            int max = Math.max(n(), bVar4.f2005b.p());
            int max2 = Math.max(o(), bVar4.f2005b.q());
            boolean z16 = false;
            int i27 = max;
            int i28 = 0;
            while (i28 < size3) {
                e eVar8 = bVar4.f2004a.get(i28);
                if (eVar8 instanceof l) {
                    int n3 = eVar8.n();
                    int o3 = eVar8.o();
                    i16 = i25;
                    bVar3 = bVar;
                    boolean a3 = bVar4.a(bVar3, eVar8, b.a.f2008b) | z16;
                    androidx.constraintlayout.a.e eVar9 = this.aL;
                    i14 = n;
                    i15 = o;
                    if (eVar9 != null) {
                        eVar9.f2149b++;
                    }
                    int n4 = eVar8.n();
                    int o4 = eVar8.o();
                    if (n4 != n3) {
                        eVar8.g(n4);
                        if (z14 && eVar8.r() > i27) {
                            i27 = Math.max(i27, eVar8.r() + eVar8.a(d.a.RIGHT).e());
                        }
                        a3 = true;
                    }
                    if (o4 != o3) {
                        eVar8.h(o4);
                        if (z15 && eVar8.s() > max2) {
                            max2 = Math.max(max2, eVar8.s() + eVar8.a(d.a.BOTTOM).e());
                        }
                        a3 = true;
                    }
                    z16 = a3 | ((l) eVar8).bi;
                } else {
                    i16 = i25;
                    i14 = n;
                    bVar3 = bVar;
                    i15 = o;
                }
                i28++;
                n = i14;
                o = i15;
                bVar = bVar3;
                i25 = i16;
            }
            int i29 = i25;
            int i30 = n;
            b.C0030b bVar7 = bVar;
            int i31 = o;
            int i32 = 0;
            int i33 = 2;
            while (true) {
                if (i32 >= i33) {
                    i10 = i30;
                    i11 = i31;
                    i12 = max2;
                    z3 = z16;
                    break;
                }
                i12 = max2;
                z3 = z16;
                int i34 = 0;
                while (i34 < size3) {
                    e eVar10 = bVar4.f2004a.get(i34);
                    if ((!(eVar10 instanceof i) || (eVar10 instanceof l)) && !(eVar10 instanceof h) && eVar10.an != 8 && ((!z || !eVar10.f2100i.f2069g.j || !eVar10.j.f2069g.j) && !(eVar10 instanceof l))) {
                        int n5 = eVar10.n();
                        int o5 = eVar10.o();
                        int i35 = eVar10.ag;
                        int i36 = b.a.f2008b;
                        if (i32 == 1) {
                            i36 = b.a.f2009c;
                        }
                        z3 |= bVar4.a(bVar7, eVar10, i36);
                        androidx.constraintlayout.a.e eVar11 = this.aL;
                        bVar2 = bVar7;
                        i13 = size3;
                        if (eVar11 != null) {
                            eVar11.f2149b++;
                        }
                        int n6 = eVar10.n();
                        int o6 = eVar10.o();
                        if (n6 != n5) {
                            eVar10.g(n6);
                            if (z14 && eVar10.r() > i27) {
                                i27 = Math.max(i27, eVar10.r() + eVar10.a(d.a.RIGHT).e());
                            }
                            z3 = true;
                        }
                        if (o6 != o5) {
                            eVar10.h(o6);
                            if (z15 && eVar10.s() > i12) {
                                i12 = Math.max(i12, eVar10.s() + eVar10.a(d.a.BOTTOM).e());
                            }
                            z3 = true;
                        }
                        if (eVar10.E && i35 != eVar10.ag) {
                            z3 = true;
                        }
                    } else {
                        bVar2 = bVar7;
                        i13 = size3;
                    }
                    i34++;
                    size3 = i13;
                    bVar7 = bVar2;
                }
                b.C0030b bVar8 = bVar7;
                int i37 = size3;
                i10 = i30;
                i11 = i31;
                if (!z3) {
                    break;
                }
                bVar4.a(this, i10, i11);
                i32++;
                max2 = i12;
                bVar7 = bVar8;
                i33 = 2;
                z16 = false;
                size3 = i37;
            }
            if (z3) {
                bVar4.a(this, i10, i11);
                if (n() < i27) {
                    g(i27);
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (o() < i12) {
                    h(i12);
                    z4 = true;
                }
                if (z4) {
                    bVar4.a(this, i10, i11);
                }
            }
            i25 = i29;
        }
        o(i25);
        return 0;
    }

    public final void e() {
        this.f2103a.a(this);
    }

    public final void a(b.C0030b bVar) {
        this.f2105c = bVar;
        this.f2104b.f2023f = bVar;
    }

    public final b.C0030b y() {
        return this.f2105c;
    }

    public final void o(int i2) {
        this.ba = i2;
        androidx.constraintlayout.a.d.f2138a = p(512);
    }

    public final boolean p(int i2) {
        return (this.ba & i2) == i2;
    }

    public final void j() {
        this.aM.b();
        this.aN = 0;
        this.aP = 0;
        this.aO = 0;
        this.aQ = 0;
        this.bb = false;
        super.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar) {
        WeakReference<d> weakReference = this.bi;
        if (weakReference == null || weakReference.get() == null || dVar.c() > ((d) this.bi.get()).c()) {
            this.bi = new WeakReference<>(dVar);
        }
    }

    public final void b(d dVar) {
        WeakReference<d> weakReference = this.bj;
        if (weakReference == null || weakReference.get() == null || dVar.c() > ((d) this.bj.get()).c()) {
            this.bj = new WeakReference<>(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(d dVar) {
        WeakReference<d> weakReference = this.bk;
        if (weakReference == null || weakReference.get() == null || dVar.c() > ((d) this.bk.get()).c()) {
            this.bk = new WeakReference<>(dVar);
        }
    }

    public final void d(d dVar) {
        WeakReference<d> weakReference = this.bl;
        if (weakReference == null || weakReference.get() == null || dVar.c() > ((d) this.bl.get()).c()) {
            this.bl = new WeakReference<>(dVar);
        }
    }

    private void a(d dVar, h hVar) {
        this.aM.a(this.aM.a((Object) dVar), hVar, 0, 5);
    }

    private void b(d dVar, h hVar) {
        this.aM.a(hVar, this.aM.a((Object) dVar), 0, 5);
    }

    private boolean b(androidx.constraintlayout.a.d dVar) {
        boolean p = p(64);
        a(dVar, p);
        int size = this.bh.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = (e) this.bh.get(i2);
            eVar.T[0] = false;
            eVar.T[1] = false;
            if (eVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = (e) this.bh.get(i3);
                if (eVar2 instanceof a) {
                    a aVar = (a) eVar2;
                    for (int i4 = 0; i4 < aVar.bb; i4++) {
                        e eVar3 = aVar.ba[i4];
                        if (aVar.f2000a == 0 || aVar.f2000a == 1) {
                            eVar3.T[0] = true;
                        } else if (aVar.f2000a == 2 || aVar.f2000a == 3) {
                            eVar3.T[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            e eVar4 = (e) this.bh.get(i5);
            if (eVar4.x()) {
                eVar4.a(dVar, p);
            }
        }
        if (androidx.constraintlayout.a.d.f2138a) {
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                e eVar5 = (e) this.bh.get(i6);
                if (!eVar5.x()) {
                    hashSet.add(eVar5);
                }
            }
            a(this, dVar, (HashSet<e>) hashSet, this.U[0] == e.a.WRAP_CONTENT ? 0 : 1, false);
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                e eVar6 = (e) it2.next();
                k.a(this, dVar, eVar6);
                eVar6.a(dVar, p);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar7 = (e) this.bh.get(i7);
                if (eVar7 instanceof f) {
                    e.a aVar2 = eVar7.U[0];
                    e.a aVar3 = eVar7.U[1];
                    if (aVar2 == e.a.WRAP_CONTENT) {
                        eVar7.U[0] = e.a.FIXED;
                    }
                    if (aVar3 == e.a.WRAP_CONTENT) {
                        eVar7.U[1] = e.a.FIXED;
                    }
                    eVar7.a(dVar, p);
                    if (aVar2 == e.a.WRAP_CONTENT) {
                        eVar7.U[0] = aVar2;
                    }
                    if (aVar3 == e.a.WRAP_CONTENT) {
                        eVar7.U[1] = aVar3;
                    }
                } else {
                    k.a(this, dVar, eVar7);
                    if (!eVar7.x()) {
                        eVar7.a(dVar, p);
                    }
                }
            }
        }
        if (this.aR > 0) {
            b.a(this, dVar, (ArrayList<e>) null, 0);
        }
        if (this.aS > 0) {
            b.a(this, dVar, (ArrayList<e>) null, 1);
        }
        return true;
    }

    private void a(boolean[] zArr) {
        zArr[2] = false;
        boolean p = p(64);
        a(p);
        int size = this.bh.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((e) this.bh.get(i2)).a(p);
        }
    }

    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        int size = this.bh.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((e) this.bh.get(i2)).a(z, z2);
        }
    }

    /* JADX WARNING: type inference failed for: r12v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04b9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04d3  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04de  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x05cc  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0657  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0668  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0684  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0691  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0694  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x06da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r1.aa = r2
            r1.ab = r2
            r1.bc = r2
            r1.bd = r2
            java.util.ArrayList r0 = r1.bh
            int r3 = r0.size()
            int r0 = r24.n()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r24.o()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.a.a.e$a[] r5 = r1.U
            r6 = 1
            r5 = r5[r6]
            androidx.constraintlayout.a.a.e$a[] r7 = r1.U
            r7 = r7[r2]
            androidx.constraintlayout.a.e r8 = r1.aL
            r9 = 1
            if (r8 == 0) goto L_0x0035
            long r11 = r8.D
            long r11 = r11 + r9
            r8.D = r11
        L_0x0035:
            int r8 = r1.ba
            boolean r8 = androidx.constraintlayout.a.a.k.a(r8, r6)
            if (r8 == 0) goto L_0x008f
            androidx.constraintlayout.a.a.a.b$b r8 = r1.f2105c
            androidx.constraintlayout.a.a.a.h.a((androidx.constraintlayout.a.a.f) r1, (androidx.constraintlayout.a.a.a.b.C0030b) r8)
            r8 = 0
        L_0x0043:
            if (r8 >= r3) goto L_0x008f
            java.util.ArrayList r11 = r1.bh
            java.lang.Object r11 = r11.get(r8)
            androidx.constraintlayout.a.a.e r11 = (androidx.constraintlayout.a.a.e) r11
            boolean r12 = r11.i()
            if (r12 == 0) goto L_0x008c
            boolean r12 = r11 instanceof androidx.constraintlayout.a.a.h
            if (r12 != 0) goto L_0x008c
            boolean r12 = r11 instanceof androidx.constraintlayout.a.a.a
            if (r12 != 0) goto L_0x008c
            boolean r12 = r11 instanceof androidx.constraintlayout.a.a.l
            if (r12 != 0) goto L_0x008c
            boolean r12 = r11.G
            if (r12 != 0) goto L_0x008c
            androidx.constraintlayout.a.a.e$a r12 = r11.l(r2)
            androidx.constraintlayout.a.a.e$a r13 = r11.l(r6)
            androidx.constraintlayout.a.a.e$a r14 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r12 != r14) goto L_0x007d
            int r12 = r11.p
            if (r12 == r6) goto L_0x007d
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r13 != r12) goto L_0x007d
            int r12 = r11.q
            if (r12 == r6) goto L_0x007d
            r12 = 1
            goto L_0x007e
        L_0x007d:
            r12 = 0
        L_0x007e:
            if (r12 != 0) goto L_0x008c
            androidx.constraintlayout.a.a.a.b$a r12 = new androidx.constraintlayout.a.a.a.b$a
            r12.<init>()
            androidx.constraintlayout.a.a.a.b$b r13 = r1.f2105c
            int r14 = androidx.constraintlayout.a.a.a.b.a.f2007a
            a(r11, r13, r12, r14)
        L_0x008c:
            int r8 = r8 + 1
            goto L_0x0043
        L_0x008f:
            r8 = 2
            if (r3 <= r8) goto L_0x0495
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r7 == r12) goto L_0x009a
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r5 != r12) goto L_0x0495
        L_0x009a:
            int r12 = r1.ba
            r13 = 1024(0x400, float:1.435E-42)
            boolean r12 = androidx.constraintlayout.a.a.k.a(r12, r13)
            if (r12 == 0) goto L_0x0495
            androidx.constraintlayout.a.a.a.b$b r12 = r1.f2105c
            java.util.ArrayList<androidx.constraintlayout.a.a.e> r13 = r1.bh
            int r14 = r13.size()
            r15 = 0
        L_0x00ad:
            if (r15 >= r14) goto L_0x00e2
            java.lang.Object r16 = r13.get(r15)
            r8 = r16
            androidx.constraintlayout.a.a.e r8 = (androidx.constraintlayout.a.a.e) r8
            androidx.constraintlayout.a.a.e$a[] r11 = r1.U
            r11 = r11[r2]
            androidx.constraintlayout.a.a.e$a[] r9 = r1.U
            r9 = r9[r6]
            androidx.constraintlayout.a.a.e$a[] r10 = r8.U
            r10 = r10[r2]
            androidx.constraintlayout.a.a.e$a[] r2 = r8.U
            r2 = r2[r6]
            boolean r2 = androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e.a) r11, (androidx.constraintlayout.a.a.e.a) r9, (androidx.constraintlayout.a.a.e.a) r10, (androidx.constraintlayout.a.a.e.a) r2)
            if (r2 == 0) goto L_0x00d8
            boolean r2 = r8 instanceof androidx.constraintlayout.a.a.g
            if (r2 != 0) goto L_0x00d8
            int r15 = r15 + 1
            r2 = 0
            r8 = 2
            r9 = 1
            goto L_0x00ad
        L_0x00d8:
            r23 = r0
            r18 = r3
            r21 = r4
            r22 = r5
            goto L_0x044d
        L_0x00e2:
            androidx.constraintlayout.a.e r2 = r1.aL
            if (r2 == 0) goto L_0x00ed
            long r8 = r2.E
            r10 = 1
            long r8 = r8 + r10
            r2.E = r8
        L_0x00ed:
            r2 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r15 = 0
            r17 = 0
        L_0x00f5:
            if (r2 >= r14) goto L_0x01df
            java.lang.Object r18 = r13.get(r2)
            r6 = r18
            androidx.constraintlayout.a.a.e r6 = (androidx.constraintlayout.a.a.e) r6
            r18 = r3
            androidx.constraintlayout.a.a.e$a[] r3 = r1.U
            r19 = 0
            r3 = r3[r19]
            r21 = r4
            androidx.constraintlayout.a.a.e$a[] r4 = r1.U
            r20 = 1
            r4 = r4[r20]
            r22 = r5
            androidx.constraintlayout.a.a.e$a[] r5 = r6.U
            r5 = r5[r19]
            r23 = r0
            androidx.constraintlayout.a.a.e$a[] r0 = r6.U
            r0 = r0[r20]
            boolean r0 = androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e.a) r3, (androidx.constraintlayout.a.a.e.a) r4, (androidx.constraintlayout.a.a.e.a) r5, (androidx.constraintlayout.a.a.e.a) r0)
            if (r0 != 0) goto L_0x0128
            androidx.constraintlayout.a.a.a.b$a r0 = r1.bf
            int r3 = androidx.constraintlayout.a.a.a.b.a.f2007a
            a(r6, r12, r0, r3)
        L_0x0128:
            boolean r0 = r6 instanceof androidx.constraintlayout.a.a.h
            if (r0 == 0) goto L_0x014c
            r3 = r6
            androidx.constraintlayout.a.a.h r3 = (androidx.constraintlayout.a.a.h) r3
            int r4 = r3.aL
            if (r4 != 0) goto L_0x013d
            if (r10 != 0) goto L_0x013a
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x013a:
            r10.add(r3)
        L_0x013d:
            int r4 = r3.aL
            r5 = 1
            if (r4 != r5) goto L_0x014c
            if (r8 != 0) goto L_0x0149
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0149:
            r8.add(r3)
        L_0x014c:
            boolean r3 = r6 instanceof androidx.constraintlayout.a.a.j
            if (r3 == 0) goto L_0x0190
            boolean r3 = r6 instanceof androidx.constraintlayout.a.a.a
            if (r3 == 0) goto L_0x0179
            r3 = r6
            androidx.constraintlayout.a.a.a r3 = (androidx.constraintlayout.a.a.a) r3
            int r4 = r3.d()
            if (r4 != 0) goto L_0x0167
            if (r9 != 0) goto L_0x0164
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0164:
            r9.add(r3)
        L_0x0167:
            int r4 = r3.d()
            r5 = 1
            if (r4 != r5) goto L_0x0190
            if (r11 != 0) goto L_0x0175
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x0175:
            r11.add(r3)
            goto L_0x0190
        L_0x0179:
            r3 = r6
            androidx.constraintlayout.a.a.j r3 = (androidx.constraintlayout.a.a.j) r3
            if (r9 != 0) goto L_0x0183
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0183:
            r9.add(r3)
            if (r11 != 0) goto L_0x018d
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x018d:
            r11.add(r3)
        L_0x0190:
            androidx.constraintlayout.a.a.d r3 = r6.J
            androidx.constraintlayout.a.a.d r3 = r3.f2087f
            if (r3 != 0) goto L_0x01ac
            androidx.constraintlayout.a.a.d r3 = r6.L
            androidx.constraintlayout.a.a.d r3 = r3.f2087f
            if (r3 != 0) goto L_0x01ac
            if (r0 != 0) goto L_0x01ac
            boolean r3 = r6 instanceof androidx.constraintlayout.a.a.a
            if (r3 != 0) goto L_0x01ac
            if (r15 != 0) goto L_0x01a9
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
        L_0x01a9:
            r15.add(r6)
        L_0x01ac:
            androidx.constraintlayout.a.a.d r3 = r6.K
            androidx.constraintlayout.a.a.d r3 = r3.f2087f
            if (r3 != 0) goto L_0x01d2
            androidx.constraintlayout.a.a.d r3 = r6.M
            androidx.constraintlayout.a.a.d r3 = r3.f2087f
            if (r3 != 0) goto L_0x01d2
            androidx.constraintlayout.a.a.d r3 = r6.N
            androidx.constraintlayout.a.a.d r3 = r3.f2087f
            if (r3 != 0) goto L_0x01d2
            if (r0 != 0) goto L_0x01d2
            boolean r0 = r6 instanceof androidx.constraintlayout.a.a.a
            if (r0 != 0) goto L_0x01d2
            if (r17 != 0) goto L_0x01cb
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
        L_0x01cb:
            r0 = r17
            r0.add(r6)
            r17 = r0
        L_0x01d2:
            int r2 = r2 + 1
            r3 = r18
            r4 = r21
            r5 = r22
            r0 = r23
            r6 = 1
            goto L_0x00f5
        L_0x01df:
            r23 = r0
            r18 = r3
            r21 = r4
            r22 = r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 == 0) goto L_0x0204
            java.util.Iterator r2 = r8.iterator()
        L_0x01f2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0204
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.h r3 = (androidx.constraintlayout.a.a.h) r3
            r4 = 0
            r5 = 0
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x01f2
        L_0x0204:
            r4 = 0
            r5 = 0
            if (r9 == 0) goto L_0x0225
            java.util.Iterator r2 = r9.iterator()
        L_0x020c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0225
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.j r3 = (androidx.constraintlayout.a.a.j) r3
            androidx.constraintlayout.a.a.a.o r6 = androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            r3.a(r0, r5, r6)
            r6.a((java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0)
            r4 = 0
            r5 = 0
            goto L_0x020c
        L_0x0225:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.LEFT
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x0249
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x0235:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0249
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 0
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0235
        L_0x0249:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.RIGHT
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x026d
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x0259:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x026d
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 0
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0259
        L_0x026d:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.CENTER
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x0291
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x027d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0291
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 0
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x027d
        L_0x0291:
            r4 = 0
            r5 = 0
            if (r15 == 0) goto L_0x02a9
            java.util.Iterator r2 = r15.iterator()
        L_0x0299:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02a9
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.e r3 = (androidx.constraintlayout.a.a.e) r3
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0299
        L_0x02a9:
            if (r10 == 0) goto L_0x02c0
            java.util.Iterator r2 = r10.iterator()
        L_0x02af:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02c0
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.h r3 = (androidx.constraintlayout.a.a.h) r3
            r5 = 1
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x02af
        L_0x02c0:
            r5 = 1
            if (r11 == 0) goto L_0x02e0
            java.util.Iterator r2 = r11.iterator()
        L_0x02c7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02e0
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.j r3 = (androidx.constraintlayout.a.a.j) r3
            androidx.constraintlayout.a.a.a.o r6 = androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            r3.a(r0, r5, r6)
            r6.a((java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0)
            r4 = 0
            r5 = 1
            goto L_0x02c7
        L_0x02e0:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.TOP
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x0304
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x02f0:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0304
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 1
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x02f0
        L_0x0304:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.BASELINE
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x0328
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x0314:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0328
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 1
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0314
        L_0x0328:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.BOTTOM
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x034c
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x0338:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x034c
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 1
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0338
        L_0x034c:
            androidx.constraintlayout.a.a.d$a r2 = androidx.constraintlayout.a.a.d.a.CENTER
            androidx.constraintlayout.a.a.d r2 = r1.a((androidx.constraintlayout.a.a.d.a) r2)
            java.util.HashSet<androidx.constraintlayout.a.a.d> r3 = r2.f2082a
            if (r3 == 0) goto L_0x0370
            java.util.HashSet<androidx.constraintlayout.a.a.d> r2 = r2.f2082a
            java.util.Iterator r2 = r2.iterator()
        L_0x035c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0370
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.d r3 = (androidx.constraintlayout.a.a.d) r3
            androidx.constraintlayout.a.a.e r3 = r3.f2085d
            r4 = 0
            r5 = 1
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x035c
        L_0x0370:
            r4 = 0
            r5 = 1
            if (r17 == 0) goto L_0x0388
            java.util.Iterator r2 = r17.iterator()
        L_0x0378:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0388
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.a.a.e r3 = (androidx.constraintlayout.a.a.e) r3
            androidx.constraintlayout.a.a.a.i.a((androidx.constraintlayout.a.a.e) r3, (int) r5, (java.util.ArrayList<androidx.constraintlayout.a.a.a.o>) r0, (androidx.constraintlayout.a.a.a.o) r4)
            goto L_0x0378
        L_0x0388:
            r2 = 0
        L_0x0389:
            if (r2 >= r14) goto L_0x03c5
            java.lang.Object r3 = r13.get(r2)
            androidx.constraintlayout.a.a.e r3 = (androidx.constraintlayout.a.a.e) r3
            androidx.constraintlayout.a.a.e$a[] r4 = r3.U
            r5 = 0
            r4 = r4[r5]
            androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x03a5
            androidx.constraintlayout.a.a.e$a[] r4 = r3.U
            r5 = 1
            r4 = r4[r5]
            androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x03a5
            r4 = 1
            goto L_0x03a6
        L_0x03a5:
            r4 = 0
        L_0x03a6:
            if (r4 == 0) goto L_0x03c2
            int r4 = r3.aJ
            androidx.constraintlayout.a.a.a.o r4 = androidx.constraintlayout.a.a.a.i.a(r0, r4)
            int r3 = r3.aK
            androidx.constraintlayout.a.a.a.o r3 = androidx.constraintlayout.a.a.a.i.a(r0, r3)
            if (r4 == 0) goto L_0x03c2
            if (r3 == 0) goto L_0x03c2
            r5 = 0
            r4.a((int) r5, (androidx.constraintlayout.a.a.a.o) r3)
            r5 = 2
            r3.f2054e = r5
            r0.remove(r4)
        L_0x03c2:
            int r2 = r2 + 1
            goto L_0x0389
        L_0x03c5:
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x044d
            androidx.constraintlayout.a.a.e$a[] r2 = r1.U
            r3 = 0
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r2 != r4) goto L_0x0408
            java.util.Iterator r2 = r0.iterator()
            r4 = 0
            r11 = 0
        L_0x03db:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x03f9
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.a.a.a.o r5 = (androidx.constraintlayout.a.a.a.o) r5
            int r6 = r5.f2054e
            r8 = 1
            if (r6 == r8) goto L_0x03db
            r5.f2053d = r3
            androidx.constraintlayout.a.d r6 = r1.aM
            int r6 = r5.a((androidx.constraintlayout.a.d) r6, (int) r3)
            if (r6 <= r4) goto L_0x03db
            r11 = r5
            r4 = r6
            goto L_0x03db
        L_0x03f9:
            if (r11 == 0) goto L_0x0408
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.FIXED
            androidx.constraintlayout.a.a.e$a[] r5 = r1.U
            r5[r3] = r2
            r1.g(r4)
            r2 = 1
            r11.f2053d = r2
            goto L_0x040a
        L_0x0408:
            r2 = 1
            r11 = 0
        L_0x040a:
            androidx.constraintlayout.a.a.e$a[] r3 = r1.U
            r3 = r3[r2]
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r3 != r2) goto L_0x0446
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = 0
        L_0x0418:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0437
            java.lang.Object r4 = r0.next()
            androidx.constraintlayout.a.a.a.o r4 = (androidx.constraintlayout.a.a.a.o) r4
            int r5 = r4.f2054e
            if (r5 == 0) goto L_0x0418
            r5 = 0
            r4.f2053d = r5
            androidx.constraintlayout.a.d r5 = r1.aM
            r6 = 1
            int r5 = r4.a((androidx.constraintlayout.a.d) r5, (int) r6)
            if (r5 <= r3) goto L_0x0418
            r2 = r4
            r3 = r5
            goto L_0x0418
        L_0x0437:
            r6 = 1
            if (r2 == 0) goto L_0x0446
            androidx.constraintlayout.a.a.e$a r0 = androidx.constraintlayout.a.a.e.a.FIXED
            androidx.constraintlayout.a.a.e$a[] r4 = r1.U
            r4[r6] = r0
            r1.h(r3)
            r2.f2053d = r6
            goto L_0x0447
        L_0x0446:
            r2 = 0
        L_0x0447:
            if (r11 != 0) goto L_0x044b
            if (r2 == 0) goto L_0x044d
        L_0x044b:
            r0 = 1
            goto L_0x044e
        L_0x044d:
            r0 = 0
        L_0x044e:
            if (r0 == 0) goto L_0x048e
            androidx.constraintlayout.a.a.e$a r0 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r7 != r0) goto L_0x046a
            int r0 = r24.n()
            r2 = r23
            if (r2 >= r0) goto L_0x0465
            if (r2 <= 0) goto L_0x0465
            r1.g(r2)
            r3 = 1
            r1.bc = r3
            goto L_0x046c
        L_0x0465:
            int r0 = r24.n()
            goto L_0x046d
        L_0x046a:
            r2 = r23
        L_0x046c:
            r0 = r2
        L_0x046d:
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            r3 = r22
            if (r3 != r2) goto L_0x0489
            int r2 = r24.o()
            r4 = r21
            if (r4 >= r2) goto L_0x0484
            if (r4 <= 0) goto L_0x0484
            r1.h(r4)
            r2 = 1
            r1.bd = r2
            goto L_0x048b
        L_0x0484:
            int r4 = r24.o()
            goto L_0x048b
        L_0x0489:
            r4 = r21
        L_0x048b:
            r2 = r0
            r0 = 1
            goto L_0x049a
        L_0x048e:
            r4 = r21
            r3 = r22
            r2 = r23
            goto L_0x0499
        L_0x0495:
            r2 = r0
            r18 = r3
            r3 = r5
        L_0x0499:
            r0 = 0
        L_0x049a:
            r5 = 64
            boolean r6 = r1.p(r5)
            if (r6 != 0) goto L_0x04ad
            r6 = 128(0x80, float:1.794E-43)
            boolean r6 = r1.p(r6)
            if (r6 == 0) goto L_0x04ab
            goto L_0x04ad
        L_0x04ab:
            r6 = 0
            goto L_0x04ae
        L_0x04ad:
            r6 = 1
        L_0x04ae:
            androidx.constraintlayout.a.d r8 = r1.aM
            r9 = 0
            r8.j = r9
            r8.k = r9
            int r10 = r1.ba
            if (r10 == 0) goto L_0x04bf
            if (r6 == 0) goto L_0x04bf
            r6 = 1
            r8.k = r6
            goto L_0x04c0
        L_0x04bf:
            r6 = 1
        L_0x04c0:
            java.util.ArrayList r8 = r1.bh
            androidx.constraintlayout.a.a.e$a[] r10 = r1.U
            r10 = r10[r9]
            androidx.constraintlayout.a.a.e$a r9 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r10 == r9) goto L_0x04d5
            androidx.constraintlayout.a.a.e$a[] r9 = r1.U
            r9 = r9[r6]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r9 != r6) goto L_0x04d3
            goto L_0x04d5
        L_0x04d3:
            r6 = 0
            goto L_0x04d6
        L_0x04d5:
            r6 = 1
        L_0x04d6:
            r24.A()
            r9 = r18
            r10 = 0
        L_0x04dc:
            if (r10 >= r9) goto L_0x04f2
            java.util.ArrayList r11 = r1.bh
            java.lang.Object r11 = r11.get(r10)
            androidx.constraintlayout.a.a.e r11 = (androidx.constraintlayout.a.a.e) r11
            boolean r12 = r11 instanceof androidx.constraintlayout.a.a.m
            if (r12 == 0) goto L_0x04ef
            androidx.constraintlayout.a.a.m r11 = (androidx.constraintlayout.a.a.m) r11
            r11.z()
        L_0x04ef:
            int r10 = r10 + 1
            goto L_0x04dc
        L_0x04f2:
            boolean r5 = r1.p(r5)
            r11 = r0
            r0 = 0
            r10 = 1
        L_0x04f9:
            if (r10 == 0) goto L_0x06d4
            r12 = 1
            int r13 = r0 + 1
            androidx.constraintlayout.a.d r0 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            r0.b()     // Catch:{ Exception -> 0x05b6 }
            r24.A()     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r0 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            r1.a((androidx.constraintlayout.a.d) r0)     // Catch:{ Exception -> 0x05b6 }
            r0 = 0
        L_0x050c:
            if (r0 >= r9) goto L_0x051e
            java.util.ArrayList r12 = r1.bh     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r12 = r12.get(r0)     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.e r12 = (androidx.constraintlayout.a.a.e) r12     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r14 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            r12.a((androidx.constraintlayout.a.d) r14)     // Catch:{ Exception -> 0x05b6 }
            int r0 = r0 + 1
            goto L_0x050c
        L_0x051e:
            androidx.constraintlayout.a.d r0 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            boolean r10 = r1.b((androidx.constraintlayout.a.d) r0)     // Catch:{ Exception -> 0x05b6 }
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bi     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x0546
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bi     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x0546
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bi     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r0 = (androidx.constraintlayout.a.a.d) r0     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r12 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r14 = r1.K     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.h r12 = r12.a((java.lang.Object) r14)     // Catch:{ Exception -> 0x05b6 }
            r1.a((androidx.constraintlayout.a.a.d) r0, (androidx.constraintlayout.a.h) r12)     // Catch:{ Exception -> 0x05b6 }
            r12 = 0
            r1.bi = r12     // Catch:{ Exception -> 0x05b4 }
        L_0x0546:
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bk     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x0568
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bk     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x0568
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bk     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r0 = (androidx.constraintlayout.a.a.d) r0     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r12 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r14 = r1.M     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.h r12 = r12.a((java.lang.Object) r14)     // Catch:{ Exception -> 0x05b6 }
            r1.b(r0, r12)     // Catch:{ Exception -> 0x05b6 }
            r12 = 0
            r1.bk = r12     // Catch:{ Exception -> 0x05b4 }
        L_0x0568:
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bj     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x058a
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bj     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x058a
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bj     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r0 = (androidx.constraintlayout.a.a.d) r0     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r12 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r14 = r1.J     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.h r12 = r12.a((java.lang.Object) r14)     // Catch:{ Exception -> 0x05b6 }
            r1.a((androidx.constraintlayout.a.a.d) r0, (androidx.constraintlayout.a.h) r12)     // Catch:{ Exception -> 0x05b6 }
            r12 = 0
            r1.bj = r12     // Catch:{ Exception -> 0x05b4 }
        L_0x058a:
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bl     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x05ad
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bl     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            if (r0 == 0) goto L_0x05ad
            java.lang.ref.WeakReference<androidx.constraintlayout.a.a.d> r0 = r1.bl     // Catch:{ Exception -> 0x05b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r0 = (androidx.constraintlayout.a.a.d) r0     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.d r12 = r1.aM     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.a.d r14 = r1.L     // Catch:{ Exception -> 0x05b6 }
            androidx.constraintlayout.a.h r12 = r12.a((java.lang.Object) r14)     // Catch:{ Exception -> 0x05b6 }
            r1.b(r0, r12)     // Catch:{ Exception -> 0x05b6 }
            r12 = 0
            r1.bl = r12     // Catch:{ Exception -> 0x05b4 }
            goto L_0x05ae
        L_0x05ad:
            r12 = 0
        L_0x05ae:
            androidx.constraintlayout.a.d r0 = r1.aM     // Catch:{ Exception -> 0x05b4 }
            r0.e()     // Catch:{ Exception -> 0x05b4 }
            goto L_0x05ca
        L_0x05b4:
            r0 = move-exception
            goto L_0x05b8
        L_0x05b6:
            r0 = move-exception
            r12 = 0
        L_0x05b8:
            r0.printStackTrace()
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r15 = "EXCEPTION : "
            java.lang.String r0 = r15.concat(r0)
            r14.println(r0)
        L_0x05ca:
            if (r10 == 0) goto L_0x05d2
            boolean[] r0 = androidx.constraintlayout.a.a.k.f2125a
            r1.a((boolean[]) r0)
            goto L_0x05e6
        L_0x05d2:
            r1.a((boolean) r5)
            r0 = 0
        L_0x05d6:
            if (r0 >= r9) goto L_0x05e6
            java.util.ArrayList r10 = r1.bh
            java.lang.Object r10 = r10.get(r0)
            androidx.constraintlayout.a.a.e r10 = (androidx.constraintlayout.a.a.e) r10
            r10.a((boolean) r5)
            int r0 = r0 + 1
            goto L_0x05d6
        L_0x05e6:
            if (r6 == 0) goto L_0x0657
            r0 = 8
            if (r13 >= r0) goto L_0x0657
            boolean[] r0 = androidx.constraintlayout.a.a.k.f2125a
            r10 = 2
            boolean r0 = r0[r10]
            if (r0 == 0) goto L_0x0657
            r0 = 0
            r14 = 0
            r15 = 0
        L_0x05f6:
            if (r0 >= r9) goto L_0x061c
            java.util.ArrayList r10 = r1.bh
            java.lang.Object r10 = r10.get(r0)
            androidx.constraintlayout.a.a.e r10 = (androidx.constraintlayout.a.a.e) r10
            int r12 = r10.aa
            int r17 = r10.n()
            int r12 = r12 + r17
            int r14 = java.lang.Math.max(r14, r12)
            int r12 = r10.ab
            int r10 = r10.o()
            int r12 = r12 + r10
            int r15 = java.lang.Math.max(r15, r12)
            int r0 = r0 + 1
            r10 = 2
            r12 = 0
            goto L_0x05f6
        L_0x061c:
            int r0 = r1.ah
            int r0 = java.lang.Math.max(r0, r14)
            int r10 = r1.ai
            int r10 = java.lang.Math.max(r10, r15)
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r7 != r12) goto L_0x063f
            int r12 = r24.n()
            if (r12 >= r0) goto L_0x063f
            r1.g(r0)
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r11 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            r12 = 0
            r0[r12] = r11
            r0 = 1
            r11 = 1
            goto L_0x0640
        L_0x063f:
            r0 = 0
        L_0x0640:
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r3 != r12) goto L_0x0658
            int r12 = r24.o()
            if (r12 >= r10) goto L_0x0658
            r1.h(r10)
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            r11 = 1
            r0[r11] = r10
            r0 = 1
            r11 = 1
            goto L_0x0658
        L_0x0657:
            r0 = 0
        L_0x0658:
            int r10 = r1.ah
            int r12 = r24.n()
            int r10 = java.lang.Math.max(r10, r12)
            int r12 = r24.n()
            if (r10 <= r12) goto L_0x0674
            r1.g(r10)
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.FIXED
            r11 = 0
            r0[r11] = r10
            r0 = 1
            r11 = 1
        L_0x0674:
            int r10 = r1.ai
            int r12 = r24.o()
            int r10 = java.lang.Math.max(r10, r12)
            int r12 = r24.o()
            if (r10 <= r12) goto L_0x0691
            r1.h(r10)
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.FIXED
            r12 = 1
            r0[r12] = r10
            r0 = 1
            r11 = 1
            goto L_0x0692
        L_0x0691:
            r12 = 1
        L_0x0692:
            if (r11 != 0) goto L_0x06d0
            androidx.constraintlayout.a.a.e$a[] r10 = r1.U
            r14 = 0
            r10 = r10[r14]
            androidx.constraintlayout.a.a.e$a r15 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r10 != r15) goto L_0x06b2
            if (r2 <= 0) goto L_0x06b2
            int r10 = r24.n()
            if (r10 <= r2) goto L_0x06b2
            r1.bc = r12
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.FIXED
            r0[r14] = r10
            r1.g(r2)
            r0 = 1
            r11 = 1
        L_0x06b2:
            androidx.constraintlayout.a.a.e$a[] r10 = r1.U
            r10 = r10[r12]
            androidx.constraintlayout.a.a.e$a r14 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r10 != r14) goto L_0x06d0
            if (r4 <= 0) goto L_0x06d0
            int r10 = r24.o()
            if (r10 <= r4) goto L_0x06d0
            r1.bd = r12
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.FIXED
            r0[r12] = r10
            r1.h(r4)
            r10 = 1
            r11 = 1
            goto L_0x06d1
        L_0x06d0:
            r10 = r0
        L_0x06d1:
            r0 = r13
            goto L_0x04f9
        L_0x06d4:
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            r1.bh = r8
            if (r11 == 0) goto L_0x06e4
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            r2 = 0
            r0[r2] = r7
            androidx.constraintlayout.a.a.e$a[] r0 = r1.U
            r2 = 1
            r0[r2] = r3
        L_0x06e4:
            androidx.constraintlayout.a.d r0 = r1.aM
            androidx.constraintlayout.a.c r0 = r0.n
            r1.a((androidx.constraintlayout.a.c) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.z():void");
    }

    private void A() {
        this.aR = 0;
        this.aS = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar, int i2) {
        if (i2 == 0) {
            c(eVar);
        } else if (i2 == 1) {
            d(eVar);
        }
    }

    private void c(e eVar) {
        int i2 = this.aR + 1;
        c[] cVarArr = this.aU;
        if (i2 >= cVarArr.length) {
            this.aU = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.aU[this.aR] = new c(eVar, 0, this.f2106d);
        this.aR++;
    }

    private void d(e eVar) {
        int i2 = this.aS + 1;
        c[] cVarArr = this.aT;
        if (i2 >= cVarArr.length) {
            this.aT = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.aT[this.aS] = new c(eVar, 1, this.f2106d);
        this.aS++;
    }

    public static boolean a(e eVar, b.C0030b bVar, b.a aVar, int i2) {
        int i3;
        int i4;
        if (bVar == null) {
            return false;
        }
        aVar.f2010d = eVar.U[0];
        aVar.f2011e = eVar.U[1];
        aVar.f2012f = eVar.n();
        aVar.f2013g = eVar.o();
        aVar.l = false;
        aVar.m = i2;
        boolean z = aVar.f2010d == e.a.MATCH_CONSTRAINT;
        boolean z2 = aVar.f2011e == e.a.MATCH_CONSTRAINT;
        boolean z3 = z && eVar.Y > 0.0f;
        boolean z4 = z2 && eVar.Y > 0.0f;
        if (z && eVar.c(0) && eVar.p == 0 && !z3) {
            aVar.f2010d = e.a.WRAP_CONTENT;
            if (z2 && eVar.q == 0) {
                aVar.f2010d = e.a.FIXED;
            }
            z = false;
        }
        if (z2 && eVar.c(1) && eVar.q == 0 && !z4) {
            aVar.f2011e = e.a.WRAP_CONTENT;
            if (z && eVar.p == 0) {
                aVar.f2011e = e.a.FIXED;
            }
            z2 = false;
        }
        if (eVar.b()) {
            aVar.f2010d = e.a.FIXED;
            z = false;
        }
        if (eVar.c()) {
            aVar.f2011e = e.a.FIXED;
            z2 = false;
        }
        if (z3) {
            if (eVar.r[0] == 4) {
                aVar.f2010d = e.a.FIXED;
            } else if (!z2) {
                if (aVar.f2011e == e.a.FIXED) {
                    i4 = aVar.f2013g;
                } else {
                    aVar.f2010d = e.a.WRAP_CONTENT;
                    bVar.a(eVar, aVar);
                    i4 = aVar.f2015i;
                }
                aVar.f2010d = e.a.FIXED;
                if (eVar.Z == 0 || eVar.Z == -1) {
                    aVar.f2012f = (int) (eVar.Y * ((float) i4));
                } else {
                    aVar.f2012f = (int) (eVar.Y / ((float) i4));
                }
            }
        }
        if (z4) {
            if (eVar.r[1] == 4) {
                aVar.f2011e = e.a.FIXED;
            } else if (!z) {
                if (aVar.f2010d == e.a.FIXED) {
                    i3 = aVar.f2012f;
                } else {
                    aVar.f2011e = e.a.WRAP_CONTENT;
                    bVar.a(eVar, aVar);
                    i3 = aVar.f2014h;
                }
                aVar.f2011e = e.a.FIXED;
                if (eVar.Z == 0 || eVar.Z == -1) {
                    aVar.f2013g = (int) (((float) i3) / eVar.Y);
                } else {
                    aVar.f2013g = (int) (((float) i3) * eVar.Y);
                }
            }
        }
        bVar.a(eVar, aVar);
        eVar.g(aVar.f2014h);
        eVar.h(aVar.f2015i);
        eVar.E = aVar.k;
        eVar.k(aVar.j);
        aVar.m = b.a.f2007a;
        return aVar.l;
    }
}
