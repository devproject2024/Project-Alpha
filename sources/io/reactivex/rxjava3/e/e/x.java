package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class x<T> implements aa<T> {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<c> f46740a;

    /* renamed from: b  reason: collision with root package name */
    final aa<? super T> f46741b;

    public x(AtomicReference<c> atomicReference, aa<? super T> aaVar) {
        this.f46740a = atomicReference;
        this.f46741b = aaVar;
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.replace(this.f46740a, cVar);
    }

    public final void onSuccess(T t) {
        this.f46741b.onSuccess(t);
    }

    public final void onError(Throwable th) {
        this.f46741b.onError(th);
    }
}
