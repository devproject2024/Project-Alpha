package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.h.a;
import java.util.concurrent.Callable;

public final class l extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public final /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public l(Runnable runnable) {
        super(runnable);
    }

    public final Void call() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            lazySet(FINISHED);
            this.runner = null;
            return null;
        } catch (Throwable th) {
            a.a(th);
            throw th;
        }
    }
}
