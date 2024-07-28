package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.g.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class en<T, U, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final c<? super T, ? super U, ? extends R> f47434b;

    /* renamed from: c  reason: collision with root package name */
    final u<? extends U> f47435c;

    public en(u<T> uVar, c<? super T, ? super U, ? extends R> cVar, u<? extends U> uVar2) {
        super(uVar);
        this.f47434b = cVar;
        this.f47435c = uVar2;
    }

    public final void subscribeActual(w<? super R> wVar) {
        f fVar = new f(wVar);
        a aVar = new a(fVar, this.f47434b);
        fVar.onSubscribe(aVar);
        this.f47435c.subscribe(new b(aVar));
        this.f46900a.subscribe(aVar);
    }

    static final class a<T, U, R> extends AtomicReference<U> implements w<T>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -312246233408980075L;
        final c<? super T, ? super U, ? extends R> combiner;
        final w<? super R> downstream;
        final AtomicReference<io.reactivex.rxjava3.b.c> other = new AtomicReference<>();
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream = new AtomicReference<>();

        a(w<? super R> wVar, c<? super T, ? super U, ? extends R> cVar) {
            this.downstream = wVar;
            this.combiner = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.combiner.a(t, obj), "The combiner returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
            this.downstream.onError(th);
        }

        public final void onComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
            this.downstream.onComplete();
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }

        public final boolean setOther(io.reactivex.rxjava3.b.c cVar) {
            return io.reactivex.rxjava3.e.a.c.setOnce(this.other, cVar);
        }

        public final void otherError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            this.downstream.onError(th);
        }
    }

    final class b implements w<U> {

        /* renamed from: b  reason: collision with root package name */
        private final a<T, U, R> f47437b;

        public final void onComplete() {
        }

        b(a<T, U, R> aVar) {
            this.f47437b = aVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            this.f47437b.setOther(cVar);
        }

        public final void onNext(U u) {
            this.f47437b.lazySet(u);
        }

        public final void onError(Throwable th) {
            this.f47437b.otherError(th);
        }
    }
}
