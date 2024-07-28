package com.bumptech.glide.load.b;

import android.os.Process;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.g;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final Map<g, b> f6718a;

    /* renamed from: b  reason: collision with root package name */
    final ReferenceQueue<p<?>> f6719b;

    /* renamed from: c  reason: collision with root package name */
    p.a f6720c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f6721d;

    /* renamed from: e  reason: collision with root package name */
    volatile C0093a f6722e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6723f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f6724g;

    /* renamed from: com.bumptech.glide.load.b.a$a  reason: collision with other inner class name */
    interface C0093a {
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public final Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public final void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    private a(boolean z, Executor executor) {
        this.f6718a = new HashMap();
        this.f6719b = new ReferenceQueue<>();
        this.f6723f = z;
        this.f6724g = executor;
        executor.execute(new Runnable() {
            public final void run() {
                a aVar = a.this;
                while (!aVar.f6721d) {
                    try {
                        aVar.a((b) aVar.f6719b.remove());
                        C0093a aVar2 = aVar.f6722e;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar, p<?> pVar) {
        b put = this.f6718a.put(gVar, new b(gVar, pVar, this.f6719b, this.f6723f));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar) {
        b remove = this.f6718a.remove(gVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bumptech.glide.load.b.p<?> b(com.bumptech.glide.load.g r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.g, com.bumptech.glide.load.b.a$b> r0 = r1.f6718a     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.b.a$b r2 = (com.bumptech.glide.load.b.a.b) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.b.p r0 = (com.bumptech.glide.load.b.p) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.a((com.bumptech.glide.load.b.a.b) r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.b(com.bumptech.glide.load.g):com.bumptech.glide.load.b.p");
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        synchronized (this) {
            this.f6718a.remove(bVar.f6728a);
            if (bVar.f6729b) {
                if (bVar.f6730c != null) {
                    this.f6720c.a(bVar.f6728a, new p(bVar.f6730c, true, false, bVar.f6728a, this.f6720c));
                }
            }
        }
    }

    static final class b extends WeakReference<p<?>> {

        /* renamed from: a  reason: collision with root package name */
        final g f6728a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f6729b;

        /* renamed from: c  reason: collision with root package name */
        v<?> f6730c;

        b(g gVar, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.f6728a = (g) j.a(gVar, "Argument must not be null");
            this.f6730c = (!pVar.f6930a || !z) ? null : (v) j.a(pVar.f6931b, "Argument must not be null");
            this.f6729b = pVar.f6930a;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f6730c = null;
            clear();
        }
    }
}
