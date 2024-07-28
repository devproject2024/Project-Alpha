package io.reactivex.rxjava3.a;

public interface z<T> {
    boolean isDisposed();

    void onError(Throwable th);

    void onSuccess(T t);

    boolean tryOnError(Throwable th);
}
