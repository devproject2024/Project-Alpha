package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.b.a;
import java.util.concurrent.Callable;

public final class h extends b {

    /* renamed from: a  reason: collision with root package name */
    final Callable<?> f46753a;

    public h(Callable<?> callable) {
        this.f46753a = callable;
    }

    public final void b(d dVar) {
        c b2 = c.CC.b(a.f46646b);
        dVar.onSubscribe(b2);
        try {
            this.f46753a.call();
            if (!b2.isDisposed()) {
                dVar.onComplete();
            }
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            if (!b2.isDisposed()) {
                dVar.onError(th);
            } else {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }
    }
}
