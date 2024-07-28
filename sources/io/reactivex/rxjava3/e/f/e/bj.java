package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.e.l;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.h.a;

public final class bj<T> extends p<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends T> f47059a;

    public bj(r<? extends T> rVar) {
        this.f47059a = rVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        l lVar = new l(wVar);
        wVar.onSubscribe(lVar);
        if (!lVar.isDisposed()) {
            try {
                lVar.complete(j.a(this.f47059a.get(), "Supplier returned a null value."));
            } catch (Throwable th) {
                b.b(th);
                if (!lVar.isDisposed()) {
                    wVar.onError(th);
                } else {
                    a.a(th);
                }
            }
        }
    }

    public final T get() throws Throwable {
        return j.a(this.f47059a.get(), "The supplier returned a null value.");
    }
}
