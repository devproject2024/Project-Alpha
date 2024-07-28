package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;

public final class bz<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends U> f47139b;

    public bz(u<T> uVar, h<? super T, ? extends U> hVar) {
        super(uVar);
        this.f47139b = hVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47139b));
    }

    static final class a<T, U> extends io.reactivex.rxjava3.e.e.a<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, ? extends U> f47140a;

        a(w<? super U> wVar, h<? super T, ? extends U> hVar) {
            super(wVar);
            this.f47140a = hVar;
        }

        public final void onNext(T t) {
            if (!this.f46717e) {
                if (this.f46718f != 0) {
                    this.f46714b.onNext(null);
                    return;
                }
                try {
                    this.f46714b.onNext(Objects.requireNonNull(this.f47140a.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final U poll() throws Throwable {
            Object poll = this.f46716d.poll();
            if (poll != null) {
                return Objects.requireNonNull(this.f47140a.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
