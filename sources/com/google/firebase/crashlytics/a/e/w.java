package com.google.firebase.crashlytics.a.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class w<E> implements List<E>, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final List<E> f38573a;

    public static <E> w<E> a(E... eArr) {
        return new w<>(Arrays.asList(eArr));
    }

    public static <E> w<E> a(List<E> list) {
        return new w<>(list);
    }

    private w(List<E> list) {
        this.f38573a = Collections.unmodifiableList(list);
    }

    public final int size() {
        return this.f38573a.size();
    }

    public final boolean isEmpty() {
        return this.f38573a.isEmpty();
    }

    public final boolean contains(Object obj) {
        return this.f38573a.contains(obj);
    }

    public final Iterator<E> iterator() {
        return this.f38573a.iterator();
    }

    public final Object[] toArray() {
        return this.f38573a.toArray();
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.f38573a.toArray(tArr);
    }

    public final boolean add(E e2) {
        return this.f38573a.add(e2);
    }

    public final boolean remove(Object obj) {
        return this.f38573a.remove(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.f38573a.containsAll(collection);
    }

    public final boolean addAll(Collection<? extends E> collection) {
        return this.f38573a.addAll(collection);
    }

    public final boolean addAll(int i2, Collection<? extends E> collection) {
        return this.f38573a.addAll(i2, collection);
    }

    public final boolean removeAll(Collection<?> collection) {
        return this.f38573a.removeAll(collection);
    }

    public final boolean retainAll(Collection<?> collection) {
        return this.f38573a.retainAll(collection);
    }

    public final void clear() {
        this.f38573a.clear();
    }

    public final boolean equals(Object obj) {
        return this.f38573a.equals(obj);
    }

    public final int hashCode() {
        return this.f38573a.hashCode();
    }

    public final E get(int i2) {
        return this.f38573a.get(i2);
    }

    public final E set(int i2, E e2) {
        return this.f38573a.set(i2, e2);
    }

    public final void add(int i2, E e2) {
        this.f38573a.add(i2, e2);
    }

    public final E remove(int i2) {
        return this.f38573a.remove(i2);
    }

    public final int indexOf(Object obj) {
        return this.f38573a.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.f38573a.lastIndexOf(obj);
    }

    public final ListIterator<E> listIterator() {
        return this.f38573a.listIterator();
    }

    public final ListIterator<E> listIterator(int i2) {
        return this.f38573a.listIterator(i2);
    }

    public final List<E> subList(int i2, int i3) {
        return this.f38573a.subList(i2, i3);
    }
}
