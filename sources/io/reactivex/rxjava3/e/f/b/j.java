package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import org.a.b;
import org.a.c;

public final class j<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final u<T> f46808b;

    public j(u<T> uVar) {
        this.f46808b = uVar;
    }

    public final void b(b<? super T> bVar) {
        this.f46808b.subscribe(new a(bVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f46809a;

        /* renamed from: b  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f46810b;

        public final void request(long j) {
        }

        a(b<? super T> bVar) {
            this.f46809a = bVar;
        }

        public final void onComplete() {
            this.f46809a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f46809a.onError(th);
        }

        public final void onNext(T t) {
            this.f46809a.onNext(t);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            this.f46810b = cVar;
            this.f46809a.onSubscribe(this);
        }

        public final void cancel() {
            this.f46810b.dispose();
        }
    }
}
