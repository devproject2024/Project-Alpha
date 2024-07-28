package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class x<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final n<? extends T> f47567b;

    public x(p<T> pVar, n<? extends T> nVar) {
        super(pVar);
        this.f47567b = nVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47567b));
    }

    static final class a<T> extends AtomicReference<c> implements m<T>, w<T>, c {
        private static final long serialVersionUID = -1953724749712440952L;
        final w<? super T> downstream;
        boolean inMaybe;
        n<? extends T> other;

        a(w<? super T> wVar, n<? extends T> nVar) {
            this.downstream = wVar;
            this.other = nVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar) && !this.inMaybe) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            io.reactivex.rxjava3.e.a.c.replace(this, (c) null);
            n<? extends T> nVar = this.other;
            this.other = null;
            nVar.a(this);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
