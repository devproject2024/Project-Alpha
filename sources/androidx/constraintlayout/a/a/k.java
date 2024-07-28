package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.d;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f2125a = new boolean[3];

    public static final boolean a(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    static void a(f fVar, d dVar, e eVar) {
        eVar.n = -1;
        eVar.o = -1;
        if (fVar.U[0] != e.a.WRAP_CONTENT && eVar.U[0] == e.a.MATCH_PARENT) {
            int i2 = eVar.J.f2088g;
            int n = fVar.n() - eVar.L.f2088g;
            eVar.J.f2090i = dVar.a((Object) eVar.J);
            eVar.L.f2090i = dVar.a((Object) eVar.L);
            dVar.a(eVar.J.f2090i, i2);
            dVar.a(eVar.L.f2090i, n);
            eVar.n = 2;
            eVar.e(i2, n);
        }
        if (fVar.U[1] != e.a.WRAP_CONTENT && eVar.U[1] == e.a.MATCH_PARENT) {
            int i3 = eVar.K.f2088g;
            int o = fVar.o() - eVar.M.f2088g;
            eVar.K.f2090i = dVar.a((Object) eVar.K);
            eVar.M.f2090i = dVar.a((Object) eVar.M);
            dVar.a(eVar.K.f2090i, i3);
            dVar.a(eVar.M.f2090i, o);
            if (eVar.ag > 0 || eVar.an == 8) {
                eVar.N.f2090i = dVar.a((Object) eVar.N);
                dVar.a(eVar.N.f2090i, eVar.ag + i3);
            }
            eVar.o = 2;
            eVar.f(i3, o);
        }
    }
}
