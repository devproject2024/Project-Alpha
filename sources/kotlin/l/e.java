package kotlin.l;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.b.a.a;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;

final class e<T> extends f<T> implements Iterator<T>, d<x>, a {

    /* renamed from: a  reason: collision with root package name */
    d<? super x> f47961a;

    /* renamed from: b  reason: collision with root package name */
    private int f47962b;

    /* renamed from: c  reason: collision with root package name */
    private T f47963c;

    /* renamed from: d  reason: collision with root package name */
    private Iterator<? extends T> f47964d;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext() {
        while (true) {
            int i2 = this.f47962b;
            if (i2 != 0) {
                if (i2 == 1) {
                    Iterator<? extends T> it2 = this.f47964d;
                    k.a((Object) it2);
                    if (it2.hasNext()) {
                        this.f47962b = 2;
                        return true;
                    }
                    this.f47964d = null;
                } else if (i2 == 2 || i2 == 3) {
                    return true;
                } else {
                    if (i2 == 4) {
                        return false;
                    }
                    throw a();
                }
            }
            this.f47962b = 5;
            d<? super x> dVar = this.f47961a;
            k.a((Object) dVar);
            this.f47961a = null;
            x xVar = x.f47997a;
            p.a aVar = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(xVar));
        }
    }

    public final T next() {
        do {
            int i2 = this.f47962b;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    this.f47962b = 1;
                    Iterator<? extends T> it2 = this.f47964d;
                    k.a((Object) it2);
                    return it2.next();
                } else if (i2 == 3) {
                    this.f47962b = 0;
                    T t = this.f47963c;
                    this.f47963c = null;
                    return t;
                } else {
                    throw a();
                }
            }
        } while (hasNext());
        throw new NoSuchElementException();
    }

    private final Throwable a() {
        RuntimeException runtimeException;
        int i2 = this.f47962b;
        if (i2 == 4) {
            runtimeException = new NoSuchElementException();
        } else if (i2 != 5) {
            runtimeException = new IllegalStateException("Unexpected state of the iterator: " + this.f47962b);
        } else {
            runtimeException = new IllegalStateException("Iterator has failed.");
        }
        return runtimeException;
    }

    public final Object a(T t, d<? super x> dVar) {
        this.f47963c = t;
        this.f47962b = 3;
        this.f47961a = dVar;
        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
        if (aVar == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return aVar == kotlin.d.a.a.COROUTINE_SUSPENDED ? aVar : x.f47997a;
    }

    public final void resumeWith(Object obj) {
        ResultKt.a(obj);
        this.f47962b = 4;
    }

    public final f getContext() {
        return g.INSTANCE;
    }
}
