package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.g.a;
import java.lang.Exception;
import java.util.ArrayDeque;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    protected final I[] f31316a;

    /* renamed from: b  reason: collision with root package name */
    protected int f31317b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread f31318c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f31319d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<I> f31320e = new ArrayDeque<>();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<O> f31321f = new ArrayDeque<>();

    /* renamed from: g  reason: collision with root package name */
    private final O[] f31322g;

    /* renamed from: h  reason: collision with root package name */
    private int f31323h;

    /* renamed from: i  reason: collision with root package name */
    private I f31324i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    /* access modifiers changed from: protected */
    public abstract E a(I i2, O o, boolean z);

    /* access modifiers changed from: protected */
    public abstract E a(Throwable th);

    /* access modifiers changed from: protected */
    public abstract I f();

    /* access modifiers changed from: protected */
    public abstract O g();

    public final /* synthetic */ void a(Object obj) throws Exception {
        I i2 = (e) obj;
        synchronized (this.f31319d) {
            a.a(i2 == this.f31324i);
            this.f31320e.addLast(i2);
            j();
            this.f31324i = null;
        }
    }

    protected g(I[] iArr, O[] oArr) {
        this.f31316a = iArr;
        this.f31317b = 2;
        for (int i2 = 0; i2 < this.f31317b; i2++) {
            this.f31316a[i2] = f();
        }
        this.f31322g = oArr;
        this.f31323h = 2;
        for (int i3 = 0; i3 < this.f31323h; i3++) {
            this.f31322g[i3] = g();
        }
        this.f31318c = new Thread() {
            public final void run() {
                do {
                    try {
                    } catch (InterruptedException e2) {
                        throw new IllegalStateException(e2);
                    }
                } while (g.this.e());
            }
        };
        this.f31318c.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public I a() throws Exception {
        I i2;
        I i3;
        synchronized (this.f31319d) {
            a.b(this.f31324i == null);
            if (this.f31317b == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f31316a;
                int i4 = this.f31317b - 1;
                this.f31317b = i4;
                i2 = iArr[i4];
            }
            this.f31324i = i2;
            i3 = this.f31324i;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public O b() throws Exception {
        synchronized (this.f31319d) {
            if (this.f31321f.isEmpty()) {
                return null;
            }
            O o = (f) this.f31321f.removeFirst();
            return o;
        }
    }

    /* access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.f31319d) {
            o.a();
            O[] oArr = this.f31322g;
            int i2 = this.f31323h;
            this.f31323h = i2 + 1;
            oArr[i2] = o;
            j();
        }
    }

    public final void c() {
        synchronized (this.f31319d) {
            this.k = true;
            this.m = 0;
            if (this.f31324i != null) {
                a(this.f31324i);
                this.f31324i = null;
            }
            while (!this.f31320e.isEmpty()) {
                a((e) this.f31320e.removeFirst());
            }
            while (!this.f31321f.isEmpty()) {
                ((f) this.f31321f.removeFirst()).e();
            }
        }
    }

    public final void d() {
        synchronized (this.f31319d) {
            this.l = true;
            this.f31319d.notify();
        }
        try {
            this.f31318c.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void j() {
        if (k()) {
            this.f31319d.notify();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.c() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.a(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.j_() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.a(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r6.j = a(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r6.j = a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r6.j = a((java.lang.Throwable) r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f31319d
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.l     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.k()     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.f31319d     // Catch:{ all -> 0x0096 }
            r1.wait()     // Catch:{ all -> 0x0096 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.l     // Catch:{ all -> 0x0096 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.f31320e     // Catch:{ all -> 0x0096 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0096 }
            com.google.android.exoplayer2.c.e r1 = (com.google.android.exoplayer2.c.e) r1     // Catch:{ all -> 0x0096 }
            O[] r3 = r6.f31322g     // Catch:{ all -> 0x0096 }
            int r4 = r6.f31323h     // Catch:{ all -> 0x0096 }
            r5 = 1
            int r4 = r4 - r5
            r6.f31323h = r4     // Catch:{ all -> 0x0096 }
            r3 = r3[r4]     // Catch:{ all -> 0x0096 }
            boolean r4 = r6.k     // Catch:{ all -> 0x0096 }
            r6.k = r2     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.a(r0)
            goto L_0x0069
        L_0x003c:
            boolean r0 = r1.j_()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.a(r0)
        L_0x0047:
            java.lang.Exception r0 = r6.a(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0056, OutOfMemoryError -> 0x004e }
            r6.j = r0     // Catch:{ RuntimeException -> 0x0056, OutOfMemoryError -> 0x004e }
            goto L_0x005d
        L_0x004e:
            r0 = move-exception
            java.lang.Exception r0 = r6.a((java.lang.Throwable) r0)
            r6.j = r0
            goto L_0x005d
        L_0x0056:
            r0 = move-exception
            java.lang.Exception r0 = r6.a((java.lang.Throwable) r0)
            r6.j = r0
        L_0x005d:
            E r0 = r6.j
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r6.f31319d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return r2
        L_0x0066:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r1
        L_0x0069:
            java.lang.Object r4 = r6.f31319d
            monitor-enter(r4)
            boolean r0 = r6.k     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0074
            r3.e()     // Catch:{ all -> 0x0093 }
            goto L_0x008e
        L_0x0074:
            boolean r0 = r3.j_()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0083
            int r0 = r6.m     // Catch:{ all -> 0x0093 }
            int r0 = r0 + r5
            r6.m = r0     // Catch:{ all -> 0x0093 }
            r3.e()     // Catch:{ all -> 0x0093 }
            goto L_0x008e
        L_0x0083:
            int r0 = r6.m     // Catch:{ all -> 0x0093 }
            r3.f31315c = r0     // Catch:{ all -> 0x0093 }
            r6.m = r2     // Catch:{ all -> 0x0093 }
            java.util.ArrayDeque<O> r0 = r6.f31321f     // Catch:{ all -> 0x0093 }
            r0.addLast(r3)     // Catch:{ all -> 0x0093 }
        L_0x008e:
            r6.a(r1)     // Catch:{ all -> 0x0093 }
            monitor-exit(r4)     // Catch:{ all -> 0x0093 }
            return r5
        L_0x0093:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0093 }
            throw r0
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.g.e():boolean");
    }

    private boolean k() {
        return !this.f31320e.isEmpty() && this.f31323h > 0;
    }

    private void a(I i2) {
        i2.a();
        I[] iArr = this.f31316a;
        int i3 = this.f31317b;
        this.f31317b = i3 + 1;
        iArr[i3] = i2;
    }
}
