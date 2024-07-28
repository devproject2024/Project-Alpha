package kotlin.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.g.b.k;

public abstract class d<E> extends a<E> implements List<E>, kotlin.g.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f47881a = new a((byte) 0);

    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int i2);

    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected d() {
    }

    public Iterator<E> iterator() {
        return new b();
    }

    public ListIterator<E> listIterator() {
        return new c(0);
    }

    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }

    public List<E> subList(int i2, int i3) {
        return new C0831d<>(this, i2, i3);
    }

    /* renamed from: kotlin.a.d$d  reason: collision with other inner class name */
    static final class C0831d<E> extends d<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private int f47885b;

        /* renamed from: c  reason: collision with root package name */
        private final d<E> f47886c;

        /* renamed from: d  reason: collision with root package name */
        private final int f47887d;

        public C0831d(d<? extends E> dVar, int i2, int i3) {
            k.d(dVar, "list");
            this.f47886c = dVar;
            this.f47887d = i2;
            int i4 = this.f47887d;
            int size = this.f47886c.size();
            if (i4 < 0 || i3 > size) {
                throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i3 + ", size: " + size);
            } else if (i4 <= i3) {
                this.f47885b = i3 - this.f47887d;
            } else {
                throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i3);
            }
        }

        public final E get(int i2) {
            a.a(i2, this.f47885b);
            return this.f47886c.get(this.f47887d + i2);
        }

        public final int a() {
            return this.f47885b;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection<Object> collection = this;
        Collection collection2 = (Collection) obj;
        k.d(collection, "c");
        k.d(collection2, "other");
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator it2 = collection2.iterator();
        for (Object a2 : collection) {
            if (!k.a(a2, it2.next())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Collection collection = this;
        k.d(collection, "c");
        Iterator it2 = collection.iterator();
        int i2 = 1;
        while (it2.hasNext()) {
            Object next = it2.next();
            i2 = (i2 * 31) + (next != null ? next.hashCode() : 0);
        }
        return i2;
    }

    class b implements Iterator<E>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        int f47882a;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public b() {
        }

        public boolean hasNext() {
            return this.f47882a < d.this.size();
        }

        public E next() {
            if (hasNext()) {
                d dVar = d.this;
                int i2 = this.f47882a;
                this.f47882a = i2 + 1;
                return dVar.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    class c extends d<E>.defpackage.b implements ListIterator<E>, kotlin.g.b.a.a {
        public final void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public c(int i2) {
            super();
            a aVar = d.f47881a;
            int size = d.this.size();
            if (i2 < 0 || i2 > size) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + size);
            }
            this.f47882a = i2;
        }

        public final E previous() {
            if (hasPrevious()) {
                this.f47882a--;
                return d.this.get(this.f47882a);
            }
            throw new NoSuchElementException();
        }

        public final boolean hasPrevious() {
            return this.f47882a > 0;
        }

        public final int nextIndex() {
            return this.f47882a;
        }

        public final int previousIndex() {
            return this.f47882a - 1;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }
    }

    public int indexOf(Object obj) {
        int i2 = 0;
        for (Object a2 : this) {
            if (k.a(a2, obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (k.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
