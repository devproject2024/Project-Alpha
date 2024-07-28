package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.o;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.e.k.e;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.e.k.m;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47141a;

    public c(u<T> uVar) {
        this.f47141a = uVar;
    }

    public final Iterator<T> iterator() {
        a aVar = new a();
        p.wrap(this.f47141a).materialize().subscribe(aVar);
        return aVar;
    }

    static final class a<T> extends io.reactivex.rxjava3.g.c<o<T>> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        o<T> f47142a;

        /* renamed from: b  reason: collision with root package name */
        final Semaphore f47143b = new Semaphore(0);

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<o<T>> f47144c = new AtomicReference<>();

        public final void onComplete() {
        }

        a() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            if (this.f47144c.getAndSet((o) obj) == null) {
                this.f47143b.release();
            }
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final boolean hasNext() {
            o<T> oVar = this.f47142a;
            if (oVar == null || !m.isError(oVar.f46611a)) {
                if (this.f47142a == null) {
                    try {
                        e.a();
                        this.f47143b.acquire();
                        o<T> andSet = this.f47144c.getAndSet((Object) null);
                        this.f47142a = andSet;
                        if (m.isError(andSet.f46611a)) {
                            throw j.a(andSet.d());
                        }
                    } catch (InterruptedException e2) {
                        dispose();
                        this.f47142a = o.a((Throwable) e2);
                        throw j.a((Throwable) e2);
                    }
                }
                return this.f47142a.b();
            }
            throw j.a(this.f47142a.d());
        }

        public final T next() {
            if (hasNext()) {
                T c2 = this.f47142a.c();
                this.f47142a = null;
                return c2;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}
