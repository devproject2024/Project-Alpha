package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.atomic.AtomicReference;

public final class o<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47614a;

    /* renamed from: b  reason: collision with root package name */
    final x f47615b;

    public o(ac<? extends T> acVar, x xVar) {
        this.f47614a = acVar;
        this.f47615b = xVar;
    }

    public final void b(aa<? super T> aaVar) {
        a aVar = new a(aaVar, this.f47614a);
        aaVar.onSubscribe(aVar);
        aVar.task.replace(this.f47615b.a((Runnable) aVar));
    }

    static final class a<T> extends AtomicReference<c> implements aa<T>, c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final aa<? super T> downstream;
        final ac<? extends T> source;
        final f task = new f();

        a(aa<? super T> aaVar, ac<? extends T> acVar) {
            this.downstream = aaVar;
            this.source = acVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        public final void run() {
            this.source.a(this);
        }
    }
}
