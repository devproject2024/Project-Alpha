package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;

public final class e<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends R> f46852b;

    public e(n<T> nVar, h<? super T, ? extends R> hVar) {
        super(nVar);
        this.f46852b = hVar;
    }

    public final void b(m<? super R> mVar) {
        this.f46848a.a(new a(mVar, this.f46852b));
    }

    static final class a<T, R> implements m<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super R> f46853a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends R> f46854b;

        /* renamed from: c  reason: collision with root package name */
        c f46855c;

        a(m<? super R> mVar, h<? super T, ? extends R> hVar) {
            this.f46853a = mVar;
            this.f46854b = hVar;
        }

        public final void dispose() {
            c cVar = this.f46855c;
            this.f46855c = io.reactivex.rxjava3.e.a.c.DISPOSED;
            cVar.dispose();
        }

        public final boolean isDisposed() {
            return this.f46855c.isDisposed();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46855c, cVar)) {
                this.f46855c = cVar;
                this.f46853a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                this.f46853a.onSuccess(Objects.requireNonNull(this.f46854b.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                b.b(th);
                this.f46853a.onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.f46853a.onError(th);
        }

        public final void onComplete() {
            this.f46853a.onComplete();
        }
    }
}
