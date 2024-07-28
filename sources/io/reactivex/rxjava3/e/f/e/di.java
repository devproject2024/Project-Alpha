package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.NoSuchElementException;

public final class di<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f47282a;

    /* renamed from: b  reason: collision with root package name */
    final T f47283b;

    public di(u<? extends T> uVar, T t) {
        this.f47282a = uVar;
        this.f47283b = t;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47282a.subscribe(new a(aaVar, this.f47283b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f47284a;

        /* renamed from: b  reason: collision with root package name */
        final T f47285b;

        /* renamed from: c  reason: collision with root package name */
        c f47286c;

        /* renamed from: d  reason: collision with root package name */
        T f47287d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47288e;

        a(aa<? super T> aaVar, T t) {
            this.f47284a = aaVar;
            this.f47285b = t;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47286c, cVar)) {
                this.f47286c = cVar;
                this.f47284a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47286c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47286c.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47288e) {
                if (this.f47287d != null) {
                    this.f47288e = true;
                    this.f47286c.dispose();
                    this.f47284a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f47287d = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f47288e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47288e = true;
            this.f47284a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47288e) {
                this.f47288e = true;
                T t = this.f47287d;
                this.f47287d = null;
                if (t == null) {
                    t = this.f47285b;
                }
                if (t != null) {
                    this.f47284a.onSuccess(t);
                } else {
                    this.f47284a.onError(new NoSuchElementException());
                }
            }
        }
    }
}
