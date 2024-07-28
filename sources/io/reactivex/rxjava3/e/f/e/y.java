package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class y<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final ac<? extends T> f47568b;

    public y(p<T> pVar, ac<? extends T> acVar) {
        super(pVar);
        this.f47568b = acVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47568b));
    }

    static final class a<T> extends AtomicReference<c> implements aa<T>, w<T>, c {
        private static final long serialVersionUID = -1953724749712440952L;
        final w<? super T> downstream;
        boolean inSingle;
        ac<? extends T> other;

        a(w<? super T> wVar, ac<? extends T> acVar) {
            this.downstream = wVar;
            this.other = acVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar) && !this.inSingle) {
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
            this.inSingle = true;
            io.reactivex.rxjava3.e.a.c.replace(this, (c) null);
            ac<? extends T> acVar = this.other;
            this.other = null;
            acVar.a(this);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
