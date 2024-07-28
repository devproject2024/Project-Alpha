package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.o;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.k.m;
import java.util.Objects;

public final class ah<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends o<R>> f46952b;

    public ah(u<T> uVar, h<? super T, ? extends o<R>> hVar) {
        super(uVar);
        this.f46952b = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46952b));
    }

    static final class a<T, R> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super R> f46953a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends o<R>> f46954b;

        /* renamed from: c  reason: collision with root package name */
        boolean f46955c;

        /* renamed from: d  reason: collision with root package name */
        c f46956d;

        a(w<? super R> wVar, h<? super T, ? extends o<R>> hVar) {
            this.f46953a = wVar;
            this.f46954b = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46956d, cVar)) {
                this.f46956d = cVar;
                this.f46953a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f46956d.dispose();
        }

        public final boolean isDisposed() {
            return this.f46956d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f46955c) {
                try {
                    o oVar = (o) Objects.requireNonNull(this.f46954b.apply(t), "The selector returned a null Notification");
                    if (m.isError(oVar.f46611a)) {
                        this.f46956d.dispose();
                        onError(oVar.d());
                    } else if (oVar.a()) {
                        this.f46956d.dispose();
                        onComplete();
                    } else {
                        this.f46953a.onNext(oVar.c());
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f46956d.dispose();
                    onError(th);
                }
            } else if (t instanceof o) {
                o oVar2 = (o) t;
                if (m.isError(oVar2.f46611a)) {
                    io.reactivex.rxjava3.h.a.a(oVar2.d());
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f46955c) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46955c = true;
            this.f46953a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46955c) {
                this.f46955c = true;
                this.f46953a.onComplete();
            }
        }
    }
}
