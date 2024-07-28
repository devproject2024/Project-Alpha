package io.reactivex.rxjava3.e.k;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class r<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public r() {
        this.list = new ArrayList<>();
    }

    public r(int i2) {
        this.list = new ArrayList<>(i2);
    }

    public final int size() {
        return get();
    }

    public final boolean isEmpty() {
        return get() == 0;
    }

    public final boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public final Iterator<T> iterator() {
        return this.list.iterator();
    }

    public final Object[] toArray() {
        return this.list.toArray();
    }

    public final <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    public final boolean add(T t) {
        boolean add = this.list.add(t);
        lazySet(this.list.size());
        return add;
    }

    public final boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public final boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    public final boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i2, collection);
        lazySet(this.list.size());
        return addAll;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    public final void clear() {
        this.list.clear();
        lazySet(0);
    }

    public final T get(int i2) {
        return this.list.get(i2);
    }

    public final T set(int i2, T t) {
        return this.list.set(i2, t);
    }

    public final void add(int i2, T t) {
        this.list.add(i2, t);
        lazySet(this.list.size());
    }

    public final T remove(int i2) {
        T remove = this.list.remove(i2);
        lazySet(this.list.size());
        return remove;
    }

    public final int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public final ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public final ListIterator<T> listIterator(int i2) {
        return this.list.listIterator(i2);
    }

    public final List<T> subList(int i2, int i3) {
        return this.list.subList(i2, i3);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.list.equals(((r) obj).list);
        }
        return this.list.equals(obj);
    }

    public final int hashCode() {
        return this.list.hashCode();
    }

    public final String toString() {
        return this.list.toString();
    }
}
