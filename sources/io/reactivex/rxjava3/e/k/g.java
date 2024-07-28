package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.h.a;
import org.a.b;

public enum g implements aa<Object>, d, k<Object>, m<Object>, w<Object>, c, org.a.c {
    INSTANCE;

    public final void cancel() {
    }

    public final void dispose() {
    }

    public final boolean isDisposed() {
        return true;
    }

    public final void onComplete() {
    }

    public final void onNext(Object obj) {
    }

    public final void onSuccess(Object obj) {
    }

    public final void request(long j) {
    }

    public static <T> b<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> w<T> asObserver() {
        return INSTANCE;
    }

    public final void onSubscribe(c cVar) {
        cVar.dispose();
    }

    public final void onSubscribe(org.a.c cVar) {
        cVar.cancel();
    }

    public final void onError(Throwable th) {
        a.a(th);
    }
}
