package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.List;

final class dp<E> extends ap<E> {

    /* renamed from: b  reason: collision with root package name */
    private static final dp<Object> f10168b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f10169c;

    public static <E> dp<E> d() {
        return f10168b;
    }

    dp() {
        this(new ArrayList(10));
    }

    private dp(List<E> list) {
        this.f10169c = list;
    }

    public final void add(int i2, E e2) {
        c();
        this.f10169c.add(i2, e2);
        this.modCount++;
    }

    public final E get(int i2) {
        return this.f10169c.get(i2);
    }

    public final E remove(int i2) {
        c();
        E remove = this.f10169c.remove(i2);
        this.modCount++;
        return remove;
    }

    public final E set(int i2, E e2) {
        c();
        E e3 = this.f10169c.set(i2, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f10169c.size();
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f10169c);
            return new dp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        dp<Object> dpVar = new dp<>(new ArrayList(0));
        f10168b = dpVar;
        dpVar.f10058a = false;
    }
}
