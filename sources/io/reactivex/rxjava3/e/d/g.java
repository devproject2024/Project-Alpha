package io.reactivex.rxjava3.e.d;

import java.util.NoSuchElementException;

public final class g<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f46705a;

    /* renamed from: b  reason: collision with root package name */
    final T f46706b;

    public g(boolean z, T t) {
        this.f46705a = z;
        this.f46706b = t;
    }

    public final void onNext(T t) {
        this.f46713d = t;
    }

    public final void onComplete() {
        if (!isDone()) {
            Object obj = this.f46713d;
            a();
            if (obj != null) {
                complete(obj);
            } else if (this.f46705a) {
                complete(this.f46706b);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}
