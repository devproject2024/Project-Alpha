package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicLong;
import org.a.b;
import org.a.c;

public final class q<T> extends a<T, T> {
    public q(h<T> hVar) {
        super(hVar);
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar));
    }

    static final class a<T> extends AtomicLong implements k<T>, c {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final b<? super T> downstream;
        c upstream;

        a(b<? super T> bVar) {
            this.downstream = bVar;
        }

        public final void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    d.b(this, 1);
                    return;
                }
                onError(new io.reactivex.rxjava3.c.c("could not emit value due to lack of requests"));
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public final void request(long j) {
            if (g.validate(j)) {
                d.a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.upstream.cancel();
        }
    }
}
