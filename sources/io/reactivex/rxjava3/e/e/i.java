package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.m;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class i<T> extends AtomicReference<c> implements w<T>, c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public i(Queue<Object> queue2) {
        this.queue = queue2;
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void onNext(T t) {
        this.queue.offer(m.next(t));
    }

    public final void onError(Throwable th) {
        this.queue.offer(m.error(th));
    }

    public final void onComplete() {
        this.queue.offer(m.complete());
    }

    public final void dispose() {
        if (io.reactivex.rxjava3.e.a.c.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }
}
