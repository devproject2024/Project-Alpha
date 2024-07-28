package io.reactivex.rxjava3.b;

final class f extends e<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    f(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    public final void onDisposed(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
