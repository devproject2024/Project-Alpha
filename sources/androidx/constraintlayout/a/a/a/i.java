package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.h;
import androidx.constraintlayout.a.a.j;
import java.util.ArrayList;

public final class i {
    public static boolean a(e.a aVar, e.a aVar2, e.a aVar3, e.a aVar4) {
        return (aVar3 == e.a.FIXED || aVar3 == e.a.WRAP_CONTENT || (aVar3 == e.a.MATCH_PARENT && aVar != e.a.WRAP_CONTENT)) || (aVar4 == e.a.FIXED || aVar4 == e.a.WRAP_CONTENT || (aVar4 == e.a.MATCH_PARENT && aVar2 != e.a.WRAP_CONTENT));
    }

    public static o a(ArrayList<o> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = arrayList.get(i3);
            if (i2 == oVar.f2052c) {
                return oVar;
            }
        }
        return null;
    }

    public static o a(e eVar, int i2, ArrayList<o> arrayList, o oVar) {
        int i3;
        int o;
        if (i2 == 0) {
            i3 = eVar.aJ;
        } else {
            i3 = eVar.aK;
        }
        int i4 = 0;
        if (i3 != -1 && (oVar == null || i3 != oVar.f2052c)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i5);
                if (oVar2.f2052c == i3) {
                    if (oVar != null) {
                        oVar.a(i2, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i5++;
                }
            }
        } else if (i3 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof j) && (o = ((j) eVar).o(i2)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i6);
                    if (oVar3.f2052c == o) {
                        oVar = oVar3;
                        break;
                    }
                    i6++;
                }
            }
            if (oVar == null) {
                oVar = new o(i2);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                d dVar = hVar.f2123d;
                if (hVar.aL == 0) {
                    i4 = 1;
                }
                dVar.a(i4, arrayList, oVar);
            }
            if (i2 == 0) {
                eVar.aJ = oVar.f2052c;
                eVar.J.a(i2, arrayList, oVar);
                eVar.L.a(i2, arrayList, oVar);
            } else {
                eVar.aK = oVar.f2052c;
                eVar.K.a(i2, arrayList, oVar);
                eVar.N.a(i2, arrayList, oVar);
                eVar.M.a(i2, arrayList, oVar);
            }
            eVar.Q.a(i2, arrayList, oVar);
        }
        return oVar;
    }
}
