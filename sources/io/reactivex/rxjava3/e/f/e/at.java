package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;

public final class at<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends Throwable> f47012a;

    public at(r<? extends Throwable> rVar) {
        this.f47012a = rVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        try {
            th = (Throwable) j.a(this.f47012a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            b.b(th);
        }
        d.error(th, (w<?>) wVar);
    }
}
