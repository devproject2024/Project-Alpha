package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.e.c.f;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<T> extends AtomicInteger implements f<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
