package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends b {

    /* renamed from: a  reason: collision with root package name */
    final f f46749a;

    /* renamed from: b  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46750b;

    public e(f fVar, io.reactivex.rxjava3.d.a aVar) {
        this.f46749a = fVar;
        this.f46750b = aVar;
    }

    public final void b(d dVar) {
        this.f46749a.a(new a(dVar, this.f46750b));
    }

    static final class a extends AtomicInteger implements d, c {
        private static final long serialVersionUID = 4109457741734051389L;
        final d downstream;
        final io.reactivex.rxjava3.d.a onFinally;
        c upstream;

        a(d dVar, io.reactivex.rxjava3.d.a aVar) {
            this.downstream = dVar;
            this.onFinally = aVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
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
