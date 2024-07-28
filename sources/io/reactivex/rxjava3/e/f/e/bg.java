package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.e.c;
import java.util.Iterator;
import java.util.Objects;

public final class bg<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T> f47048a;

    public bg(Iterable<? extends T> iterable) {
        this.f47048a = iterable;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            Iterator<? extends T> it2 = this.f47048a.iterator();
            try {
                if (!it2.hasNext()) {
                    d.complete((w<?>) wVar);
                    return;
                }
                a aVar = new a(wVar, it2);
                wVar.onSubscribe(aVar);
                if (!aVar.f47052d) {
                    while (!aVar.isDisposed()) {
                        try {
                            aVar.f47049a.onNext(Objects.requireNonNull(aVar.f47050b.next(), "The iterator returned a null value"));
                            if (!aVar.isDisposed()) {
                                try {
                                    if (!aVar.f47050b.hasNext()) {
                                        if (!aVar.isDisposed()) {
                                            aVar.f47049a.onComplete();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th) {
                                    b.b(th);
                                    aVar.f47049a.onError(th);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            b.b(th2);
                            aVar.f47049a.onError(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                b.b(th3);
                d.error(th3, (w<?>) wVar);
            }
        } catch (Throwable th4) {
            b.b(th4);
            d.error(th4, (w<?>) wVar);
        }
    }

    static final class a<T> extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47049a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends T> f47050b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f47051c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47052d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47053e;

        /* renamed from: f  reason: collision with root package name */
        boolean f47054f;

        a(w<? super T> wVar, Iterator<? extends T> it2) {
            this.f47049a = wVar;
            this.f47050b = it2;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f47052d = true;
            return 1;
        }

        public final T poll() {
            if (this.f47053e) {
                return null;
            }
            if (!this.f47054f) {
                this.f47054f = true;
            } else if (!this.f47050b.hasNext()) {
                this.f47053e = true;
                return null;
            }
            return Objects.requireNonNull(this.f47050b.next(), "The iterator returned a null value");
        }

        public final boolean isEmpty() {
            return this.f47053e;
        }

        public final void clear() {
            this.f47053e = true;
        }

        public final void dispose() {
            this.f47051c = true;
        }

        public final boolean isDisposed() {
            return this.f47051c;
        }
    }
}
