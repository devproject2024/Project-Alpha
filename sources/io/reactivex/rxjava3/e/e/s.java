package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.atomic.AtomicReference;

public final class s<T> extends AtomicReference<c> implements w<T>, c {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super c> onSubscribe;

    public s(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super c> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }

    public final void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                b.b(th);
                ((c) get()).dispose();
                onError(th);
            }
        }
    }

    public final void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                b.b(th2);
                io.reactivex.rxjava3.h.a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
            }
        } else {
            io.reactivex.rxjava3.h.a.a(th);
        }
    }

    public final void onComplete() {
        if (!isDisposed()) {
            lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
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
