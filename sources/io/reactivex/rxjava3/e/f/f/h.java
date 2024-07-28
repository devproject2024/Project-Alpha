package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.b.a;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class h<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f47599a;

    public h(Callable<? extends T> callable) {
        this.f47599a = callable;
    }

    public final void b(aa<? super T> aaVar) {
        c b2 = c.CC.b(a.f46646b);
        aaVar.onSubscribe(b2);
        if (!b2.isDisposed()) {
            try {
                Object requireNonNull = Objects.requireNonNull(this.f47599a.call(), "The callable returned a null value");
                if (!b2.isDisposed()) {
                    aaVar.onSuccess(requireNonNull);
                }
            } catch (Throwable th) {
                b.b(th);
                if (!b2.isDisposed()) {
                    aaVar.onError(th);
                } else {
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }
}
