package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.f;

public final class dp<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final u<? extends T> f47318b;

    public dp(u<T> uVar, u<? extends T> uVar2) {
        super(uVar);
        this.f47318b = uVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar, this.f47318b);
        wVar.onSubscribe(aVar.f47321c);
        this.f46900a.subscribe(aVar);
    }

    static final class a<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47319a;

        /* renamed from: b  reason: collision with root package name */
        final u<? extends T> f47320b;

        /* renamed from: c  reason: collision with root package name */
        final f f47321c = new f();

        /* renamed from: d  reason: collision with root package name */
        boolean f47322d = true;

        a(w<? super T> wVar, u<? extends T> uVar) {
            this.f47319a = wVar;
            this.f47320b = uVar;
        }

        public final void onSubscribe(c cVar) {
            this.f47321c.update(cVar);
        }

        public final void onNext(T t) {
            if (this.f47322d) {
                this.f47322d = false;
            }
            this.f47319a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f47319a.onError(th);
        }

        public final void onComplete() {
            if (this.f47322d) {
                this.f47322d = false;
                this.f47320b.subscribe(this);
                return;
            }
            this.f47319a.onComplete();
        }
    }
}
