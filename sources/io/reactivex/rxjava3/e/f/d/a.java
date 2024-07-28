package io.reactivex.rxjava3.e.f.d;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final n<T> f46869a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<? extends R>> f46870b;

    public a(n<T> nVar, h<? super T, ? extends u<? extends R>> hVar) {
        this.f46869a = nVar;
        this.f46870b = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        C0794a aVar = new C0794a(wVar, this.f46870b);
        wVar.onSubscribe(aVar);
        this.f46869a.a(aVar);
    }

    /* renamed from: io.reactivex.rxjava3.e.f.d.a$a  reason: collision with other inner class name */
    static final class C0794a<T, R> extends AtomicReference<c> implements m<T>, w<R>, c {
        private static final long serialVersionUID = -8948264376121066672L;
        final w<? super R> downstream;
        final h<? super T, ? extends u<? extends R>> mapper;

        C0794a(w<? super R> wVar, h<? super T, ? extends u<? extends R>> hVar) {
            this.downstream = wVar;
            this.mapper = hVar;
        }

        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this, cVar);
        }

        public final void onSuccess(T t) {
            try {
                u uVar = (u) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (!isDisposed()) {
                    uVar.subscribe(this);
                }
            } catch (Throwable th) {
                b.b(th);
                this.downstream.onError(th);
            }
        }
    }
}
