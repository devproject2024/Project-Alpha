package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import java.util.ArrayList;

public class m extends e {
    public ArrayList<e> bh = new ArrayList<>();

    public void j() {
        this.bh.clear();
        super.j();
    }

    public final void a(e eVar) {
        this.bh.add(eVar);
        if (eVar.V != null) {
            ((m) eVar.V).b(eVar);
        }
        eVar.V = this;
    }

    public final void b(e eVar) {
        this.bh.remove(eVar);
        eVar.j();
    }

    public void z() {
        ArrayList<e> arrayList = this.bh;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.bh.get(i2);
                if (eVar instanceof m) {
                    ((m) eVar).z();
                }
            }
        }
    }

    public final void a(c cVar) {
        super.a(cVar);
        int size = this.bh.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bh.get(i2).a(cVar);
        }
    }
}
