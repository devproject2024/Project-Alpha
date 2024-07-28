package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.b;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T> extends AtomicReference<c> implements aa<T>, c {
    private static final long serialVersionUID = 4943102778943297569L;
    final b<? super T, ? super Throwable> onCallback;

    public d(b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    public final void onError(Throwable th) {
        try {
            lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
            this.onCallback.accept(null, th);
        } catch (Throwable th2) {
            io.reactivex.rxjava3.c.b.b(th2);
            a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
        }
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
    }

    public final void onSuccess(T t) {
        try {
            lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
            this.onCallback.accept(t, null);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            a.a(th);
        }
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this);
    }

    public final boolean isDisposed() {
        return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }
}
