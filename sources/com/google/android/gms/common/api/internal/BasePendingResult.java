package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.base.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends l> extends g<R> {

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<Boolean> f8384c = new cp();

    /* renamed from: a  reason: collision with root package name */
    private final Object f8385a;

    /* renamed from: b  reason: collision with root package name */
    private final a<R> f8386b;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<e> f8387d;

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f8388e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<g.a> f8389f;

    /* renamed from: g  reason: collision with root package name */
    private m<? super R> f8390g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<cd> f8391h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public R f8392i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    private b mResultGuardian;
    private com.google.android.gms.common.internal.m n;
    private volatile bx<R> o;
    private boolean p;

    final class b {
        private b() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.b(BasePendingResult.this.f8392i);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, byte b2) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f8385a = new Object();
        this.f8388e = new CountDownLatch(1);
        this.f8389f = new ArrayList<>();
        this.f8391h = new AtomicReference<>();
        this.p = false;
        this.f8386b = new a<>(Looper.getMainLooper());
        this.f8387d = new WeakReference<>((Object) null);
    }

    static /* synthetic */ m b(m mVar) {
        return mVar;
    }

    /* access modifiers changed from: protected */
    public abstract R a(Status status);

    public final Integer c() {
        return null;
    }

    public static class a<R extends l> extends k {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void a(m<? super R> mVar, R r) {
            sendMessage(obtainMessage(1, new Pair(BasePendingResult.b((m) mVar), r)));
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                m mVar = (m) pair.first;
                l lVar = (l) pair.second;
                try {
                    mVar.onResult(lVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.b(lVar);
                    throw e2;
                }
            } else if (i2 != 2) {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i3);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).c(Status.f8357d);
            }
        }
    }

    protected BasePendingResult(e eVar) {
        this.f8385a = new Object();
        this.f8388e = new CountDownLatch(1);
        this.f8389f = new ArrayList<>();
        this.f8391h = new AtomicReference<>();
        this.p = false;
        this.f8386b = new a<>(eVar != null ? eVar.b() : Looper.getMainLooper());
        this.f8387d = new WeakReference<>(eVar);
    }

    private boolean f() {
        return this.f8388e.getCount() == 0;
    }

    public final R a(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            s.c("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        s.a(!this.k, (Object) "Result has already been consumed.");
        if (this.o != null) {
            z = false;
        }
        s.a(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.f8388e.await(j2, timeUnit)) {
                c(Status.f8357d);
            }
        } catch (InterruptedException unused) {
            c(Status.f8355b);
        }
        s.a(f(), (Object) "Result is not ready.");
        return g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.gms.common.api.m<? super R> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f8385a
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.f8390g = r6     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x000a:
            boolean r1 = r5.k     // Catch:{ all -> 0x003f }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.s.a((boolean) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.internal.bx<R> r1 = r5.o     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.s.a((boolean) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x003f }
            boolean r1 = r5.b()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x002b:
            boolean r1 = r5.f()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.common.api.internal.BasePendingResult$a<R> r1 = r5.f8386b     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.l r2 = r5.g()     // Catch:{ all -> 0x003f }
            r1.a(r6, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x003b:
            r5.f8390g = r6     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.m):void");
    }

    public final void a(g.a aVar) {
        s.b(true, "Callback cannot be null.");
        synchronized (this.f8385a) {
            if (f()) {
                aVar.a(this.j);
            } else {
                this.f8389f.add(aVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f8385a
            monitor-enter(r0)
            boolean r1 = r2.l     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x001f
            boolean r1 = r2.k     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            R r1 = r2.f8392i     // Catch:{ all -> 0x0021 }
            b((com.google.android.gms.common.api.l) r1)     // Catch:{ all -> 0x0021 }
            r1 = 1
            r2.l = r1     // Catch:{ all -> 0x0021 }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.f8358e     // Catch:{ all -> 0x0021 }
            com.google.android.gms.common.api.l r1 = r2.a((com.google.android.gms.common.api.Status) r1)     // Catch:{ all -> 0x0021 }
            r2.c(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a():void");
    }

    public final boolean d() {
        boolean b2;
        synchronized (this.f8385a) {
            if (((e) this.f8387d.get()) == null || !this.p) {
                a();
            }
            b2 = b();
        }
        return b2;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f8385a) {
            z = this.l;
        }
        return z;
    }

    public final void a(R r) {
        synchronized (this.f8385a) {
            if (this.m || this.l) {
                b((l) r);
                return;
            }
            f();
            boolean z = true;
            s.a(!f(), (Object) "Results have already been set");
            if (this.k) {
                z = false;
            }
            s.a(z, (Object) "Result has already been consumed");
            c(r);
        }
    }

    public final void c(Status status) {
        synchronized (this.f8385a) {
            if (!f()) {
                a(a(status));
                this.m = true;
            }
        }
    }

    public final void a(cd cdVar) {
        this.f8391h.set(cdVar);
    }

    public final void e() {
        this.p = this.p || f8384c.get().booleanValue();
    }

    private final R g() {
        R r;
        synchronized (this.f8385a) {
            s.a(!this.k, (Object) "Result has already been consumed.");
            s.a(f(), (Object) "Result is not ready.");
            r = this.f8392i;
            this.f8392i = null;
            this.f8390g = null;
            this.k = true;
        }
        cd andSet = this.f8391h.getAndSet((Object) null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void c(R r) {
        this.f8392i = r;
        this.n = null;
        this.f8388e.countDown();
        this.j = this.f8392i.a();
        int i2 = 0;
        if (this.l) {
            this.f8390g = null;
        } else if (this.f8390g != null) {
            this.f8386b.removeMessages(2);
            this.f8386b.a(this.f8390g, g());
        } else if (this.f8392i instanceof i) {
            this.mResultGuardian = new b(this, (byte) 0);
        }
        ArrayList arrayList = this.f8389f;
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((g.a) obj).a(this.j);
        }
        this.f8389f.clear();
    }

    public static void b(l lVar) {
        if (lVar instanceof i) {
            try {
                ((i) lVar).a();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(lVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
            }
        }
    }
}
