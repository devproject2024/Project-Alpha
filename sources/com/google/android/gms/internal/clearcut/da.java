package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.List;

final class da<E> extends u<E> {

    /* renamed from: b  reason: collision with root package name */
    private static final da<Object> f9266b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f9267c;

    da() {
        this(new ArrayList(10));
    }

    private da(List<E> list) {
        this.f9267c = list;
    }

    public static <E> da<E> d() {
        return f9266b;
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9267c);
            return new da(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void add(int i2, E e2) {
        c();
        this.f9267c.add(i2, e2);
        this.modCount++;
    }

    public final E get(int i2) {
        return this.f9267c.get(i2);
    }

    public final E remove(int i2) {
        c();
        E remove = this.f9267c.remove(i2);
        this.modCount++;
        return remove;
    }

    public final E set(int i2, E e2) {
        c();
        E e3 = this.f9267c.set(i2, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f9267c.size();
    }

    static {
        da<Object> daVar = new da<>();
        f9266b = daVar;
        daVar.f9429a = false;
    }
}
