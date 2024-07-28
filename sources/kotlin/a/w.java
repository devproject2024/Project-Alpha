package kotlin.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.g.b.a.a;
import kotlin.g.b.f;
import kotlin.g.b.k;

public final class w implements Serializable, List, RandomAccess, a {
    public static final w INSTANCE = new w();
    private static final long serialVersionUID = -7390468764508069838L;

    public final /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void add(int i2, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean add(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int i2, Collection collection) {
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
        return 1;
    }

    public final int indexOf(Void voidR) {
        k.d(voidR, "element");
        return -1;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final int lastIndexOf(Void voidR) {
        k.d(voidR, "element");
        return -1;
    }

    public final Void remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public final /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Void set(int i2, Void voidR) {
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

    private w() {
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return contains((Void) obj);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return indexOf((Void) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return lastIndexOf((Void) obj);
    }

    public final int size() {
        return getSize();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public final boolean containsAll(Collection collection) {
        k.d(collection, "elements");
        return collection.isEmpty();
    }

    public final Void get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
    }

    public final Iterator iterator() {
        return v.f47892a;
    }

    public final ListIterator listIterator() {
        return v.f47892a;
    }

    public final ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return v.f47892a;
        }
        throw new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i2)));
    }

    public final List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
