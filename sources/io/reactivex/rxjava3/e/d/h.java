package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import java.util.Objects;
import java.util.Optional;

public final class h<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46707a;

    /* renamed from: b  reason: collision with root package name */
    final io.reactivex.rxjava3.d.h<? super T, Optional<? extends R>> f46708b;

    public h(p<T> pVar, io.reactivex.rxjava3.d.h<? super T, Optional<? extends R>> hVar) {
        this.f46707a = pVar;
        this.f46708b = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        this.f46707a.subscribe(new a(wVar, this.f46708b));
    }

    static final class a<T, R> extends io.reactivex.rxjava3.e.e.a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.h<? super T, Optional<? extends R>> f46709a;

        a(w<? super R> wVar, io.reactivex.rxjava3.d.h<? super T, Optional<? extends R>> hVar) {
            super(wVar);
            this.f46709a = hVar;
        }

        public final void onNext(T t) {
            if (!this.f46717e) {
                if (this.f46718f != 0) {
                    this.f46714b.onNext(null);
                    return;
                }
                try {
                    Optional optional = (Optional) Objects.requireNonNull(this.f46709a.apply(t), "The mapper returned a null Optional");
                    if (optional.isPresent()) {
                        this.f46714b.onNext(optional.get());
                    }
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final R poll() throws Throwable {
            Optional optional;
            do {
                Object poll = this.f46716d.poll();
                if (poll == null) {
                    return null;
                }
                optional = (Optional) Objects.requireNonNull(this.f46709a.apply(poll), "The mapper returned a null Optional");
            } while (!optional.isPresent());
            return optional.get();
        }
    }
}
