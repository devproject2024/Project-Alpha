package com.bumptech.glide.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.a.i;
import com.bumptech.glide.e.a.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class f<R> implements c<R>, g<R> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f6556a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final int f6557b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6558c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6559d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6560e;

    /* renamed from: f  reason: collision with root package name */
    private R f6561f;

    /* renamed from: g  reason: collision with root package name */
    private d f6562g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6563h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6564i;
    private boolean j;
    private q k;

    public final void a() {
    }

    public final void a(Drawable drawable) {
    }

    public final void b() {
    }

    public final void b(Drawable drawable) {
    }

    public final void b(i iVar) {
    }

    public final void c() {
    }

    public f() {
        this(f6556a);
    }

    private f(a aVar) {
        this.f6557b = Integer.MIN_VALUE;
        this.f6558c = Integer.MIN_VALUE;
        this.f6559d = true;
        this.f6560e = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r3 == null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x000a
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r3
        L_0x000a:
            r0 = 1
            r2.f6563h = r0     // Catch:{ all -> 0x0020 }
            r2.notifyAll()     // Catch:{ all -> 0x0020 }
            r1 = 0
            if (r3 == 0) goto L_0x0018
            com.bumptech.glide.e.d r3 = r2.f6562g     // Catch:{ all -> 0x0020 }
            r2.f6562g = r1     // Catch:{ all -> 0x0020 }
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x001f
            r3.b()
        L_0x001f:
            return r0
        L_0x0020:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.f.cancel(boolean):boolean");
    }

    public final synchronized boolean isCancelled() {
        return this.f6563h;
    }

    public final synchronized boolean isDone() {
        return this.f6563h || this.f6564i || this.j;
    }

    public final R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public final R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    public final void a(i iVar) {
        iVar.a(this.f6557b, this.f6558c);
    }

    public final synchronized void a(d dVar) {
        this.f6562g = dVar;
    }

    public final synchronized d d() {
        return this.f6562g;
    }

    public final synchronized void c(Drawable drawable) {
    }

    public final synchronized void a(R r, com.bumptech.glide.e.b.f<? super R> fVar) {
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f6559d && !isDone()) {
            k.b();
        }
        if (this.f6563h) {
            throw new CancellationException();
        } else if (this.j) {
            throw new ExecutionException(this.k);
        } else if (this.f6564i) {
            return this.f6561f;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    wait(longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.j) {
                throw new ExecutionException(this.k);
            } else if (this.f6563h) {
                throw new CancellationException();
            } else if (this.f6564i) {
                return this.f6561f;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public final synchronized boolean onLoadFailed(q qVar, Object obj, j<R> jVar, boolean z) {
        this.j = true;
        this.k = qVar;
        notifyAll();
        return false;
    }

    public final synchronized boolean onResourceReady(R r, Object obj, j<R> jVar, com.bumptech.glide.load.a aVar, boolean z) {
        this.f6564i = true;
        this.f6561f = r;
        notifyAll();
        return false;
    }

    static class a {
        a() {
        }
    }
}
