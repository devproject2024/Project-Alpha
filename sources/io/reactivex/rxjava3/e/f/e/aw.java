package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.e.b;
import io.reactivex.rxjava3.e.k.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class aw<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends f> f47019b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47020c;

    public aw(u<T> uVar, h<? super T, ? extends f> hVar, boolean z) {
        super(uVar);
        this.f47019b = hVar;
        this.f47020c = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47019b, this.f47020c));
    }

    static final class a<T> extends b<T> implements w<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final w<? super T> downstream;
        final c errors = new c();
        final h<? super T, ? extends f> mapper;
        final io.reactivex.rxjava3.b.b set = new io.reactivex.rxjava3.b.b();
        io.reactivex.rxjava3.b.c upstream;

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final T poll() {
            return null;
        }

        public final int requestFusion(int i2) {
            return i2 & 2;
        }

        a(w<? super T> wVar, h<? super T, ? extends f> hVar, boolean z) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.delayErrors = z;
            lazySet(1);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                f fVar = (f) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0804a aVar = new C0804a();
                if (!this.disposed && this.set.a((io.reactivex.rxjava3.b.c) aVar)) {
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
                this.errors.tryTerminateConsumer((w<?>) this.downstream);
            } else if (decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer((w<?>) this.downstream);
            }
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer((w<?>) this.downstream);
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

        /* renamed from: io.reactivex.rxjava3.e.f.e.aw$a$a  reason: collision with other inner class name */
        final class C0804a extends AtomicReference<io.reactivex.rxjava3.b.c> implements d, io.reactivex.rxjava3.b.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0804a() {
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
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
                return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
            }
        }
    }
}
