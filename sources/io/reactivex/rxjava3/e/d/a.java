package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.e.l;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public final class a<T, A, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46683a;

    /* renamed from: b  reason: collision with root package name */
    final Collector<T, A, R> f46684b;

    public a(p<T> pVar, Collector<T, A, R> collector) {
        this.f46683a = pVar;
        this.f46684b = collector;
    }

    public final void subscribeActual(w<? super R> wVar) {
        try {
            this.f46683a.subscribe(new C0787a(wVar, this.f46684b.supplier().get(), this.f46684b.accumulator(), this.f46684b.finisher()));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    /* renamed from: io.reactivex.rxjava3.e.d.a$a  reason: collision with other inner class name */
    static final class C0787a<T, A, R> extends l<R> implements w<T> {
        private static final long serialVersionUID = -229544830565448758L;
        final BiConsumer<A, T> accumulator;
        A container;
        boolean done;
        final Function<A, R> finisher;
        c upstream;

        C0787a(w<? super R> wVar, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(wVar);
            this.container = a2;
            this.accumulator = biConsumer;
            this.finisher = function;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator.accept(this.container, t);
                } catch (Throwable th) {
                    b.b(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.done = true;
            this.upstream = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.container = null;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.upstream = io.reactivex.rxjava3.e.a.c.DISPOSED;
                A a2 = this.container;
                this.container = null;
                try {
                    complete(Objects.requireNonNull(this.finisher.apply(a2), "The finisher returned a null value"));
                } catch (Throwable th) {
                    b.b(th);
                    this.downstream.onError(th);
                }
            }
        }

        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }
    }
}
