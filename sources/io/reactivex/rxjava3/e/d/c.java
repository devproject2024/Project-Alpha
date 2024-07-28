package io.reactivex.rxjava3.e.d;

import java.util.NoSuchElementException;

public final class c<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f46693a;

    /* renamed from: b  reason: collision with root package name */
    final T f46694b;

    public c(boolean z, T t) {
        this.f46693a = z;
        this.f46694b = t;
    }

    public final void onNext(T t) {
        complete(t);
    }

    public final void onComplete() {
        if (!isDone()) {
            a();
            if (this.f46693a) {
                complete(this.f46694b);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}
