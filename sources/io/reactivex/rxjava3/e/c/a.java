package io.reactivex.rxjava3.e.c;

public abstract class a<T> implements f<T>, h<T> {
    public void cancel() {
    }

    public final void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final T poll() throws Throwable {
        return null;
    }

    public final void request(long j) {
    }

    public final int requestFusion(int i2) {
        return i2 & 2;
    }

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
