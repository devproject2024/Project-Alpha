package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.e;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.CountDownLatch;

public final class h<T> extends CountDownLatch implements aa<T>, d, m<T> {

    /* renamed from: a  reason: collision with root package name */
    T f46723a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f46724b;

    /* renamed from: c  reason: collision with root package name */
    c f46725c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f46726d;

    public h() {
        super(1);
    }

    public final void onSubscribe(c cVar) {
        this.f46725c = cVar;
        if (this.f46726d) {
            cVar.dispose();
        }
    }

    public final void onSuccess(T t) {
        this.f46723a = t;
        countDown();
    }

    public final void onError(Throwable th) {
        this.f46724b = th;
        countDown();
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
                this.f46726d = true;
                c cVar = this.f46725c;
                if (cVar != null) {
                    cVar.dispose();
                }
                throw j.a((Throwable) e2);
            }
        }
        Throwable th = this.f46724b;
        if (th == null) {
            return this.f46723a;
        }
        throw j.a(th);
    }
}
