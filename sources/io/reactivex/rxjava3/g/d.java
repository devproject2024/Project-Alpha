package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.h;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d<T> implements aa<T>, c {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<c> f47751a = new AtomicReference<>();

    public final void onSubscribe(c cVar) {
        h.a(this.f47751a, cVar, getClass());
    }

    public final boolean isDisposed() {
        return this.f47751a.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this.f47751a);
    }
}
