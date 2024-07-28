package io.reactivex.rxjava3.e.j;

import io.reactivex.rxjava3.e.c.h;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.b;

public final class e<T> extends AtomicInteger implements h<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;

    public final int requestFusion(int i2) {
        return i2 & 1;
    }

    public e(b<? super T> bVar, T t) {
        this.subscriber = bVar;
        this.value = t;
    }

    public final void request(long j) {
        if (g.validate(j) && compareAndSet(0, 1)) {
            b<? super T> bVar = this.subscriber;
            bVar.onNext(this.value);
            if (get() != 2) {
                bVar.onComplete();
            }
        }
    }

    public final void cancel() {
        lazySet(2);
    }

    public final boolean isCancelled() {
        return get() == 2;
    }

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    public final boolean isEmpty() {
        return get() != 0;
    }

    public final void clear() {
        lazySet(1);
    }
}
