package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.g.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ad<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f46918b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f46919c;

    /* renamed from: d  reason: collision with root package name */
    final x f46920d;

    public ad(u<T> uVar, long j, TimeUnit timeUnit, x xVar) {
        super(uVar);
        this.f46918b = j;
        this.f46919c = timeUnit;
        this.f46920d = xVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new b(new f(wVar), this.f46918b, this.f46919c, this.f46920d.a()));
    }

    static final class b<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46921a;

        /* renamed from: b  reason: collision with root package name */
        final long f46922b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f46923c;

        /* renamed from: d  reason: collision with root package name */
        final x.c f46924d;

        /* renamed from: e  reason: collision with root package name */
        c f46925e;

        /* renamed from: f  reason: collision with root package name */
        c f46926f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f46927g;

        /* renamed from: h  reason: collision with root package name */
        boolean f46928h;

        b(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.f46921a = wVar;
            this.f46922b = j;
            this.f46923c = timeUnit;
            this.f46924d = cVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46925e, cVar)) {
                this.f46925e = cVar;
                this.f46921a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f46928h) {
                long j = this.f46927g + 1;
                this.f46927g = j;
                c cVar = this.f46926f;
                if (cVar != null) {
                    cVar.dispose();
                }
                a aVar = new a(t, j, this);
                this.f46926f = aVar;
                aVar.setResource(this.f46924d.a(aVar, this.f46922b, this.f46923c));
            }
        }

        public final void onError(Throwable th) {
            if (this.f46928h) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            c cVar = this.f46926f;
            if (cVar != null) {
                cVar.dispose();
            }
            this.f46928h = true;
            this.f46921a.onError(th);
            this.f46924d.dispose();
        }

        public final void onComplete() {
            if (!this.f46928h) {
                this.f46928h = true;
                c cVar = this.f46926f;
                if (cVar != null) {
                    cVar.dispose();
                }
                a aVar = (a) cVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.f46921a.onComplete();
                this.f46924d.dispose();
            }
        }

        public final void dispose() {
            this.f46925e.dispose();
            this.f46924d.dispose();
        }

        public final boolean isDisposed() {
            return this.f46924d.isDisposed();
        }
    }

    static final class a<T> extends AtomicReference<c> implements c, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j, b<T> bVar) {
            this.value = t;
            this.idx = j;
            this.parent = bVar;
        }

        public final void run() {
            if (this.once.compareAndSet(false, true)) {
                b<T> bVar = this.parent;
                long j = this.idx;
                T t = this.value;
                if (j == bVar.f46927g) {
                    bVar.f46921a.onNext(t);
                    dispose();
                }
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void setResource(c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this, cVar);
        }
    }
}
