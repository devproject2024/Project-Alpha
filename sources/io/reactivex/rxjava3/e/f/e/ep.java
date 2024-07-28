package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ep<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T>[] f47442a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends u<? extends T>> f47443b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super Object[], ? extends R> f47444c;

    /* renamed from: d  reason: collision with root package name */
    final int f47445d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47446e;

    public ep(u<? extends T>[] uVarArr, Iterable<? extends u<? extends T>> iterable, h<? super Object[], ? extends R> hVar, int i2, boolean z) {
        this.f47442a = uVarArr;
        this.f47443b = iterable;
        this.f47444c = hVar;
        this.f47445d = i2;
        this.f47446e = z;
    }

    public final void subscribeActual(w<? super R> wVar) {
        int i2;
        u<? extends T>[] uVarArr = this.f47442a;
        if (uVarArr == null) {
            uVarArr = new u[8];
            i2 = 0;
            for (u<? extends T> uVar : this.f47443b) {
                if (i2 == uVarArr.length) {
                    u<? extends T>[] uVarArr2 = new u[((i2 >> 2) + i2)];
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, i2);
                    uVarArr = uVarArr2;
                }
                uVarArr[i2] = uVar;
                i2++;
            }
        } else {
            i2 = uVarArr.length;
        }
        if (i2 == 0) {
            d.complete((w<?>) wVar);
        } else {
            new a(wVar, this.f47444c, i2, this.f47446e).subscribe(uVarArr, this.f47445d);
        }
    }

    static final class a<T, R> extends AtomicInteger implements c {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final w<? super R> downstream;
        final b<T, R>[] observers;
        final T[] row;
        final h<? super Object[], ? extends R> zipper;

        a(w<? super R> wVar, h<? super Object[], ? extends R> hVar, int i2, boolean z) {
            this.downstream = wVar;
            this.zipper = hVar;
            this.observers = new b[i2];
            this.row = (Object[]) new Object[i2];
            this.delayError = z;
        }

        public final void subscribe(u<? extends T>[] uVarArr, int i2) {
            b<T, R>[] bVarArr = this.observers;
            int length = bVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                uVarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            clear();
            cancelSources();
        }

        /* access modifiers changed from: package-private */
        public final void cancelSources() {
            for (b<T, R> bVar : this.observers) {
                io.reactivex.rxjava3.e.a.c.dispose(bVar.f47451e);
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            for (b<T, R> bVar : this.observers) {
                bVar.f47448b.clear();
            }
        }

        public final void drain() {
            Throwable th;
            if (getAndIncrement() == 0) {
                b<T, R>[] bVarArr = this.observers;
                w<? super R> wVar = this.downstream;
                T[] tArr = this.row;
                boolean z = this.delayError;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int i4 = 0;
                    for (b<T, R> bVar : bVarArr) {
                        if (tArr[i4] == null) {
                            boolean z2 = bVar.f47449c;
                            T poll = bVar.f47448b.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, wVar, z, bVar)) {
                                if (!z3) {
                                    tArr[i4] = poll;
                                } else {
                                    i3++;
                                }
                            } else {
                                return;
                            }
                        } else if (bVar.f47449c && !z && (th = bVar.f47450d) != null) {
                            this.cancelled = true;
                            cancel();
                            wVar.onError(th);
                            return;
                        }
                        i4++;
                    }
                    if (i3 == 0) {
                        try {
                            wVar.onNext(Objects.requireNonNull(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.c.b.b(th2);
                            cancel();
                            wVar.onError(th2);
                            return;
                        }
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, w<? super R> wVar, boolean z3, b<?, ?> bVar) {
            if (this.cancelled) {
                cancel();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = bVar.f47450d;
                    if (th != null) {
                        this.cancelled = true;
                        cancel();
                        wVar.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.cancelled = true;
                        cancel();
                        wVar.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = bVar.f47450d;
                    this.cancelled = true;
                    cancel();
                    if (th2 != null) {
                        wVar.onError(th2);
                    } else {
                        wVar.onComplete();
                    }
                    return true;
                }
            }
        }
    }

    static final class b<T, R> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final a<T, R> f47447a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.rxjava3.e.g.c<T> f47448b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f47449c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f47450d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<c> f47451e = new AtomicReference<>();

        b(a<T, R> aVar, int i2) {
            this.f47447a = aVar;
            this.f47448b = new io.reactivex.rxjava3.e.g.c<>(i2);
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.f47451e, cVar);
        }

        public final void onNext(T t) {
            this.f47448b.offer(t);
            this.f47447a.drain();
        }

        public final void onError(Throwable th) {
            this.f47450d = th;
            this.f47449c = true;
            this.f47447a.drain();
        }

        public final void onComplete() {
            this.f47449c = true;
            this.f47447a.drain();
        }
    }
}
