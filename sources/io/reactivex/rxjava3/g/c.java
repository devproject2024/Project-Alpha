package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.k.h;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c<T> implements w<T>, io.reactivex.rxjava3.b.c {
    final AtomicReference<io.reactivex.rxjava3.b.c> upstream = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
        if (h.a(this.upstream, cVar, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.upstream.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
    }
}
