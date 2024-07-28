package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import java.util.Objects;

public final class dc<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c<T, T, T> f47246b;

    public dc(u<T> uVar, c<T, T, T> cVar) {
        super(uVar);
        this.f47246b = cVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47246b));
    }

    static final class a<T> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47247a;

        /* renamed from: b  reason: collision with root package name */
        final c<T, T, T> f47248b;

        /* renamed from: c  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f47249c;

        /* renamed from: d  reason: collision with root package name */
        T f47250d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47251e;

        a(w<? super T> wVar, c<T, T, T> cVar) {
            this.f47247a = wVar;
            this.f47248b = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47249c, cVar)) {
                this.f47249c = cVar;
                this.f47247a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47249c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47249c.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47251e) {
                w<? super T> wVar = this.f47247a;
                T t2 = this.f47250d;
                if (t2 == null) {
                    this.f47250d = t;
                    wVar.onNext(t);
                    return;
                }
                try {
                    T requireNonNull = Objects.requireNonNull(this.f47248b.a(t2, t), "The value returned by the accumulator is null");
                    this.f47250d = requireNonNull;
                    wVar.onNext(requireNonNull);
                } catch (Throwable th) {
                    b.b(th);
                    this.f47249c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47251e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47251e = true;
            this.f47247a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47251e) {
                this.f47251e = true;
                this.f47247a.onComplete();
            }
        }
    }
}
