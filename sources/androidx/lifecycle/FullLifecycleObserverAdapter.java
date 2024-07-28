package androidx.lifecycle;

import androidx.lifecycle.k;

class FullLifecycleObserverAdapter implements o {

    /* renamed from: a  reason: collision with root package name */
    private final g f3578a;

    /* renamed from: b  reason: collision with root package name */
    private final o f3579b;

    FullLifecycleObserverAdapter(g gVar, o oVar) {
        this.f3578a = gVar;
        this.f3579b = oVar;
    }

    public final void a(q qVar, k.a aVar) {
        switch (aVar) {
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                o oVar = this.f3579b;
                if (oVar != null) {
                    oVar.a(qVar, aVar);
                    return;
                }
                return;
        }
    }
}
