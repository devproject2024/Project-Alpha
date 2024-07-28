package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.d;
import io.reactivex.rxjava3.e.j.g;
import java.util.NoSuchElementException;

public final class w<T> extends y<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    final h<T> f46835a;

    /* renamed from: b  reason: collision with root package name */
    final T f46836b = null;

    public w(h<T> hVar) {
        this.f46835a = hVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f46835a.a(new a(aaVar, this.f46836b));
    }

    public final h<T> a() {
        return io.reactivex.rxjava3.h.a.a(new v(this.f46835a, this.f46836b));
    }

    static final class a<T> implements k<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f46837a;

        /* renamed from: b  reason: collision with root package name */
        final T f46838b;

        /* renamed from: c  reason: collision with root package name */
        org.a.c f46839c;

        /* renamed from: d  reason: collision with root package name */
        boolean f46840d;

        /* renamed from: e  reason: collision with root package name */
        T f46841e;

        a(aa<? super T> aaVar, T t) {
            this.f46837a = aaVar;
            this.f46838b = t;
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.f46839c, cVar)) {
                this.f46839c = cVar;
                this.f46837a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f46840d) {
                if (this.f46841e != null) {
                    this.f46840d = true;
                    this.f46839c.cancel();
                    this.f46839c = g.CANCELLED;
                    this.f46837a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f46841e = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f46840d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46840d = true;
            this.f46839c = g.CANCELLED;
            this.f46837a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46840d) {
                this.f46840d = true;
                this.f46839c = g.CANCELLED;
                T t = this.f46841e;
                this.f46841e = null;
                if (t == null) {
                    t = this.f46838b;
                }
                if (t != null) {
                    this.f46837a.onSuccess(t);
                } else {
                    this.f46837a.onError(new NoSuchElementException());
                }
            }
        }

        public final void dispose() {
            this.f46839c.cancel();
            this.f46839c = g.CANCELLED;
        }

        public final boolean isDisposed() {
            return this.f46839c == g.CANCELLED;
        }
    }
}
