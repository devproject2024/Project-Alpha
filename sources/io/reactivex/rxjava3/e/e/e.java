package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.CountDownLatch;

public abstract class e<T> extends CountDownLatch implements w<T>, c {

    /* renamed from: a  reason: collision with root package name */
    T f46719a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f46720b;

    /* renamed from: c  reason: collision with root package name */
    c f46721c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f46722d;

    public e() {
        super(1);
    }

    public final void onSubscribe(c cVar) {
        this.f46721c = cVar;
        if (this.f46722d) {
            cVar.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.f46722d = true;
        c cVar = this.f46721c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f46722d;
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.rxjava3.e.k.e.a();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw j.a((Throwable) e2);
            }
        }
        Throwable th = this.f46720b;
        if (th == null) {
            return this.f46719a;
        }
        throw j.a(th);
    }
}
