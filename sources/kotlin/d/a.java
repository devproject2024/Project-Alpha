package kotlin.d;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;

public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> cVar) {
        k.d(cVar, "key");
        this.key = cVar;
    }

    public <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        k.d(mVar, "operation");
        return f.b.a.a(this, r, mVar);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        k.d(cVar, "key");
        return f.b.a.a((f.b) this, cVar);
    }

    public f.c<?> getKey() {
        return this.key;
    }

    public f minusKey(f.c<?> cVar) {
        k.d(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    public f plus(f fVar) {
        k.d(fVar, "context");
        return f.b.a.a((f.b) this, fVar);
    }
}
