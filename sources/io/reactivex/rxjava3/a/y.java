package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.e.d;
import io.reactivex.rxjava3.e.f.b.w;
import io.reactivex.rxjava3.e.f.f.b;
import io.reactivex.rxjava3.e.f.f.e;
import io.reactivex.rxjava3.e.f.f.f;
import io.reactivex.rxjava3.e.f.f.h;
import io.reactivex.rxjava3.e.f.f.i;
import io.reactivex.rxjava3.e.f.f.j;
import io.reactivex.rxjava3.e.f.f.k;
import io.reactivex.rxjava3.e.f.f.l;
import io.reactivex.rxjava3.e.f.f.m;
import io.reactivex.rxjava3.e.f.f.n;
import io.reactivex.rxjava3.e.f.f.o;
import io.reactivex.rxjava3.e.f.f.p;
import io.reactivex.rxjava3.e.f.f.q;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class y<T> implements ac<T> {
    /* access modifiers changed from: protected */
    public abstract void b(aa<? super T> aaVar);

    public static <T> y<T> a(ab<T> abVar) {
        Objects.requireNonNull(abVar, "source is null");
        return a.a(new io.reactivex.rxjava3.e.f.f.a(abVar));
    }

    public static <T> y<T> a(r<? extends ac<? extends T>> rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return a.a(new b(rVar));
    }

    public static <T> y<T> a(Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return a.a(new h(callable));
    }

    public static <T> y<T> a(T t) {
        Objects.requireNonNull(t, "item is null");
        return a.a(new j(t));
    }

    public static <T> y<T> T_() {
        return a.a(l.f47606a);
    }

    public static <T> y<T> a(ac<T> acVar) {
        Objects.requireNonNull(acVar, "source is null");
        if (acVar instanceof y) {
            return a.a((y) acVar);
        }
        return a.a(new i(acVar));
    }

    public static <T1, T2, R> y<R> a(ac<? extends T1> acVar, ac<? extends T2> acVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        Objects.requireNonNull(acVar, "source1 is null");
        Objects.requireNonNull(acVar2, "source2 is null");
        Objects.requireNonNull(cVar, "zipper is null");
        io.reactivex.rxjava3.d.h<Object[], ? extends R> a2 = io.reactivex.rxjava3.e.b.a.a(cVar);
        ac[] acVarArr = {acVar, acVar2};
        Objects.requireNonNull(a2, "zipper is null");
        Objects.requireNonNull(acVarArr, "sources is null");
        return a.a(new io.reactivex.rxjava3.e.f.f.r(acVarArr, a2));
    }

    public final y<T> a(TimeUnit timeUnit) {
        return a(timeUnit, io.reactivex.rxjava3.i.a.a());
    }

    private y<T> a(TimeUnit timeUnit, x xVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a(new io.reactivex.rxjava3.e.f.f.c(this, timeUnit, xVar));
    }

    public final y<T> a(io.reactivex.rxjava3.d.a aVar) {
        Objects.requireNonNull(aVar, "onFinally is null");
        return a.a(new e(this, aVar));
    }

    public final y<T> a(g<? super io.reactivex.rxjava3.b.c> gVar) {
        Objects.requireNonNull(gVar, "onSubscribe is null");
        return a.a(new f(this, gVar));
    }

    public final <R> y<R> a(io.reactivex.rxjava3.d.h<? super T, ? extends ac<? extends R>> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.a(new io.reactivex.rxjava3.e.f.f.g(this, hVar));
    }

    public final T b() {
        io.reactivex.rxjava3.e.e.h hVar = new io.reactivex.rxjava3.e.e.h();
        a(hVar);
        return hVar.a();
    }

    public final <R> y<R> b(io.reactivex.rxjava3.d.h<? super T, ? extends R> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.a(new k(this, hVar));
    }

    public final y<T> a(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a(new m(this, xVar));
    }

    public final y<T> c(io.reactivex.rxjava3.d.h<Throwable, ? extends T> hVar) {
        Objects.requireNonNull(hVar, "itemSupplier is null");
        return a.a(new n(this, hVar, null));
    }

    public final y<T> b(T t) {
        Objects.requireNonNull(t, "item is null");
        return a.a(new n(this, (io.reactivex.rxjava3.d.h) null, t));
    }

    public final io.reactivex.rxjava3.b.c d() {
        return a(io.reactivex.rxjava3.e.b.a.b(), (g<? super Throwable>) io.reactivex.rxjava3.e.b.a.f46650f);
    }

    public final io.reactivex.rxjava3.b.c a(io.reactivex.rxjava3.d.b<? super T, ? super Throwable> bVar) {
        Objects.requireNonNull(bVar, "onCallback is null");
        d dVar = new d(bVar);
        a(dVar);
        return dVar;
    }

    public final io.reactivex.rxjava3.b.c b(g<? super T> gVar) {
        return a(gVar, (g<? super Throwable>) io.reactivex.rxjava3.e.b.a.f46650f);
    }

    public final io.reactivex.rxjava3.b.c a(g<? super T> gVar, g<? super Throwable> gVar2) {
        Objects.requireNonNull(gVar, "onSuccess is null");
        Objects.requireNonNull(gVar2, "onError is null");
        io.reactivex.rxjava3.e.e.k kVar = new io.reactivex.rxjava3.e.e.k(gVar, gVar2);
        a(kVar);
        return kVar;
    }

    public final void a(aa<? super T> aaVar) {
        Objects.requireNonNull(aaVar, "observer is null");
        aa<? super Object> a2 = a.a(this, aaVar);
        Objects.requireNonNull(a2, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <E extends aa<? super T>> E c(E e2) {
        a(e2);
        return e2;
    }

    public final y<T> b(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a(new o(this, xVar));
    }

    public final p<T> e() {
        if (this instanceof io.reactivex.rxjava3.e.c.e) {
            return ((io.reactivex.rxjava3.e.c.e) this).U_();
        }
        return a.a(new q(this));
    }

    public final y<T> c() {
        h hVar;
        if (this instanceof io.reactivex.rxjava3.e.c.d) {
            hVar = ((io.reactivex.rxjava3.e.c.d) this).a();
        } else {
            hVar = a.a(new p(this));
        }
        return a.a(new w(hVar.a(3, (io.reactivex.rxjava3.d.q<? super Throwable>) io.reactivex.rxjava3.e.b.a.c())));
    }
}
