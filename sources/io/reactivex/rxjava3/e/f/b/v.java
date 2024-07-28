package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.j.c;
import io.reactivex.rxjava3.e.j.g;
import java.util.NoSuchElementException;
import org.a.b;

public final class v<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final T f46833c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46834d = true;

    public v(h<T> hVar, T t) {
        super(hVar);
        this.f46833c = t;
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar, this.f46833c, this.f46834d));
    }

    static final class a<T> extends c<T> implements k<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        org.a.c upstream;

        a(b<? super T> bVar, T t, boolean z) {
            super(bVar);
            this.defaultValue = t;
            this.failOnEmpty = z;
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.upstream.cancel();
                    this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
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
                T t = this.value;
                this.value = null;
                if (t == null) {
                    t = this.defaultValue;
                }
                if (t != null) {
                    complete(t);
                } else if (this.failOnEmpty) {
                    this.downstream.onError(new NoSuchElementException());
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public final void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
