package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.b.a;
import java.util.concurrent.Callable;

public final class d<T> extends l<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f46851a;

    public d(Callable<? extends T> callable) {
        this.f46851a = callable;
    }

    public final T get() throws Exception {
        return this.f46851a.call();
    }

    public final void b(m<? super T> mVar) {
        c b2 = c.CC.b(a.f46646b);
        mVar.onSubscribe(b2);
        if (!b2.isDisposed()) {
            try {
                Object call = this.f46851a.call();
                if (b2.isDisposed()) {
                    return;
                }
                if (call == null) {
                    mVar.onComplete();
                } else {
                    mVar.onSuccess(call);
                }
            } catch (Throwable th) {
                b.b(th);
                if (!b2.isDisposed()) {
                    mVar.onError(th);
                } else {
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }
}
