package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.c.b;
import io.reactivex.rxjava3.h.a;

public final class bi<T> extends p<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    final Runnable f47058a;

    public bi(Runnable runnable) {
        this.f47058a = runnable;
    }

    public final void subscribeActual(w<? super T> wVar) {
        b bVar = new b();
        wVar.onSubscribe(bVar);
        if (!bVar.isDisposed()) {
            try {
                this.f47058a.run();
                if (!bVar.isDisposed()) {
                    wVar.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                if (!bVar.isDisposed()) {
                    wVar.onError(th);
                } else {
                    a.a(th);
                }
            }
        }
    }

    public final T get() throws Throwable {
        this.f47058a.run();
        return null;
    }
}
