package kotlin.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.g.b.a.a;

public final class v implements ListIterator, a {

    /* renamed from: a  reason: collision with root package name */
    public static final v f47892a = new v();

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext() {
        return false;
    }

    public final boolean hasPrevious() {
        return false;
    }

    public final int nextIndex() {
        return 0;
    }

    public final int previousIndex() {
        return -1;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private v() {
    }

    public final /* synthetic */ Object next() {
        throw new NoSuchElementException();
    }

    public final /* synthetic */ Object previous() {
        throw new NoSuchElementException();
    }
}
