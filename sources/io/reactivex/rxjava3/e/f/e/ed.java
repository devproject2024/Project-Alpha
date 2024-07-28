package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ed extends p<Long> {

    /* renamed from: a  reason: collision with root package name */
    final x f47387a;

    /* renamed from: b  reason: collision with root package name */
    final long f47388b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47389c;

    public ed(long j, TimeUnit timeUnit, x xVar) {
        this.f47388b = j;
        this.f47389c = timeUnit;
        this.f47387a = xVar;
    }

    public final void subscribeActual(w<? super Long> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        aVar.setResource(this.f47387a.a(aVar, this.f47388b, this.f47389c));
    }

    static final class a extends AtomicReference<c> implements c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final w<? super Long> downstream;

        a(w<? super Long> wVar) {
            this.downstream = wVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void run() {
            if (!isDisposed()) {
                this.downstream.onNext(0L);
                lazySet(d.INSTANCE);
                this.downstream.onComplete();
            }
        }

        public final void setResource(c cVar) {
            io.reactivex.rxjava3.e.a.c.trySet(this, cVar);
        }
    }
}
