package io.reactivex.rxjava3.e.e;

public final class f<T> extends e<T> {
    public final void onNext(T t) {
        if (this.f46719a == null) {
            this.f46719a = t;
            this.f46721c.dispose();
            countDown();
        }
    }

    public final void onError(Throwable th) {
        if (this.f46719a == null) {
            this.f46720b = th;
        }
        countDown();
    }
}
