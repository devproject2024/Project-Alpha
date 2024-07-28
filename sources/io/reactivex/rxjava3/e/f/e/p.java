package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class p<T> extends a<T, T> implements w<T> {

    /* renamed from: e  reason: collision with root package name */
    static final a[] f47525e = new a[0];

    /* renamed from: f  reason: collision with root package name */
    static final a[] f47526f = new a[0];

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f47527b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    final int f47528c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<a<T>[]> f47529d;

    /* renamed from: g  reason: collision with root package name */
    volatile long f47530g;

    /* renamed from: h  reason: collision with root package name */
    final b<T> f47531h;

    /* renamed from: i  reason: collision with root package name */
    b<T> f47532i;
    int j;
    Throwable k;
    volatile boolean l;

    public final void onSubscribe(c cVar) {
    }

    public p(io.reactivex.rxjava3.a.p<T> pVar, int i2) {
        super(pVar);
        this.f47528c = i2;
        b<T> bVar = new b<>(i2);
        this.f47531h = bVar;
        this.f47532i = bVar;
        this.f47529d = new AtomicReference<>(f47525e);
    }

    public final void subscribeActual(w<? super T> wVar) {
        a[] aVarArr;
        a[] aVarArr2;
        a aVar = new a(wVar, this);
        wVar.onSubscribe(aVar);
        do {
            aVarArr = (a[]) this.f47529d.get();
            if (aVarArr == f47526f) {
                break;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f47529d.compareAndSet(aVarArr, aVarArr2));
        if (this.f47527b.get() || !this.f47527b.compareAndSet(false, true)) {
            a(aVar);
        } else {
            this.f46900a.subscribe(this);
        }
    }

    private void a(a<T> aVar) {
        if (aVar.getAndIncrement() == 0) {
            long j2 = aVar.index;
            int i2 = aVar.offset;
            b<T> bVar = aVar.node;
            w<? super T> wVar = aVar.downstream;
            int i3 = this.f47528c;
            int i4 = 1;
            while (!aVar.disposed) {
                boolean z = this.l;
                boolean z2 = this.f47530g == j2;
                if (z && z2) {
                    aVar.node = null;
                    Throwable th = this.k;
                    if (th != null) {
                        wVar.onError(th);
                        return;
                    } else {
                        wVar.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i2 == i3) {
                        bVar = bVar.f47534b;
                        i2 = 0;
                    }
                    wVar.onNext(bVar.f47533a[i2]);
                    i2++;
                    j2++;
                } else {
                    aVar.index = j2;
                    aVar.offset = i2;
                    aVar.node = bVar;
                    i4 = aVar.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            aVar.node = null;
        }
    }

    public final void onNext(T t) {
        int i2 = this.j;
        if (i2 == this.f47528c) {
            b<T> bVar = new b<>(i2);
            bVar.f47533a[0] = t;
            this.j = 1;
            this.f47532i.f47534b = bVar;
            this.f47532i = bVar;
        } else {
            this.f47532i.f47533a[i2] = t;
            this.j = i2 + 1;
        }
        this.f47530g++;
        for (a a2 : (a[]) this.f47529d.get()) {
            a(a2);
        }
    }

    public final void onError(Throwable th) {
        this.k = th;
        this.l = true;
        for (a a2 : (a[]) this.f47529d.getAndSet(f47526f)) {
            a(a2);
        }
    }

    public final void onComplete() {
        this.l = true;
        for (a a2 : (a[]) this.f47529d.getAndSet(f47526f)) {
            a(a2);
        }
    }

    static final class a<T> extends AtomicInteger implements c {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final w<? super T> downstream;
        long index;
        b<T> node;
        int offset;
        final p<T> parent;

        a(w<? super T> wVar, p<T> pVar) {
            this.downstream = wVar;
            this.parent = pVar;
            this.node = pVar.f47531h;
        }

        public final void dispose() {
            a[] aVarArr;
            a[] aVarArr2;
            if (!this.disposed) {
                this.disposed = true;
                p<T> pVar = this.parent;
                do {
                    aVarArr = (a[]) pVar.f47529d.get();
                    int length = aVarArr.length;
                    if (length != 0) {
                        int i2 = -1;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            } else if (aVarArr[i3] == this) {
                                i2 = i3;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i2 < 0) {
                            return;
                        }
                        if (length == 1) {
                            aVarArr2 = p.f47525e;
                        } else {
                            a[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } while (!pVar.f47529d.compareAndSet(aVarArr, aVarArr2));
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f47533a;

        /* renamed from: b  reason: collision with root package name */
        volatile b<T> f47534b;

        b(int i2) {
            this.f47533a = (Object[]) new Object[i2];
        }
    }
}
