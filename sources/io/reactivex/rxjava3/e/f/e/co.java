package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import java.util.Objects;

public final class co<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47185a;

    /* renamed from: b  reason: collision with root package name */
    final c<T, T, T> f47186b;

    public co(u<T> uVar, c<T, T, T> cVar) {
        this.f47185a = uVar;
        this.f47186b = cVar;
    }

    public final void b(m<? super T> mVar) {
        this.f47185a.subscribe(new a(mVar, this.f47186b));
    }

    static final class a<T> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f47187a;

        /* renamed from: b  reason: collision with root package name */
        final c<T, T, T> f47188b;

        /* renamed from: c  reason: collision with root package name */
        boolean f47189c;

        /* renamed from: d  reason: collision with root package name */
        T f47190d;

        /* renamed from: e  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f47191e;

        a(m<? super T> mVar, c<T, T, T> cVar) {
            this.f47187a = mVar;
            this.f47188b = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47191e, cVar)) {
                this.f47191e = cVar;
                this.f47187a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47189c) {
                T t2 = this.f47190d;
                if (t2 == null) {
                    this.f47190d = t;
                    return;
                }
                try {
                    this.f47190d = Objects.requireNonNull(this.f47188b.a(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    b.b(th);
                    this.f47191e.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47189c) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47189c = true;
            this.f47190d = null;
            this.f47187a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47189c) {
                this.f47189c = true;
                T t = this.f47190d;
                this.f47190d = null;
                if (t != null) {
                    this.f47187a.onSuccess(t);
                } else {
                    this.f47187a.onComplete();
                }
            }
        }

        public final void dispose() {
            this.f47191e.dispose();
        }

        public final boolean isDisposed() {
            return this.f47191e.isDisposed();
        }
    }
}
