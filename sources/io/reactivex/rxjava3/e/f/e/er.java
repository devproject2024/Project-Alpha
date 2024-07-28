package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class er<T> extends AtomicReference<c> implements w<T>, c {
    private static final long serialVersionUID = -8612022020200669122L;
    final w<? super T> downstream;
    final AtomicReference<c> upstream = new AtomicReference<>();

    public er(w<? super T> wVar) {
        this.downstream = wVar;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public final void onNext(T t) {
        this.downstream.onNext(t);
    }

    public final void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    public final void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return this.upstream.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final void setResource(c cVar) {
        io.reactivex.rxjava3.e.a.c.set(this, cVar);
    }
}
