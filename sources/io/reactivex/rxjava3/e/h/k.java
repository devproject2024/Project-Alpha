package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.h.a;

public final class k extends a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public final /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public k(Runnable runnable) {
        super(runnable);
    }

    public final void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            dispose();
            a.a(th);
            throw th;
        }
    }
}
