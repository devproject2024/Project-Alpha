package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayDeque;

public final class ds<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f47331b;

    public ds(u<T> uVar, int i2) {
        super(uVar);
        this.f47331b = i2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47331b));
    }

    static final class a<T> extends ArrayDeque<T> implements w<T>, c {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final w<? super T> downstream;
        c upstream;

        a(w<? super T> wVar, int i2) {
            this.downstream = wVar;
            this.count = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            w<? super T> wVar = this.downstream;
            while (!this.cancelled) {
                Object poll = poll();
                if (poll == null) {
                    wVar.onComplete();
                    return;
                }
                wVar.onNext(poll);
            }
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }
    }
}
