package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;

public final class bk<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47060a;

    public bk(u<T> uVar) {
        this.f47060a = uVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47060a.subscribe(wVar);
    }
}
