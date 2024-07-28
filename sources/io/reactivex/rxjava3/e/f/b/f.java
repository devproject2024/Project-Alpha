package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.e.c.c;

public final class f<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final q<? super T> f46797c;

    public f(h<T> hVar, q<? super T> qVar) {
        super(hVar);
        this.f46797c = qVar;
    }

    public final void b(org.a.b<? super T> bVar) {
        if (bVar instanceof c) {
            this.f46770b.a(new a((c) bVar, this.f46797c));
        } else {
            this.f46770b.a(new b(bVar, this.f46797c));
        }
    }

    static final class b<T> extends io.reactivex.rxjava3.e.i.b<T, T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        final q<? super T> f46799a;

        b(org.a.b<? super T> bVar, q<? super T> qVar) {
            super(bVar);
            this.f46799a = qVar;
        }

        public final void onNext(T t) {
            if (!a(t)) {
                this.f47723f.request(1);
            }
        }

        public final boolean a(T t) {
            if (this.f47725h) {
                return false;
            }
            if (this.f47726i != 0) {
                this.f47722e.onNext(null);
                return true;
            }
            try {
                boolean test = this.f46799a.test(t);
                if (test) {
                    this.f47722e.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            io.reactivex.rxjava3.e.c.h hVar = this.f47724g;
            q<? super T> qVar = this.f46799a;
            while (true) {
                T poll = hVar.poll();
                if (poll == null) {
                    return null;
                }
                if (qVar.test(poll)) {
                    return poll;
                }
                if (this.f47726i == 2) {
                    hVar.request(1);
                }
            }
        }
    }

    static final class a<T> extends io.reactivex.rxjava3.e.i.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final q<? super T> f46798a;

        a(c<? super T> cVar, q<? super T> qVar) {
            super(cVar);
            this.f46798a = qVar;
        }

        public final void onNext(T t) {
            if (!a(t)) {
                this.f47718f.request(1);
            }
        }

        public final boolean a(T t) {
            if (this.f47720h) {
                return false;
            }
            if (this.f47721i != 0) {
                return this.f47717e.a(null);
            }
            try {
                if (!this.f46798a.test(t) || !this.f47717e.a(t)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            io.reactivex.rxjava3.e.c.h hVar = this.f47719g;
            q<? super T> qVar = this.f46798a;
            while (true) {
                T poll = hVar.poll();
                if (poll == null) {
                    return null;
                }
                if (qVar.test(poll)) {
                    return poll;
                }
                if (this.f47721i == 2) {
                    hVar.request(1);
                }
            }
        }
    }
}
