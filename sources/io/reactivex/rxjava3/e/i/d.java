package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.h.a;

public final class d<T> extends c<T> {
    public final void onNext(T t) {
        if (this.f47727a == null) {
            this.f47727a = t;
            this.f47729c.cancel();
            countDown();
        }
    }

    public final void onError(Throwable th) {
        if (this.f47727a == null) {
            this.f47728b = th;
        } else {
            a.a(th);
        }
        countDown();
    }
}
