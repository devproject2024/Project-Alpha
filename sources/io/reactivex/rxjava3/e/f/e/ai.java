package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.g;

public final class ai<T> extends a<T, T> {
    public ai(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        w<? super T> f46957a;

        /* renamed from: b  reason: collision with root package name */
        c f46958b;

        a(w<? super T> wVar) {
            this.f46957a = wVar;
        }

        public final void dispose() {
            c cVar = this.f46958b;
            this.f46958b = g.INSTANCE;
            this.f46957a = g.asObserver();
            cVar.dispose();
        }

        public final boolean isDisposed() {
            return this.f46958b.isDisposed();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46958b, cVar)) {
                this.f46958b = cVar;
                this.f46957a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f46957a.onNext(t);
        }

        public final void onError(Throwable th) {
            w<? super T> wVar = this.f46957a;
            this.f46958b = g.INSTANCE;
            this.f46957a = g.asObserver();
            wVar.onError(th);
        }

        public final void onComplete() {
            w<? super T> wVar = this.f46957a;
            this.f46958b = g.INSTANCE;
            this.f46957a = g.asObserver();
            wVar.onComplete();
        }
    }
}
