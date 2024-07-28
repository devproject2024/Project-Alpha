package kotlin.a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.g.b.b;
import kotlin.g.b.f;
import kotlin.g.b.k;

final class e<T> implements Collection<T>, a {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f47888a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47889b;

    public final boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final <T> T[] toArray(T[] tArr) {
        return f.a(this, tArr);
    }

    public e(T[] tArr, boolean z) {
        k.d(tArr, "values");
        this.f47888a = tArr;
        this.f47889b = z;
    }

    public final boolean isEmpty() {
        return this.f47888a.length == 0;
    }

    public final boolean contains(Object obj) {
        return f.a(this.f47888a, obj);
    }

    public final boolean containsAll(Collection<? extends Object> collection) {
        k.d(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<T> iterator() {
        return b.a(this.f47888a);
    }

    public final Object[] toArray() {
        T[] tArr = this.f47888a;
        boolean z = this.f47889b;
        k.d(tArr, "$this$copyToArrayOfAny");
        if (!z || !k.a((Object) tArr.getClass(), (Object) Object[].class)) {
            tArr = Arrays.copyOf(tArr, tArr.length, Object[].class);
        }
        k.b(tArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return tArr;
    }

    public final /* bridge */ int size() {
        return this.f47888a.length;
    }
}
