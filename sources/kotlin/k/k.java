package kotlin.k;

import kotlin.g.a.b;
import kotlin.k.i;

public interface k<T, V> extends b<T, V>, i<V> {

    public interface a<T, V> extends b<T, V>, i.a<V> {
    }

    V get(T t);

    Object getDelegate(T t);

    a<T, V> getGetter();
}
