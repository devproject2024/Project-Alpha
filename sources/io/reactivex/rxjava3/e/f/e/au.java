package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.q;

public final class au<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47013b;

    public au(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47013b = qVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47013b));
    }

    static final class a<T> extends io.reactivex.rxjava3.e.e.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final q<? super T> f47014a;

        a(w<? super T> wVar, q<? super T> qVar) {
            super(wVar);
            this.f47014a = qVar;
        }

        public final void onNext(T t) {
            if (this.f46718f == 0) {
                try {
                    if (this.f47014a.test(t)) {
                        this.f46714b.onNext(t);
                    }
                } catch (Throwable th) {
                    a(th);
                }
            } else {
                this.f46714b.onNext(null);
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
                r2 = this;
            L_0x0000:
                io.reactivex.rxjava3.e.c.f r0 = r2.f46716d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.rxjava3.d.q<? super T> r1 = r2.f47014a
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.au.a.poll():java.lang.Object");
        }
    }
}
