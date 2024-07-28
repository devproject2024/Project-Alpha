package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.j.e;
import java.util.concurrent.atomic.AtomicBoolean;

final class el<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final e<T> f47420a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f47421b = new AtomicBoolean();

    el(e<T> eVar) {
        this.f47420a = eVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47420a.subscribe(wVar);
        this.f47421b.set(true);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return !this.f47421b.get() && this.f47421b.compareAndSet(false, true);
    }
}
