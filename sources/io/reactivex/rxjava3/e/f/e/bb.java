package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.c.b;

public final class bb<T> extends p<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    final a f47034a;

    public bb(a aVar) {
        this.f47034a = aVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        b bVar = new b();
        wVar.onSubscribe(bVar);
        if (!bVar.isDisposed()) {
            try {
                this.f47034a.run();
                if (!bVar.isDisposed()) {
                    wVar.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                if (!bVar.isDisposed()) {
                    wVar.onError(th);
                } else {
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }

    public final T get() throws Throwable {
        this.f47034a.run();
        return null;
    }
}
