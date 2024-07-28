package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.a.b;
import androidx.constraintlayout.a.a.e;

public class l extends j {

    /* renamed from: a  reason: collision with root package name */
    private int f2126a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2127b = 0;
    public int bc = 0;
    public int bd = 0;
    public int be = 0;
    public int bf = 0;
    public int bg = 0;
    public int bh = 0;
    public boolean bi = false;
    public int bj = 0;
    public int bk = 0;
    protected b.a bl = new b.a();
    b.C0030b bm = null;

    public void a(int i2, int i3, int i4, int i5) {
    }

    public final void p(int i2) {
        this.f2126a = i2;
        this.bc = i2;
        this.f2127b = i2;
        this.bd = i2;
        this.be = i2;
        this.bf = i2;
    }

    public final void q(int i2) {
        this.f2126a = i2;
        this.bg = i2;
    }

    public final void r(int i2) {
        this.f2127b = i2;
        this.bh = i2;
    }

    public final void b_() {
        d();
    }

    public final void d() {
        for (int i2 = 0; i2 < this.bb; i2++) {
            e eVar = this.ba[i2];
            if (eVar != null) {
                eVar.G = true;
            }
        }
    }

    public final void g(int i2, int i3) {
        this.bj = i2;
        this.bk = i3;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        b.C0030b y = this.V != null ? ((f) this.V).y() : null;
        if (y == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.bb) {
                return true;
            }
            e eVar = this.ba[i2];
            if (eVar != null && !(eVar instanceof h)) {
                e.a l = eVar.l(0);
                e.a l2 = eVar.l(1);
                if (l != e.a.MATCH_CONSTRAINT || eVar.p == 1 || l2 != e.a.MATCH_CONSTRAINT || eVar.q == 1) {
                    z = false;
                }
                if (!z) {
                    if (l == e.a.MATCH_CONSTRAINT) {
                        l = e.a.WRAP_CONTENT;
                    }
                    if (l2 == e.a.MATCH_CONSTRAINT) {
                        l2 = e.a.WRAP_CONTENT;
                    }
                    b.a aVar = this.bl;
                    aVar.f2010d = l;
                    aVar.f2011e = l2;
                    aVar.f2012f = eVar.n();
                    this.bl.f2013g = eVar.o();
                    y.a(eVar, this.bl);
                    eVar.g(this.bl.f2014h);
                    eVar.h(this.bl.f2015i);
                    eVar.k(this.bl.j);
                }
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(e eVar, e.a aVar, int i2, e.a aVar2, int i3) {
        while (this.bm == null && this.V != null) {
            this.bm = ((f) this.V).y();
        }
        b.a aVar3 = this.bl;
        aVar3.f2010d = aVar;
        aVar3.f2011e = aVar2;
        aVar3.f2012f = i2;
        aVar3.f2013g = i3;
        this.bm.a(eVar, aVar3);
        eVar.g(this.bl.f2014h);
        eVar.h(this.bl.f2015i);
        eVar.E = this.bl.k;
        eVar.k(this.bl.j);
    }
}
