package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final x f46856b;

    public f(n<T> nVar, x xVar) {
        super(nVar);
        this.f46856b = xVar;
    }

    public final void b(m<? super T> mVar) {
        this.f46848a.a(new a(mVar, this.f46856b));
    }

    static final class a<T> extends AtomicReference<c> implements m<T>, c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> downstream;
        Throwable error;
        final x scheduler;
        T value;

        a(m<? super T> mVar, x xVar) {
            this.downstream = mVar;
            this.scheduler = xVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
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

        public final void onComplete() {
            io.reactivex.rxjava3.e.a.c.replace(this, this.scheduler.a((Runnable) this));
        }

        public final void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.downstream.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.value = null;
                this.downstream.onSuccess(t);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
