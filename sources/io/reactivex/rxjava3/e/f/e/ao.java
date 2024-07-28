package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.e.m;

public final class ao<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final g<? super c> f46983b;

    /* renamed from: c  reason: collision with root package name */
    private final a f46984c;

    public ao(p<T> pVar, g<? super c> gVar, a aVar) {
        super(pVar);
        this.f46983b = gVar;
        this.f46984c = aVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new m(wVar, this.f46983b, this.f46984c));
    }
}
