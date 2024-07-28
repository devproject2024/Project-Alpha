package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class e<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<T> f47588a;

    /* renamed from: b  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f47589b;

    public e(ac<T> acVar, io.reactivex.rxjava3.d.a aVar) {
        this.f47588a = acVar;
        this.f47589b = aVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47588a.a(new a(aaVar, this.f47589b));
    }

    static final class a<T> extends AtomicInteger implements aa<T>, c {
        private static final long serialVersionUID = 4109457741734051389L;
        final aa<? super T> downstream;
        final io.reactivex.rxjava3.d.a onFinally;
        c upstream;

        a(aa<? super T> aaVar, io.reactivex.rxjava3.d.a aVar) {
            this.downstream = aaVar;
            this.onFinally = aVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
            runFinally();
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
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
                    b.b(th);
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }
}
