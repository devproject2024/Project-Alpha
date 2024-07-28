package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final x f46861b;

    public h(n<T> nVar, x xVar) {
        super(nVar);
        this.f46861b = xVar;
    }

    public final void b(m<? super T> mVar) {
        a aVar = new a(mVar);
        mVar.onSubscribe(aVar);
        aVar.task.replace(this.f46861b.a((Runnable) new b(aVar, this.f46848a)));
    }

    static final class b<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f46862a;

        /* renamed from: b  reason: collision with root package name */
        final n<T> f46863b;

        b(m<? super T> mVar, n<T> nVar) {
            this.f46862a = mVar;
            this.f46863b = nVar;
        }

        public final void run() {
            this.f46863b.a(this.f46862a);
        }
    }

    static final class a<T> extends AtomicReference<c> implements m<T>, c {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> downstream;
        final f task = new f();

        a(m<? super T> mVar) {
            this.downstream = mVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
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

        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}
