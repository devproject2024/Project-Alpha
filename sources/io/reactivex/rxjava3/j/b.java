package io.reactivex.rxjava3.j;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends e<T> {

    /* renamed from: a  reason: collision with root package name */
    static final a[] f47801a = new a[0];

    /* renamed from: b  reason: collision with root package name */
    static final a[] f47802b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a<T>[]> f47803c = new AtomicReference<>(f47802b);

    /* renamed from: d  reason: collision with root package name */
    Throwable f47804d;

    public static <T> b<T> a() {
        return new b<>();
    }

    b() {
    }

    public final void subscribeActual(w<? super T> wVar) {
        boolean z;
        a aVar = new a(wVar, this);
        wVar.onSubscribe(aVar);
        while (true) {
            a[] aVarArr = (a[]) this.f47803c.get();
            z = false;
            if (aVarArr != f47801a) {
                int length = aVarArr.length;
                a[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.f47803c.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = this.f47804d;
            if (th != null) {
                wVar.onError(th);
            } else {
                wVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f47803c.get();
            if (aVarArr != f47801a && aVarArr != f47802b) {
                int length = aVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f47802b;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f47803c.compareAndSet(aVarArr, aVarArr2));
    }

    public final void onSubscribe(c cVar) {
        if (this.f47803c.get() == f47801a) {
            cVar.dispose();
        }
    }

    public final void onNext(T t) {
        j.a(t, "onNext called with a null value.");
        for (a onNext : (a[]) this.f47803c.get()) {
            onNext.onNext(t);
        }
    }

    public final void onError(Throwable th) {
        j.a(th, "onError called with a null Throwable.");
        a<T>[] aVarArr = this.f47803c.get();
        a<T>[] aVarArr2 = f47801a;
        if (aVarArr == aVarArr2) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.f47804d = th;
        for (a onError : (a[]) this.f47803c.getAndSet(aVarArr2)) {
            onError.onError(th);
        }
    }

    public final void onComplete() {
        a<T>[] aVarArr = this.f47803c.get();
        a<T>[] aVarArr2 = f47801a;
        if (aVarArr != aVarArr2) {
            for (a onComplete : (a[]) this.f47803c.getAndSet(aVarArr2)) {
                onComplete.onComplete();
            }
        }
    }

    static final class a<T> extends AtomicBoolean implements c {
        private static final long serialVersionUID = 3562861878281475070L;
        final w<? super T> downstream;
        final b<T> parent;

        a(w<? super T> wVar, b<T> bVar) {
            this.downstream = wVar;
            this.parent = bVar;
        }

        public final void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                io.reactivex.rxjava3.h.a.a(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public final void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.a(this);
            }
        }

        public final boolean isDisposed() {
            return get();
        }
    }
}
