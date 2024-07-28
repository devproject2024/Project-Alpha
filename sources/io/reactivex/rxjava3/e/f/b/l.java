package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.e.c.i;
import io.reactivex.rxjava3.e.j.e;
import org.a.b;

public final class l<T> extends h<T> implements i<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f46811b;

    public l(T t) {
        this.f46811b = t;
    }

    public final void b(b<? super T> bVar) {
        bVar.onSubscribe(new e(bVar, this.f46811b));
    }

    public final T get() {
        return this.f46811b;
    }
}
