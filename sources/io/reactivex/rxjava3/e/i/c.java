package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.e;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.CountDownLatch;

public abstract class c<T> extends CountDownLatch implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    T f47727a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f47728b;

    /* renamed from: c  reason: collision with root package name */
    org.a.c f47729c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f47730d;

    public c() {
        super(1);
    }

    public final void onSubscribe(org.a.c cVar) {
        if (g.validate(this.f47729c, cVar)) {
            this.f47729c = cVar;
            if (!this.f47730d) {
                cVar.request(Long.MAX_VALUE);
                if (this.f47730d) {
                    this.f47729c = g.CANCELLED;
                    cVar.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                e.a();
                await();
            } catch (InterruptedException e2) {
                org.a.c cVar = this.f47729c;
                this.f47729c = g.CANCELLED;
                if (cVar != null) {
                    cVar.cancel();
                }
                throw j.a((Throwable) e2);
            }
        }
        Throwable th = this.f47728b;
        if (th == null) {
            return this.f47727a;
        }
        throw j.a(th);
    }
}
