package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.e.n;
import io.reactivex.rxjava3.e.f.a.c;
import io.reactivex.rxjava3.e.f.a.d;
import io.reactivex.rxjava3.e.f.a.e;
import io.reactivex.rxjava3.e.f.a.f;
import io.reactivex.rxjava3.e.f.a.g;
import io.reactivex.rxjava3.e.f.a.h;
import io.reactivex.rxjava3.e.f.a.i;
import io.reactivex.rxjava3.e.f.a.j;
import io.reactivex.rxjava3.e.f.a.k;
import io.reactivex.rxjava3.e.f.a.l;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.Callable;

public abstract class b implements f {
    /* access modifiers changed from: protected */
    public abstract void b(d dVar);

    public static b a() {
        return a.a(f.f46751a);
    }

    @SafeVarargs
    public static b a(f... fVarArr) {
        Objects.requireNonNull(fVarArr, "sources is null");
        return a.a((b) new io.reactivex.rxjava3.e.f.a.b(fVarArr));
    }

    public static b a(e eVar) {
        Objects.requireNonNull(eVar, "source is null");
        return a.a((b) new c(eVar));
    }

    public static b a(r<? extends f> rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return a.a((b) new d(rVar));
    }

    public static b a(Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return a.a((b) new g(th));
    }

    public static b a(Callable<?> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return a.a((b) new h(callable));
    }

    private static NullPointerException b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b a(f fVar) {
        Objects.requireNonNull(fVar, "source is null");
        if (fVar instanceof b) {
            return a.a((b) fVar);
        }
        return a.a((b) new i(fVar));
    }

    public final <T> y<T> a(ac<T> acVar) {
        Objects.requireNonNull(acVar, "next is null");
        return a.a(new io.reactivex.rxjava3.e.f.f.d(acVar, this));
    }

    public final b b(f fVar) {
        Objects.requireNonNull(fVar, "next is null");
        return a.a((b) new io.reactivex.rxjava3.e.f.a.a(this, fVar));
    }

    public final void b() {
        io.reactivex.rxjava3.e.e.h hVar = new io.reactivex.rxjava3.e.e.h();
        a((d) hVar);
        hVar.a();
    }

    public final b a(io.reactivex.rxjava3.d.a aVar) {
        io.reactivex.rxjava3.d.g b2 = io.reactivex.rxjava3.e.b.a.b();
        io.reactivex.rxjava3.d.g b3 = io.reactivex.rxjava3.e.b.a.b();
        io.reactivex.rxjava3.d.a aVar2 = io.reactivex.rxjava3.e.b.a.f46647c;
        return a(b2, b3, aVar, aVar2, aVar2, io.reactivex.rxjava3.e.b.a.f46647c);
    }

    public final b a(io.reactivex.rxjava3.d.g<? super Throwable> gVar) {
        io.reactivex.rxjava3.d.g b2 = io.reactivex.rxjava3.e.b.a.b();
        io.reactivex.rxjava3.d.a aVar = io.reactivex.rxjava3.e.b.a.f46647c;
        io.reactivex.rxjava3.d.a aVar2 = io.reactivex.rxjava3.e.b.a.f46647c;
        return a(b2, gVar, aVar, aVar, aVar2, aVar2);
    }

    private b a(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c> gVar, io.reactivex.rxjava3.d.g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2, io.reactivex.rxjava3.d.a aVar3, io.reactivex.rxjava3.d.a aVar4) {
        Objects.requireNonNull(gVar, "onSubscribe is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar2, "onTerminate is null");
        Objects.requireNonNull(aVar3, "onAfterTerminate is null");
        Objects.requireNonNull(aVar4, "onDispose is null");
        return a.a((b) new k(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    public final b b(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c> gVar) {
        io.reactivex.rxjava3.d.g b2 = io.reactivex.rxjava3.e.b.a.b();
        io.reactivex.rxjava3.d.a aVar = io.reactivex.rxjava3.e.b.a.f46647c;
        io.reactivex.rxjava3.d.a aVar2 = io.reactivex.rxjava3.e.b.a.f46647c;
        return a(gVar, b2, aVar, aVar, aVar2, aVar2);
    }

    public final b b(io.reactivex.rxjava3.d.a aVar) {
        Objects.requireNonNull(aVar, "onFinally is null");
        return a.a((b) new e(this, aVar));
    }

    public final b a(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a((b) new j(this, xVar));
    }

    public final io.reactivex.rxjava3.b.c c() {
        n nVar = new n();
        a((d) nVar);
        return nVar;
    }

    public final void a(d dVar) {
        Objects.requireNonNull(dVar, "observer is null");
        try {
            d a2 = a.a(this, dVar);
            Objects.requireNonNull(a2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            a.a(th);
            throw b(th);
        }
    }

    public final io.reactivex.rxjava3.b.c a(io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.g<? super Throwable> gVar) {
        Objects.requireNonNull(gVar, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        io.reactivex.rxjava3.e.e.j jVar = new io.reactivex.rxjava3.e.e.j(gVar, aVar);
        a((d) jVar);
        return jVar;
    }

    public final b b(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a.a((b) new l(this, xVar));
    }
}
