package io.reactivex.rxjava3.a;

public interface g<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
