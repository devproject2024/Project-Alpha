package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.h.a;

public class l<T> extends b<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final w<? super T> downstream;
    protected T value;

    public l(w<? super T> wVar) {
        this.downstream = wVar;
    }

    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void complete(T t) {
        int i2 = get();
        if ((i2 & 54) == 0) {
            w<? super T> wVar = this.downstream;
            if (i2 == 8) {
                this.value = t;
                lazySet(16);
                wVar.onNext(null);
            } else {
                lazySet(2);
                wVar.onNext(t);
            }
            if (get() != 4) {
                wVar.onComplete();
            }
        }
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            a.a(th);
            return;
        }
        lazySet(2);
        this.downstream.onError(th);
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.downstream.onComplete();
        }
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final boolean isDisposed() {
        return get() == 4;
    }
}
