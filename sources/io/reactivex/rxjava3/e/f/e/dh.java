package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class dh<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47277a;

    public dh(u<T> uVar) {
        this.f47277a = uVar;
    }

    public final void b(m<? super T> mVar) {
        this.f47277a.subscribe(new a(mVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f47278a;

        /* renamed from: b  reason: collision with root package name */
        c f47279b;

        /* renamed from: c  reason: collision with root package name */
        T f47280c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47281d;

        a(m<? super T> mVar) {
            this.f47278a = mVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47279b, cVar)) {
                this.f47279b = cVar;
                this.f47278a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47279b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47279b.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47281d) {
                if (this.f47280c != null) {
                    this.f47281d = true;
                    this.f47279b.dispose();
                    this.f47278a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f47280c = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f47281d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47281d = true;
            this.f47278a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47281d) {
                this.f47281d = true;
                T t = this.f47280c;
                this.f47280c = null;
                if (t == null) {
                    this.f47278a.onComplete();
                } else {
                    this.f47278a.onSuccess(t);
                }
            }
        }
    }
}
