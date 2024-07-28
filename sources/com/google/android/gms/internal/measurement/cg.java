package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class cg<E> extends AbstractList<E> implements ed<E> {

    /* renamed from: a  reason: collision with root package name */
    boolean f10522a = true;

    cg() {
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
        r_();
        return super.add(e2);
    }

    public void add(int i2, E e2) {
        r_();
        super.add(i2, e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        r_();
        return super.addAll(collection);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        r_();
        return super.addAll(i2, collection);
    }

    public void clear() {
        r_();
        super.clear();
    }

    public boolean a() {
        return this.f10522a;
    }

    public final void b() {
        this.f10522a = false;
    }

    public E remove(int i2) {
        r_();
        return super.remove(i2);
    }

    public boolean remove(Object obj) {
        r_();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        r_();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        r_();
        return super.retainAll(collection);
    }

    public E set(int i2, E e2) {
        r_();
        return super.set(i2, e2);
    }

    /* access modifiers changed from: protected */
    public final void r_() {
        if (!this.f10522a) {
            throw new UnsupportedOperationException();
        }
    }
}
