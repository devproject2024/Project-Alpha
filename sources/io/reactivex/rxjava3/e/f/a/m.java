package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.f.e.be;

public final class m<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f46769a;

    public m(f fVar) {
        this.f46769a = fVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46769a.a(new be.a(wVar));
    }
}
