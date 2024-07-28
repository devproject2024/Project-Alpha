package com.google.android.gms.internal.p001firebaseperf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.cj  reason: invalid package */
abstract class cj<E> extends AbstractList<E> implements dz<E> {

    /* renamed from: a  reason: collision with root package name */
    boolean f9521a = true;

    cj() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public boolean add(E e2) {
        c();
        return super.add(e2);
    }

    public void add(int i2, E e2) {
        c();
        super.add(i2, e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        c();
        return super.addAll(collection);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        c();
        return super.addAll(i2, collection);
    }

    public void clear() {
        c();
        super.clear();
    }

    public boolean a() {
        return this.f9521a;
    }

    public final void b() {
        this.f9521a = false;
    }

    public E remove(int i2) {
        c();
        return super.remove(i2);
    }

    public boolean remove(Object obj) {
        c();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        c();
        return super.retainAll(collection);
    }

    public E set(int i2, E e2) {
        c();
        return super.set(i2, e2);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!this.f9521a) {
            throw new UnsupportedOperationException();
        }
    }
}
