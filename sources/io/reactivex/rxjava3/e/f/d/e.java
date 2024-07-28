package io.reactivex.rxjava3.e.f.d;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T> extends b {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46883a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends f> f46884b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f46885c;

    public e(p<T> pVar, h<? super T, ? extends f> hVar, boolean z) {
        this.f46883a = pVar;
        this.f46884b = hVar;
        this.f46885c = z;
    }

    public final void b(d dVar) {
        if (!h.a((Object) this.f46883a, this.f46884b, dVar)) {
            this.f46883a.subscribe(new a(dVar, this.f46884b, this.f46885c));
        }
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: f  reason: collision with root package name */
        static final C0798a f46886f = new C0798a((a<?>) null);

        /* renamed from: a  reason: collision with root package name */
        final d f46887a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends f> f46888b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f46889c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.rxjava3.e.k.c f46890d = new io.reactivex.rxjava3.e.k.c();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<C0798a> f46891e = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f46892g;

        /* renamed from: h  reason: collision with root package name */
        c f46893h;

        a(d dVar, h<? super T, ? extends f> hVar, boolean z) {
            this.f46887a = dVar;
            this.f46888b = hVar;
            this.f46889c = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46893h, cVar)) {
                this.f46893h = cVar;
                this.f46887a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            C0798a aVar;
            try {
                f fVar = (f) Objects.requireNonNull(this.f46888b.apply(t), "The mapper returned a null CompletableSource");
                C0798a aVar2 = new C0798a(this);
                do {
                    aVar = this.f46891e.get();
                    if (aVar == f46886f) {
                        return;
                    }
                } while (!this.f46891e.compareAndSet(aVar, aVar2));
                if (aVar != null) {
                    aVar.dispose();
                }
                fVar.a(aVar2);
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.f46893h.dispose();
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            if (!this.f46890d.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.f46889c) {
                onComplete();
                return;
            }
            a();
            this.f46890d.tryTerminateConsumer(this.f46887a);
        }

        public final void onComplete() {
            this.f46892g = true;
            if (this.f46891e.get() == null) {
                this.f46890d.tryTerminateConsumer(this.f46887a);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            C0798a andSet = this.f46891e.getAndSet(f46886f);
            if (andSet != null && andSet != f46886f) {
                andSet.dispose();
            }
        }

        public final void dispose() {
            this.f46893h.dispose();
            a();
            this.f46890d.tryTerminateAndReport();
        }

        public final boolean isDisposed() {
            return this.f46891e.get() == f46886f;
        }

        /* renamed from: io.reactivex.rxjava3.e.f.d.e$a$a  reason: collision with other inner class name */
        static final class C0798a extends AtomicReference<c> implements d {
            private static final long serialVersionUID = -8003404460084760287L;
            final a<?> parent;

            C0798a(a<?> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onError(Throwable th) {
                a<?> aVar = this.parent;
                if (!aVar.f46891e.compareAndSet(this, (Object) null)) {
                    io.reactivex.rxjava3.h.a.a(th);
                } else if (!aVar.f46890d.tryAddThrowableOrReport(th)) {
                } else {
                    if (!aVar.f46889c) {
                        aVar.f46893h.dispose();
                        aVar.a();
                        aVar.f46890d.tryTerminateConsumer(aVar.f46887a);
                    } else if (aVar.f46892g) {
                        aVar.f46890d.tryTerminateConsumer(aVar.f46887a);
                    }
                }
            }

            public final void onComplete() {
                a<?> aVar = this.parent;
                if (aVar.f46891e.compareAndSet(this, (Object) null) && aVar.f46892g) {
                    aVar.f46890d.tryTerminateConsumer(aVar.f46887a);
                }
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
