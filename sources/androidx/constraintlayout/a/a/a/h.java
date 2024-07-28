package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a;
import androidx.constraintlayout.a.a.a.b;
import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static b.a f2036a = new b.a();

    private static void a(a aVar, b.C0030b bVar, int i2, boolean z) {
        if (!aVar.e()) {
            return;
        }
        if (i2 == 0) {
            a((e) aVar, bVar, z);
        } else {
            a((e) aVar, bVar);
        }
    }

    private static void a(e eVar, b.C0030b bVar, boolean z) {
        if (!(eVar instanceof f) && eVar.i() && a(eVar)) {
            f.a(eVar, bVar, new b.a(), b.a.f2007a);
        }
        d a2 = eVar.a(d.a.LEFT);
        d a3 = eVar.a(d.a.RIGHT);
        int c2 = a2.c();
        int c3 = a3.c();
        if (a2.f2082a != null && a2.f2084c) {
            Iterator<d> it2 = a2.f2082a.iterator();
            while (it2.hasNext()) {
                d next = it2.next();
                e eVar2 = next.f2085d;
                boolean a4 = a(eVar2);
                if (eVar2.i() && a4) {
                    f.a(eVar2, bVar, new b.a(), b.a.f2007a);
                }
                if (eVar2.U[0] != e.a.MATCH_CONSTRAINT || a4) {
                    if (!eVar2.i()) {
                        if (next == eVar2.J && eVar2.L.f2087f == null) {
                            int e2 = eVar2.J.e() + c2;
                            eVar2.a(e2, eVar2.n() + e2);
                            a(eVar2, bVar, z);
                        } else if (next == eVar2.L && eVar2.J.f2087f == null) {
                            int e3 = c2 - eVar2.L.e();
                            eVar2.a(e3 - eVar2.n(), e3);
                            a(eVar2, bVar, z);
                        } else if (next == eVar2.J && eVar2.L.f2087f != null && eVar2.L.f2087f.f2084c && !eVar2.v()) {
                            a(bVar, eVar2, z);
                        }
                    }
                } else if (eVar2.U[0] == e.a.MATCH_CONSTRAINT && eVar2.t >= 0 && eVar2.s >= 0) {
                    if ((eVar2.an == 8 || (eVar2.p == 0 && eVar2.Y == 0.0f)) && !eVar2.v() && !eVar2.G) {
                        if (((next == eVar2.J && eVar2.L.f2087f != null && eVar2.L.f2087f.f2084c) || (next == eVar2.L && eVar2.J.f2087f != null && eVar2.J.f2087f.f2084c)) && !eVar2.v()) {
                            a(eVar, bVar, eVar2, z);
                        }
                    }
                }
            }
        }
        if (!(eVar instanceof androidx.constraintlayout.a.a.h) && a3.f2082a != null && a3.f2084c) {
            Iterator<d> it3 = a3.f2082a.iterator();
            while (it3.hasNext()) {
                d next2 = it3.next();
                e eVar3 = next2.f2085d;
                boolean a5 = a(eVar3);
                if (eVar3.i() && a5) {
                    f.a(eVar3, bVar, new b.a(), b.a.f2007a);
                }
                boolean z2 = (next2 == eVar3.J && eVar3.L.f2087f != null && eVar3.L.f2087f.f2084c) || (next2 == eVar3.L && eVar3.J.f2087f != null && eVar3.J.f2087f.f2084c);
                if (eVar3.U[0] != e.a.MATCH_CONSTRAINT || a5) {
                    if (!eVar3.i()) {
                        if (next2 == eVar3.J && eVar3.L.f2087f == null) {
                            int e4 = eVar3.J.e() + c3;
                            eVar3.a(e4, eVar3.n() + e4);
                            a(eVar3, bVar, z);
                        } else if (next2 == eVar3.L && eVar3.J.f2087f == null) {
                            int e5 = c3 - eVar3.L.e();
                            eVar3.a(e5 - eVar3.n(), e5);
                            a(eVar3, bVar, z);
                        } else if (z2 && !eVar3.v()) {
                            a(bVar, eVar3, z);
                        }
                    }
                } else if (eVar3.U[0] == e.a.MATCH_CONSTRAINT && eVar3.t >= 0 && eVar3.s >= 0) {
                    if ((eVar3.an == 8 || (eVar3.p == 0 && eVar3.Y == 0.0f)) && !eVar3.v() && !eVar3.G && z2 && !eVar3.v()) {
                        a(eVar, bVar, eVar3, z);
                    }
                }
            }
        }
    }

    private static void a(e eVar, b.C0030b bVar) {
        if (!(eVar instanceof f) && eVar.i() && a(eVar)) {
            f.a(eVar, bVar, new b.a(), b.a.f2007a);
        }
        d a2 = eVar.a(d.a.TOP);
        d a3 = eVar.a(d.a.BOTTOM);
        int c2 = a2.c();
        int c3 = a3.c();
        if (a2.f2082a != null && a2.f2084c) {
            Iterator<d> it2 = a2.f2082a.iterator();
            while (it2.hasNext()) {
                d next = it2.next();
                e eVar2 = next.f2085d;
                boolean a4 = a(eVar2);
                if (eVar2.i() && a4) {
                    f.a(eVar2, bVar, new b.a(), b.a.f2007a);
                }
                if (eVar2.U[1] != e.a.MATCH_CONSTRAINT || a4) {
                    if (!eVar2.i()) {
                        if (next == eVar2.K && eVar2.M.f2087f == null) {
                            int e2 = eVar2.K.e() + c2;
                            eVar2.b(e2, eVar2.o() + e2);
                            a(eVar2, bVar);
                        } else if (next == eVar2.M && eVar2.M.f2087f == null) {
                            int e3 = c2 - eVar2.M.e();
                            eVar2.b(e3 - eVar2.o(), e3);
                            a(eVar2, bVar);
                        } else if (next == eVar2.K && eVar2.M.f2087f != null && eVar2.M.f2087f.f2084c) {
                            a(bVar, eVar2);
                        }
                    }
                } else if (eVar2.U[1] == e.a.MATCH_CONSTRAINT && eVar2.w >= 0 && eVar2.v >= 0) {
                    if ((eVar2.an == 8 || (eVar2.q == 0 && eVar2.Y == 0.0f)) && !eVar2.w() && !eVar2.G) {
                        if (((next == eVar2.K && eVar2.M.f2087f != null && eVar2.M.f2087f.f2084c) || (next == eVar2.M && eVar2.K.f2087f != null && eVar2.K.f2087f.f2084c)) && !eVar2.w()) {
                            a(eVar, bVar, eVar2);
                        }
                    }
                }
            }
        }
        if (!(eVar instanceof androidx.constraintlayout.a.a.h)) {
            if (a3.f2082a != null && a3.f2084c) {
                Iterator<d> it3 = a3.f2082a.iterator();
                while (it3.hasNext()) {
                    d next2 = it3.next();
                    e eVar3 = next2.f2085d;
                    boolean a5 = a(eVar3);
                    if (eVar3.i() && a5) {
                        f.a(eVar3, bVar, new b.a(), b.a.f2007a);
                    }
                    boolean z = (next2 == eVar3.K && eVar3.M.f2087f != null && eVar3.M.f2087f.f2084c) || (next2 == eVar3.M && eVar3.K.f2087f != null && eVar3.K.f2087f.f2084c);
                    if (eVar3.U[1] != e.a.MATCH_CONSTRAINT || a5) {
                        if (!eVar3.i()) {
                            if (next2 == eVar3.K && eVar3.M.f2087f == null) {
                                int e4 = eVar3.K.e() + c3;
                                eVar3.b(e4, eVar3.o() + e4);
                                a(eVar3, bVar);
                            } else if (next2 == eVar3.M && eVar3.K.f2087f == null) {
                                int e5 = c3 - eVar3.M.e();
                                eVar3.b(e5 - eVar3.o(), e5);
                                a(eVar3, bVar);
                            } else if (z && !eVar3.w()) {
                                a(bVar, eVar3);
                            }
                        }
                    } else if (eVar3.U[1] == e.a.MATCH_CONSTRAINT && eVar3.w >= 0 && eVar3.v >= 0) {
                        if ((eVar3.an == 8 || (eVar3.q == 0 && eVar3.Y == 0.0f)) && !eVar3.w() && !eVar3.G && z && !eVar3.w()) {
                            a(eVar, bVar, eVar3);
                        }
                    }
                }
            }
            d a6 = eVar.a(d.a.BASELINE);
            if (a6.f2082a != null && a6.f2084c) {
                int c4 = a6.c();
                Iterator<d> it4 = a6.f2082a.iterator();
                while (it4.hasNext()) {
                    d next3 = it4.next();
                    e eVar4 = next3.f2085d;
                    boolean a7 = a(eVar4);
                    if (eVar4.i() && a7) {
                        f.a(eVar4, bVar, new b.a(), b.a.f2007a);
                    }
                    if ((eVar4.U[1] != e.a.MATCH_CONSTRAINT || a7) && !eVar4.i() && next3 == eVar4.N) {
                        eVar4.b(c4);
                        a(eVar4, bVar);
                    }
                }
            }
        }
    }

    public static void a(f fVar, b.C0030b bVar) {
        e.a aVar = fVar.U[0];
        e.a aVar2 = fVar.U[1];
        fVar.h();
        ArrayList<e> arrayList = fVar.bh;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).h();
        }
        boolean z = fVar.f2106d;
        if (aVar == e.a.FIXED) {
            fVar.a(0, fVar.n());
        } else {
            fVar.f();
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = arrayList.get(i3);
            if (eVar instanceof androidx.constraintlayout.a.a.h) {
                androidx.constraintlayout.a.a.h hVar = (androidx.constraintlayout.a.a.h) eVar;
                if (hVar.aL == 1) {
                    if (hVar.e() != -1) {
                        hVar.r(hVar.e());
                    } else if (hVar.y() != -1 && fVar.b()) {
                        hVar.r(fVar.n() - hVar.y());
                    } else if (fVar.b()) {
                        hVar.r((int) ((hVar.d() * ((float) fVar.n())) + 0.5f));
                    }
                    z2 = true;
                }
            } else if ((eVar instanceof a) && ((a) eVar).d() == 0) {
                z3 = true;
            }
        }
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = arrayList.get(i4);
                if (eVar2 instanceof androidx.constraintlayout.a.a.h) {
                    androidx.constraintlayout.a.a.h hVar2 = (androidx.constraintlayout.a.a.h) eVar2;
                    if (hVar2.aL == 1) {
                        a((e) hVar2, bVar, z);
                    }
                }
            }
        }
        a((e) fVar, bVar, z);
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                e eVar3 = arrayList.get(i5);
                if (eVar3 instanceof a) {
                    a aVar3 = (a) eVar3;
                    if (aVar3.d() == 0) {
                        a(aVar3, bVar, 0, z);
                    }
                }
            }
        }
        if (aVar2 == e.a.FIXED) {
            fVar.b(0, fVar.o());
        } else {
            fVar.c_();
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            e eVar4 = arrayList.get(i6);
            if (eVar4 instanceof androidx.constraintlayout.a.a.h) {
                androidx.constraintlayout.a.a.h hVar3 = (androidx.constraintlayout.a.a.h) eVar4;
                if (hVar3.aL == 0) {
                    if (hVar3.e() != -1) {
                        hVar3.r(hVar3.e());
                    } else if (hVar3.y() != -1 && fVar.c()) {
                        hVar3.r(fVar.o() - hVar3.y());
                    } else if (fVar.c()) {
                        hVar3.r((int) ((hVar3.d() * ((float) fVar.o())) + 0.5f));
                    }
                    z4 = true;
                }
            } else if ((eVar4 instanceof a) && ((a) eVar4).d() == 1) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar5 = arrayList.get(i7);
                if (eVar5 instanceof androidx.constraintlayout.a.a.h) {
                    androidx.constraintlayout.a.a.h hVar4 = (androidx.constraintlayout.a.a.h) eVar5;
                    if (hVar4.aL == 0) {
                        a((e) hVar4, bVar);
                    }
                }
            }
        }
        a((e) fVar, bVar);
        if (z5) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar6 = arrayList.get(i8);
                if (eVar6 instanceof a) {
                    a aVar4 = (a) eVar6;
                    if (aVar4.d() == 1) {
                        a(aVar4, bVar, 1, z);
                    }
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            e eVar7 = arrayList.get(i9);
            if (eVar7.i() && a(eVar7)) {
                f.a(eVar7, bVar, f2036a, b.a.f2007a);
                a(eVar7, bVar, z);
                a(eVar7, bVar);
            }
        }
    }

    private static void a(b.C0030b bVar, e eVar, boolean z) {
        float f2 = eVar.ak;
        int c2 = eVar.J.f2087f.c();
        int c3 = eVar.L.f2087f.c();
        int e2 = eVar.J.e() + c2;
        int e3 = c3 - eVar.L.e();
        if (c2 == c3) {
            f2 = 0.5f;
        } else {
            c2 = e2;
            c3 = e3;
        }
        int n = eVar.n();
        int i2 = (c3 - c2) - n;
        if (c2 > c3) {
            i2 = (c2 - c3) - n;
        }
        int i3 = ((int) ((f2 * ((float) i2)) + 0.5f)) + c2;
        int i4 = i3 + n;
        if (c2 > c3) {
            i4 = i3 - n;
        }
        eVar.a(i3, i4);
        a(eVar, bVar, z);
    }

    private static void a(b.C0030b bVar, e eVar) {
        float f2 = eVar.al;
        int c2 = eVar.K.f2087f.c();
        int c3 = eVar.M.f2087f.c();
        int e2 = eVar.K.e() + c2;
        int e3 = c3 - eVar.M.e();
        if (c2 == c3) {
            f2 = 0.5f;
        } else {
            c2 = e2;
            c3 = e3;
        }
        int o = eVar.o();
        int i2 = (c3 - c2) - o;
        if (c2 > c3) {
            i2 = (c2 - c3) - o;
        }
        int i3 = (int) ((f2 * ((float) i2)) + 0.5f);
        int i4 = c2 + i3;
        int i5 = i4 + o;
        if (c2 > c3) {
            i4 = c2 - i3;
            i5 = i4 - o;
        }
        eVar.b(i4, i5);
        a(eVar, bVar);
    }

    private static void a(e eVar, b.C0030b bVar, e eVar2, boolean z) {
        int i2;
        float f2 = eVar2.ak;
        int c2 = eVar2.J.f2087f.c() + eVar2.J.e();
        int c3 = eVar2.L.f2087f.c() - eVar2.L.e();
        if (c3 >= c2) {
            int n = eVar2.n();
            if (eVar2.an != 8) {
                if (eVar2.p == 2) {
                    if (eVar instanceof f) {
                        i2 = eVar.n();
                    } else {
                        i2 = eVar.V.n();
                    }
                    n = (int) (eVar2.ak * 0.5f * ((float) i2));
                } else if (eVar2.p == 0) {
                    n = c3 - c2;
                }
                n = Math.max(eVar2.s, n);
                if (eVar2.t > 0) {
                    n = Math.min(eVar2.t, n);
                }
            }
            int i3 = c2 + ((int) ((f2 * ((float) ((c3 - c2) - n))) + 0.5f));
            eVar2.a(i3, n + i3);
            a(eVar2, bVar, z);
        }
    }

    private static void a(e eVar, b.C0030b bVar, e eVar2) {
        int i2;
        float f2 = eVar2.al;
        int c2 = eVar2.K.f2087f.c() + eVar2.K.e();
        int c3 = eVar2.M.f2087f.c() - eVar2.M.e();
        if (c3 >= c2) {
            int o = eVar2.o();
            if (eVar2.an != 8) {
                if (eVar2.q == 2) {
                    if (eVar instanceof f) {
                        i2 = eVar.o();
                    } else {
                        i2 = eVar.V.o();
                    }
                    o = (int) (f2 * 0.5f * ((float) i2));
                } else if (eVar2.q == 0) {
                    o = c3 - c2;
                }
                o = Math.max(eVar2.v, o);
                if (eVar2.w > 0) {
                    o = Math.min(eVar2.w, o);
                }
            }
            int i3 = c2 + ((int) ((f2 * ((float) ((c3 - c2) - o))) + 0.5f));
            eVar2.b(i3, o + i3);
            a(eVar2, bVar);
        }
    }

    private static boolean a(e eVar) {
        e.a aVar = eVar.U[0];
        e.a aVar2 = eVar.U[1];
        f fVar = eVar.V != null ? (f) eVar.V : null;
        if (fVar != null) {
            e.a aVar3 = e.a.FIXED;
        }
        if (fVar != null) {
            e.a aVar4 = e.a.FIXED;
        }
        boolean z = aVar == e.a.FIXED || aVar == e.a.WRAP_CONTENT || (aVar == e.a.MATCH_CONSTRAINT && eVar.p == 0 && eVar.Y == 0.0f && eVar.c(0)) || eVar.b();
        boolean z2 = aVar2 == e.a.FIXED || aVar2 == e.a.WRAP_CONTENT || (aVar2 == e.a.MATCH_CONSTRAINT && eVar.q == 0 && eVar.Y == 0.0f && eVar.c(1)) || eVar.c();
        if (eVar.Y > 0.0f && (z || z2)) {
            return true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
