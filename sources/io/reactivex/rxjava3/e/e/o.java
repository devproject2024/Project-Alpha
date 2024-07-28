package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.q;
import java.util.concurrent.atomic.AtomicReference;

public final class o<T> extends AtomicReference<c> implements w<T>, c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final a onComplete;
    final g<? super Throwable> onError;
    final q<? super T> onNext;

    public o(q<? super T> qVar, g<? super Throwable> gVar, a aVar) {
        this.onNext = qVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void onNext(T t) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                b.b(th);
                dispose();
                onError(th);
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.done) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            b.b(th2);
            io.reactivex.rxjava3.h.a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
        }
    }

    public final void onComplete() {
        if (!this.done) {
            this.done = true;
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
        return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
    }
}
