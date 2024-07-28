package io.reactivex.rxjava3.b;

import io.reactivex.rxjava3.c.a;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.e.k.o;
import java.util.ArrayList;

public final class b implements c, d {

    /* renamed from: a  reason: collision with root package name */
    o<c> f46639a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f46640b;

    public final void dispose() {
        if (!this.f46640b) {
            synchronized (this) {
                if (!this.f46640b) {
                    this.f46640b = true;
                    o<c> oVar = this.f46639a;
                    this.f46639a = null;
                    a(oVar);
                }
            }
        }
    }

    public final boolean isDisposed() {
        return this.f46640b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(io.reactivex.rxjava3.b.c r10) {
        /*
            r9 = this;
            java.lang.String r0 = "disposable is null"
            java.util.Objects.requireNonNull(r10, r0)
            boolean r0 = r9.f46640b
            if (r0 != 0) goto L_0x008e
            monitor-enter(r9)
            boolean r0 = r9.f46640b     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0089
            io.reactivex.rxjava3.e.k.o<io.reactivex.rxjava3.b.c> r0 = r9.f46639a     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0019
            io.reactivex.rxjava3.e.k.o r0 = new io.reactivex.rxjava3.e.k.o     // Catch:{ all -> 0x008b }
            r0.<init>()     // Catch:{ all -> 0x008b }
            r9.f46639a = r0     // Catch:{ all -> 0x008b }
        L_0x0019:
            T[] r1 = r0.f47742e     // Catch:{ all -> 0x008b }
            int r2 = r0.f47739b     // Catch:{ all -> 0x008b }
            int r3 = r10.hashCode()     // Catch:{ all -> 0x008b }
            int r3 = io.reactivex.rxjava3.e.k.o.a(r3)     // Catch:{ all -> 0x008b }
            r3 = r3 & r2
            r4 = r1[r3]     // Catch:{ all -> 0x008b }
            r5 = 1
            if (r4 == 0) goto L_0x003e
            boolean r4 = r4.equals(r10)     // Catch:{ all -> 0x008b }
            if (r4 != 0) goto L_0x0087
        L_0x0031:
            int r3 = r3 + r5
            r3 = r3 & r2
            r4 = r1[r3]     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x003e
            boolean r4 = r4.equals(r10)     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0031
            goto L_0x0087
        L_0x003e:
            r1[r3] = r10     // Catch:{ all -> 0x008b }
            int r10 = r0.f47740c     // Catch:{ all -> 0x008b }
            int r10 = r10 + r5
            r0.f47740c = r10     // Catch:{ all -> 0x008b }
            int r1 = r0.f47741d     // Catch:{ all -> 0x008b }
            if (r10 < r1) goto L_0x0087
            T[] r10 = r0.f47742e     // Catch:{ all -> 0x008b }
            int r1 = r10.length     // Catch:{ all -> 0x008b }
            int r2 = r1 << 1
            int r3 = r2 + -1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x008b }
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ all -> 0x008b }
            int r6 = r0.f47740c     // Catch:{ all -> 0x008b }
        L_0x0056:
            int r7 = r6 + -1
            if (r6 == 0) goto L_0x007b
        L_0x005a:
            int r1 = r1 + -1
            r6 = r10[r1]     // Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x005a
            r6 = r10[r1]     // Catch:{ all -> 0x008b }
            int r6 = r6.hashCode()     // Catch:{ all -> 0x008b }
            int r6 = io.reactivex.rxjava3.e.k.o.a(r6)     // Catch:{ all -> 0x008b }
            r6 = r6 & r3
            r8 = r4[r6]     // Catch:{ all -> 0x008b }
            if (r8 == 0) goto L_0x0075
        L_0x006f:
            int r6 = r6 + r5
            r6 = r6 & r3
            r8 = r4[r6]     // Catch:{ all -> 0x008b }
            if (r8 != 0) goto L_0x006f
        L_0x0075:
            r8 = r10[r1]     // Catch:{ all -> 0x008b }
            r4[r6] = r8     // Catch:{ all -> 0x008b }
            r6 = r7
            goto L_0x0056
        L_0x007b:
            r0.f47739b = r3     // Catch:{ all -> 0x008b }
            float r10 = (float) r2     // Catch:{ all -> 0x008b }
            float r1 = r0.f47738a     // Catch:{ all -> 0x008b }
            float r10 = r10 * r1
            int r10 = (int) r10     // Catch:{ all -> 0x008b }
            r0.f47741d = r10     // Catch:{ all -> 0x008b }
            r0.f47742e = r4     // Catch:{ all -> 0x008b }
        L_0x0087:
            monitor-exit(r9)     // Catch:{ all -> 0x008b }
            return r5
        L_0x0089:
            monitor-exit(r9)     // Catch:{ all -> 0x008b }
            goto L_0x008e
        L_0x008b:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x008b }
            throw r10
        L_0x008e:
            r10.dispose()
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.b.b.a(io.reactivex.rxjava3.b.c):boolean");
    }

    public final boolean b(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(io.reactivex.rxjava3.b.c r8) {
        /*
            r7 = this;
            java.lang.String r0 = "disposable is null"
            java.util.Objects.requireNonNull(r8, r0)
            boolean r0 = r7.f46640b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r7)
            boolean r0 = r7.f46640b     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r1
        L_0x0012:
            io.reactivex.rxjava3.e.k.o<io.reactivex.rxjava3.b.c> r0 = r7.f46639a     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x004b
            T[] r2 = r0.f47742e     // Catch:{ all -> 0x004d }
            int r3 = r0.f47739b     // Catch:{ all -> 0x004d }
            int r4 = r8.hashCode()     // Catch:{ all -> 0x004d }
            int r4 = io.reactivex.rxjava3.e.k.o.a(r4)     // Catch:{ all -> 0x004d }
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x004d }
            r6 = 1
            if (r5 != 0) goto L_0x002a
        L_0x0028:
            r8 = 0
            goto L_0x0046
        L_0x002a:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0035
            boolean r8 = r0.a(r4, r2, r3)     // Catch:{ all -> 0x004d }
            goto L_0x0046
        L_0x0035:
            int r4 = r4 + r6
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x004d }
            if (r5 != 0) goto L_0x003c
            goto L_0x0028
        L_0x003c:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0035
            boolean r8 = r0.a(r4, r2, r3)     // Catch:{ all -> 0x004d }
        L_0x0046:
            if (r8 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r6
        L_0x004b:
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r1
        L_0x004d:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.b.b.c(io.reactivex.rxjava3.b.c):boolean");
    }

    public final void a() {
        if (!this.f46640b) {
            synchronized (this) {
                if (!this.f46640b) {
                    o<c> oVar = this.f46639a;
                    this.f46639a = null;
                    a(oVar);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b() {
        /*
            r2 = this;
            boolean r0 = r2.f46640b
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f46640b     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0015 }
            return r1
        L_0x000d:
            io.reactivex.rxjava3.e.k.o<io.reactivex.rxjava3.b.c> r0 = r2.f46639a     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0013
            int r1 = r0.f47740c     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r2)     // Catch:{ all -> 0x0015 }
            return r1
        L_0x0015:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0015 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.b.b.b():int");
    }

    private static void a(o<c> oVar) {
        if (oVar != null) {
            ArrayList arrayList = null;
            for (T t : oVar.f47742e) {
                if (t instanceof c) {
                    try {
                        ((c) t).dispose();
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw j.a((Throwable) arrayList.get(0));
            }
            throw new a((Iterable<? extends Throwable>) arrayList);
        }
    }
}
