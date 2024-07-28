package io.reactivex.rxjava3.e.a;

import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class f extends AtomicReference<c> implements c {
    private static final long serialVersionUID = -754898800686245608L;

    public f() {
    }

    public f(c cVar) {
        lazySet(cVar);
    }

    public final boolean update(c cVar) {
        return c.set(this, cVar);
    }

    public final boolean replace(c cVar) {
        return c.replace(this, cVar);
    }

    public final void dispose() {
        c.dispose(this);
    }

    public final boolean isDisposed() {
        return c.isDisposed((c) get());
    }
}
