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

public final class j<T> extends y<Boolean> implements e<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47481a;

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47482b;

    public j(u<T> uVar, q<? super T> qVar) {
        this.f47481a = uVar;
        this.f47482b = qVar;
    }

    public final void b(aa<? super Boolean> aaVar) {
        this.f47481a.subscribe(new a(aaVar, this.f47482b));
    }

    public final p<Boolean> U_() {
        return io.reactivex.rxjava3.h.a.a(new i(this.f47481a, this.f47482b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super Boolean> f47483a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47484b;

        /* renamed from: c  reason: collision with root package name */
        c f47485c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47486d;

        a(aa<? super Boolean> aaVar, q<? super T> qVar) {
            this.f47483a = aaVar;
            this.f47484b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47485c, cVar)) {
                this.f47485c = cVar;
                this.f47483a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47486d) {
                try {
                    if (this.f47484b.test(t)) {
                        this.f47486d = true;
                        this.f47485c.dispose();
                        this.f47483a.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f47485c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47486d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47486d = true;
            this.f47483a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47486d) {
                this.f47486d = true;
                this.f47483a.onSuccess(Boolean.FALSE);
            }
        }

        public final void dispose() {
            this.f47485c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47485c.isDisposed();
        }
    }
}
