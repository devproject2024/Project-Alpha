package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.a;
import io.reactivex.rxjava3.e.k.m;

public final class f<T> implements w<T>, c {

    /* renamed from: a  reason: collision with root package name */
    final w<? super T> f47755a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f47756b;

    /* renamed from: c  reason: collision with root package name */
    c f47757c;

    /* renamed from: d  reason: collision with root package name */
    boolean f47758d;

    /* renamed from: e  reason: collision with root package name */
    a<Object> f47759e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f47760f;

    public f(w<? super T> wVar) {
        this(wVar, (byte) 0);
    }

    private f(w<? super T> wVar, byte b2) {
        this.f47755a = wVar;
        this.f47756b = false;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.a.c.validate(this.f47757c, cVar)) {
            this.f47757c = cVar;
            this.f47755a.onSubscribe(this);
        }
    }

    public final void dispose() {
        this.f47760f = true;
        this.f47757c.dispose();
    }

    public final boolean isDisposed() {
        return this.f47757c.isDisposed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        r6.f47755a.onNext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r7 = r6.f47759e;
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r7 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        r6.f47758d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        r6.f47759e = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004c, code lost:
        r2 = r6.f47755a;
        r3 = r7.f47732b;
        r7 = r7.f47731a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        if (r3 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0055, code lost:
        if (r4 >= r7) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        r5 = r3[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        if (r5 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005f, code lost:
        if (io.reactivex.rxjava3.e.k.m.acceptFull((java.lang.Object) r5, r2) == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0066, code lost:
        r3 = r3[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.f47760f
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            if (r7 != 0) goto L_0x0016
            io.reactivex.rxjava3.b.c r7 = r6.f47757c
            r7.dispose()
            java.lang.String r7 = "onNext called with a null value."
            java.lang.NullPointerException r7 = io.reactivex.rxjava3.e.k.j.a((java.lang.String) r7)
            r6.onError(r7)
            return
        L_0x0016:
            monitor-enter(r6)
            boolean r0 = r6.f47760f     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x001d
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            return
        L_0x001d:
            boolean r0 = r6.f47758d     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0035
            io.reactivex.rxjava3.e.k.a<java.lang.Object> r0 = r6.f47759e     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x002c
            io.reactivex.rxjava3.e.k.a r0 = new io.reactivex.rxjava3.e.k.a     // Catch:{ all -> 0x0073 }
            r0.<init>()     // Catch:{ all -> 0x0073 }
            r6.f47759e = r0     // Catch:{ all -> 0x0073 }
        L_0x002c:
            java.lang.Object r7 = io.reactivex.rxjava3.e.k.m.next(r7)     // Catch:{ all -> 0x0073 }
            r0.a(r7)     // Catch:{ all -> 0x0073 }
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            return
        L_0x0035:
            r0 = 1
            r6.f47758d = r0     // Catch:{ all -> 0x0073 }
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            io.reactivex.rxjava3.a.w<? super T> r1 = r6.f47755a
            r1.onNext(r7)
        L_0x003e:
            monitor-enter(r6)
            io.reactivex.rxjava3.e.k.a<java.lang.Object> r7 = r6.f47759e     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r7 != 0) goto L_0x0048
            r6.f47758d = r1     // Catch:{ all -> 0x0070 }
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            return
        L_0x0048:
            r2 = 0
            r6.f47759e = r2     // Catch:{ all -> 0x0070 }
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            io.reactivex.rxjava3.a.w<? super T> r2 = r6.f47755a
            java.lang.Object[] r3 = r7.f47732b
            int r7 = r7.f47731a
        L_0x0052:
            if (r3 == 0) goto L_0x006d
            r4 = 0
        L_0x0055:
            if (r4 >= r7) goto L_0x0066
            r5 = r3[r4]
            if (r5 == 0) goto L_0x0066
            boolean r5 = io.reactivex.rxjava3.e.k.m.acceptFull((java.lang.Object) r5, r2)
            if (r5 == 0) goto L_0x0063
            r1 = 1
            goto L_0x006d
        L_0x0063:
            int r4 = r4 + 1
            goto L_0x0055
        L_0x0066:
            r3 = r3[r7]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            goto L_0x0052
        L_0x006d:
            if (r1 == 0) goto L_0x003e
            return
        L_0x0070:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            throw r7
        L_0x0073:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.g.f.onNext(java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r1 == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        io.reactivex.rxjava3.h.a.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        r3.f47755a.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.f47760f
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.h.a.a((java.lang.Throwable) r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.f47760f     // Catch:{ all -> 0x0045 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            r1 = 1
            goto L_0x0038
        L_0x0011:
            boolean r0 = r3.f47758d     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0034
            r3.f47760f = r2     // Catch:{ all -> 0x0045 }
            io.reactivex.rxjava3.e.k.a<java.lang.Object> r0 = r3.f47759e     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0022
            io.reactivex.rxjava3.e.k.a r0 = new io.reactivex.rxjava3.e.k.a     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            r3.f47759e = r0     // Catch:{ all -> 0x0045 }
        L_0x0022:
            java.lang.Object r4 = io.reactivex.rxjava3.e.k.m.error(r4)     // Catch:{ all -> 0x0045 }
            boolean r2 = r3.f47756b     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x002e
            r0.a(r4)     // Catch:{ all -> 0x0045 }
            goto L_0x0032
        L_0x002e:
            java.lang.Object[] r0 = r0.f47732b     // Catch:{ all -> 0x0045 }
            r0[r1] = r4     // Catch:{ all -> 0x0045 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            return
        L_0x0034:
            r3.f47760f = r2     // Catch:{ all -> 0x0045 }
            r3.f47758d = r2     // Catch:{ all -> 0x0045 }
        L_0x0038:
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x003f
            io.reactivex.rxjava3.h.a.a((java.lang.Throwable) r4)
            return
        L_0x003f:
            io.reactivex.rxjava3.a.w<? super T> r0 = r3.f47755a
            r0.onError(r4)
            return
        L_0x0045:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0045 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.g.f.onError(java.lang.Throwable):void");
    }

    public final void onComplete() {
        if (!this.f47760f) {
            synchronized (this) {
                if (!this.f47760f) {
                    if (this.f47758d) {
                        a<Object> aVar = this.f47759e;
                        if (aVar == null) {
                            aVar = new a<>();
                            this.f47759e = aVar;
                        }
                        aVar.a(m.complete());
                        return;
                    }
                    this.f47760f = true;
                    this.f47758d = true;
                    this.f47755a.onComplete();
                }
            }
        }
    }
}
