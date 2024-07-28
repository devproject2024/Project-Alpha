package kotlin.d.b.a;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;

public abstract class i extends a {
    public i(d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == g.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public f getContext() {
        return g.INSTANCE;
    }
}
