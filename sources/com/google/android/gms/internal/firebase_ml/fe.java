package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class fe<E> extends AbstractList<E> implements gq<E> {

    /* renamed from: a  reason: collision with root package name */
    boolean f9878a = true;

    fe() {
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
        e();
        return super.add(e2);
    }

    public void add(int i2, E e2) {
        e();
        super.add(i2, e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        e();
        return super.addAll(collection);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        e();
        return super.addAll(i2, collection);
    }

    public void clear() {
        e();
        super.clear();
    }

    public boolean c() {
        return this.f9878a;
    }

    public final void d() {
        this.f9878a = false;
    }

    public E remove(int i2) {
        e();
        return super.remove(i2);
    }

    public boolean remove(Object obj) {
        e();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        e();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        e();
        return super.retainAll(collection);
    }

    public E set(int i2, E e2) {
        e();
        return super.set(i2, e2);
    }

    /* access modifiers changed from: protected */
    public final void e() {
        if (!this.f9878a) {
            throw new UnsupportedOperationException();
        }
    }
}
