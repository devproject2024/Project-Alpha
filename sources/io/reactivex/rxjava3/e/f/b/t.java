package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.j.d;
import io.reactivex.rxjava3.e.j.e;
import java.util.Objects;
import org.a.b;

public final class t {
    public static <T, R> boolean a(org.a.a<T> aVar, b<? super R> bVar, h<? super T, ? extends org.a.a<? extends R>> hVar) {
        if (!(aVar instanceof r)) {
            return false;
        }
        try {
            Object obj = ((r) aVar).get();
            if (obj == null) {
                d.complete(bVar);
                return true;
            }
            try {
                org.a.a aVar2 = (org.a.a) Objects.requireNonNull(hVar.apply(obj), "The mapper returned a null Publisher");
                if (aVar2 instanceof r) {
                    try {
                        Object obj2 = ((r) aVar2).get();
                        if (obj2 == null) {
                            d.complete(bVar);
                            return true;
                        }
                        bVar.onSubscribe(new e(bVar, obj2));
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        d.error(th, bVar);
                        return true;
                    }
                } else {
                    aVar2.a(bVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                d.error(th2, bVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.rxjava3.c.b.b(th3);
            d.error(th3, bVar);
            return true;
        }
    }

    public static final class a<T, R> extends io.reactivex.rxjava3.a.h<R> {

        /* renamed from: b  reason: collision with root package name */
        final T f46825b;

        /* renamed from: c  reason: collision with root package name */
        final h<? super T, ? extends org.a.a<? extends R>> f46826c;

        public a(T t, h<? super T, ? extends org.a.a<? extends R>> hVar) {
            this.f46825b = t;
            this.f46826c = hVar;
        }

        public final void b(b<? super R> bVar) {
            try {
                org.a.a aVar = (org.a.a) Objects.requireNonNull(this.f46826c.apply(this.f46825b), "The mapper returned a null Publisher");
                if (aVar instanceof r) {
                    try {
                        Object obj = ((r) aVar).get();
                        if (obj == null) {
                            d.complete(bVar);
                        } else {
                            bVar.onSubscribe(new e(bVar, obj));
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        d.error(th, bVar);
                    }
                } else {
                    aVar.a(bVar);
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                d.error(th2, bVar);
            }
        }
    }
}
