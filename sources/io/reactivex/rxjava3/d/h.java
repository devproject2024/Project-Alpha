package io.reactivex.rxjava3.d;

@FunctionalInterface
public interface h<T, R> {
    R apply(T t) throws Throwable;
}
