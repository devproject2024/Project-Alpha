package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;

public final class f<T> extends AtomicInteger implements k<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final b<? super T> downstream;
    final io.reactivex.rxjava3.e.k.c error = new io.reactivex.rxjava3.e.k.c();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<c> upstream = new AtomicReference<>();

    public f(b<? super T> bVar) {
        this.downstream = bVar;
    }

    public final void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was ".concat(String.valueOf(j))));
            return;
        }
        g.deferredRequest(this.upstream, this.requested, j);
    }

    public final void cancel() {
        if (!this.done) {
            g.cancel(this.upstream);
        }
    }

    public final void onSubscribe(c cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            g.deferredSetOnce(this.upstream, this.requested, cVar);
            return;
        }
        cVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public final void onNext(T t) {
        b<? super T> bVar = this.downstream;
        io.reactivex.rxjava3.e.k.c cVar = this.error;
        if (get() == 0 && compareAndSet(0, 1)) {
            bVar.onNext(t);
            if (decrementAndGet() != 0) {
                cVar.tryTerminateConsumer((b<?>) bVar);
            }
        }
    }

    public final void onError(Throwable th) {
        this.done = true;
        b<? super T> bVar = this.downstream;
        io.reactivex.rxjava3.e.k.c cVar = this.error;
        if (cVar.tryAddThrowableOrReport(th) && getAndIncrement() == 0) {
            cVar.tryTerminateConsumer((b<?>) bVar);
        }
    }

    public final void onComplete() {
        this.done = true;
        b<? super T> bVar = this.downstream;
        io.reactivex.rxjava3.e.k.c cVar = this.error;
        if (getAndIncrement() == 0) {
            cVar.tryTerminateConsumer((b<?>) bVar);
        }
    }
}
