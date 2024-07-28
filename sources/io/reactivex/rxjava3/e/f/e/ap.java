package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.NoSuchElementException;

public final class ap<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f46985b;

    /* renamed from: c  reason: collision with root package name */
    final T f46986c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46987d;

    public ap(u<T> uVar, long j, T t, boolean z) {
        super(uVar);
        this.f46985b = j;
        this.f46986c = t;
        this.f46987d = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46985b, this.f46986c, this.f46987d));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46988a;

        /* renamed from: b  reason: collision with root package name */
        final long f46989b;

        /* renamed from: c  reason: collision with root package name */
        final T f46990c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f46991d;

        /* renamed from: e  reason: collision with root package name */
        c f46992e;

        /* renamed from: f  reason: collision with root package name */
        long f46993f;

        /* renamed from: g  reason: collision with root package name */
        boolean f46994g;

        a(w<? super T> wVar, long j, T t, boolean z) {
            this.f46988a = wVar;
            this.f46989b = j;
            this.f46990c = t;
            this.f46991d = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46992e, cVar)) {
                this.f46992e = cVar;
                this.f46988a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f46992e.dispose();
        }

        public final boolean isDisposed() {
            return this.f46992e.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f46994g) {
                long j = this.f46993f;
                if (j == this.f46989b) {
                    this.f46994g = true;
                    this.f46992e.dispose();
                    this.f46988a.onNext(t);
                    this.f46988a.onComplete();
                    return;
                }
                this.f46993f = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f46994g) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46994g = true;
            this.f46988a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46994g) {
                this.f46994g = true;
                T t = this.f46990c;
                if (t != null || !this.f46991d) {
                    if (t != null) {
                        this.f46988a.onNext(t);
                    }
                    this.f46988a.onComplete();
                    return;
                }
                this.f46988a.onError(new NoSuchElementException());
            }
        }
    }
}
