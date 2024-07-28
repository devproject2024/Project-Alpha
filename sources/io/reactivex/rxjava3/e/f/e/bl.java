package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.g;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;

public final class bl<T, S> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<S> f47061a;

    /* renamed from: b  reason: collision with root package name */
    final c<S, g<T>, S> f47062b;

    /* renamed from: c  reason: collision with root package name */
    final io.reactivex.rxjava3.d.g<? super S> f47063c;

    public bl(r<S> rVar, c<S, g<T>, S> cVar, io.reactivex.rxjava3.d.g<? super S> gVar) {
        this.f47061a = rVar;
        this.f47062b = cVar;
        this.f47063c = gVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            a aVar = new a(wVar, this.f47062b, this.f47063c, this.f47061a.get());
            wVar.onSubscribe(aVar);
            S s = aVar.f47067d;
            if (aVar.f47068e) {
                aVar.f47067d = null;
                aVar.a(s);
                return;
            }
            c<S, ? super g<T>, S> cVar = aVar.f47065b;
            while (!aVar.f47068e) {
                aVar.f47070g = false;
                try {
                    s = cVar.a(s, aVar);
                    if (aVar.f47069f) {
                        aVar.f47068e = true;
                        aVar.f47067d = null;
                        aVar.a(s);
                        return;
                    }
                } catch (Throwable th) {
                    b.b(th);
                    aVar.f47067d = null;
                    aVar.f47068e = true;
                    aVar.onError(th);
                    aVar.a(s);
                    return;
                }
            }
            aVar.f47067d = null;
            aVar.a(s);
        } catch (Throwable th2) {
            b.b(th2);
            d.error(th2, (w<?>) wVar);
        }
    }

    static final class a<T, S> implements g<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47064a;

        /* renamed from: b  reason: collision with root package name */
        final c<S, ? super g<T>, S> f47065b;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.rxjava3.d.g<? super S> f47066c;

        /* renamed from: d  reason: collision with root package name */
        S f47067d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f47068e;

        /* renamed from: f  reason: collision with root package name */
        boolean f47069f;

        /* renamed from: g  reason: collision with root package name */
        boolean f47070g;

        a(w<? super T> wVar, c<S, ? super g<T>, S> cVar, io.reactivex.rxjava3.d.g<? super S> gVar, S s) {
            this.f47064a = wVar;
            this.f47065b = cVar;
            this.f47066c = gVar;
            this.f47067d = s;
        }

        /* access modifiers changed from: package-private */
        public final void a(S s) {
            try {
                this.f47066c.accept(s);
            } catch (Throwable th) {
                b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final void dispose() {
            this.f47068e = true;
        }

        public final boolean isDisposed() {
            return this.f47068e;
        }

        public final void onNext(T t) {
            if (this.f47069f) {
                return;
            }
            if (this.f47070g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(j.a("onNext called with a null value."));
            } else {
                this.f47070g = true;
                this.f47064a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (this.f47069f) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            if (th == null) {
                th = j.a("onError called with a null Throwable.");
            }
            this.f47069f = true;
            this.f47064a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47069f) {
                this.f47069f = true;
                this.f47064a.onComplete();
            }
        }
    }
}
