package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends AtomicReference<c> implements m<T>, c {
    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public b(g<? super T> gVar, g<? super Throwable> gVar2, a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void onSuccess(T t) {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            io.reactivex.rxjava3.h.a.a(th);
        }
    }

    public final void onError(Throwable th) {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.c.b.b(th2);
            io.reactivex.rxjava3.h.a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
        }
    }

    public final void onComplete() {
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            io.reactivex.rxjava3.h.a.a(th);
        }
    }

    public final boolean hasCustomOnError() {
        return this.onError != io.reactivex.rxjava3.e.b.a.f46650f;
    }
}
