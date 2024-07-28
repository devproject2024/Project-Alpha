package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class cs<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47208b;

    public cs(p<T> pVar, long j) {
        super(pVar);
        this.f47208b = j;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f();
        wVar.onSubscribe(fVar);
        long j = this.f47208b;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new a(wVar, j2, fVar, this.f46900a).subscribeNext();
    }

    static final class a<T> extends AtomicInteger implements w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final w<? super T> downstream;
        long remaining;
        final f sd;
        final u<? extends T> source;

        a(w<? super T> wVar, long j, f fVar, u<? extends T> uVar) {
            this.downstream = wVar;
            this.sd = fVar;
            this.source = uVar;
            this.remaining = j;
        }

        public final void onSubscribe(c cVar) {
            this.sd.replace(cVar);
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public final void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.sd.isDisposed()) {
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
