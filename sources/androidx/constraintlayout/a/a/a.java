package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.b;
import androidx.constraintlayout.a.d;
import androidx.constraintlayout.a.h;
import java.util.HashMap;

public final class a extends j {

    /* renamed from: a  reason: collision with root package name */
    public int f2000a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2001b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f2002c = 0;

    /* renamed from: d  reason: collision with root package name */
    boolean f2003d = false;

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return this.f2003d;
    }

    public final boolean c() {
        return this.f2003d;
    }

    public final void a(e eVar, HashMap<e, e> hashMap) {
        super.a(eVar, hashMap);
        a aVar = (a) eVar;
        this.f2000a = aVar.f2000a;
        this.f2001b = aVar.f2001b;
        this.f2002c = aVar.f2002c;
    }

    public final String toString() {
        String str = "[Barrier] " + this.ao + " {";
        for (int i2 = 0; i2 < this.bb; i2++) {
            e eVar = this.ba[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + eVar.ao;
        }
        return str + "}";
    }

    public final void a(d dVar, boolean z) {
        boolean z2;
        int i2;
        int i3;
        this.R[0] = this.J;
        this.R[2] = this.K;
        this.R[1] = this.L;
        this.R[3] = this.M;
        for (int i4 = 0; i4 < this.R.length; i4++) {
            this.R[i4].f2090i = dVar.a((Object) this.R[i4]);
        }
        int i5 = this.f2000a;
        if (i5 >= 0 && i5 < 4) {
            d dVar2 = this.R[this.f2000a];
            if (!this.f2003d) {
                e();
            }
            if (this.f2003d) {
                this.f2003d = false;
                int i6 = this.f2000a;
                if (i6 == 0 || i6 == 1) {
                    dVar.a(this.J.f2090i, this.aa);
                    dVar.a(this.L.f2090i, this.aa);
                } else if (i6 == 2 || i6 == 3) {
                    dVar.a(this.K.f2090i, this.ab);
                    dVar.a(this.M.f2090i, this.ab);
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.bb) {
                        z2 = false;
                        break;
                    }
                    e eVar = this.ba[i7];
                    if ((this.f2001b || eVar.a()) && ((((i2 = this.f2000a) == 0 || i2 == 1) && eVar.U[0] == e.a.MATCH_CONSTRAINT && eVar.J.f2087f != null && eVar.L.f2087f != null) || (((i3 = this.f2000a) == 2 || i3 == 3) && eVar.U[1] == e.a.MATCH_CONSTRAINT && eVar.K.f2087f != null && eVar.M.f2087f != null))) {
                        z2 = true;
                    } else {
                        i7++;
                    }
                }
                z2 = true;
                boolean z3 = this.J.b() || this.L.b();
                boolean z4 = this.K.b() || this.M.b();
                boolean z5 = !z2 && ((this.f2000a == 0 && z3) || ((this.f2000a == 2 && z4) || ((this.f2000a == 1 && z3) || (this.f2000a == 3 && z4))));
                int i8 = 5;
                if (!z5) {
                    i8 = 4;
                }
                for (int i9 = 0; i9 < this.bb; i9++) {
                    e eVar2 = this.ba[i9];
                    if (this.f2001b || eVar2.a()) {
                        h a2 = dVar.a((Object) eVar2.R[this.f2000a]);
                        eVar2.R[this.f2000a].f2090i = a2;
                        int i10 = (eVar2.R[this.f2000a].f2087f == null || eVar2.R[this.f2000a].f2087f.f2085d != this) ? 0 : eVar2.R[this.f2000a].f2088g + 0;
                        int i11 = this.f2000a;
                        if (i11 == 0 || i11 == 2) {
                            b c2 = dVar.c();
                            h d2 = dVar.d();
                            d2.f2169d = 0;
                            c2.b(dVar2.f2090i, a2, d2, this.f2002c - i10);
                            dVar.a(c2);
                        } else {
                            b c3 = dVar.c();
                            h d3 = dVar.d();
                            d3.f2169d = 0;
                            c3.a(dVar2.f2090i, a2, d3, this.f2002c + i10);
                            dVar.a(c3);
                        }
                        dVar.c(dVar2.f2090i, a2, this.f2002c + i10, i8);
                    }
                }
                int i12 = this.f2000a;
                if (i12 == 0) {
                    dVar.c(this.L.f2090i, this.J.f2090i, 0, 8);
                    dVar.c(this.J.f2090i, this.V.L.f2090i, 0, 4);
                    dVar.c(this.J.f2090i, this.V.J.f2090i, 0, 0);
                } else if (i12 == 1) {
                    dVar.c(this.J.f2090i, this.L.f2090i, 0, 8);
                    dVar.c(this.J.f2090i, this.V.J.f2090i, 0, 4);
                    dVar.c(this.J.f2090i, this.V.L.f2090i, 0, 0);
                } else if (i12 == 2) {
                    dVar.c(this.M.f2090i, this.K.f2090i, 0, 8);
                    dVar.c(this.K.f2090i, this.V.M.f2090i, 0, 4);
                    dVar.c(this.K.f2090i, this.V.K.f2090i, 0, 0);
                } else if (i12 == 3) {
                    dVar.c(this.K.f2090i, this.M.f2090i, 0, 8);
                    dVar.c(this.K.f2090i, this.V.K.f2090i, 0, 4);
                    dVar.c(this.K.f2090i, this.V.M.f2090i, 0, 0);
                }
            }
        }
    }

    public final int d() {
        int i2 = this.f2000a;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    public final boolean e() {
        int i2;
        int i3;
        boolean z = true;
        for (int i4 = 0; i4 < this.bb; i4++) {
            e eVar = this.ba[i4];
            if ((this.f2001b || eVar.a()) && ((((i2 = this.f2000a) == 0 || i2 == 1) && !eVar.b()) || (((i3 = this.f2000a) == 2 || i3 == 3) && !eVar.c()))) {
                z = false;
            }
        }
        if (!z || this.bb <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.bb; i6++) {
            e eVar2 = this.ba[i6];
            if (this.f2001b || eVar2.a()) {
                if (!z2) {
                    int i7 = this.f2000a;
                    if (i7 == 0) {
                        i5 = eVar2.a(d.a.LEFT).c();
                    } else if (i7 == 1) {
                        i5 = eVar2.a(d.a.RIGHT).c();
                    } else if (i7 == 2) {
                        i5 = eVar2.a(d.a.TOP).c();
                    } else if (i7 == 3) {
                        i5 = eVar2.a(d.a.BOTTOM).c();
                    }
                    z2 = true;
                }
                int i8 = this.f2000a;
                if (i8 == 0) {
                    i5 = Math.min(i5, eVar2.a(d.a.LEFT).c());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, eVar2.a(d.a.RIGHT).c());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, eVar2.a(d.a.TOP).c());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, eVar2.a(d.a.BOTTOM).c());
                }
            }
        }
        int i9 = i5 + this.f2002c;
        int i10 = this.f2000a;
        if (i10 == 0 || i10 == 1) {
            a(i9, i9);
        } else {
            b(i9, i9);
        }
        this.f2003d = true;
        return true;
    }
}
