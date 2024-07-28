package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.a.d;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public final class f<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final Stream<T> f46698a;

    public f(Stream<T> stream) {
        this.f46698a = stream;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a(wVar, this.f46698a);
    }

    public static <T> void a(w<? super T> wVar, Stream<T> stream) {
        try {
            Iterator it2 = stream.iterator();
            if (!it2.hasNext()) {
                d.complete((w<?>) wVar);
                a(stream);
                return;
            }
            a aVar = new a(wVar, it2, stream);
            wVar.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
            a(stream);
        }
    }

    static void a(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            b.b(th);
            io.reactivex.rxjava3.h.a.a(th);
        }
    }

    static final class a<T> implements io.reactivex.rxjava3.e.c.f<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46699a;

        /* renamed from: b  reason: collision with root package name */
        Iterator<T> f46700b;

        /* renamed from: c  reason: collision with root package name */
        AutoCloseable f46701c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f46702d;

        /* renamed from: e  reason: collision with root package name */
        boolean f46703e;

        /* renamed from: f  reason: collision with root package name */
        boolean f46704f;

        a(w<? super T> wVar, Iterator<T> it2, AutoCloseable autoCloseable) {
            this.f46699a = wVar;
            this.f46700b = it2;
            this.f46701c = autoCloseable;
        }

        public final void dispose() {
            this.f46702d = true;
            a();
        }

        public final boolean isDisposed() {
            return this.f46702d;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f46704f = true;
            return 1;
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException();
        }

        public final T poll() {
            Iterator<T> it2 = this.f46700b;
            if (it2 == null) {
                return null;
            }
            if (!this.f46703e) {
                this.f46703e = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            return Objects.requireNonNull(this.f46700b.next(), "The Stream's Iterator.next() returned a null value");
        }

        public final boolean isEmpty() {
            Iterator<T> it2 = this.f46700b;
            if (it2 == null) {
                return true;
            }
            if (!this.f46703e || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public final void clear() {
            this.f46700b = null;
            AutoCloseable autoCloseable = this.f46701c;
            this.f46701c = null;
            if (autoCloseable != null) {
                f.a(autoCloseable);
            }
        }

        public final void a() {
            if (!this.f46704f) {
                Iterator<T> it2 = this.f46700b;
                w<? super T> wVar = this.f46699a;
                while (!this.f46702d) {
                    try {
                        Object requireNonNull = Objects.requireNonNull(it2.next(), "The Stream's Iterator.next returned a null value");
                        if (!this.f46702d) {
                            wVar.onNext(requireNonNull);
                            if (!this.f46702d) {
                                try {
                                    if (!it2.hasNext()) {
                                        wVar.onComplete();
                                        this.f46702d = true;
                                    }
                                } catch (Throwable th) {
                                    b.b(th);
                                    wVar.onError(th);
                                    this.f46702d = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        b.b(th2);
                        wVar.onError(th2);
                        this.f46702d = true;
                    }
                }
                clear();
            }
        }
    }
}
