package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class l extends b {

    /* renamed from: a  reason: collision with root package name */
    final f f46767a;

    /* renamed from: b  reason: collision with root package name */
    final x f46768b;

    public l(f fVar, x xVar) {
        this.f46767a = fVar;
        this.f46768b = xVar;
    }

    public final void b(d dVar) {
        a aVar = new a(dVar, this.f46767a);
        dVar.onSubscribe(aVar);
        aVar.task.replace(this.f46768b.a((Runnable) aVar));
    }

    static final class a extends AtomicReference<c> implements d, c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final d downstream;
        final f source;
        final io.reactivex.rxjava3.e.a.f task = new io.reactivex.rxjava3.e.a.f();

        a(d dVar, f fVar) {
            this.downstream = dVar;
            this.source = fVar;
        }

        public final void run() {
            this.source.a(this);
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
