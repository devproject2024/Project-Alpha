package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.t;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;

public final class by<R, T> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final t<? extends R, ? super T> f47138b;

    public by(u<T> uVar, t<? extends R, ? super T> tVar) {
        super(uVar);
        this.f47138b = tVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        try {
            w<? super Object> a2 = this.f47138b.a();
            this.f46900a.subscribe((w) Objects.requireNonNull(a2, "Operator " + this.f47138b + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            b.b(th);
            a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
