package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;

public final class ba<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends Iterable<? extends R>> f47030b;

    public ba(u<T> uVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
        super(uVar);
        this.f47030b = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47030b));
    }

    static final class a<T, R> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super R> f47031a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends Iterable<? extends R>> f47032b;

        /* renamed from: c  reason: collision with root package name */
        c f47033c;

        a(w<? super R> wVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
            this.f47031a = wVar;
            this.f47032b = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47033c, cVar)) {
                this.f47033c = cVar;
                this.f47031a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.f47033c != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                try {
                    w<? super R> wVar = this.f47031a;
                    for (Object requireNonNull : (Iterable) this.f47032b.apply(t)) {
                        try {
                            try {
                                wVar.onNext(Objects.requireNonNull(requireNonNull, "The iterator returned a null value"));
                            } catch (Throwable th) {
                                b.b(th);
                                this.f47033c.dispose();
                                onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            b.b(th2);
                            this.f47033c.dispose();
                            onError(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    b.b(th3);
                    this.f47033c.dispose();
                    onError(th3);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47033c == io.reactivex.rxjava3.e.a.c.DISPOSED) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47033c = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f47031a.onError(th);
        }

        public final void onComplete() {
            if (this.f47033c != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                this.f47033c = io.reactivex.rxjava3.e.a.c.DISPOSED;
                this.f47031a.onComplete();
            }
        }

        public final boolean isDisposed() {
            return this.f47033c.isDisposed();
        }

        public final void dispose() {
            this.f47033c.dispose();
            this.f47033c = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }
    }
}
