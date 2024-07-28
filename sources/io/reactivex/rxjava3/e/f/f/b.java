package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;

public final class b<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends ac<? extends T>> f47573a;

    public b(r<? extends ac<? extends T>> rVar) {
        this.f47573a = rVar;
    }

    public final void b(aa<? super T> aaVar) {
        try {
            ((ac) Objects.requireNonNull(this.f47573a.get(), "The singleSupplier returned a null SingleSource")).a(aaVar);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (aa<?>) aaVar);
        }
    }
}
