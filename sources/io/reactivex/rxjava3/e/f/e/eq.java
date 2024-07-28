package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.Iterator;
import java.util.Objects;

public final class eq<T, U, V> extends p<V> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T> f47452a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<U> f47453b;

    /* renamed from: c  reason: collision with root package name */
    final c<? super T, ? super U, ? extends V> f47454c;

    public eq(p<? extends T> pVar, Iterable<U> iterable, c<? super T, ? super U, ? extends V> cVar) {
        this.f47452a = pVar;
        this.f47453b = iterable;
        this.f47454c = cVar;
    }

    public final void subscribeActual(w<? super V> wVar) {
        try {
            Iterator it2 = (Iterator) Objects.requireNonNull(this.f47453b.iterator(), "The iterator returned by other is null");
            try {
                if (!it2.hasNext()) {
                    d.complete((w<?>) wVar);
                } else {
                    this.f47452a.subscribe(new a(wVar, it2, this.f47454c));
                }
            } catch (Throwable th) {
                b.b(th);
                d.error(th, (w<?>) wVar);
            }
        } catch (Throwable th2) {
            b.b(th2);
            d.error(th2, (w<?>) wVar);
        }
    }

    static final class a<T, U, V> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super V> f47455a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<U> f47456b;

        /* renamed from: c  reason: collision with root package name */
        final c<? super T, ? super U, ? extends V> f47457c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f47458d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47459e;

        a(w<? super V> wVar, Iterator<U> it2, c<? super T, ? super U, ? extends V> cVar) {
            this.f47455a = wVar;
            this.f47456b = it2;
            this.f47457c = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47458d, cVar)) {
                this.f47458d = cVar;
                this.f47455a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47458d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47458d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47459e) {
                try {
                    try {
                        this.f47455a.onNext(Objects.requireNonNull(this.f47457c.a(t, Objects.requireNonNull(this.f47456b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.f47456b.hasNext()) {
                                this.f47459e = true;
                                this.f47458d.dispose();
                                this.f47455a.onComplete();
                            }
                        } catch (Throwable th) {
                            b.b(th);
                            a(th);
                        }
                    } catch (Throwable th2) {
                        b.b(th2);
                        a(th2);
                    }
                } catch (Throwable th3) {
                    b.b(th3);
                    a(th3);
                }
            }
        }

        private void a(Throwable th) {
            this.f47459e = true;
            this.f47458d.dispose();
            this.f47455a.onError(th);
        }

        public final void onError(Throwable th) {
            if (this.f47459e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47459e = true;
            this.f47455a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47459e) {
                this.f47459e = true;
                this.f47455a.onComplete();
            }
        }
    }
}
