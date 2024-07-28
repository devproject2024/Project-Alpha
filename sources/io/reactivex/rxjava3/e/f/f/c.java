package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.TimeUnit;

public final class c<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47574a;

    /* renamed from: b  reason: collision with root package name */
    final long f47575b = 1000;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47576c;

    /* renamed from: d  reason: collision with root package name */
    final x f47577d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47578e;

    public c(ac<? extends T> acVar, TimeUnit timeUnit, x xVar) {
        this.f47574a = acVar;
        this.f47576c = timeUnit;
        this.f47577d = xVar;
        this.f47578e = false;
    }

    public final void b(aa<? super T> aaVar) {
        f fVar = new f();
        aaVar.onSubscribe(fVar);
        this.f47574a.a(new a(fVar, aaVar));
    }

    final class a implements aa<T> {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f47579a;

        /* renamed from: c  reason: collision with root package name */
        private final f f47581c;

        a(f fVar, aa<? super T> aaVar) {
            this.f47581c = fVar;
            this.f47579a = aaVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            this.f47581c.replace(cVar);
        }

        public final void onSuccess(T t) {
            this.f47581c.replace(c.this.f47577d.a(new b(t), c.this.f47575b, c.this.f47576c));
        }

        public final void onError(Throwable th) {
            this.f47581c.replace(c.this.f47577d.a(new C0821a(th), c.this.f47578e ? c.this.f47575b : 0, c.this.f47576c));
        }

        final class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final T f47585b;

            b(T t) {
                this.f47585b = t;
            }

            public final void run() {
                a.this.f47579a.onSuccess(this.f47585b);
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.f.c$a$a  reason: collision with other inner class name */
        final class C0821a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final Throwable f47583b;

            C0821a(Throwable th) {
                this.f47583b = th;
            }

            public final void run() {
                a.this.f47579a.onError(this.f47583b);
            }
        }
    }
}
