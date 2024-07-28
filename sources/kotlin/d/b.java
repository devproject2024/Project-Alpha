package kotlin.d;

import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.g.b.k;

public abstract class b<B extends f.b, E extends B> implements f.c<E> {
    private final kotlin.g.a.b<f.b, E> safeCast;
    private final f.c<?> topmostKey;

    public b(f.c<B> cVar, kotlin.g.a.b<? super f.b, ? extends E> bVar) {
        k.d(cVar, "baseKey");
        k.d(bVar, "safeCast");
        this.safeCast = bVar;
        this.topmostKey = cVar instanceof b ? ((b) cVar).topmostKey : cVar;
    }

    public final E tryCast$kotlin_stdlib(f.b bVar) {
        k.d(bVar, "element");
        return (f.b) this.safeCast.invoke(bVar);
    }

    public final boolean isSubKey$kotlin_stdlib(f.c<?> cVar) {
        k.d(cVar, "key");
        return cVar == this || this.topmostKey == cVar;
    }
}
