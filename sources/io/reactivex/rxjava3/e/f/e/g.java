package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.e.c.e;

public final class g<T> extends y<Boolean> implements e<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47465a;

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47466b;

    public g(u<T> uVar, q<? super T> qVar) {
        this.f47465a = uVar;
        this.f47466b = qVar;
    }

    public final void b(aa<? super Boolean> aaVar) {
        this.f47465a.subscribe(new a(aaVar, this.f47466b));
    }

    public final p<Boolean> U_() {
        return io.reactivex.rxjava3.h.a.a(new f(this.f47465a, this.f47466b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super Boolean> f47467a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47468b;

        /* renamed from: c  reason: collision with root package name */
        c f47469c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47470d;

        a(aa<? super Boolean> aaVar, q<? super T> qVar) {
            this.f47467a = aaVar;
            this.f47468b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47469c, cVar)) {
                this.f47469c = cVar;
                this.f47467a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47470d) {
                try {
                    if (!this.f47468b.test(t)) {
                        this.f47470d = true;
                        this.f47469c.dispose();
                        this.f47467a.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f47469c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47470d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47470d = true;
            this.f47467a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47470d) {
                this.f47470d = true;
                this.f47467a.onSuccess(Boolean.TRUE);
            }
        }

        public final void dispose() {
            this.f47469c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47469c.isDisposed();
        }
    }
}
