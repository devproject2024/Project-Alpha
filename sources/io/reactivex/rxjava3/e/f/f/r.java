package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.f.f.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class r<T, R> extends y<R> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T>[] f47618a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super Object[], ? extends R> f47619b;

    public r(ac<? extends T>[] acVarArr, h<? super Object[], ? extends R> hVar) {
        this.f47618a = acVarArr;
        this.f47619b = hVar;
    }

    public final void b(aa<? super R> aaVar) {
        ac<? extends T>[] acVarArr = this.f47618a;
        int length = acVarArr.length;
        int i2 = 0;
        if (length == 1) {
            acVarArr[0].a(new k.a(aaVar, new a()));
            return;
        }
        b bVar = new b(aaVar, length, this.f47619b);
        aaVar.onSubscribe(bVar);
        while (i2 < length && !bVar.isDisposed()) {
            ac<? extends T> acVar = acVarArr[i2];
            if (acVar == null) {
                bVar.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            } else {
                acVar.a(bVar.observers[i2]);
                i2++;
            }
        }
    }

    static final class b<T, R> extends AtomicInteger implements io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -5556924161382950569L;
        final aa<? super R> downstream;
        final c<T>[] observers;
        final Object[] values;
        final h<? super Object[], ? extends R> zipper;

        b(aa<? super R> aaVar, int i2, h<? super Object[], ? extends R> hVar) {
            super(i2);
            this.downstream = aaVar;
            this.zipper = hVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.observers = cVarArr;
            this.values = new Object[i2];
        }

        public final boolean isDisposed() {
            return get() <= 0;
        }

        public final void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> dispose : this.observers) {
                    dispose.dispose();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(Objects.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.downstream.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void disposeExcept(int i2) {
            c<T>[] cVarArr = this.observers;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 < length) {
                    cVarArr[i2].dispose();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.downstream.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }
    }

    static final class c<T> extends AtomicReference<io.reactivex.rxjava3.b.c> implements aa<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final b<T, ?> parent;

        c(b<T, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }
    }

    final class a implements h<T, R> {
        a() {
        }

        public final R apply(T t) throws Throwable {
            return Objects.requireNonNull(r.this.f47619b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
