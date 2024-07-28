package io.reactivex.rxjava3.e.a;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.c.f;

public enum d implements f<Object> {
    INSTANCE,
    NEVER;

    public final void clear() {
    }

    public final void dispose() {
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

    public final boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(w<?> wVar) {
        wVar.onSubscribe(INSTANCE);
        wVar.onComplete();
    }

    public static void complete(m<?> mVar) {
        mVar.onSubscribe(INSTANCE);
        mVar.onComplete();
    }

    public static void error(Throwable th, w<?> wVar) {
        wVar.onSubscribe(INSTANCE);
        wVar.onError(th);
    }

    public static void complete(io.reactivex.rxjava3.a.d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th, io.reactivex.rxjava3.a.d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th);
    }

    public static void error(Throwable th, aa<?> aaVar) {
        aaVar.onSubscribe(INSTANCE);
        aaVar.onError(th);
    }

    public static void error(Throwable th, m<?> mVar) {
        mVar.onSubscribe(INSTANCE);
        mVar.onError(th);
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
