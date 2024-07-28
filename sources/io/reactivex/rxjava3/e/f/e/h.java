package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T>[] f47471a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends u<? extends T>> f47472b;

    public h(u<? extends T>[] uVarArr, Iterable<? extends u<? extends T>> iterable) {
        this.f47471a = uVarArr;
        this.f47472b = iterable;
    }

    public final void subscribeActual(w<? super T> wVar) {
        int i2;
        u<? extends T>[] uVarArr = this.f47471a;
        if (uVarArr == null) {
            uVarArr = new u[8];
            try {
                i2 = 0;
                for (u<? extends T> uVar : this.f47472b) {
                    if (uVar == null) {
                        d.error((Throwable) new NullPointerException("One of the sources is null"), (w<?>) wVar);
                        return;
                    }
                    if (i2 == uVarArr.length) {
                        u<? extends T>[] uVarArr2 = new u[((i2 >> 2) + i2)];
                        System.arraycopy(uVarArr, 0, uVarArr2, 0, i2);
                        uVarArr = uVarArr2;
                    }
                    int i3 = i2 + 1;
                    uVarArr[i2] = uVar;
                    i2 = i3;
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                d.error(th, (w<?>) wVar);
                return;
            }
        } else {
            i2 = uVarArr.length;
        }
        if (i2 == 0) {
            d.complete((w<?>) wVar);
        } else if (i2 == 1) {
            uVarArr[0].subscribe(wVar);
        } else {
            new a(wVar, i2).a(uVarArr);
        }
    }

    static final class a<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47473a;

        /* renamed from: b  reason: collision with root package name */
        final b<T>[] f47474b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f47475c = new AtomicInteger();

        a(w<? super T> wVar, int i2) {
            this.f47473a = wVar;
            this.f47474b = new b[i2];
        }

        public final void a(u<? extends T>[] uVarArr) {
            b<T>[] bVarArr = this.f47474b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.f47473a);
                i2 = i3;
            }
            this.f47475c.lazySet(0);
            this.f47473a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f47475c.get() == 0; i4++) {
                uVarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        public final boolean a(int i2) {
            int i3 = 0;
            if (this.f47475c.get() != 0 || !this.f47475c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f47474b;
            int length = bVarArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    bVarArr[i3].dispose();
                }
                i3 = i4;
            }
            return true;
        }

        public final void dispose() {
            if (this.f47475c.get() != -1) {
                this.f47475c.lazySet(-1);
                for (b<T> dispose : this.f47474b) {
                    dispose.dispose();
                }
            }
        }

        public final boolean isDisposed() {
            return this.f47475c.get() == -1;
        }
    }

    static final class b<T> extends AtomicReference<c> implements w<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final w<? super T> downstream;
        final int index;
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, w<? super T> wVar) {
            this.parent = aVar;
            this.index = i2;
            this.downstream = wVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.downstream.onNext(t);
            } else {
                ((c) get()).dispose();
            }
        }

        public final void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }
    }
}
