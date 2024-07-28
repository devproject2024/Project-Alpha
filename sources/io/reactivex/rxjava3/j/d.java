package io.reactivex.rxjava3.j;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.a;
import io.reactivex.rxjava3.e.k.m;

final class d<T> extends e<T> implements a.C0826a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final e<T> f47811a;

    /* renamed from: b  reason: collision with root package name */
    boolean f47812b;

    /* renamed from: c  reason: collision with root package name */
    a<Object> f47813c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f47814d;

    d(e<T> eVar) {
        this.f47811a = eVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47811a.subscribe(wVar);
    }

    public final void onSubscribe(c cVar) {
        boolean z = true;
        if (!this.f47814d) {
            synchronized (this) {
                if (!this.f47814d) {
                    if (this.f47812b) {
                        a<Object> aVar = this.f47813c;
                        if (aVar == null) {
                            aVar = new a<>();
                            this.f47813c = aVar;
                        }
                        aVar.a(m.disposable(cVar));
                        return;
                    }
                    this.f47812b = true;
                    z = false;
                }
            }
        }
        if (z) {
            cVar.dispose();
            return;
        }
        this.f47811a.onSubscribe(cVar);
        a();
    }

    public final void onNext(T t) {
        if (!this.f47814d) {
            synchronized (this) {
                if (!this.f47814d) {
                    if (this.f47812b) {
                        a<Object> aVar = this.f47813c;
                        if (aVar == null) {
                            aVar = new a<>();
                            this.f47813c = aVar;
                        }
                        aVar.a(m.next(t));
                        return;
                    }
                    this.f47812b = true;
                    this.f47811a.onNext(t);
                    a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        io.reactivex.rxjava3.h.a.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r3.f47811a.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.f47814d
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.h.a.a((java.lang.Throwable) r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.f47814d     // Catch:{ all -> 0x003b }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            r1 = 1
            goto L_0x002e
        L_0x0011:
            r3.f47814d = r2     // Catch:{ all -> 0x003b }
            boolean r0 = r3.f47812b     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002c
            io.reactivex.rxjava3.e.k.a<java.lang.Object> r0 = r3.f47813c     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0022
            io.reactivex.rxjava3.e.k.a r0 = new io.reactivex.rxjava3.e.k.a     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            r3.f47813c = r0     // Catch:{ all -> 0x003b }
        L_0x0022:
            java.lang.Object r4 = io.reactivex.rxjava3.e.k.m.error(r4)     // Catch:{ all -> 0x003b }
            java.lang.Object[] r0 = r0.f47732b     // Catch:{ all -> 0x003b }
            r0[r1] = r4     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            return
        L_0x002c:
            r3.f47812b = r2     // Catch:{ all -> 0x003b }
        L_0x002e:
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            io.reactivex.rxjava3.h.a.a((java.lang.Throwable) r4)
            return
        L_0x0035:
            io.reactivex.rxjava3.j.e<T> r0 = r3.f47811a
            r0.onError(r4)
            return
        L_0x003b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.j.d.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f47814d) {
            synchronized (this) {
                if (!this.f47814d) {
                    this.f47814d = true;
                    if (this.f47812b) {
                        a<Object> aVar = this.f47813c;
                        if (aVar == null) {
                            aVar = new a<>();
                            this.f47813c = aVar;
                        }
                        aVar.a(m.complete());
                        return;
                    }
                    this.f47812b = true;
                    this.f47811a.onComplete();
                }
            }
        }
    }

    private void a() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f47813c;
                if (aVar == null) {
                    this.f47812b = false;
                    return;
                }
                this.f47813c = null;
            }
            aVar.a((a.C0826a<? super Object>) this);
        }
        while (true) {
        }
    }

    public final boolean test(Object obj) {
        return m.acceptFull(obj, this.f47811a);
    }
}
