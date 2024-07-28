package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T> extends b {

    /* renamed from: a  reason: collision with root package name */
    final n<T> f46849a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends f> f46850b;

    public c(n<T> nVar, h<? super T, ? extends f> hVar) {
        this.f46849a = nVar;
        this.f46850b = hVar;
    }

    public final void b(d dVar) {
        a aVar = new a(dVar, this.f46850b);
        dVar.onSubscribe(aVar);
        this.f46849a.a(aVar);
    }

    static final class a<T> extends AtomicReference<io.reactivex.rxjava3.b.c> implements d, m<T>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -2177128922851101253L;
        final d downstream;
        final h<? super T, ? extends f> mapper;

        a(d dVar, h<? super T, ? extends f> hVar) {
            this.downstream = dVar;
            this.mapper = hVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this, cVar);
        }

        public final void onSuccess(T t) {
            try {
                f fVar = (f) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    fVar.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}
