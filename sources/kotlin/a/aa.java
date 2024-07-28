package kotlin.a;

import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.k;

public final class aa<T> implements Iterable<z<? extends T>>, a {

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.g.a.a<Iterator<T>> f47868a;

    public aa(kotlin.g.a.a<? extends Iterator<? extends T>> aVar) {
        k.d(aVar, "iteratorFactory");
        this.f47868a = aVar;
    }

    public final Iterator<z<T>> iterator() {
        return new ab<>(this.f47868a.invoke());
    }
}
