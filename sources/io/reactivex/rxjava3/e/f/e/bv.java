package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.c.i;
import io.reactivex.rxjava3.e.f.e.db;

public final class bv<T> extends p<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f47127a;

    public bv(T t) {
        this.f47127a = t;
    }

    public final void subscribeActual(w<? super T> wVar) {
        db.a aVar = new db.a(wVar, this.f47127a);
        wVar.onSubscribe(aVar);
        aVar.run();
    }

    public final T get() {
        return this.f47127a;
    }
}
