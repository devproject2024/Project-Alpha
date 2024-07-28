package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a.b;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.a.h;
import androidx.constraintlayout.a.a.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public f f2018a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2019b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2020c = true;

    /* renamed from: d  reason: collision with root package name */
    public f f2021d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<p> f2022e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public b.C0030b f2023f = null;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<m> f2024g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<m> f2025h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private b.a f2026i = new b.a();

    public e(f fVar) {
        this.f2018a = fVar;
        this.f2021d = fVar;
    }

    public final int a(f fVar, int i2) {
        int size = this.f2024g.size();
        long j = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j = Math.max(j, this.f2024g.get(i3).a(fVar, i2));
        }
        return (int) j;
    }

    private void a(androidx.constraintlayout.a.a.e eVar, e.a aVar, int i2, e.a aVar2, int i3) {
        b.a aVar3 = this.f2026i;
        aVar3.f2010d = aVar;
        aVar3.f2011e = aVar2;
        aVar3.f2012f = i2;
        aVar3.f2013g = i3;
        this.f2023f.a(eVar, aVar3);
        eVar.g(this.f2026i.f2014h);
        eVar.h(this.f2026i.f2015i);
        eVar.E = this.f2026i.k;
        eVar.k(this.f2026i.j);
    }

    public final boolean a(f fVar) {
        int i2;
        int i3;
        Iterator it2 = fVar.bh.iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) it2.next();
            e.a aVar = eVar.U[0];
            e.a aVar2 = eVar.U[1];
            if (eVar.an == 8) {
                eVar.f2096e = true;
            } else {
                if (eVar.u < 1.0f && aVar == e.a.MATCH_CONSTRAINT) {
                    eVar.p = 2;
                }
                if (eVar.x < 1.0f && aVar2 == e.a.MATCH_CONSTRAINT) {
                    eVar.q = 2;
                }
                if (eVar.Y > 0.0f) {
                    if (aVar == e.a.MATCH_CONSTRAINT && (aVar2 == e.a.WRAP_CONTENT || aVar2 == e.a.FIXED)) {
                        eVar.p = 3;
                    } else if (aVar2 == e.a.MATCH_CONSTRAINT && (aVar == e.a.WRAP_CONTENT || aVar == e.a.FIXED)) {
                        eVar.q = 3;
                    } else if (aVar == e.a.MATCH_CONSTRAINT && aVar2 == e.a.MATCH_CONSTRAINT) {
                        if (eVar.p == 0) {
                            eVar.p = 3;
                        }
                        if (eVar.q == 0) {
                            eVar.q = 3;
                        }
                    }
                }
                if (aVar == e.a.MATCH_CONSTRAINT && eVar.p == 1 && (eVar.J.f2087f == null || eVar.L.f2087f == null)) {
                    aVar = e.a.WRAP_CONTENT;
                }
                e.a aVar3 = aVar;
                e.a aVar4 = (aVar2 == e.a.MATCH_CONSTRAINT && eVar.q == 1 && (eVar.K.f2087f == null || eVar.M.f2087f == null)) ? e.a.WRAP_CONTENT : aVar2;
                eVar.f2100i.f2068f = aVar3;
                eVar.f2100i.f2065c = eVar.p;
                eVar.j.f2068f = aVar4;
                eVar.j.f2065c = eVar.q;
                if ((aVar3 == e.a.MATCH_PARENT || aVar3 == e.a.FIXED || aVar3 == e.a.WRAP_CONTENT) && (aVar4 == e.a.MATCH_PARENT || aVar4 == e.a.FIXED || aVar4 == e.a.WRAP_CONTENT)) {
                    int n = eVar.n();
                    if (aVar3 == e.a.MATCH_PARENT) {
                        i2 = (fVar.n() - eVar.J.f2088g) - eVar.L.f2088g;
                        aVar3 = e.a.FIXED;
                    } else {
                        i2 = n;
                    }
                    int o = eVar.o();
                    if (aVar4 == e.a.MATCH_PARENT) {
                        i3 = (fVar.o() - eVar.K.f2088g) - eVar.M.f2088g;
                        aVar4 = e.a.FIXED;
                    } else {
                        i3 = o;
                    }
                    a(eVar, aVar3, i2, aVar4, i3);
                    eVar.f2100i.f2069g.a(eVar.n());
                    eVar.j.f2069g.a(eVar.o());
                    eVar.f2096e = true;
                } else {
                    if (aVar3 == e.a.MATCH_CONSTRAINT && (aVar4 == e.a.WRAP_CONTENT || aVar4 == e.a.FIXED)) {
                        if (eVar.p == 3) {
                            if (aVar4 == e.a.WRAP_CONTENT) {
                                a(eVar, e.a.WRAP_CONTENT, 0, e.a.WRAP_CONTENT, 0);
                            }
                            int o2 = eVar.o();
                            e.a aVar5 = e.a.FIXED;
                            a(eVar, aVar5, (int) ((((float) o2) * eVar.Y) + 0.5f), aVar5, o2);
                            eVar.f2100i.f2069g.a(eVar.n());
                            eVar.j.f2069g.a(eVar.o());
                            eVar.f2096e = true;
                        } else if (eVar.p == 1) {
                            a(eVar, e.a.WRAP_CONTENT, 0, aVar4, 0);
                            eVar.f2100i.f2069g.m = eVar.n();
                        } else if (eVar.p == 2) {
                            if (fVar.U[0] == e.a.FIXED || fVar.U[0] == e.a.MATCH_PARENT) {
                                androidx.constraintlayout.a.a.e eVar2 = eVar;
                                a(eVar2, e.a.FIXED, (int) ((eVar.u * ((float) fVar.n())) + 0.5f), aVar4, eVar.o());
                                eVar.f2100i.f2069g.a(eVar.n());
                                eVar.j.f2069g.a(eVar.o());
                                eVar.f2096e = true;
                            }
                        } else if (eVar.R[0].f2087f == null || eVar.R[1].f2087f == null) {
                            a(eVar, e.a.WRAP_CONTENT, 0, aVar4, 0);
                            eVar.f2100i.f2069g.a(eVar.n());
                            eVar.j.f2069g.a(eVar.o());
                            eVar.f2096e = true;
                        }
                    }
                    if (aVar4 == e.a.MATCH_CONSTRAINT && (aVar3 == e.a.WRAP_CONTENT || aVar3 == e.a.FIXED)) {
                        if (eVar.q == 3) {
                            if (aVar3 == e.a.WRAP_CONTENT) {
                                a(eVar, e.a.WRAP_CONTENT, 0, e.a.WRAP_CONTENT, 0);
                            }
                            int n2 = eVar.n();
                            float f2 = eVar.Y;
                            if (eVar.t() == -1) {
                                f2 = 1.0f / f2;
                            }
                            e.a aVar6 = e.a.FIXED;
                            a(eVar, aVar6, n2, aVar6, (int) ((((float) n2) * f2) + 0.5f));
                            eVar.f2100i.f2069g.a(eVar.n());
                            eVar.j.f2069g.a(eVar.o());
                            eVar.f2096e = true;
                        } else if (eVar.q == 1) {
                            a(eVar, aVar3, 0, e.a.WRAP_CONTENT, 0);
                            eVar.j.f2069g.m = eVar.o();
                        } else if (eVar.q == 2) {
                            if (fVar.U[1] == e.a.FIXED || fVar.U[1] == e.a.MATCH_PARENT) {
                                androidx.constraintlayout.a.a.e eVar3 = eVar;
                                a(eVar3, aVar3, eVar.n(), e.a.FIXED, (int) ((eVar.x * ((float) fVar.o())) + 0.5f));
                                eVar.f2100i.f2069g.a(eVar.n());
                                eVar.j.f2069g.a(eVar.o());
                                eVar.f2096e = true;
                            }
                        } else if (eVar.R[2].f2087f == null || eVar.R[3].f2087f == null) {
                            a(eVar, e.a.WRAP_CONTENT, 0, aVar4, 0);
                            eVar.f2100i.f2069g.a(eVar.n());
                            eVar.j.f2069g.a(eVar.o());
                            eVar.f2096e = true;
                        }
                    }
                    if (aVar3 == e.a.MATCH_CONSTRAINT && aVar4 == e.a.MATCH_CONSTRAINT) {
                        if (eVar.p == 1 || eVar.q == 1) {
                            a(eVar, e.a.WRAP_CONTENT, 0, e.a.WRAP_CONTENT, 0);
                            eVar.f2100i.f2069g.m = eVar.n();
                            eVar.j.f2069g.m = eVar.o();
                        } else if (eVar.q == 2 && eVar.p == 2) {
                            if ((fVar.U[0] == e.a.FIXED || fVar.U[0] == e.a.FIXED) && (fVar.U[1] == e.a.FIXED || fVar.U[1] == e.a.FIXED)) {
                                float f3 = eVar.u;
                                float f4 = eVar.x;
                                int n3 = (int) ((f3 * ((float) fVar.n())) + 0.5f);
                                int o3 = (int) ((f4 * ((float) fVar.o())) + 0.5f);
                                e.a aVar7 = e.a.FIXED;
                                a(eVar, aVar7, n3, aVar7, o3);
                                eVar.f2100i.f2069g.a(eVar.n());
                                eVar.j.f2069g.a(eVar.o());
                                eVar.f2096e = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void a() {
        Iterator it2 = this.f2018a.bh.iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) it2.next();
            if (!eVar.f2096e) {
                boolean z = false;
                e.a aVar = eVar.U[0];
                e.a aVar2 = eVar.U[1];
                int i2 = eVar.p;
                int i3 = eVar.q;
                boolean z2 = aVar == e.a.WRAP_CONTENT || (aVar == e.a.MATCH_CONSTRAINT && i2 == 1);
                if (aVar2 == e.a.WRAP_CONTENT || (aVar2 == e.a.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                boolean z3 = eVar.f2100i.f2069g.j;
                boolean z4 = eVar.j.f2069g.j;
                if (z3 && z4) {
                    a(eVar, e.a.FIXED, eVar.f2100i.f2069g.f2033g, e.a.FIXED, eVar.j.f2069g.f2033g);
                    eVar.f2096e = true;
                } else if (z3 && z) {
                    a(eVar, e.a.FIXED, eVar.f2100i.f2069g.f2033g, e.a.WRAP_CONTENT, eVar.j.f2069g.f2033g);
                    if (aVar2 == e.a.MATCH_CONSTRAINT) {
                        eVar.j.f2069g.m = eVar.o();
                    } else {
                        eVar.j.f2069g.a(eVar.o());
                        eVar.f2096e = true;
                    }
                } else if (z4 && z2) {
                    a(eVar, e.a.WRAP_CONTENT, eVar.f2100i.f2069g.f2033g, e.a.FIXED, eVar.j.f2069g.f2033g);
                    if (aVar == e.a.MATCH_CONSTRAINT) {
                        eVar.f2100i.f2069g.m = eVar.n();
                    } else {
                        eVar.f2100i.f2069g.a(eVar.n());
                        eVar.f2096e = true;
                    }
                }
                if (eVar.f2096e && eVar.j.f2048b != null) {
                    eVar.j.f2048b.a(eVar.ag);
                }
            }
        }
    }

    public final void b() {
        a(this.f2022e);
        this.f2024g.clear();
        m.f2039a = 0;
        a(this.f2018a.f2100i, 0, this.f2024g);
        a(this.f2018a.j, 1, this.f2024g);
        this.f2019b = false;
    }

    private void a(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f2021d.f2100i.c();
        this.f2021d.j.c();
        arrayList.add(this.f2021d.f2100i);
        arrayList.add(this.f2021d.j);
        Iterator it2 = this.f2021d.bh.iterator();
        HashSet hashSet = null;
        while (it2.hasNext()) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) it2.next();
            if (eVar instanceof h) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.v()) {
                    if (eVar.f2098g == null) {
                        eVar.f2098g = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f2098g);
                } else {
                    arrayList.add(eVar.f2100i);
                }
                if (eVar.w()) {
                    if (eVar.f2099h == null) {
                        eVar.f2099h = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f2099h);
                } else {
                    arrayList.add(eVar.j);
                }
                if (eVar instanceof j) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            it3.next().c();
        }
        Iterator<p> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            p next = it4.next();
            if (next.f2066d != this.f2021d) {
                next.f();
            }
        }
    }

    private void a(f fVar, int i2, int i3, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f2030d;
        if (pVar.f2067e == null && pVar != this.f2018a.f2100i && pVar != this.f2018a.j) {
            if (mVar == null) {
                mVar = new m(pVar, i3);
                arrayList.add(mVar);
            }
            pVar.f2067e = mVar;
            mVar.f2044f.add(pVar);
            mVar.f2043e = pVar;
            for (d next : pVar.j.k) {
                if (next instanceof f) {
                    a((f) next, i2, 0, fVar2, arrayList, mVar);
                }
            }
            for (d next2 : pVar.k.k) {
                if (next2 instanceof f) {
                    a((f) next2, i2, 1, fVar2, arrayList, mVar);
                }
            }
            if (i2 == 1 && (pVar instanceof n)) {
                for (d next3 : ((n) pVar).f2047a.k) {
                    if (next3 instanceof f) {
                        a((f) next3, i2, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            for (f next4 : pVar.j.l) {
                if (next4 == fVar2) {
                    mVar.f2041c = true;
                }
                a(next4, i2, 0, fVar2, arrayList, mVar);
            }
            for (f next5 : pVar.k.l) {
                if (next5 == fVar2) {
                    mVar.f2041c = true;
                }
                a(next5, i2, 1, fVar2, arrayList, mVar);
            }
            if (i2 == 1 && (pVar instanceof n)) {
                for (f a2 : ((n) pVar).f2047a.l) {
                    a(a2, i2, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    private void a(p pVar, int i2, ArrayList<m> arrayList) {
        for (d next : pVar.j.k) {
            if (next instanceof f) {
                a((f) next, i2, 0, pVar.k, arrayList, (m) null);
            } else if (next instanceof p) {
                a(((p) next).j, i2, 0, pVar.k, arrayList, (m) null);
            }
        }
        for (d next2 : pVar.k.k) {
            if (next2 instanceof f) {
                a((f) next2, i2, 1, pVar.j, arrayList, (m) null);
            } else if (next2 instanceof p) {
                a(((p) next2).k, i2, 1, pVar.j, arrayList, (m) null);
            }
        }
        if (i2 == 1) {
            for (d next3 : ((n) pVar).f2047a.k) {
                if (next3 instanceof f) {
                    a((f) next3, i2, 2, (f) null, arrayList, (m) null);
                }
            }
        }
    }
}
