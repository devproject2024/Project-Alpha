package kotlin.a;

import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.f;
import kotlin.g.b.k;
import kotlin.g.b.l;

public abstract class a<E> implements Collection<E>, kotlin.g.b.a.a {
    public abstract int a();

    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected a() {
    }

    public final int size() {
        return a();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
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

    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: kotlin.a.a$a  reason: collision with other inner class name */
    static final class C0830a extends l implements b<E, CharSequence> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0830a(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final CharSequence invoke(E e2) {
            return e2 == this.this$0 ? "(this Collection)" : String.valueOf(e2);
        }
    }

    public String toString() {
        return k.a((Iterable) this, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (b) new C0830a(this), 24);
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        k.d(tArr, "array");
        T[] a2 = f.a(this, tArr);
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object a2 : this) {
            if (k.a(a2, obj)) {
                return true;
            }
        }
        return false;
    }
}
