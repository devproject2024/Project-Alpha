package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;

public final class k<T, R> extends y<R> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47602a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends R> f47603b;

    public k(ac<? extends T> acVar, h<? super T, ? extends R> hVar) {
        this.f47602a = acVar;
        this.f47603b = hVar;
    }

    public final void b(aa<? super R> aaVar) {
        this.f47602a.a(new a(aaVar, this.f47603b));
    }

    static final class a<T, R> implements aa<T> {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super R> f47604a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends R> f47605b;

        a(aa<? super R> aaVar, h<? super T, ? extends R> hVar) {
            this.f47604a = aaVar;
            this.f47605b = hVar;
        }

        public final void onSubscribe(c cVar) {
            this.f47604a.onSubscribe(cVar);
        }

        public final void onSuccess(T t) {
            try {
                this.f47604a.onSuccess(Objects.requireNonNull(this.f47605b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                b.b(th);
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.f47604a.onError(th);
        }
    }
}
