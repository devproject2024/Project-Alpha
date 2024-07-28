package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.e.l;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class bf<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final Future<? extends T> f47045a;

    /* renamed from: b  reason: collision with root package name */
    final long f47046b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47047c;

    public bf(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f47045a = future;
        this.f47046b = j;
        this.f47047c = timeUnit;
    }

    public final void subscribeActual(w<? super T> wVar) {
        l lVar = new l(wVar);
        wVar.onSubscribe(lVar);
        if (!lVar.isDisposed()) {
            try {
                lVar.complete(j.a(this.f47047c != null ? this.f47045a.get(this.f47046b, this.f47047c) : this.f47045a.get(), "Future returned a null value."));
            } catch (Throwable th) {
                b.b(th);
                if (!lVar.isDisposed()) {
                    wVar.onError(th);
                }
            }
        }
    }
}
