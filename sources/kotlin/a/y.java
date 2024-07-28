package kotlin.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.a.a;
import kotlin.g.b.f;
import kotlin.g.b.k;

public final class y implements Serializable, Set, a {
    public static final y INSTANCE = new y();
    private static final long serialVersionUID = 3406603774387020532L;

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean add(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Void voidR) {
        k.d(voidR, "element");
        return false;
    }

    public final int getSize() {
        return 0;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object[] toArray() {
        return f.a(this);
    }

    public final <T> T[] toArray(T[] tArr) {
        return f.a(this, tArr);
    }

    public final String toString() {
        return "[]";
    }

    private y() {
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return contains((Void) obj);
    }

    public final int size() {
        return getSize();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public final boolean containsAll(Collection collection) {
        k.d(collection, "elements");
        return collection.isEmpty();
    }

    public final Iterator iterator() {
        return v.f47892a;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
