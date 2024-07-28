package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T, R> extends y<R> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47595a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends ac<? extends R>> f47596b;

    public g(ac<? extends T> acVar, h<? super T, ? extends ac<? extends R>> hVar) {
        this.f47596b = hVar;
        this.f47595a = acVar;
    }

    public final void b(aa<? super R> aaVar) {
        this.f47595a.a(new a(aaVar, this.f47596b));
    }

    static final class a<T, R> extends AtomicReference<c> implements aa<T>, c {
        private static final long serialVersionUID = 3258103020495908596L;
        final aa<? super R> downstream;
        final h<? super T, ? extends ac<? extends R>> mapper;

        a(aa<? super R> aaVar, h<? super T, ? extends ac<? extends R>> hVar) {
            this.downstream = aaVar;
            this.mapper = hVar;
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
            try {
                ac acVar = (ac) Objects.requireNonNull(this.mapper.apply(t), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    acVar.a(new C0822a(this, this.downstream));
                }
            } catch (Throwable th) {
                b.b(th);
                this.downstream.onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        /* renamed from: io.reactivex.rxjava3.e.f.f.g$a$a  reason: collision with other inner class name */
        static final class C0822a<R> implements aa<R> {

            /* renamed from: a  reason: collision with root package name */
            final AtomicReference<c> f47597a;

            /* renamed from: b  reason: collision with root package name */
            final aa<? super R> f47598b;

            C0822a(AtomicReference<c> atomicReference, aa<? super R> aaVar) {
                this.f47597a = atomicReference;
                this.f47598b = aaVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.replace(this.f47597a, cVar);
            }

            public final void onSuccess(R r) {
                this.f47598b.onSuccess(r);
            }

            public final void onError(Throwable th) {
                this.f47598b.onError(th);
            }
        }
    }
}
