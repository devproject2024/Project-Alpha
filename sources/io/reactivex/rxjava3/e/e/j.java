package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.atomic.AtomicReference;

public final class j extends AtomicReference<c> implements d, c, g<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final g<? super Throwable> onError;

    public j(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public j(g<? super Throwable> gVar, a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }

    public final void accept(Throwable th) {
        io.reactivex.rxjava3.h.a.a((Throwable) new io.reactivex.rxjava3.c.d(th));
    }

    public final void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            b.b(th);
            io.reactivex.rxjava3.h.a.a(th);
        }
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
    }

    public final void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            b.b(th2);
            io.reactivex.rxjava3.h.a.a(th2);
        }
        lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final boolean hasCustomOnError() {
        return this.onError != this;
    }
}
