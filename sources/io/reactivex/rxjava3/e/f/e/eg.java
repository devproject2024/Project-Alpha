package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

public final class eg<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final x f47399b;

    public eg(u<T> uVar, x xVar) {
        super(uVar);
        this.f47399b = xVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47399b));
    }

    static final class a<T> extends AtomicBoolean implements w<T>, c {
        private static final long serialVersionUID = 1015244841293359600L;
        final w<? super T> downstream;
        final x scheduler;
        c upstream;

        a(w<? super T> wVar, x xVar) {
            this.downstream = wVar;
            this.scheduler = xVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
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

        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.a((Runnable) new C0815a());
            }
        }

        public final boolean isDisposed() {
            return get();
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.eg$a$a  reason: collision with other inner class name */
        final class C0815a implements Runnable {
            C0815a() {
            }

            public final void run() {
                a.this.upstream.dispose();
            }
        }
    }
}
