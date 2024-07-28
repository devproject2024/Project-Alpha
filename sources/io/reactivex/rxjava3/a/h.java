package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.e.f.b.c;
import io.reactivex.rxjava3.e.f.b.e;
import io.reactivex.rxjava3.e.f.b.f;
import io.reactivex.rxjava3.e.f.b.g;
import io.reactivex.rxjava3.e.f.b.i;
import io.reactivex.rxjava3.e.f.b.k;
import io.reactivex.rxjava3.e.f.b.l;
import io.reactivex.rxjava3.e.f.b.m;
import io.reactivex.rxjava3.e.f.b.n;
import io.reactivex.rxjava3.e.f.b.s;
import io.reactivex.rxjava3.e.f.b.t;
import io.reactivex.rxjava3.e.f.b.u;
import io.reactivex.rxjava3.e.f.b.x;
import io.reactivex.rxjava3.e.i.d;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.a.a;
import org.a.b;

public abstract class h<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f46609a = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    /* access modifiers changed from: protected */
    public abstract void b(b<? super T> bVar);

    public static int a() {
        return f46609a;
    }

    public static <T> h<T> a(j<T> jVar, a aVar) {
        Objects.requireNonNull(jVar, "source is null");
        Objects.requireNonNull(aVar, "mode is null");
        return io.reactivex.rxjava3.h.a.a(new io.reactivex.rxjava3.e.f.b.b(jVar, aVar));
    }

    public static <T> h<T> a(T t) {
        Objects.requireNonNull(t, "item is null");
        return io.reactivex.rxjava3.h.a.a(new l(t));
    }

    public static <T> h<T> a(a<? extends T> aVar, a<? extends T> aVar2) {
        Objects.requireNonNull(aVar, "source1 is null");
        Objects.requireNonNull(aVar2, "source2 is null");
        a[] aVarArr = {aVar, aVar2};
        Objects.requireNonNull(aVarArr, "items is null");
        h a2 = io.reactivex.rxjava3.h.a.a(new i(aVarArr));
        io.reactivex.rxjava3.d.h a3 = io.reactivex.rxjava3.e.b.a.a();
        int i2 = f46609a;
        Objects.requireNonNull(a3, "mapper is null");
        io.reactivex.rxjava3.e.b.b.a(2, "maxConcurrency");
        io.reactivex.rxjava3.e.b.b.a(i2, "bufferSize");
        if (!(a2 instanceof io.reactivex.rxjava3.e.c.i)) {
            return io.reactivex.rxjava3.h.a.a(new g(a2, a3, i2));
        }
        Object obj = ((io.reactivex.rxjava3.e.c.i) a2).get();
        if (obj == null) {
            return io.reactivex.rxjava3.h.a.a(e.f46796b);
        }
        return io.reactivex.rxjava3.h.a.a(new t.a(obj, a3));
    }

    public final T b() {
        d dVar = new d();
        a(dVar);
        T a2 = dVar.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    public final h<T> c() {
        io.reactivex.rxjava3.d.h a2 = io.reactivex.rxjava3.e.b.a.a();
        Objects.requireNonNull(a2, "keySelector is null");
        return io.reactivex.rxjava3.h.a.a(new c(this, a2, io.reactivex.rxjava3.e.b.b.a()));
    }

    public final h<T> a(io.reactivex.rxjava3.d.g<? super T> gVar) {
        io.reactivex.rxjava3.d.g b2 = io.reactivex.rxjava3.e.b.a.b();
        io.reactivex.rxjava3.d.a aVar = io.reactivex.rxjava3.e.b.a.f46647c;
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(b2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar, "onAfterTerminate is null");
        return io.reactivex.rxjava3.h.a.a(new io.reactivex.rxjava3.e.f.b.d(this, gVar, b2, aVar, aVar));
    }

    public final h<T> a(q<? super T> qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return io.reactivex.rxjava3.h.a.a(new f(this, qVar));
    }

    public final <R> h<R> a(io.reactivex.rxjava3.d.h<? super T, ? extends R> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return io.reactivex.rxjava3.h.a.a(new m(this, hVar));
    }

    public final h<T> d() {
        return a(Long.MAX_VALUE, (q<? super Throwable>) io.reactivex.rxjava3.e.b.a.c());
    }

    public final h<T> a(long j, q<? super Throwable> qVar) {
        if (j >= 0) {
            Objects.requireNonNull(qVar, "predicate is null");
            return io.reactivex.rxjava3.h.a.a(new s(this, j, qVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was ".concat(String.valueOf(j)));
    }

    public final h<T> a(io.reactivex.rxjava3.d.c<T, T, T> cVar) {
        Objects.requireNonNull(cVar, "accumulator is null");
        return io.reactivex.rxjava3.h.a.a(new u(this, cVar));
    }

    public final io.reactivex.rxjava3.b.c b(io.reactivex.rxjava3.d.g<? super T> gVar) {
        return a(gVar, io.reactivex.rxjava3.e.b.a.f46650f, io.reactivex.rxjava3.e.b.a.f46647c);
    }

    public final io.reactivex.rxjava3.b.c a(io.reactivex.rxjava3.d.g<? super T> gVar, io.reactivex.rxjava3.d.g<? super Throwable> gVar2) {
        return a(gVar, gVar2, io.reactivex.rxjava3.e.b.a.f46647c);
    }

    private io.reactivex.rxjava3.b.c a(io.reactivex.rxjava3.d.g<? super T> gVar, io.reactivex.rxjava3.d.g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        io.reactivex.rxjava3.e.i.e eVar = new io.reactivex.rxjava3.e.i.e(gVar, gVar2, aVar, k.a.INSTANCE);
        a(eVar);
        return eVar;
    }

    public final void a(b<? super T> bVar) {
        if (bVar instanceof k) {
            a((k) bVar);
            return;
        }
        Objects.requireNonNull(bVar, "subscriber is null");
        a(new io.reactivex.rxjava3.e.i.f(bVar));
    }

    public final void a(k<? super T> kVar) {
        Objects.requireNonNull(kVar, "subscriber is null");
        try {
            b<? super Object> a2 = io.reactivex.rxjava3.h.a.a(this, kVar);
            Objects.requireNonNull(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            io.reactivex.rxjava3.h.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final h<T> b(x xVar) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return a(xVar, !(this instanceof io.reactivex.rxjava3.e.f.b.b));
    }

    private h<T> a(x xVar, boolean z) {
        Objects.requireNonNull(xVar, "scheduler is null");
        return io.reactivex.rxjava3.h.a.a(new x(this, xVar, z));
    }

    public final h<T> a(x xVar) {
        int i2 = f46609a;
        Objects.requireNonNull(xVar, "scheduler is null");
        io.reactivex.rxjava3.e.b.b.a(i2, "bufferSize");
        return io.reactivex.rxjava3.h.a.a(new n(this, xVar, i2));
    }
}
