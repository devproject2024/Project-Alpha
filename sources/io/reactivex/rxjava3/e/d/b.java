package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.c.e;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public final class b<T, A, R> extends y<R> implements e<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46685a;

    /* renamed from: b  reason: collision with root package name */
    final Collector<T, A, R> f46686b;

    public b(p<T> pVar, Collector<T, A, R> collector) {
        this.f46685a = pVar;
        this.f46686b = collector;
    }

    public final p<R> U_() {
        return new a(this.f46685a, this.f46686b);
    }

    public final void b(aa<? super R> aaVar) {
        try {
            this.f46685a.subscribe(new a(aaVar, this.f46686b.supplier().get(), this.f46686b.accumulator(), this.f46686b.finisher()));
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (aa<?>) aaVar);
        }
    }

    static final class a<T, A, R> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super R> f46687a;

        /* renamed from: b  reason: collision with root package name */
        final BiConsumer<A, T> f46688b;

        /* renamed from: c  reason: collision with root package name */
        final Function<A, R> f46689c;

        /* renamed from: d  reason: collision with root package name */
        c f46690d;

        /* renamed from: e  reason: collision with root package name */
        boolean f46691e;

        /* renamed from: f  reason: collision with root package name */
        A f46692f;

        a(aa<? super R> aaVar, A a2, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.f46687a = aaVar;
            this.f46692f = a2;
            this.f46688b = biConsumer;
            this.f46689c = function;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46690d, cVar)) {
                this.f46690d = cVar;
                this.f46687a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f46691e) {
                try {
                    this.f46688b.accept(this.f46692f, t);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46690d.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f46691e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46691e = true;
            this.f46690d = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f46692f = null;
            this.f46687a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46691e) {
                this.f46691e = true;
                this.f46690d = io.reactivex.rxjava3.e.a.c.DISPOSED;
                A a2 = this.f46692f;
                this.f46692f = null;
                try {
                    this.f46687a.onSuccess(Objects.requireNonNull(this.f46689c.apply(a2), "The finisher returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46687a.onError(th);
                }
            }
        }

        public final void dispose() {
            this.f46690d.dispose();
            this.f46690d = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f46690d == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }
    }
}
