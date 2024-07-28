package io.reactivex.rxjava3.e.e;

public interface r<T> {
    void drain();

    void innerComplete(q<T> qVar);

    void innerError(q<T> qVar, Throwable th);

    void innerNext(q<T> qVar, T t);
}
