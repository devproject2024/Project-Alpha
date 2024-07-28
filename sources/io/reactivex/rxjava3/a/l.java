package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.e.e.h;
import io.reactivex.rxjava3.e.f.c.b;
import io.reactivex.rxjava3.e.f.c.c;
import io.reactivex.rxjava3.e.f.c.d;
import io.reactivex.rxjava3.e.f.c.e;
import io.reactivex.rxjava3.e.f.c.f;
import io.reactivex.rxjava3.e.f.c.g;
import io.reactivex.rxjava3.e.f.c.i;
import io.reactivex.rxjava3.e.f.c.k;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.Callable;

public abstract class l<T> implements n<T> {
    /* access modifiers changed from: protected */
    public abstract void b(m<? super T> mVar);

    public static <T> l<T> a(Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return a.a(new d(callable));
    }

    public static <T> l<T> a(n<T> nVar) {
        if (nVar instanceof l) {
            return a.a((l) nVar);
        }
        Objects.requireNonNull(nVar, "source is null");
        return a.a(new k(nVar));
    }

    public final T a() {
        h hVar = new h();
        a(hVar);
        return hVar.a();
    }

    public final <R> p<R> a(io.reactivex.rxjava3.d.h<? super T, ? extends u<? extends R>> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.a(new io.reactivex.rxjava3.e.f.d.a(this, hVar));
    }

    public final b b(io.reactivex.rxjava3.d.h<? super T, ? extends f> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.a((b) new c(this, hVar));
    }

    public final <R> l<R> c(io.reactivex.rxjava3.d.h<? super T, ? extends R> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.a(new e(this, hVar));
    }

    public final l<T> a(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a(new f(this, xVar));
    }

    public final l<T> b() {
        q c2 = io.reactivex.rxjava3.e.b.a.c();
        Objects.requireNonNull(c2, "predicate is null");
        return a.a(new g(this, c2));
    }

    public final io.reactivex.rxjava3.b.c a(io.reactivex.rxjava3.d.g<? super T> gVar, io.reactivex.rxjava3.d.g<? super Throwable> gVar2) {
        io.reactivex.rxjava3.d.a aVar = io.reactivex.rxjava3.e.b.a.f46647c;
        Objects.requireNonNull(gVar, "onSuccess is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        b bVar = new b(gVar, gVar2, aVar);
        a(bVar);
        return bVar;
    }

    public final void a(m<? super T> mVar) {
        Objects.requireNonNull(mVar, "observer is null");
        m<? super Object> a2 = a.a(this, mVar);
        Objects.requireNonNull(a2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    public final l<T> b(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a(new io.reactivex.rxjava3.e.f.c.h(this, xVar));
    }

    public final y<T> a(ac<? extends T> acVar) {
        Objects.requireNonNull(acVar, "other is null");
        return a.a(new i(this, acVar));
    }
}
