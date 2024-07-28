package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class m<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<T> f47607a;

    /* renamed from: b  reason: collision with root package name */
    final x f47608b;

    public m(ac<T> acVar, x xVar) {
        this.f47607a = acVar;
        this.f47608b = xVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47607a.a(new a(aaVar, this.f47608b));
    }

    static final class a<T> extends AtomicReference<c> implements aa<T>, c, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final aa<? super T> downstream;
        Throwable error;
        final x scheduler;
        T value;

        a(aa<? super T> aaVar, x xVar) {
            this.downstream = aaVar;
            this.scheduler = xVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.value = t;
            io.reactivex.rxjava3.e.a.c.replace(this, this.scheduler.a((Runnable) this));
        }

        public final void onError(Throwable th) {
            this.error = th;
            io.reactivex.rxjava3.e.a.c.replace(this, this.scheduler.a((Runnable) this));
        }

        public final void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
