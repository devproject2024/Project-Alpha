package io.reactivex.rxjava3.e.f.d;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46897a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends ac<? extends R>> f46898b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f46899c;

    public g(p<T> pVar, h<? super T, ? extends ac<? extends R>> hVar, boolean z) {
        this.f46897a = pVar;
        this.f46898b = hVar;
        this.f46899c = z;
    }

    public final void subscribeActual(w<? super R> wVar) {
        if (!h.b(this.f46897a, this.f46898b, wVar)) {
            this.f46897a.subscribe(new a(wVar, this.f46898b, this.f46899c));
        }
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c {
        static final C0800a<Object> INNER_DISPOSED = new C0800a<>((a) null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final AtomicReference<C0800a<R>> inner = new AtomicReference<>();
        final h<? super T, ? extends ac<? extends R>> mapper;
        c upstream;

        a(w<? super R> wVar, h<? super T, ? extends ac<? extends R>> hVar, boolean z) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            C0800a<Object> aVar;
            C0800a aVar2 = this.inner.get();
            if (aVar2 != null) {
                aVar2.dispose();
            }
            try {
                ac acVar = (ac) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                C0800a aVar3 = new C0800a(this);
                do {
                    aVar = this.inner.get();
                    if (aVar == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(aVar, aVar3));
                acVar.a(aVar3);
            } catch (Throwable th) {
                b.b(th);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
            }
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void disposeInner() {
            C0800a<Object> andSet = this.inner.getAndSet(INNER_DISPOSED);
            if (andSet != null && andSet != INNER_DISPOSED) {
                andSet.dispose();
            }
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void innerError(C0800a<R> aVar, Throwable th) {
            if (!this.inner.compareAndSet(aVar, (Object) null)) {
                io.reactivex.rxjava3.h.a.a(th);
            } else if (this.errors.tryAddThrowableOrReport(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    disposeInner();
                }
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super R> wVar = this.downstream;
                io.reactivex.rxjava3.e.k.c cVar = this.errors;
                AtomicReference<C0800a<R>> atomicReference = this.inner;
                int i2 = 1;
                while (!this.cancelled) {
                    if (cVar.get() == null || this.delayErrors) {
                        boolean z = this.done;
                        C0800a aVar = atomicReference.get();
                        boolean z2 = aVar == null;
                        if (z && z2) {
                            cVar.tryTerminateConsumer((w<?>) wVar);
                            return;
                        } else if (z2 || aVar.item == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            atomicReference.compareAndSet(aVar, (Object) null);
                            wVar.onNext(aVar.item);
                        }
                    } else {
                        cVar.tryTerminateConsumer((w<?>) wVar);
                        return;
                    }
                }
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.d.g$a$a  reason: collision with other inner class name */
        static final class C0800a<R> extends AtomicReference<c> implements aa<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final a<?, R> parent;

            C0800a(a<?, R> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            public final void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
