package kotlin.d.b.a;

import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.b.k;

public abstract class d extends a {
    private final f _context;
    private transient kotlin.d.d<Object> intercepted;

    public d(kotlin.d.d<Object> dVar, f fVar) {
        super(dVar);
        this._context = fVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(kotlin.d.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    public f getContext() {
        f fVar = this._context;
        k.a((Object) fVar);
        return fVar;
    }

    public final kotlin.d.d<Object> intercepted() {
        kotlin.d.d<Object> dVar = this.intercepted;
        if (dVar == null) {
            e eVar = (e) getContext().get(e.f47904a);
            if (eVar == null || (dVar = eVar.interceptContinuation(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        kotlin.d.d<Object> dVar = this.intercepted;
        if (!(dVar == null || dVar == this)) {
            f.b bVar = getContext().get(e.f47904a);
            k.a((Object) bVar);
            ((e) bVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = c.f47897a;
    }
}
