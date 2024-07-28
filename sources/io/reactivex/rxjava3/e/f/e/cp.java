package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import java.util.Objects;

public final class cp<T, R> extends y<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47192a;

    /* renamed from: b  reason: collision with root package name */
    final R f47193b;

    /* renamed from: c  reason: collision with root package name */
    final c<R, ? super T, R> f47194c;

    public cp(u<T> uVar, R r, c<R, ? super T, R> cVar) {
        this.f47192a = uVar;
        this.f47193b = r;
        this.f47194c = cVar;
    }

    public final void b(aa<? super R> aaVar) {
        this.f47192a.subscribe(new a(aaVar, this.f47194c, this.f47193b));
    }

    static final class a<T, R> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super R> f47195a;

        /* renamed from: b  reason: collision with root package name */
        final c<R, ? super T, R> f47196b;

        /* renamed from: c  reason: collision with root package name */
        R f47197c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f47198d;

        a(aa<? super R> aaVar, c<R, ? super T, R> cVar, R r) {
            this.f47195a = aaVar;
            this.f47197c = r;
            this.f47196b = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47198d, cVar)) {
                this.f47198d = cVar;
                this.f47195a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            R r = this.f47197c;
            if (r != null) {
                try {
                    this.f47197c = Objects.requireNonNull(this.f47196b.a(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    b.b(th);
                    this.f47198d.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47197c != null) {
                this.f47197c = null;
                this.f47195a.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            R r = this.f47197c;
            if (r != null) {
                this.f47197c = null;
                this.f47195a.onSuccess(r);
            }
        }

        public final void dispose() {
            this.f47198d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47198d.isDisposed();
        }
    }
}
