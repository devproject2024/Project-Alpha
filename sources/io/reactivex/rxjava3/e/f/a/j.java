package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class j extends b {

    /* renamed from: a  reason: collision with root package name */
    final f f46755a;

    /* renamed from: b  reason: collision with root package name */
    final x f46756b;

    public j(f fVar, x xVar) {
        this.f46755a = fVar;
        this.f46756b = xVar;
    }

    public final void b(d dVar) {
        this.f46755a.a(new a(dVar, this.f46756b));
    }

    static final class a extends AtomicReference<c> implements d, c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final d downstream;
        Throwable error;
        final x scheduler;

        a(d dVar, x xVar) {
            this.downstream = dVar;
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
            this.downstream.onComplete();
        }
    }
}
