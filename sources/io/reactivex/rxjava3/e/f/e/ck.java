package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ck<T> extends io.reactivex.rxjava3.f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47176a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>> f47177b = new AtomicReference<>();

    public ck(u<T> uVar) {
        this.f47176a = uVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r0 = r4.f47177b
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.e.f.e.ck$b r0 = (io.reactivex.rxjava3.e.f.e.ck.b) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0020
        L_0x0010:
            io.reactivex.rxjava3.e.f.e.ck$b r1 = new io.reactivex.rxjava3.e.f.e.ck$b
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r2 = r4.f47177b
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r2 = r4.f47177b
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 == 0) goto L_0x0000
            r0 = r1
        L_0x0020:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0033
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.rxjava3.a.u<T> r5 = r4.f47176a
            r5.subscribe(r0)
        L_0x003e:
            return
        L_0x003f:
            r5 = move-exception
            io.reactivex.rxjava3.c.b.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.e.k.j.a((java.lang.Throwable) r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.ck.a(io.reactivex.rxjava3.d.g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.rxjava3.a.w<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r0 = r3.f47177b
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.e.f.e.ck$b r0 = (io.reactivex.rxjava3.e.f.e.ck.b) r0
            if (r0 != 0) goto L_0x001a
            io.reactivex.rxjava3.e.f.e.ck$b r1 = new io.reactivex.rxjava3.e.f.e.ck$b
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r2 = r3.f47177b
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.ck$b<T>> r2 = r3.f47177b
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 == 0) goto L_0x0000
            r0 = r1
        L_0x001a:
            io.reactivex.rxjava3.e.f.e.ck$a r1 = new io.reactivex.rxjava3.e.f.e.ck$a
            r1.<init>(r4, r0)
            r4.onSubscribe(r1)
            boolean r2 = r0.add(r1)
            if (r2 == 0) goto L_0x0032
            boolean r4 = r1.isDisposed()
            if (r4 == 0) goto L_0x0031
            r0.remove(r1)
        L_0x0031:
            return
        L_0x0032:
            java.lang.Throwable r0 = r0.error
            if (r0 == 0) goto L_0x003a
            r4.onError(r0)
            return
        L_0x003a:
            r4.onComplete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.ck.subscribeActual(io.reactivex.rxjava3.a.w):void");
    }

    public final void a() {
        b bVar = this.f47177b.get();
        if (bVar != null && bVar.isDisposed()) {
            this.f47177b.compareAndSet(bVar, (Object) null);
        }
    }

    static final class b<T> extends AtomicReference<a<T>[]> implements w<T>, c {
        static final a[] EMPTY = new a[0];
        static final a[] TERMINATED = new a[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<b<T>> current;
        Throwable error;
        final AtomicReference<c> upstream;

        b(AtomicReference<b<T>> atomicReference) {
            this.current = atomicReference;
            this.upstream = new AtomicReference<>();
            lazySet(EMPTY);
        }

        public final void dispose() {
            getAndSet(TERMINATED);
            this.current.compareAndSet(this, (Object) null);
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
        }

        public final boolean isDisposed() {
            return get() == TERMINATED;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            for (a aVar : (a[]) get()) {
                aVar.downstream.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (this.upstream.get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                this.error = th;
                this.upstream.lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                for (a aVar : (a[]) getAndSet(TERMINATED)) {
                    aVar.downstream.onError(th);
                }
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            this.upstream.lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
            for (a aVar : (a[]) getAndSet(TERMINATED)) {
                aVar.downstream.onComplete();
            }
        }

        public final boolean add(a<T> aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
                if (aVarArr == TERMINATED) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public final void remove(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
                int length = aVarArr.length;
                if (length != 0) {
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
                        aVarArr2 = EMPTY;
                        if (length != 1) {
                            aVarArr2 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr2, i2, (length - i2) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }
    }

    static final class a<T> extends AtomicReference<b<T>> implements c {
        private static final long serialVersionUID = 7463222674719692880L;
        final w<? super T> downstream;

        a(w<? super T> wVar, b<T> bVar) {
            this.downstream = wVar;
            lazySet(bVar);
        }

        public final void dispose() {
            b bVar = (b) getAndSet((Object) null);
            if (bVar != null) {
                bVar.remove(this);
            }
        }

        public final boolean isDisposed() {
            return get() == null;
        }
    }
}
