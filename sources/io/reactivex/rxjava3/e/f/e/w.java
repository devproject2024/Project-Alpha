package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class w<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final f f47566b;

    public w(p<T> pVar, f fVar) {
        super(pVar);
        this.f47566b = fVar;
    }

    public final void subscribeActual(io.reactivex.rxjava3.a.w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47566b));
    }

    static final class a<T> extends AtomicReference<c> implements d, io.reactivex.rxjava3.a.w<T>, c {
        private static final long serialVersionUID = -1953724749712440952L;
        final io.reactivex.rxjava3.a.w<? super T> downstream;
        boolean inCompletable;
        f other;

        a(io.reactivex.rxjava3.a.w<? super T> wVar, f fVar) {
            this.downstream = wVar;
            this.other = fVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar) && !this.inCompletable) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            io.reactivex.rxjava3.e.a.c.replace(this, (c) null);
            f fVar = this.other;
            this.other = null;
            fVar.a(this);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
