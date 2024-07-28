package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.f;

public final class ci<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super Throwable, ? extends u<? extends T>> f47166b;

    public ci(u<T> uVar, h<? super Throwable, ? extends u<? extends T>> hVar) {
        super(uVar);
        this.f47166b = hVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar, this.f47166b);
        wVar.onSubscribe(aVar.f47169c);
        this.f46900a.subscribe(aVar);
    }

    static final class a<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47167a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super Throwable, ? extends u<? extends T>> f47168b;

        /* renamed from: c  reason: collision with root package name */
        final f f47169c = new f();

        /* renamed from: d  reason: collision with root package name */
        boolean f47170d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47171e;

        a(w<? super T> wVar, h<? super Throwable, ? extends u<? extends T>> hVar) {
            this.f47167a = wVar;
            this.f47168b = hVar;
        }

        public final void onSubscribe(c cVar) {
            this.f47169c.replace(cVar);
        }

        public final void onNext(T t) {
            if (!this.f47171e) {
                this.f47167a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (!this.f47170d) {
                this.f47170d = true;
                try {
                    u uVar = (u) this.f47168b.apply(th);
                    if (uVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("Observable is null");
                        nullPointerException.initCause(th);
                        this.f47167a.onError(nullPointerException);
                        return;
                    }
                    uVar.subscribe(this);
                } catch (Throwable th2) {
                    b.b(th2);
                    this.f47167a.onError(new io.reactivex.rxjava3.c.a(th, th2));
                }
            } else if (this.f47171e) {
                io.reactivex.rxjava3.h.a.a(th);
            } else {
                this.f47167a.onError(th);
            }
        }

        public final void onComplete() {
            if (!this.f47171e) {
                this.f47171e = true;
                this.f47170d = true;
                this.f47167a.onComplete();
            }
        }
    }
}
