package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.k;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class eo<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final u<?>[] f47438b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends u<?>> f47439c;

    /* renamed from: d  reason: collision with root package name */
    final h<? super Object[], R> f47440d;

    public eo(u<T> uVar, u<?>[] uVarArr, h<? super Object[], R> hVar) {
        super(uVar);
        this.f47438b = uVarArr;
        this.f47439c = null;
        this.f47440d = hVar;
    }

    public eo(u<T> uVar, Iterable<? extends u<?>> iterable, h<? super Object[], R> hVar) {
        super(uVar);
        this.f47438b = null;
        this.f47439c = iterable;
        this.f47440d = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        int i2;
        u<?>[] uVarArr = this.f47438b;
        if (uVarArr == null) {
            uVarArr = new u[8];
            try {
                i2 = 0;
                for (u<?> uVar : this.f47439c) {
                    if (i2 == uVarArr.length) {
                        uVarArr = (u[]) Arrays.copyOf(uVarArr, (i2 >> 1) + i2);
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
            new bz(this.f46900a, new a()).subscribeActual(wVar);
            return;
        }
        b bVar = new b(wVar, this.f47440d, i2);
        wVar.onSubscribe(bVar);
        bVar.subscribe(uVarArr, i2);
        this.f46900a.subscribe(bVar);
    }

    static final class b<T, R> extends AtomicInteger implements w<T>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 1577321883966341961L;
        final h<? super Object[], R> combiner;
        volatile boolean done;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c error;
        final c[] observers;
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream;
        final AtomicReferenceArray<Object> values;

        b(w<? super R> wVar, h<? super Object[], R> hVar, int i2) {
            this.downstream = wVar;
            this.combiner = hVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.observers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.upstream = new AtomicReference<>();
            this.error = new io.reactivex.rxjava3.e.k.c();
        }

        /* access modifiers changed from: package-private */
        public final void subscribe(u<?>[] uVarArr, int i2) {
            c[] cVarArr = this.observers;
            AtomicReference<io.reactivex.rxjava3.b.c> atomicReference = this.upstream;
            for (int i3 = 0; i3 < i2 && !io.reactivex.rxjava3.e.a.c.isDisposed(atomicReference.get()) && !this.done; i3++) {
                uVarArr[i3].subscribe(cVarArr[i3]);
            }
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            if (!this.done) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.values;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i2 = 0;
                objArr[0] = t;
                while (i2 < length) {
                    Object obj = atomicReferenceArray.get(i2);
                    if (obj != null) {
                        i2++;
                        objArr[i2] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    k.a(this.downstream, Objects.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), (AtomicInteger) this, this.error);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                k.a(this.downstream, this, this.error);
            }
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            for (c dispose : this.observers) {
                dispose.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        /* access modifiers changed from: package-private */
        public final void innerError(int i2, Throwable th) {
            this.done = true;
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            cancelAllBut(i2);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete(int i2, boolean z) {
            if (!z) {
                this.done = true;
                cancelAllBut(i2);
                k.a(this.downstream, this, this.error);
            }
        }

        /* access modifiers changed from: package-private */
        public final void cancelAllBut(int i2) {
            c[] cVarArr = this.observers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }
    }

    static final class c extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public final void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }
    }

    final class a implements h<T, R> {
        a() {
        }

        public final R apply(T t) throws Throwable {
            return Objects.requireNonNull(eo.this.f47440d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }
}
