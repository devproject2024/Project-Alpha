package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ax<T> extends b implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47021a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends f> f47022b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47023c;

    public ax(u<T> uVar, h<? super T, ? extends f> hVar, boolean z) {
        this.f47021a = uVar;
        this.f47022b = hVar;
        this.f47023c = z;
    }

    public final void b(d dVar) {
        this.f47021a.subscribe(new a(dVar, this.f47022b, this.f47023c));
    }

    public final p<T> U_() {
        return io.reactivex.rxjava3.h.a.a(new aw(this.f47021a, this.f47022b, this.f47023c));
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final d downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final h<? super T, ? extends f> mapper;
        final io.reactivex.rxjava3.b.b set = new io.reactivex.rxjava3.b.b();
        c upstream;

        a(d dVar, h<? super T, ? extends f> hVar, boolean z) {
            this.downstream = dVar;
            this.mapper = hVar;
            this.delayErrors = z;
            lazySet(1);
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                f fVar = (f) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0805a aVar = new C0805a();
                if (!this.disposed && this.set.a((c) aVar)) {
                    fVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            if (!this.errors.tryAddThrowableOrReport(th)) {
                return;
            }
            if (!this.delayErrors) {
                this.disposed = true;
                this.upstream.dispose();
                this.set.dispose();
                this.errors.tryTerminateConsumer(this.downstream);
            } else if (decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }

        public final void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete(a<T>.defpackage.a aVar) {
            this.set.c(aVar);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(a<T>.defpackage.a aVar, Throwable th) {
            this.set.c(aVar);
            onError(th);
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ax$a$a  reason: collision with other inner class name */
        final class C0805a extends AtomicReference<c> implements d, c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0805a() {
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onComplete() {
                a.this.innerComplete(this);
            }

            public final void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }

            public final boolean isDisposed() {
                return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
            }
        }
    }
}
