package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.h;
import java.util.Objects;

public abstract class b<T> implements w<T> {

    /* renamed from: a  reason: collision with root package name */
    private c f47750a;

    public final void onSubscribe(c cVar) {
        boolean z;
        c cVar2 = this.f47750a;
        Class<?> cls = getClass();
        Objects.requireNonNull(cVar, "next is null");
        if (cVar2 != null) {
            cVar.dispose();
            if (cVar2 != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                h.a(cls);
            }
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.f47750a = cVar;
        }
    }
}
