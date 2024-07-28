package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;

public final class x<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final io.reactivex.rxjava3.a.x f46842c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46843d;

    public x(h<T> hVar, io.reactivex.rxjava3.a.x xVar, boolean z) {
        super(hVar);
        this.f46842c = xVar;
        this.f46843d = z;
    }

    public final void b(b<? super T> bVar) {
        x.c a2 = this.f46842c.a();
        a aVar = new a(bVar, a2, this.f46770b, this.f46843d);
        bVar.onSubscribe(aVar);
        a2.a((Runnable) aVar);
    }

    static final class a<T> extends AtomicReference<Thread> implements k<T>, Runnable, c {
        private static final long serialVersionUID = 8094547886072529208L;
        final b<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        org.a.a<T> source;
        final AtomicReference<c> upstream = new AtomicReference<>();
        final x.c worker;

        a(b<? super T> bVar, x.c cVar, org.a.a<T> aVar, boolean z) {
            this.downstream = bVar;
            this.worker = cVar;
            this.source = aVar;
            this.nonScheduledRequests = !z;
        }

        public final void run() {
            lazySet(Thread.currentThread());
            org.a.a<T> aVar = this.source;
            this.source = null;
            aVar.a(this);
        }

        public final void onSubscribe(c cVar) {
            if (g.setOnce(this.upstream, cVar)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, cVar);
                }
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        public final void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public final void request(long j) {
            if (g.validate(j)) {
                c cVar = this.upstream.get();
                if (cVar != null) {
                    requestUpstream(j, cVar);
                    return;
                }
                d.a(this.requested, j);
                c cVar2 = this.upstream.get();
                if (cVar2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, cVar2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void requestUpstream(long j, c cVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                cVar.request(j);
            } else {
                this.worker.a((Runnable) new C0791a(cVar, j));
            }
        }

        public final void cancel() {
            g.cancel(this.upstream);
            this.worker.dispose();
        }

        /* renamed from: io.reactivex.rxjava3.e.f.b.x$a$a  reason: collision with other inner class name */
        static final class C0791a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final c f46844a;

            /* renamed from: b  reason: collision with root package name */
            final long f46845b;

            C0791a(c cVar, long j) {
                this.f46844a = cVar;
                this.f46845b = j;
            }

            public final void run() {
                this.f46844a.request(this.f46845b);
            }
        }
    }
}
