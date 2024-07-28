package io.reactivex.rxjava3.e.c;

public final class b<T> extends a<T> {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f46682a;

    public final void cancel() {
        this.f46682a = true;
    }

    public final void dispose() {
        this.f46682a = true;
    }

    public final boolean isDisposed() {
        return this.f46682a;
    }
}
