package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.d.r;
import java.util.Objects;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    final r<? extends f> f46748a;

    public d(r<? extends f> rVar) {
        this.f46748a = rVar;
    }

    public final void b(io.reactivex.rxjava3.a.d dVar) {
        try {
            ((f) Objects.requireNonNull(this.f46748a.get(), "The completableSupplier returned a null CompletableSource")).a(dVar);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            io.reactivex.rxjava3.e.a.d.error(th, dVar);
        }
    }
}
