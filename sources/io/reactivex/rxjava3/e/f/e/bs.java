package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class bs extends p<Long> {

    /* renamed from: a  reason: collision with root package name */
    final x f47113a;

    /* renamed from: b  reason: collision with root package name */
    final long f47114b;

    /* renamed from: c  reason: collision with root package name */
    final long f47115c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f47116d;

    public bs(long j, long j2, TimeUnit timeUnit, x xVar) {
        this.f47114b = j;
        this.f47115c = j2;
        this.f47116d = timeUnit;
        this.f47113a = xVar;
    }

    public final void subscribeActual(w<? super Long> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        x xVar = this.f47113a;
        if (xVar instanceof io.reactivex.rxjava3.e.h.p) {
            x.c a2 = xVar.a();
            aVar.setResource(a2);
            a2.a(aVar, this.f47114b, this.f47115c, this.f47116d);
            return;
        }
        aVar.setResource(xVar.a(aVar, this.f47114b, this.f47115c, this.f47116d));
    }

    static final class a extends AtomicReference<c> implements c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
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
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                w<? super Long> wVar = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                wVar.onNext(Long.valueOf(j));
            }
        }

        public final void setResource(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }
    }
}
