package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.e;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class ct<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final e f47209b;

    public ct(p<T> pVar, e eVar) {
        super(pVar);
        this.f47209b = eVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f();
        wVar.onSubscribe(fVar);
        new a(wVar, this.f47209b, fVar, this.f46900a).subscribeNext();
    }

    static final class a<T> extends AtomicInteger implements w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final w<? super T> downstream;
        final u<? extends T> source;
        final e stop;
        final f upstream;

        a(w<? super T> wVar, e eVar, f fVar, u<? extends T> uVar) {
            this.downstream = wVar;
            this.upstream = fVar;
            this.source = uVar;
            this.stop = eVar;
        }

        public final void onSubscribe(c cVar) {
            this.upstream.replace(cVar);
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            try {
                if (this.stop.a()) {
                    this.downstream.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                b.b(th);
                this.downstream.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }
}
