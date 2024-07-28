package kotlin.d;

import java.io.Serializable;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;

public final class g implements Serializable, f {
    public static final g INSTANCE = new g();
    private static final long serialVersionUID = 0;

    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        k.d(mVar, "operation");
        return r;
    }

    public final <E extends f.b> E get(f.c<E> cVar) {
        k.d(cVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final f plus(f fVar) {
        k.d(fVar, "context");
        return fVar;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    private g() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public final f minusKey(f.c<?> cVar) {
        k.d(cVar, "key");
        return this;
    }
}
