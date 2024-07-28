package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.e.a.d;

public final class j<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f47601a;

    public j(T t) {
        this.f47601a = t;
    }

    public final void b(aa<? super T> aaVar) {
        aaVar.onSubscribe(d.INSTANCE);
        aaVar.onSuccess(this.f47601a);
    }
}
