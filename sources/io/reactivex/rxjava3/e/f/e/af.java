package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.g.f;
import java.util.concurrent.TimeUnit;

public final class af<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f46930b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f46931c;

    /* renamed from: d  reason: collision with root package name */
    final x f46932d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f46933e;

    public af(u<T> uVar, long j, TimeUnit timeUnit, x xVar, boolean z) {
        super(uVar);
        this.f46930b = j;
        this.f46931c = timeUnit;
        this.f46932d = xVar;
        this.f46933e = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(!this.f46933e ? new f(wVar) : wVar, this.f46930b, this.f46931c, this.f46932d.a(), this.f46933e));
    }

    static final class a<T> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46934a;

        /* renamed from: b  reason: collision with root package name */
        final long f46935b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f46936c;

        /* renamed from: d  reason: collision with root package name */
        final x.c f46937d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f46938e;

        /* renamed from: f  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f46939f;

        a(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, boolean z) {
            this.f46934a = wVar;
            this.f46935b = j;
            this.f46936c = timeUnit;
            this.f46937d = cVar;
            this.f46938e = z;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46939f, cVar)) {
                this.f46939f = cVar;
                this.f46934a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f46937d.a(new c(t), this.f46935b, this.f46936c);
        }

        public final void onError(Throwable th) {
            this.f46937d.a(new b(th), this.f46938e ? this.f46935b : 0, this.f46936c);
        }

        public final void onComplete() {
            this.f46937d.a(new C0802a(), this.f46935b, this.f46936c);
        }

        public final void dispose() {
            this.f46939f.dispose();
            this.f46937d.dispose();
        }

        public final boolean isDisposed() {
            return this.f46937d.isDisposed();
        }

        final class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final T f46944b;

            c(T t) {
                this.f46944b = t;
            }

            public final void run() {
                a.this.f46934a.onNext(this.f46944b);
            }
        }

        final class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final Throwable f46942b;

            b(Throwable th) {
                this.f46942b = th;
            }

            public final void run() {
                try {
                    a.this.f46934a.onError(this.f46942b);
                } finally {
                    a.this.f46937d.dispose();
                }
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.af$a$a  reason: collision with other inner class name */
        final class C0802a implements Runnable {
            C0802a() {
            }

            public final void run() {
                try {
                    a.this.f46934a.onComplete();
                } finally {
                    a.this.f46937d.dispose();
                }
            }
        }
    }
}
