package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;

public final class dr<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47326b;

    public dr(u<T> uVar, long j) {
        super(uVar);
        this.f47326b = j;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47326b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47327a;

        /* renamed from: b  reason: collision with root package name */
        boolean f47328b;

        /* renamed from: c  reason: collision with root package name */
        c f47329c;

        /* renamed from: d  reason: collision with root package name */
        long f47330d;

        a(w<? super T> wVar, long j) {
            this.f47327a = wVar;
            this.f47330d = j;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47329c, cVar)) {
                this.f47329c = cVar;
                if (this.f47330d == 0) {
                    this.f47328b = true;
                    cVar.dispose();
                    d.complete((w<?>) this.f47327a);
                    return;
                }
                this.f47327a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47328b) {
                long j = this.f47330d;
                this.f47330d = j - 1;
                if (j > 0) {
                    boolean z = this.f47330d == 0;
                    this.f47327a.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47328b) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47328b = true;
            this.f47329c.dispose();
            this.f47327a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47328b) {
                this.f47328b = true;
                this.f47329c.dispose();
                this.f47327a.onComplete();
            }
        }

        public final void dispose() {
            this.f47329c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47329c.isDisposed();
        }
    }
}
