package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.d;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class cw<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final d<? super Integer, ? super Throwable> f47228b;

    public cw(p<T> pVar, d<? super Integer, ? super Throwable> dVar) {
        super(pVar);
        this.f47228b = dVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f();
        wVar.onSubscribe(fVar);
        new a(wVar, this.f47228b, fVar, this.f46900a).subscribeNext();
    }

    static final class a<T> extends AtomicInteger implements w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final w<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final u<? extends T> source;
        final f upstream;

        a(w<? super T> wVar, d<? super Integer, ? super Throwable> dVar, f fVar, u<? extends T> uVar) {
            this.downstream = wVar;
            this.upstream = fVar;
            this.source = uVar;
            this.predicate = dVar;
        }

        public final void onSubscribe(c cVar) {
            this.upstream.replace(cVar);
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (!dVar.a(Integer.valueOf(i2), th)) {
                    this.downstream.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                b.b(th2);
                this.downstream.onError(new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        /* access modifiers changed from: package-private */
        public final void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }
}
