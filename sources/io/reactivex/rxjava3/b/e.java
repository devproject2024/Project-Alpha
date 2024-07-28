package io.reactivex.rxjava3.b;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

abstract class e<T> extends AtomicReference<T> implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    /* access modifiers changed from: protected */
    public abstract void onDisposed(T t);

    e(T t) {
        super(Objects.requireNonNull(t, "value is null"));
    }

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            onDisposed(andSet);
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
