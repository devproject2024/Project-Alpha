package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.g.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ac<T, U> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<U>> f46906b;

    public ac(u<T> uVar, h<? super T, ? extends u<U>> hVar) {
        super(uVar);
        this.f46906b = hVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(new f(wVar), this.f46906b));
    }

    static final class a<T, U> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46907a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends u<U>> f46908b;

        /* renamed from: c  reason: collision with root package name */
        c f46909c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<c> f46910d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        volatile long f46911e;

        /* renamed from: f  reason: collision with root package name */
        boolean f46912f;

        a(w<? super T> wVar, h<? super T, ? extends u<U>> hVar) {
            this.f46907a = wVar;
            this.f46908b = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46909c, cVar)) {
                this.f46909c = cVar;
                this.f46907a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f46912f) {
                long j = this.f46911e + 1;
                this.f46911e = j;
                c cVar = this.f46910d.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                try {
                    u uVar = (u) Objects.requireNonNull(this.f46908b.apply(t), "The ObservableSource supplied is null");
                    C0801a aVar = new C0801a(this, j, t);
                    if (this.f46910d.compareAndSet(cVar, aVar)) {
                        uVar.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    b.b(th);
                    dispose();
                    this.f46907a.onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.f46910d);
            this.f46907a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46912f) {
                this.f46912f = true;
                c cVar = this.f46910d.get();
                if (cVar != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                    C0801a aVar = (C0801a) cVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                    io.reactivex.rxjava3.e.a.c.dispose(this.f46910d);
                    this.f46907a.onComplete();
                }
            }
        }

        public final void dispose() {
            this.f46909c.dispose();
            io.reactivex.rxjava3.e.a.c.dispose(this.f46910d);
        }

        public final boolean isDisposed() {
            return this.f46909c.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public final void a(long j, T t) {
            if (j == this.f46911e) {
                this.f46907a.onNext(t);
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ac$a$a  reason: collision with other inner class name */
        static final class C0801a<T, U> extends io.reactivex.rxjava3.g.c<U> {

            /* renamed from: a  reason: collision with root package name */
            final a<T, U> f46913a;

            /* renamed from: b  reason: collision with root package name */
            final long f46914b;

            /* renamed from: c  reason: collision with root package name */
            final T f46915c;

            /* renamed from: d  reason: collision with root package name */
            boolean f46916d;

            /* renamed from: e  reason: collision with root package name */
            final AtomicBoolean f46917e = new AtomicBoolean();

            C0801a(a<T, U> aVar, long j, T t) {
                this.f46913a = aVar;
                this.f46914b = j;
                this.f46915c = t;
            }

            public final void onNext(U u) {
                if (!this.f46916d) {
                    this.f46916d = true;
                    dispose();
                    a();
                }
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                if (this.f46917e.compareAndSet(false, true)) {
                    this.f46913a.a(this.f46914b, this.f46915c);
                }
            }

            public final void onError(Throwable th) {
                if (this.f46916d) {
                    io.reactivex.rxjava3.h.a.a(th);
                    return;
                }
                this.f46916d = true;
                this.f46913a.onError(th);
            }

            public final void onComplete() {
                if (!this.f46916d) {
                    this.f46916d = true;
                    a();
                }
            }
        }
    }
}
