package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class k<T> extends AtomicReference<c> implements aa<T>, c {
    private static final long serialVersionUID = -7012088219455310787L;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public k(g<? super T> gVar, g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    public final void onError(Throwable th) {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            b.b(th2);
            a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
        }
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void onSuccess(T t) {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            b.b(th);
            a.a(th);
        }
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final boolean hasCustomOnError() {
        return this.onError != io.reactivex.rxjava3.e.b.a.f46650f;
    }
}
