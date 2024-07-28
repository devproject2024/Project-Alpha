package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.a.i;
import androidx.constraintlayout.a.a.a.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class j extends e implements i {
    public e[] ba = new e[4];
    public int bb = 0;

    public void b_() {
    }

    public final void a(e eVar) {
        if (eVar != this && eVar != null) {
            int i2 = this.bb + 1;
            e[] eVarArr = this.ba;
            if (i2 > eVarArr.length) {
                this.ba = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            }
            e[] eVarArr2 = this.ba;
            int i3 = this.bb;
            eVarArr2[i3] = eVar;
            this.bb = i3 + 1;
        }
    }

    public void a(e eVar, HashMap<e, e> hashMap) {
        super.a(eVar, hashMap);
        j jVar = (j) eVar;
        this.bb = 0;
        int i2 = jVar.bb;
        for (int i3 = 0; i3 < i2; i3++) {
            a(hashMap.get(jVar.ba[i3]));
        }
    }

    public final void g() {
        this.bb = 0;
        Arrays.fill(this.ba, (Object) null);
    }

    public final void a(ArrayList<o> arrayList, int i2, o oVar) {
        for (int i3 = 0; i3 < this.bb; i3++) {
            oVar.a(this.ba[i3]);
        }
        for (int i4 = 0; i4 < this.bb; i4++) {
            i.a(this.ba[i4], i2, arrayList, oVar);
        }
    }

    public final int o(int i2) {
        for (int i3 = 0; i3 < this.bb; i3++) {
            e eVar = this.ba[i3];
            if (i2 == 0 && eVar.aJ != -1) {
                return eVar.aJ;
            }
            if (i2 == 1 && eVar.aK != -1) {
                return eVar.aK;
            }
        }
        return -1;
    }
}
