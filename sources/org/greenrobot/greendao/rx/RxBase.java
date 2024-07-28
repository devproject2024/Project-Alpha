package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import rx.Observable;
import rx.Scheduler;

class RxBase {
    protected final Scheduler scheduler;

    RxBase() {
        this.scheduler = null;
    }

    RxBase(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    /* access modifiers changed from: protected */
    public <R> Observable<R> wrap(Callable<R> callable) {
        return wrap(RxUtils.fromCallable(callable));
    }

    /* access modifiers changed from: protected */
    public <R> Observable<R> wrap(Observable<R> observable) {
        Scheduler scheduler2 = this.scheduler;
        return scheduler2 != null ? observable.subscribeOn(scheduler2) : observable;
    }
}
