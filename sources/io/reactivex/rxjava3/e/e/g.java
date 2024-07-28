package io.reactivex.rxjava3.e.e;

public final class g<T> extends e<T> {
    public final void onNext(T t) {
        this.f46719a = t;
    }

    public final void onError(Throwable th) {
        this.f46719a = null;
        this.f46720b = th;
        countDown();
    }
}
