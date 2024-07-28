package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class n extends AtomicReference<c> implements d, c {
    private static final long serialVersionUID = -7545121636549663526L;

    public final boolean hasCustomOnError() {
        return false;
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final void onComplete() {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
    }

    public final void onError(Throwable th) {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        a.a((Throwable) new io.reactivex.rxjava3.c.d(th));
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }
}
