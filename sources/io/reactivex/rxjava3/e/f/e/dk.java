package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayDeque;

public final class dk<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f47293b;

    public dk(u<T> uVar, int i2) {
        super(uVar);
        this.f47293b = i2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47293b));
    }

    static final class a<T> extends ArrayDeque<T> implements w<T>, c {
        private static final long serialVersionUID = -3807491841935125653L;
        final w<? super T> downstream;
        final int skip;
        c upstream;

        a(w<? super T> wVar, int i2) {
            super(i2);
            this.downstream = wVar;
            this.skip = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}
