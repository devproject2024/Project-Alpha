package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.c.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class db {
    public static <T, R> boolean a(u<T> uVar, w<? super R> wVar, h<? super T, ? extends u<? extends R>> hVar) {
        if (!(uVar instanceof r)) {
            return false;
        }
        try {
            Object obj = ((r) uVar).get();
            if (obj == null) {
                d.complete((w<?>) wVar);
                return true;
            }
            try {
                u uVar2 = (u) Objects.requireNonNull(hVar.apply(obj), "The mapper returned a null ObservableSource");
                if (uVar2 instanceof r) {
                    try {
                        Object obj2 = ((r) uVar2).get();
                        if (obj2 == null) {
                            d.complete((w<?>) wVar);
                            return true;
                        }
                        a aVar = new a(wVar, obj2);
                        wVar.onSubscribe(aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        d.error(th, (w<?>) wVar);
                        return true;
                    }
                } else {
                    uVar2.subscribe(wVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                d.error(th2, (w<?>) wVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.rxjava3.c.b.b(th3);
            d.error(th3, (w<?>) wVar);
            return true;
        }
    }

    public static <T, U> p<U> a(T t, h<? super T, ? extends u<? extends U>> hVar) {
        return io.reactivex.rxjava3.h.a.a(new b(t, hVar));
    }

    static final class b<T, R> extends p<R> {

        /* renamed from: a  reason: collision with root package name */
        final T f47244a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends u<? extends R>> f47245b;

        b(T t, h<? super T, ? extends u<? extends R>> hVar) {
            this.f47244a = t;
            this.f47245b = hVar;
        }

        public final void subscribeActual(w<? super R> wVar) {
            try {
                u uVar = (u) Objects.requireNonNull(this.f47245b.apply(this.f47244a), "The mapper returned a null ObservableSource");
                if (uVar instanceof r) {
                    try {
                        Object obj = ((r) uVar).get();
                        if (obj == null) {
                            d.complete((w<?>) wVar);
                            return;
                        }
                        a aVar = new a(wVar, obj);
                        wVar.onSubscribe(aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        d.error(th, (w<?>) wVar);
                    }
                } else {
                    uVar.subscribe(wVar);
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                d.error(th2, (w<?>) wVar);
            }
        }
    }

    public static final class a<T> extends AtomicInteger implements f<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final w<? super T> observer;
        final T value;

        public a(w<? super T> wVar, T t) {
            this.observer = wVar;
            this.value = t;
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public final boolean isEmpty() {
            return get() != 1;
        }

        public final void clear() {
            lazySet(3);
        }

        public final void dispose() {
            set(3);
        }

        public final boolean isDisposed() {
            return get() == 3;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public final void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }
}
