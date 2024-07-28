package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.g;

public final class al<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T> f46969b;

    public al(u<T> uVar, g<? super T> gVar) {
        super(uVar);
        this.f46969b = gVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46969b));
    }

    static final class a<T> extends io.reactivex.rxjava3.e.e.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final g<? super T> f46970a;

        a(w<? super T> wVar, g<? super T> gVar) {
            super(wVar);
            this.f46970a = gVar;
        }

        public final void onNext(T t) {
            this.f46714b.onNext(t);
            if (this.f46718f == 0) {
                try {
                    this.f46970a.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            T poll = this.f46716d.poll();
            if (poll != null) {
                this.f46970a.accept(poll);
            }
            return poll;
        }
    }
}
