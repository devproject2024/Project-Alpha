package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.b.c;

public interface m<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(c cVar);

    void onSuccess(T t);
}
