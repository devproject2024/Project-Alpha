package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.d;
import io.reactivex.rxjava3.e.c.e;
import java.util.concurrent.atomic.AtomicInteger;

public final class df<T> extends y<Boolean> implements e<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f47268a;

    /* renamed from: b  reason: collision with root package name */
    final u<? extends T> f47269b;

    /* renamed from: c  reason: collision with root package name */
    final d<? super T, ? super T> f47270c;

    /* renamed from: d  reason: collision with root package name */
    final int f47271d;

    public df(u<? extends T> uVar, u<? extends T> uVar2, d<? super T, ? super T> dVar, int i2) {
        this.f47268a = uVar;
        this.f47269b = uVar2;
        this.f47270c = dVar;
        this.f47271d = i2;
    }

    public final void b(aa<? super Boolean> aaVar) {
        a aVar = new a(aaVar, this.f47271d, this.f47268a, this.f47269b, this.f47270c);
        aaVar.onSubscribe(aVar);
        aVar.subscribe();
    }

    public final p<Boolean> U_() {
        return io.reactivex.rxjava3.h.a.a(new de(this.f47268a, this.f47269b, this.f47270c, this.f47271d));
    }

    static final class a<T> extends AtomicInteger implements c {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final aa<? super Boolean> downstream;
        final u<? extends T> first;
        final b<T>[] observers;
        final io.reactivex.rxjava3.e.a.a resources = new io.reactivex.rxjava3.e.a.a(2);
        final u<? extends T> second;
        T v1;
        T v2;

        a(aa<? super Boolean> aaVar, int i2, u<? extends T> uVar, u<? extends T> uVar2, d<? super T, ? super T> dVar) {
            this.downstream = aaVar;
            this.first = uVar;
            this.second = uVar2;
            this.comparer = dVar;
            b<T>[] bVarArr = new b[2];
            this.observers = bVarArr;
            bVarArr[0] = new b<>(this, 0, i2);
            bVarArr[1] = new b<>(this, 1, i2);
        }

        /* access modifiers changed from: package-private */
        public final boolean setDisposable(c cVar, int i2) {
            return this.resources.setResource(i2, cVar);
        }

        /* access modifiers changed from: package-private */
        public final void subscribe() {
            b<T>[] bVarArr = this.observers;
            this.first.subscribe(bVarArr[0]);
            this.second.subscribe(bVarArr[1]);
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    b<T>[] bVarArr = this.observers;
                    bVarArr[0].f47273b.clear();
                    bVarArr[1].f47273b.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void cancel(io.reactivex.rxjava3.e.g.c<T> cVar, io.reactivex.rxjava3.e.g.c<T> cVar2) {
            this.cancelled = true;
            cVar.clear();
            cVar2.clear();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.observers;
                b<T> bVar = bVarArr[0];
                io.reactivex.rxjava3.e.g.c<T> cVar = bVar.f47273b;
                b<T> bVar2 = bVarArr[1];
                io.reactivex.rxjava3.e.g.c<T> cVar2 = bVar2.f47273b;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = bVar.f47275d;
                    if (!z || (th2 = bVar.f47276e) == null) {
                        boolean z2 = bVar2.f47275d;
                        if (!z2 || (th = bVar2.f47276e) == null) {
                            if (this.v1 == null) {
                                this.v1 = cVar.poll();
                            }
                            boolean z3 = this.v1 == null;
                            if (this.v2 == null) {
                                this.v2 = cVar2.poll();
                            }
                            boolean z4 = this.v2 == null;
                            if (z && z2 && z3 && z4) {
                                this.downstream.onSuccess(Boolean.TRUE);
                                return;
                            } else if (!z || !z2 || z3 == z4) {
                                if (!z3 && !z4) {
                                    try {
                                        if (!this.comparer.a(this.v1, this.v2)) {
                                            cancel(cVar, cVar2);
                                            this.downstream.onSuccess(Boolean.FALSE);
                                            return;
                                        }
                                        this.v1 = null;
                                        this.v2 = null;
                                    } catch (Throwable th3) {
                                        io.reactivex.rxjava3.c.b.b(th3);
                                        cancel(cVar, cVar2);
                                        this.downstream.onError(th3);
                                        return;
                                    }
                                }
                                if ((z3 || z4) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                cancel(cVar, cVar2);
                                this.downstream.onSuccess(Boolean.FALSE);
                                return;
                            }
                        } else {
                            cancel(cVar, cVar2);
                            this.downstream.onError(th);
                            return;
                        }
                    } else {
                        cancel(cVar, cVar2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
                cVar.clear();
                cVar2.clear();
            }
        }
    }

    static final class b<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final a<T> f47272a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.rxjava3.e.g.c<T> f47273b;

        /* renamed from: c  reason: collision with root package name */
        final int f47274c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f47275d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f47276e;

        b(a<T> aVar, int i2, int i3) {
            this.f47272a = aVar;
            this.f47274c = i2;
            this.f47273b = new io.reactivex.rxjava3.e.g.c<>(i3);
        }

        public final void onSubscribe(c cVar) {
            this.f47272a.setDisposable(cVar, this.f47274c);
        }

        public final void onNext(T t) {
            this.f47273b.offer(t);
            this.f47272a.drain();
        }

        public final void onError(Throwable th) {
            this.f47276e = th;
            this.f47275d = true;
            this.f47272a.drain();
        }

        public final void onComplete() {
            this.f47275d = true;
            this.f47272a.drain();
        }
    }
}
