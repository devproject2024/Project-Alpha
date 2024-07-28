package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.e.b;

public final class am<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46971b;

    public am(u<T> uVar, io.reactivex.rxjava3.d.a aVar) {
        super(uVar);
        this.f46971b = aVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46971b));
    }

    static final class a<T> extends b<T> implements w<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final w<? super T> downstream;
        final io.reactivex.rxjava3.d.a onFinally;
        f<T> qd;
        boolean syncFused;
        c upstream;

        a(w<? super T> wVar, io.reactivex.rxjava3.d.a aVar) {
            this.downstream = wVar;
            this.onFinally = aVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof f) {
                    this.qd = (f) cVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        public final void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        public final void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final int requestFusion(int i2) {
            f<T> fVar = this.qd;
            if (fVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int requestFusion = fVar.requestFusion(i2);
            if (requestFusion != 0) {
                boolean z = true;
                if (requestFusion != 1) {
                    z = false;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        public final void clear() {
            this.qd.clear();
        }

        public final boolean isEmpty() {
            return this.qd.isEmpty();
        }

        public final T poll() throws Throwable {
            T poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        /* access modifiers changed from: package-private */
        public final void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }
}
