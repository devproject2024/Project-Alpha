package io.reactivex.rxjava3.e.j;

import org.a.b;

public class c<T> extends a<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final b<? super T> downstream;
    protected T value;

    public c(b<? super T> bVar) {
        this.downstream = bVar;
    }

    public final void request(long j) {
        T t;
        if (g.validate(j)) {
            do {
                int i2 = get();
                if ((i2 & -2) == 0) {
                    if (i2 == 1) {
                        if (compareAndSet(1, 3) && (t = this.value) != null) {
                            this.value = null;
                            b<? super T> bVar = this.downstream;
                            bVar.onNext(t);
                            if (get() != 4) {
                                bVar.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final void complete(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & -3) == 0) {
                if (i2 == 2) {
                    lazySet(3);
                    b<? super T> bVar = this.downstream;
                    bVar.onNext(t);
                    if (get() != 4) {
                        bVar.onComplete();
                        return;
                    }
                    return;
                }
                this.value = t;
                if (!compareAndSet(0, 1)) {
                    i2 = get();
                    if (i2 == 4) {
                        this.value = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.value = t;
        lazySet(16);
        b<? super T> bVar2 = this.downstream;
        bVar2.onNext(t);
        if (get() != 4) {
            bVar2.onComplete();
        }
    }

    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
