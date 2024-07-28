package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public final class e<T> extends AtomicReference<c> implements k<T>, io.reactivex.rxjava3.b.c, c {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super c> onSubscribe;

    public e(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super c> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.j.g.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                b.b(th);
                cVar.cancel();
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
                ((c) get()).cancel();
                onError(th);
            }
        }
    }

    public final void onError(Throwable th) {
        if (get() != io.reactivex.rxjava3.e.j.g.CANCELLED) {
            lazySet(io.reactivex.rxjava3.e.j.g.CANCELLED);
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
        if (get() != io.reactivex.rxjava3.e.j.g.CANCELLED) {
            lazySet(io.reactivex.rxjava3.e.j.g.CANCELLED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
        }
    }

    public final void dispose() {
        cancel();
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.j.g.CANCELLED;
    }

    public final void request(long j) {
        ((c) get()).request(j);
    }

    public final void cancel() {
        io.reactivex.rxjava3.e.j.g.cancel(this);
    }

    public final boolean hasCustomOnError() {
        return this.onError != io.reactivex.rxjava3.e.b.a.f46650f;
    }
}
