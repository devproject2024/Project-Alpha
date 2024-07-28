package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;
import java.util.Collection;
import java.util.Objects;

public final class aj<T, K> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, K> f46959b;

    /* renamed from: c  reason: collision with root package name */
    final r<? extends Collection<? super K>> f46960c;

    public aj(u<T> uVar, h<? super T, K> hVar, r<? extends Collection<? super K>> rVar) {
        super(uVar);
        this.f46959b = hVar;
        this.f46960c = rVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            this.f46900a.subscribe(new a(wVar, this.f46959b, (Collection) j.a(this.f46960c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T, K> extends io.reactivex.rxjava3.e.e.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<? super K> f46961a;

        /* renamed from: g  reason: collision with root package name */
        final h<? super T, K> f46962g;

        a(w<? super T> wVar, h<? super T, K> hVar, Collection<? super K> collection) {
            super(wVar);
            this.f46962g = hVar;
            this.f46961a = collection;
        }

        public final void onNext(T t) {
            if (!this.f46717e) {
                if (this.f46718f == 0) {
                    try {
                        if (this.f46961a.add(Objects.requireNonNull(this.f46962g.apply(t), "The keySelector returned a null key"))) {
                            this.f46714b.onNext(t);
                        }
                    } catch (Throwable th) {
                        a(th);
                    }
                } else {
                    this.f46714b.onNext(null);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f46717e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46717e = true;
            this.f46961a.clear();
            this.f46714b.onError(th);
        }

        public final void onComplete() {
            if (!this.f46717e) {
                this.f46717e = true;
                this.f46961a.clear();
                this.f46714b.onComplete();
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final T poll() throws java.lang.Throwable {
            /*
                r4 = this;
            L_0x0000:
                io.reactivex.rxjava3.e.c.f r0 = r4.f46716d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x001c
                java.util.Collection<? super K> r1 = r4.f46961a
                io.reactivex.rxjava3.d.h<? super T, K> r2 = r4.f46962g
                java.lang.Object r2 = r2.apply(r0)
                java.lang.String r3 = "The keySelector returned a null key"
                java.lang.Object r2 = java.util.Objects.requireNonNull(r2, r3)
                boolean r1 = r1.add(r2)
                if (r1 == 0) goto L_0x0000
            L_0x001c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.aj.a.poll():java.lang.Object");
        }

        public final void clear() {
            this.f46961a.clear();
            super.clear();
        }
    }
}
