package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cc<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final f f47155b;

    public cc(p<T> pVar, f fVar) {
        super(pVar);
        this.f47155b = fVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        this.f46900a.subscribe(aVar);
        this.f47155b.a(aVar.otherObserver);
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = -4592979584110982903L;
        final w<? super T> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final AtomicReference<c> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        volatile boolean otherDone;
        final C0808a otherObserver = new C0808a(this);

        a(w<? super T> wVar) {
            this.downstream = wVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.mainDisposable, cVar);
        }

        public final void onNext(T t) {
            k.a(this.downstream, t, (AtomicInteger) this, this.errors);
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.errors);
        }

        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                k.a(this.downstream, this, this.errors);
            }
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.mainDisposable.get());
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.mainDisposable);
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
            this.errors.tryTerminateAndReport();
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.mainDisposable);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.errors);
        }

        /* access modifiers changed from: package-private */
        public final void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                k.a(this.downstream, this, this.errors);
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.cc$a$a  reason: collision with other inner class name */
        static final class C0808a extends AtomicReference<c> implements d {
            private static final long serialVersionUID = -2935427570954647017L;
            final a<?> parent;

            C0808a(a<?> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }

            public final void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
