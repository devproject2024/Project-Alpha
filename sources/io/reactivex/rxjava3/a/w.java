package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.b.c;

public interface w<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(c cVar);
}
