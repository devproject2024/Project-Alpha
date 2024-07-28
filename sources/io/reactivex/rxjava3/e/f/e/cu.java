package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.k;
import io.reactivex.rxjava3.j.b;
import io.reactivex.rxjava3.j.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cu<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super p<Object>, ? extends u<?>> f47210b;

    public cu(u<T> uVar, h<? super p<Object>, ? extends u<?>> hVar) {
        super(uVar);
        this.f47210b = hVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        e e2 = b.a().e();
        try {
            u uVar = (u) Objects.requireNonNull(this.f47210b.apply(e2), "The handler returned a null ObservableSource");
            a aVar = new a(wVar, e2, this.f46900a);
            wVar.onSubscribe(aVar);
            uVar.subscribe(aVar.inner);
            aVar.subscribeNext();
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final w<? super T> downstream;
        final io.reactivex.rxjava3.e.k.c error = new io.reactivex.rxjava3.e.k.c();
        final a<T>.defpackage.a inner = new C0811a();
        final e<Object> signaller;
        final u<T> source;
        final AtomicReference<c> upstream = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        a(w<? super T> wVar, e<Object> eVar, u<T> uVar) {
            this.downstream = wVar;
            this.signaller = eVar;
            this.source = uVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            k.a(this.downstream, t, (AtomicInteger) this, this.error);
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.inner);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public final void onComplete() {
            io.reactivex.rxjava3.e.a.c.replace(this.upstream, (c) null);
            this.active = false;
            this.signaller.onNext(0);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this.inner);
        }

        /* access modifiers changed from: package-private */
        public final void innerNext() {
            subscribeNext();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            k.a(this.downstream, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.cu$a$a  reason: collision with other inner class name */
        final class C0811a extends AtomicReference<c> implements w<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            C0811a() {
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onNext(Object obj) {
                a.this.innerNext();
            }

            public final void onError(Throwable th) {
                a.this.innerError(th);
            }

            public final void onComplete() {
                a.this.innerComplete();
            }
        }
    }
}
