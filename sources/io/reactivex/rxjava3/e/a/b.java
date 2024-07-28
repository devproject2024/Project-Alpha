package io.reactivex.rxjava3.e.a;

import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.f;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends AtomicReference<f> implements c {
    private static final long serialVersionUID = 5718521705281392066L;

    public b(f fVar) {
        super(fVar);
    }

    public final boolean isDisposed() {
        return get() == null;
    }

    public final void dispose() {
        f fVar;
        if (get() != null && (fVar = (f) getAndSet((Object) null)) != null) {
            try {
                fVar.cancel();
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                a.a(th);
            }
        }
    }
}
