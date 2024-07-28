package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class bt extends p<Long> {

    /* renamed from: a  reason: collision with root package name */
    final x f47117a;

    /* renamed from: b  reason: collision with root package name */
    final long f47118b;

    /* renamed from: c  reason: collision with root package name */
    final long f47119c;

    /* renamed from: d  reason: collision with root package name */
    final long f47120d;

    /* renamed from: e  reason: collision with root package name */
    final long f47121e;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f47122f;

    public bt(long j, long j2, long j3, long j4, TimeUnit timeUnit, x xVar) {
        this.f47120d = j3;
        this.f47121e = j4;
        this.f47122f = timeUnit;
        this.f47117a = xVar;
        this.f47118b = j;
        this.f47119c = j2;
    }

    public final void subscribeActual(w<? super Long> wVar) {
        a aVar = new a(wVar, this.f47118b, this.f47119c);
        wVar.onSubscribe(aVar);
        x xVar = this.f47117a;
        if (xVar instanceof io.reactivex.rxjava3.e.h.p) {
            x.c a2 = xVar.a();
            aVar.setResource(a2);
            a2.a(aVar, this.f47120d, this.f47121e, this.f47122f);
            return;
        }
        aVar.setResource(xVar.a(aVar, this.f47120d, this.f47121e, this.f47122f));
    }

    static final class a extends AtomicReference<c> implements c, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final w<? super Long> downstream;
        final long end;

        a(w<? super Long> wVar, long j, long j2) {
            this.downstream = wVar;
            this.count = j;
            this.end = j2;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void run() {
            if (!isDisposed()) {
                long j = this.count;
                this.downstream.onNext(Long.valueOf(j));
                if (j == this.end) {
                    if (!isDisposed()) {
                        this.downstream.onComplete();
                    }
                    io.reactivex.rxjava3.e.a.c.dispose(this);
                    return;
                }
                this.count = j + 1;
            }
        }

        public final void setResource(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }
    }
}
