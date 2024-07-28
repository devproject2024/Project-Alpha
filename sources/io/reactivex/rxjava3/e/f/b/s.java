package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.e.j.f;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.b;
import org.a.c;

public final class s<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final q<? super Throwable> f46823c;

    /* renamed from: d  reason: collision with root package name */
    final long f46824d;

    public s(h<T> hVar, long j, q<? super Throwable> qVar) {
        super(hVar);
        this.f46823c = qVar;
        this.f46824d = j;
    }

    public final void b(b<? super T> bVar) {
        f fVar = new f(false);
        bVar.onSubscribe(fVar);
        new a(bVar, this.f46824d, this.f46823c, fVar, this.f46770b).subscribeNext();
    }

    static final class a<T> extends AtomicInteger implements k<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        final q<? super Throwable> predicate;
        long produced;
        long remaining;
        final f sa;
        final org.a.a<? extends T> source;

        a(b<? super T> bVar, long j, q<? super Throwable> qVar, f fVar, org.a.a<? extends T> aVar) {
            this.downstream = bVar;
            this.sa = fVar;
            this.source = aVar;
            this.predicate = qVar;
            this.remaining = j;
        }

        public final void onSubscribe(c cVar) {
            this.sa.setSubscription(cVar);
        }

        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    this.downstream.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
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
                while (!this.sa.isCancelled()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0;
                        this.sa.produced(j);
                    }
                    this.source.a(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }
}
