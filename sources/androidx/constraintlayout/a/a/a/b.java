package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<e> f2004a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public f f2005b;

    /* renamed from: c  reason: collision with root package name */
    private a f2006c = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f2007a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f2008b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f2009c = 2;

        /* renamed from: d  reason: collision with root package name */
        public e.a f2010d;

        /* renamed from: e  reason: collision with root package name */
        public e.a f2011e;

        /* renamed from: f  reason: collision with root package name */
        public int f2012f;

        /* renamed from: g  reason: collision with root package name */
        public int f2013g;

        /* renamed from: h  reason: collision with root package name */
        public int f2014h;

        /* renamed from: i  reason: collision with root package name */
        public int f2015i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    /* renamed from: androidx.constraintlayout.a.a.a.b$b  reason: collision with other inner class name */
    public interface C0030b {
        void a();

        void a(e eVar, a aVar);
    }

    public final void a(f fVar) {
        this.f2004a.clear();
        int size = fVar.bh.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = (e) fVar.bh.get(i2);
            if (eVar.U[0] == e.a.MATCH_CONSTRAINT || eVar.U[1] == e.a.MATCH_CONSTRAINT) {
                this.f2004a.add(eVar);
            }
        }
        fVar.d();
    }

    public b(f fVar) {
        this.f2005b = fVar;
    }

    public final void a(f fVar, int i2, int i3) {
        int p = fVar.p();
        int q = fVar.q();
        fVar.i(0);
        fVar.j(0);
        fVar.g(i2);
        fVar.h(i3);
        fVar.i(p);
        fVar.j(q);
        this.f2005b.z();
    }

    public final boolean a(C0030b bVar, e eVar, int i2) {
        this.f2006c.f2010d = eVar.U[0];
        this.f2006c.f2011e = eVar.U[1];
        this.f2006c.f2012f = eVar.n();
        this.f2006c.f2013g = eVar.o();
        a aVar = this.f2006c;
        aVar.l = false;
        aVar.m = i2;
        boolean z = aVar.f2010d == e.a.MATCH_CONSTRAINT;
        boolean z2 = this.f2006c.f2011e == e.a.MATCH_CONSTRAINT;
        boolean z3 = z && eVar.Y > 0.0f;
        boolean z4 = z2 && eVar.Y > 0.0f;
        if (z3 && eVar.r[0] == 4) {
            this.f2006c.f2010d = e.a.FIXED;
        }
        if (z4 && eVar.r[1] == 4) {
            this.f2006c.f2011e = e.a.FIXED;
        }
        bVar.a(eVar, this.f2006c);
        eVar.g(this.f2006c.f2014h);
        eVar.h(this.f2006c.f2015i);
        eVar.E = this.f2006c.k;
        eVar.k(this.f2006c.j);
        this.f2006c.m = a.f2007a;
        return this.f2006c.l;
    }
}
