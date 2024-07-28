package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.b;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.c.e;
import java.util.Objects;

public final class r<T, U> extends y<U> implements e<U> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47542a;

    /* renamed from: b  reason: collision with root package name */
    final io.reactivex.rxjava3.d.r<? extends U> f47543b;

    /* renamed from: c  reason: collision with root package name */
    final b<? super U, ? super T> f47544c;

    public r(u<T> uVar, io.reactivex.rxjava3.d.r<? extends U> rVar, b<? super U, ? super T> bVar) {
        this.f47542a = uVar;
        this.f47543b = rVar;
        this.f47544c = bVar;
    }

    public final void b(aa<? super U> aaVar) {
        try {
            this.f47542a.subscribe(new a(aaVar, Objects.requireNonNull(this.f47543b.get(), "The initialSupplier returned a null value"), this.f47544c));
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (aa<?>) aaVar);
        }
    }

    public final p<U> U_() {
        return io.reactivex.rxjava3.h.a.a(new q(this.f47542a, this.f47543b, this.f47544c));
    }

    static final class a<T, U> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super U> f47545a;

        /* renamed from: b  reason: collision with root package name */
        final b<? super U, ? super T> f47546b;

        /* renamed from: c  reason: collision with root package name */
        final U f47547c;

        /* renamed from: d  reason: collision with root package name */
        c f47548d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47549e;

        a(aa<? super U> aaVar, U u, b<? super U, ? super T> bVar) {
            this.f47545a = aaVar;
            this.f47546b = bVar;
            this.f47547c = u;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47548d, cVar)) {
                this.f47548d = cVar;
                this.f47545a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47548d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47548d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47549e) {
                try {
                    this.f47546b.accept(this.f47547c, t);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f47548d.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47549e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47549e = true;
            this.f47545a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47549e) {
                this.f47549e = true;
                this.f47545a.onSuccess(this.f47547c);
            }
        }
    }
}
