package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

abstract class j<T> extends CompletableFuture<T> implements w<T> {

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<c> f46712c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    T f46713d;

    j() {
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this.f46712c, cVar);
    }

    public final void onError(Throwable th) {
        a();
        if (!completeExceptionally(th)) {
            a.a(th);
        }
    }

    private void b() {
        io.reactivex.rxjava3.e.a.c.dispose(this.f46712c);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.f46713d = null;
        this.f46712c.lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
    }

    public final boolean cancel(boolean z) {
        b();
        return super.cancel(z);
    }

    public final boolean complete(T t) {
        b();
        return super.complete(t);
    }

    public final boolean completeExceptionally(Throwable th) {
        b();
        return super.completeExceptionally(th);
    }
}
