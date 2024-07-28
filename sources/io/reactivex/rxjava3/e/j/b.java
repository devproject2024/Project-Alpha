package io.reactivex.rxjava3.e.j;

import io.reactivex.rxjava3.e.c.h;
import java.util.concurrent.atomic.AtomicLong;

public abstract class b<T> extends AtomicLong implements h<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
