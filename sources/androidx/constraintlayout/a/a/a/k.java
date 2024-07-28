package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a;
import androidx.constraintlayout.a.a.a.f;
import androidx.constraintlayout.a.a.e;

final class k extends p {
    /* access modifiers changed from: package-private */
    public final boolean a() {
        return false;
    }

    public k(e eVar) {
        super(eVar);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f2067e = null;
        this.j.a();
    }

    private void a(f fVar) {
        this.j.k.add(fVar);
        fVar.l.add(this.j);
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (this.f2066d instanceof a) {
            this.j.f2028b = true;
            a aVar = (a) this.f2066d;
            int i2 = aVar.f2000a;
            boolean z = aVar.f2001b;
            int i3 = 0;
            if (i2 == 0) {
                this.j.f2031e = f.a.LEFT;
                while (i3 < aVar.bb) {
                    e eVar = aVar.ba[i3];
                    if (z || eVar.an != 8) {
                        f fVar = eVar.f2100i.j;
                        fVar.k.add(this.j);
                        this.j.l.add(fVar);
                    }
                    i3++;
                }
                a(this.f2066d.f2100i.j);
                a(this.f2066d.f2100i.k);
            } else if (i2 == 1) {
                this.j.f2031e = f.a.RIGHT;
                while (i3 < aVar.bb) {
                    e eVar2 = aVar.ba[i3];
                    if (z || eVar2.an != 8) {
                        f fVar2 = eVar2.f2100i.k;
                        fVar2.k.add(this.j);
                        this.j.l.add(fVar2);
                    }
                    i3++;
                }
                a(this.f2066d.f2100i.j);
                a(this.f2066d.f2100i.k);
            } else if (i2 == 2) {
                this.j.f2031e = f.a.TOP;
                while (i3 < aVar.bb) {
                    e eVar3 = aVar.ba[i3];
                    if (z || eVar3.an != 8) {
                        f fVar3 = eVar3.j.j;
                        fVar3.k.add(this.j);
                        this.j.l.add(fVar3);
                    }
                    i3++;
                }
                a(this.f2066d.j.j);
                a(this.f2066d.j.k);
            } else if (i2 == 3) {
                this.j.f2031e = f.a.BOTTOM;
                while (i3 < aVar.bb) {
                    e eVar4 = aVar.ba[i3];
                    if (z || eVar4.an != 8) {
                        f fVar4 = eVar4.j.k;
                        fVar4.k.add(this.j);
                        this.j.l.add(fVar4);
                    }
                    i3++;
                }
                a(this.f2066d.j.j);
                a(this.f2066d.j.k);
            }
        }
    }

    public final void d() {
        a aVar = (a) this.f2066d;
        int i2 = aVar.f2000a;
        int i3 = -1;
        int i4 = 0;
        for (f fVar : this.j.l) {
            int i5 = fVar.f2033g;
            if (i3 == -1 || i5 < i3) {
                i3 = i5;
            }
            if (i4 < i5) {
                i4 = i5;
            }
        }
        if (i2 == 0 || i2 == 2) {
            this.j.a(i3 + aVar.f2002c);
        } else {
            this.j.a(i4 + aVar.f2002c);
        }
    }

    public final void e() {
        if (this.f2066d instanceof a) {
            int i2 = ((a) this.f2066d).f2000a;
            if (i2 == 0 || i2 == 1) {
                this.f2066d.e(this.j.f2033g);
            } else {
                this.f2066d.f(this.j.f2033g);
            }
        }
    }
}
