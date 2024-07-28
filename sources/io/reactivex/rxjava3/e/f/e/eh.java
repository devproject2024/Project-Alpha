package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class eh<T, D> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends D> f47401a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super D, ? extends u<? extends T>> f47402b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super D> f47403c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f47404d;

    public eh(r<? extends D> rVar, h<? super D, ? extends u<? extends T>> hVar, g<? super D> gVar, boolean z) {
        this.f47401a = rVar;
        this.f47402b = hVar;
        this.f47403c = gVar;
        this.f47404d = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            Object obj = this.f47401a.get();
            try {
                ((u) Objects.requireNonNull(this.f47402b.apply(obj), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(wVar, obj, this.f47403c, this.f47404d));
            } catch (Throwable th) {
                b.b(th);
                d.error((Throwable) new io.reactivex.rxjava3.c.a(th, th), (w<?>) wVar);
            }
        } catch (Throwable th2) {
            b.b(th2);
            d.error(th2, (w<?>) wVar);
        }
    }

    static final class a<T, D> extends AtomicBoolean implements w<T>, c {
        private static final long serialVersionUID = 5904473792286235046L;
        final g<? super D> disposer;
        final w<? super T> downstream;
        final boolean eager;
        final D resource;
        c upstream;

        a(w<? super T> wVar, D d2, g<? super D> gVar, boolean z) {
            this.downstream = wVar;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th2) {
                        b.b(th2);
                        th = new io.reactivex.rxjava3.c.a(th, th2);
                    }
                }
                this.upstream.dispose();
                this.downstream.onError(th);
                return;
            }
            this.downstream.onError(th);
            this.upstream.dispose();
            disposeResource();
        }

        public final void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        b.b(th);
                        this.downstream.onError(th);
                        return;
                    }
                }
                this.upstream.dispose();
                this.downstream.onComplete();
                return;
            }
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeResource();
        }

        public final void dispose() {
            if (this.eager) {
                disposeResource();
                this.upstream.dispose();
                this.upstream = io.reactivex.rxjava3.e.a.c.DISPOSED;
                return;
            }
            this.upstream.dispose();
            this.upstream = io.reactivex.rxjava3.e.a.c.DISPOSED;
            disposeResource();
        }

        public final boolean isDisposed() {
            return get();
        }

        /* access modifiers changed from: package-private */
        public final void disposeResource() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    b.b(th);
                    io.reactivex.rxjava3.h.a.a(th);
                }
            }
        }
    }
}
