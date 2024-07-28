package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.c;
import java.util.Objects;

public final class m<T, U> extends a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final h<? super T, ? extends U> f46812c;

    public m(io.reactivex.rxjava3.a.h<T> hVar, h<? super T, ? extends U> hVar2) {
        super(hVar);
        this.f46812c = hVar2;
    }

    public final void b(org.a.b<? super U> bVar) {
        if (bVar instanceof c) {
            this.f46770b.a(new a((c) bVar, this.f46812c));
        } else {
            this.f46770b.a(new b(bVar, this.f46812c));
        }
    }

    static final class b<T, U> extends io.reactivex.rxjava3.e.i.b<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, ? extends U> f46814a;

        b(org.a.b<? super U> bVar, h<? super T, ? extends U> hVar) {
            super(bVar);
            this.f46814a = hVar;
        }

        public final void onNext(T t) {
            if (!this.f47725h) {
                if (this.f47726i != 0) {
                    this.f47722e.onNext(null);
                    return;
                }
                try {
                    this.f47722e.onNext(Objects.requireNonNull(this.f46814a.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final U poll() throws Throwable {
            Object poll = this.f47724g.poll();
            if (poll != null) {
                return Objects.requireNonNull(this.f46814a.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    static final class a<T, U> extends io.reactivex.rxjava3.e.i.a<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, ? extends U> f46813a;

        a(c<? super U> cVar, h<? super T, ? extends U> hVar) {
            super(cVar);
            this.f46813a = hVar;
        }

        public final void onNext(T t) {
            if (!this.f47720h) {
                if (this.f47721i != 0) {
                    this.f47717e.onNext(null);
                    return;
                }
                try {
                    this.f47717e.onNext(Objects.requireNonNull(this.f46813a.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final boolean a(T t) {
            if (this.f47720h) {
                return false;
            }
            try {
                return this.f47717e.a(Objects.requireNonNull(this.f46813a.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final U poll() throws Throwable {
            Object poll = this.f47719g.poll();
            if (poll != null) {
                return Objects.requireNonNull(this.f46813a.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
