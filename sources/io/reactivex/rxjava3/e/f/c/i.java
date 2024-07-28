package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class i<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final n<T> f46864a;

    /* renamed from: b  reason: collision with root package name */
    final ac<? extends T> f46865b;

    public i(n<T> nVar, ac<? extends T> acVar) {
        this.f46864a = nVar;
        this.f46865b = acVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f46864a.a(new a(aaVar, this.f46865b));
    }

    static final class a<T> extends AtomicReference<c> implements m<T>, c {
        private static final long serialVersionUID = 4603919676453758899L;
        final aa<? super T> downstream;
        final ac<? extends T> other;

        a(aa<? super T> aaVar, ac<? extends T> acVar) {
            this.downstream = aaVar;
            this.other = acVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            c cVar = (c) get();
            if (cVar != io.reactivex.rxjava3.e.a.c.DISPOSED && compareAndSet(cVar, (Object) null)) {
                this.other.a(new C0793a(this.downstream, this));
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.c.i$a$a  reason: collision with other inner class name */
        static final class C0793a<T> implements aa<T> {

            /* renamed from: a  reason: collision with root package name */
            final aa<? super T> f46866a;

            /* renamed from: b  reason: collision with root package name */
            final AtomicReference<c> f46867b;

            C0793a(aa<? super T> aaVar, AtomicReference<c> atomicReference) {
                this.f46866a = aaVar;
                this.f46867b = atomicReference;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this.f46867b, cVar);
            }

            public final void onSuccess(T t) {
                this.f46866a.onSuccess(t);
            }

            public final void onError(Throwable th) {
                this.f46866a.onError(th);
            }
        }
    }
}
