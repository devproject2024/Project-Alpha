package com.google.android.gms.internal.p001firebaseperf;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.fn  reason: invalid package */
final class fn<E> extends cj<E> {

    /* renamed from: b  reason: collision with root package name */
    private static final fn<Object> f9635b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f9636c;

    public static <E> fn<E> d() {
        return f9635b;
    }

    fn() {
        this(new ArrayList(10));
    }

    private fn(List<E> list) {
        this.f9636c = list;
    }

    public final void add(int i2, E e2) {
        c();
        this.f9636c.add(i2, e2);
        this.modCount++;
    }

    public final E get(int i2) {
        return this.f9636c.get(i2);
    }

    public final E remove(int i2) {
        c();
        E remove = this.f9636c.remove(i2);
        this.modCount++;
        return remove;
    }

    public final E set(int i2, E e2) {
        c();
        E e3 = this.f9636c.set(i2, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f9636c.size();
    }

    public final /* synthetic */ dz d(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9636c);
            return new fn(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        fn<Object> fnVar = new fn<>(new ArrayList(0));
        f9635b = fnVar;
        fnVar.f9521a = false;
    }
}
