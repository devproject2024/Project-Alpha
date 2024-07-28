package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.h;

public final class j extends p {
    /* access modifiers changed from: package-private */
    public final boolean a() {
        return false;
    }

    public j(e eVar) {
        super(eVar);
        eVar.f2100i.c();
        eVar.j.c();
        this.f2070h = ((h) eVar).aL;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.j.a();
    }

    private void a(f fVar) {
        this.j.k.add(fVar);
        fVar.l.add(this.j);
    }

    public final void d() {
        if (this.j.f2029c && !this.j.j) {
            this.j.a((int) ((((float) this.j.l.get(0).f2033g) * ((h) this.f2066d).d()) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        h hVar = (h) this.f2066d;
        int e2 = hVar.e();
        int y = hVar.y();
        if (hVar.aL == 1) {
            if (e2 != -1) {
                this.j.l.add(this.f2066d.V.f2100i.j);
                this.f2066d.V.f2100i.j.k.add(this.j);
                this.j.f2032f = e2;
            } else if (y != -1) {
                this.j.l.add(this.f2066d.V.f2100i.k);
                this.f2066d.V.f2100i.k.k.add(this.j);
                this.j.f2032f = -y;
            } else {
                this.j.f2028b = true;
                this.j.l.add(this.f2066d.V.f2100i.k);
                this.f2066d.V.f2100i.k.k.add(this.j);
            }
            a(this.f2066d.f2100i.j);
            a(this.f2066d.f2100i.k);
            return;
        }
        if (e2 != -1) {
            this.j.l.add(this.f2066d.V.j.j);
            this.f2066d.V.j.j.k.add(this.j);
            this.j.f2032f = e2;
        } else if (y != -1) {
            this.j.l.add(this.f2066d.V.j.k);
            this.f2066d.V.j.k.k.add(this.j);
            this.j.f2032f = -y;
        } else {
            this.j.f2028b = true;
            this.j.l.add(this.f2066d.V.j.k);
            this.f2066d.V.j.k.k.add(this.j);
        }
        a(this.f2066d.j.j);
        a(this.f2066d.j.k);
    }

    public final void e() {
        if (((h) this.f2066d).aL == 1) {
            this.f2066d.e(this.j.f2033g);
        } else {
            this.f2066d.f(this.j.f2033g);
        }
    }
}
