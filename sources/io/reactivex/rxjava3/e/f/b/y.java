package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
import org.a.b;
import org.a.c;

public final class y<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final x f46846c;

    public y(h<T> hVar, x xVar) {
        super(hVar);
        this.f46846c = xVar;
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar, this.f46846c));
    }

    static final class a<T> extends AtomicBoolean implements k<T>, c {
        private static final long serialVersionUID = 1015244841293359600L;
        final b<? super T> downstream;
        final x scheduler;
        c upstream;

        a(b<? super T> bVar, x xVar) {
            this.downstream = bVar;
            this.scheduler = xVar;
        }

        public final void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                io.reactivex.rxjava3.h.a.a(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public final void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public final void request(long j) {
            this.upstream.request(j);
        }

        public final void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.a((Runnable) new C0792a());
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.b.y$a$a  reason: collision with other inner class name */
        final class C0792a implements Runnable {
            C0792a() {
            }

            public final void run() {
                a.this.upstream.cancel();
            }
        }
    }
}
