package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.g.b;
import java.util.concurrent.atomic.AtomicReference;

public final class q<T> extends AtomicReference<c> implements w<T>, c {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final r<T> parent;
    final int prefetch;
    k<T> queue;

    public q(r<T> rVar, int i2) {
        this.parent = rVar;
        this.prefetch = i2;
    }

    public final void onSubscribe(c cVar) {
        k<T> kVar;
        if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
            if (cVar instanceof f) {
                f fVar = (f) cVar;
                int requestFusion = fVar.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = fVar;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = fVar;
                    return;
                }
            }
            int i2 = -this.prefetch;
            if (i2 < 0) {
                kVar = new io.reactivex.rxjava3.e.g.c<>(-i2);
            } else {
                kVar = new b<>(i2);
            }
            this.queue = kVar;
        }
    }

    public final void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    public final void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    public final void onComplete() {
        this.parent.innerComplete(this);
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
    }

    public final boolean isDone() {
        return this.done;
    }

    public final void setDone() {
        this.done = true;
    }

    public final k<T> queue() {
        return this.queue;
    }
}
