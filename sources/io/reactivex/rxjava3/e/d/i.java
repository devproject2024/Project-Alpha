package io.reactivex.rxjava3.e.d;

import java.util.NoSuchElementException;

public final class i<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f46710a;

    /* renamed from: b  reason: collision with root package name */
    final T f46711b;

    public i(boolean z, T t) {
        this.f46710a = z;
        this.f46711b = t;
    }

    public final void onNext(T t) {
        if (this.f46713d != null) {
            this.f46713d = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.f46713d = t;
    }

    public final void onComplete() {
        if (!isDone()) {
            Object obj = this.f46713d;
            a();
            if (obj != null) {
                complete(obj);
            } else if (this.f46710a) {
                complete(this.f46711b);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}
