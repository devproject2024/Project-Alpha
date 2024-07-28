package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.e.l;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.Callable;

public final class bd<T> extends p<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f47041a;

    public bd(Callable<? extends T> callable) {
        this.f47041a = callable;
    }

    public final void subscribeActual(w<? super T> wVar) {
        l lVar = new l(wVar);
        wVar.onSubscribe(lVar);
        if (!lVar.isDisposed()) {
            try {
                lVar.complete(j.a(this.f47041a.call(), "Callable returned a null value."));
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
        return j.a(this.f47041a.call(), "The Callable returned a null value.");
    }
}
