package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicLong;
import org.a.b;
import org.a.c;

public final class p<T> extends a<T, T> implements g<T> {

    /* renamed from: c  reason: collision with root package name */
    final g<? super T> f46822c = this;

    public final void accept(T t) {
    }

    public p(h<T> hVar) {
        super(hVar);
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar, this.f46822c));
    }

    static final class a<T> extends AtomicLong implements k<T>, c {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final b<? super T> downstream;
        final g<? super T> onDrop;
        c upstream;

        a(b<? super T> bVar, g<? super T> gVar) {
            this.downstream = bVar;
            this.onDrop = gVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.j.g.validate(this.upstream, cVar)) {
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
                try {
                    this.onDrop.accept(t);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    cancel();
                    onError(th);
                }
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
            if (io.reactivex.rxjava3.e.j.g.validate(j)) {
                d.a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.upstream.cancel();
        }
    }
}
