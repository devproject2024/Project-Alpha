package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.e.j.c;
import org.a.b;

public final class p<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final ac<? extends T> f47616b;

    public p(ac<? extends T> acVar) {
        this.f47616b = acVar;
    }

    public final void b(b<? super T> bVar) {
        this.f47616b.a(new a(bVar));
    }

    static final class a<T> extends c<T> implements aa<T> {
        private static final long serialVersionUID = 187782011903685568L;
        io.reactivex.rxjava3.b.c upstream;

        a(b<? super T> bVar) {
            super(bVar);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            complete(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void cancel() {
            super.cancel();
            this.upstream.dispose();
        }
    }
}
