package io.reactivex.rxjava3.e.h;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class c implements Future<Object> {

    /* renamed from: a  reason: collision with root package name */
    final io.reactivex.rxjava3.b.c f47646a;

    public final Object get() {
        return null;
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return null;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    c(io.reactivex.rxjava3.b.c cVar) {
        this.f47646a = cVar;
    }

    public final boolean cancel(boolean z) {
        this.f47646a.dispose();
        return false;
    }
}
