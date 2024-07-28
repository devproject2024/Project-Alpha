package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import java.util.HashMap;

public final class h extends e {

    /* renamed from: a  reason: collision with root package name */
    protected float f2120a = -1.0f;
    public int aL;
    private int aM;
    private boolean aN;

    /* renamed from: b  reason: collision with root package name */
    protected int f2121b = -1;

    /* renamed from: c  reason: collision with root package name */
    protected int f2122c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d f2123d = this.K;

    public final boolean a() {
        return true;
    }

    public h() {
        this.aL = 0;
        this.aM = 0;
        this.S.clear();
        this.S.add(this.f2123d);
        int length = this.R.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.R[i2] = this.f2123d;
        }
    }

    public final void a(e eVar, HashMap<e, e> hashMap) {
        super.a(eVar, hashMap);
        h hVar = (h) eVar;
        this.f2120a = hVar.f2120a;
        this.f2121b = hVar.f2121b;
        this.f2122c = hVar.f2122c;
        o(hVar.aL);
    }

    public final void o(int i2) {
        if (this.aL != i2) {
            this.aL = i2;
            this.S.clear();
            if (this.aL == 1) {
                this.f2123d = this.J;
            } else {
                this.f2123d = this.K;
            }
            this.S.add(this.f2123d);
            int length = this.R.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.R[i3] = this.f2123d;
            }
        }
    }

    public final d a(d.a aVar) {
        switch (aVar) {
            case LEFT:
            case RIGHT:
                if (this.aL == 1) {
                    return this.f2123d;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.aL == 0) {
                    return this.f2123d;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(aVar.name());
    }

    public final void a(float f2) {
        if (f2 > -1.0f) {
            this.f2120a = f2;
            this.f2121b = -1;
            this.f2122c = -1;
        }
    }

    public final void p(int i2) {
        if (i2 >= 0) {
            this.f2120a = -1.0f;
            this.f2121b = i2;
            this.f2122c = -1;
        }
    }

    public final void q(int i2) {
        if (i2 >= 0) {
            this.f2120a = -1.0f;
            this.f2121b = -1;
            this.f2122c = i2;
        }
    }

    public final float d() {
        return this.f2120a;
    }

    public final int e() {
        return this.f2121b;
    }

    public final int y() {
        return this.f2122c;
    }

    public final void r(int i2) {
        this.f2123d.a(i2);
        this.aN = true;
    }

    public final boolean b() {
        return this.aN;
    }

    public final boolean c() {
        return this.aN;
    }

    public final void a(androidx.constraintlayout.a.d dVar, boolean z) {
        f fVar = (f) this.V;
        if (fVar != null) {
            d a2 = fVar.a(d.a.LEFT);
            d a3 = fVar.a(d.a.RIGHT);
            boolean z2 = this.V != null && this.V.U[0] == e.a.WRAP_CONTENT;
            if (this.aL == 0) {
                a2 = fVar.a(d.a.TOP);
                a3 = fVar.a(d.a.BOTTOM);
                z2 = this.V != null && this.V.U[1] == e.a.WRAP_CONTENT;
            }
            if (this.aN && this.f2123d.f2084c) {
                androidx.constraintlayout.a.h a4 = dVar.a((Object) this.f2123d);
                dVar.a(a4, this.f2123d.c());
                if (this.f2121b != -1) {
                    if (z2) {
                        dVar.a(dVar.a((Object) a3), a4, 0, 5);
                    }
                } else if (this.f2122c != -1 && z2) {
                    androidx.constraintlayout.a.h a5 = dVar.a((Object) a3);
                    dVar.a(a4, dVar.a((Object) a2), 0, 5);
                    dVar.a(a5, a4, 0, 5);
                }
                this.aN = false;
            } else if (this.f2121b != -1) {
                androidx.constraintlayout.a.h a6 = dVar.a((Object) this.f2123d);
                dVar.c(a6, dVar.a((Object) a2), this.f2121b, 8);
                if (z2) {
                    dVar.a(dVar.a((Object) a3), a6, 0, 5);
                }
            } else if (this.f2122c != -1) {
                androidx.constraintlayout.a.h a7 = dVar.a((Object) this.f2123d);
                androidx.constraintlayout.a.h a8 = dVar.a((Object) a3);
                dVar.c(a7, a8, -this.f2122c, 8);
                if (z2) {
                    dVar.a(a7, dVar.a((Object) a2), 0, 5);
                    dVar.a(a8, a7, 0, 5);
                }
            } else if (this.f2120a != -1.0f) {
                dVar.a(androidx.constraintlayout.a.d.a(dVar, dVar.a((Object) this.f2123d), dVar.a((Object) a3), this.f2120a));
            }
        }
    }

    public final void a(boolean z) {
        if (this.V != null) {
            int b2 = androidx.constraintlayout.a.d.b((Object) this.f2123d);
            if (this.aL == 1) {
                e(b2);
                f(0);
                h(this.V.o());
                g(0);
                return;
            }
            e(0);
            f(b2);
            g(this.V.n());
            h(0);
        }
    }
}
