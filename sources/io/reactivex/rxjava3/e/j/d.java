package io.reactivex.rxjava3.e.j;

import io.reactivex.rxjava3.e.c.h;
import org.a.b;

public enum d implements h<Object> {
    INSTANCE;

    public final void cancel() {
    }

    public final void clear() {
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Object poll() {
        return null;
    }

    public final int requestFusion(int i2) {
        return i2 & 2;
    }

    public final String toString() {
        return "EmptySubscription";
    }

    public final void request(long j) {
        g.validate(j);
    }

    public static void error(Throwable th, b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
