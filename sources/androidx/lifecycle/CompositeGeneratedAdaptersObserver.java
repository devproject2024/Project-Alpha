package androidx.lifecycle;

import androidx.lifecycle.k;

class CompositeGeneratedAdaptersObserver implements o {

    /* renamed from: a  reason: collision with root package name */
    private final h[] f3577a;

    CompositeGeneratedAdaptersObserver(h[] hVarArr) {
        this.f3577a = hVarArr;
    }

    public final void a(q qVar, k.a aVar) {
        x xVar = new x();
        for (h a2 : this.f3577a) {
            a2.a(aVar, false, xVar);
        }
        for (h a3 : this.f3577a) {
            a3.a(aVar, true, xVar);
        }
    }
}
