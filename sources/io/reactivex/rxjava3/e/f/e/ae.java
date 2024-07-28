package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;

public final class ae<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends u<? extends T>> f46929a;

    public ae(r<? extends u<? extends T>> rVar) {
        this.f46929a = rVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            ((u) Objects.requireNonNull(this.f46929a.get(), "The supplier returned a null ObservableSource")).subscribe(wVar);
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }
}
