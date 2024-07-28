package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.f.e.cp;
import java.util.Objects;

public final class cq<T, R> extends y<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47199a;

    /* renamed from: b  reason: collision with root package name */
    final r<R> f47200b;

    /* renamed from: c  reason: collision with root package name */
    final c<R, ? super T, R> f47201c;

    public cq(u<T> uVar, r<R> rVar, c<R, ? super T, R> cVar) {
        this.f47199a = uVar;
        this.f47200b = rVar;
        this.f47201c = cVar;
    }

    public final void b(aa<? super R> aaVar) {
        try {
            this.f47199a.subscribe(new cp.a(aaVar, this.f47201c, Objects.requireNonNull(this.f47200b.get(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (aa<?>) aaVar);
        }
    }
}
