package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.o;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.g.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class e<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47359a;

    public e(u<T> uVar) {
        this.f47359a = uVar;
    }

    public final Iterator<T> iterator() {
        return new a(this.f47359a, new b());
    }

    static final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b<T> f47360a;

        /* renamed from: b  reason: collision with root package name */
        private final u<T> f47361b;

        /* renamed from: c  reason: collision with root package name */
        private T f47362c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f47363d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f47364e = true;

        /* renamed from: f  reason: collision with root package name */
        private Throwable f47365f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f47366g;

        a(u<T> uVar, b<T> bVar) {
            this.f47361b = uVar;
            this.f47360a = bVar;
        }

        public final boolean hasNext() {
            Throwable th = this.f47365f;
            if (th != null) {
                throw j.a(th);
            } else if (!this.f47363d) {
                return false;
            } else {
                if (!this.f47364e || a()) {
                    return true;
                }
                return false;
            }
        }

        private boolean a() {
            if (!this.f47366g) {
                this.f47366g = true;
                this.f47360a.a();
                new cb(this.f47361b).subscribe(this.f47360a);
            }
            try {
                b<T> bVar = this.f47360a;
                bVar.a();
                io.reactivex.rxjava3.e.k.e.a();
                o take = bVar.f47367a.take();
                if (take.b()) {
                    this.f47364e = false;
                    this.f47362c = take.c();
                    return true;
                }
                this.f47363d = false;
                if (take.a()) {
                    return false;
                }
                this.f47365f = take.d();
                throw j.a(this.f47365f);
            } catch (InterruptedException e2) {
                this.f47360a.dispose();
                this.f47365f = e2;
                throw j.a((Throwable) e2);
            }
        }

        public final T next() {
            Throwable th = this.f47365f;
            if (th != null) {
                throw j.a(th);
            } else if (hasNext()) {
                this.f47364e = true;
                return this.f47362c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class b<T> extends c<o<T>> {

        /* renamed from: a  reason: collision with root package name */
        final BlockingQueue<o<T>> f47367a = new ArrayBlockingQueue(1);

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f47368b = new AtomicInteger();

        public final void onComplete() {
        }

        b() {
        }

        public final /* synthetic */ void onNext(Object obj) {
            o oVar = (o) obj;
            if (this.f47368b.getAndSet(0) == 1 || !oVar.b()) {
                while (!this.f47367a.offer(oVar)) {
                    o oVar2 = (o) this.f47367a.poll();
                    if (oVar2 != null && !oVar2.b()) {
                        oVar = oVar2;
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.h.a.a(th);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f47368b.set(1);
        }
    }
}
