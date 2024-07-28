package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a.f;

public class g extends f {
    public int m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f2031e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f2031e = f.a.VERTICAL_DIMENSION;
        }
    }

    public final void a(int i2) {
        if (!this.j) {
            this.j = true;
            this.f2033g = i2;
            for (d d2 : this.k) {
                d2.d();
            }
        }
    }
}
