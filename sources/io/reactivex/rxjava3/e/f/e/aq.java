package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.e;

public final class aq<T> extends l<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f46995a;

    /* renamed from: b  reason: collision with root package name */
    final long f46996b;

    public aq(u<T> uVar, long j) {
        this.f46995a = uVar;
        this.f46996b = j;
    }

    public final void b(m<? super T> mVar) {
        this.f46995a.subscribe(new a(mVar, this.f46996b));
    }

    public final p<T> U_() {
        return io.reactivex.rxjava3.h.a.a(new ap(this.f46995a, this.f46996b, null, false));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f46997a;

        /* renamed from: b  reason: collision with root package name */
        final long f46998b;

        /* renamed from: c  reason: collision with root package name */
        c f46999c;

        /* renamed from: d  reason: collision with root package name */
        long f47000d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47001e;

        a(m<? super T> mVar, long j) {
            this.f46997a = mVar;
            this.f46998b = j;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46999c, cVar)) {
                this.f46999c = cVar;
                this.f46997a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f46999c.dispose();
        }

        public final boolean isDisposed() {
            return this.f46999c.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47001e) {
                long j = this.f47000d;
                if (j == this.f46998b) {
                    this.f47001e = true;
                    this.f46999c.dispose();
                    this.f46997a.onSuccess(t);
                    return;
                }
                this.f47000d = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f47001e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47001e = true;
            this.f46997a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47001e) {
                this.f47001e = true;
                this.f46997a.onComplete();
            }
        }
    }
}
