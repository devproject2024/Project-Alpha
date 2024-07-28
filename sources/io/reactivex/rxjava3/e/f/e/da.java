package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.g.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class da<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final u<?> f47241b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47242c;

    public da(u<T> uVar, u<?> uVar2, boolean z) {
        super(uVar);
        this.f47241b = uVar2;
        this.f47242c = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f(wVar);
        if (this.f47242c) {
            this.f46900a.subscribe(new a(fVar, this.f47241b));
        } else {
            this.f46900a.subscribe(new b(fVar, this.f47241b));
        }
    }

    static abstract class c<T> extends AtomicReference<T> implements w<T>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -3517602651313910099L;
        final w<? super T> downstream;
        final AtomicReference<io.reactivex.rxjava3.b.c> other = new AtomicReference<>();
        final u<?> sampler;
        io.reactivex.rxjava3.b.c upstream;

        /* access modifiers changed from: package-private */
        public abstract void completion();

        /* access modifiers changed from: package-private */
        public abstract void run();

        c(w<? super T> wVar, u<?> uVar) {
            this.downstream = wVar;
            this.sampler = uVar;
        }

        public void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                }
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
            this.downstream.onError(th);
        }

        public void onComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
            completion();
        }

        /* access modifiers changed from: package-private */
        public boolean setOther(io.reactivex.rxjava3.b.c cVar) {
            return io.reactivex.rxjava3.e.a.c.setOnce(this.other, cVar);
        }

        public void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.other);
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.other.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public void error(Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    static final class d<T> implements w<Object> {

        /* renamed from: a  reason: collision with root package name */
        final c<T> f47243a;

        d(c<T> cVar) {
            this.f47243a = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            this.f47243a.setOther(cVar);
        }

        public final void onNext(Object obj) {
            this.f47243a.run();
        }

        public final void onError(Throwable th) {
            this.f47243a.error(th);
        }

        public final void onComplete() {
            this.f47243a.complete();
        }
    }

    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(w<? super T> wVar, u<?> uVar) {
            super(wVar, uVar);
        }

        /* access modifiers changed from: package-private */
        public final void completion() {
            this.downstream.onComplete();
        }

        /* access modifiers changed from: package-private */
        public final void run() {
            emit();
        }
    }

    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip = new AtomicInteger();

        a(w<? super T> wVar, u<?> uVar) {
            super(wVar, uVar);
        }

        /* access modifiers changed from: package-private */
        public final void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public final void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }
}
