package com.bumptech.glide.e;

import com.bumptech.glide.e.e;

public final class b implements d, e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6534a;

    /* renamed from: b  reason: collision with root package name */
    private final e f6535b;

    /* renamed from: c  reason: collision with root package name */
    private volatile d f6536c;

    /* renamed from: d  reason: collision with root package name */
    private volatile d f6537d;

    /* renamed from: e  reason: collision with root package name */
    private e.a f6538e = e.a.CLEARED;

    /* renamed from: f  reason: collision with root package name */
    private e.a f6539f = e.a.CLEARED;

    public b(Object obj, e eVar) {
        this.f6534a = obj;
        this.f6535b = eVar;
    }

    public final void a(d dVar, d dVar2) {
        this.f6536c = dVar;
        this.f6537d = dVar2;
    }

    public final void a() {
        synchronized (this.f6534a) {
            if (this.f6538e != e.a.RUNNING) {
                this.f6538e = e.a.RUNNING;
                this.f6536c.a();
            }
        }
    }

    public final void b() {
        synchronized (this.f6534a) {
            this.f6538e = e.a.CLEARED;
            this.f6536c.b();
            if (this.f6539f != e.a.CLEARED) {
                this.f6539f = e.a.CLEARED;
                this.f6537d.b();
            }
        }
    }

    public final void c() {
        synchronized (this.f6534a) {
            if (this.f6538e == e.a.RUNNING) {
                this.f6538e = e.a.PAUSED;
                this.f6536c.c();
            }
            if (this.f6539f == e.a.RUNNING) {
                this.f6539f = e.a.PAUSED;
                this.f6537d.c();
            }
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f6534a) {
            if (this.f6538e != e.a.RUNNING) {
                if (this.f6539f != e.a.RUNNING) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f6534a) {
            if (this.f6538e != e.a.SUCCESS) {
                if (this.f6539f != e.a.SUCCESS) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final boolean f() {
        boolean z;
        synchronized (this.f6534a) {
            z = this.f6538e == e.a.CLEARED && this.f6539f == e.a.CLEARED;
        }
        return z;
    }

    public final boolean a(d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            if (!this.f6536c.a(bVar.f6536c) || !this.f6537d.a(bVar.f6537d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean b(d dVar) {
        boolean z;
        boolean z2;
        synchronized (this.f6534a) {
            z = false;
            if (this.f6535b != null) {
                if (!this.f6535b.b(this)) {
                    z2 = false;
                    if (z2 && g(dVar)) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    public final boolean c(d dVar) {
        boolean z;
        boolean z2;
        synchronized (this.f6534a) {
            z = false;
            if (this.f6535b != null) {
                if (!this.f6535b.c(this)) {
                    z2 = false;
                    if (z2 && g(dVar)) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    public final boolean d(d dVar) {
        boolean z;
        boolean z2;
        synchronized (this.f6534a) {
            z = false;
            if (this.f6535b != null) {
                if (!this.f6535b.d(this)) {
                    z2 = false;
                    if (z2 && g(dVar)) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    private boolean g(d dVar) {
        if (!dVar.equals(this.f6536c)) {
            return this.f6538e == e.a.FAILED && dVar.equals(this.f6537d);
        }
        return true;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f6534a) {
            if (!this.f6536c.g()) {
                if (!this.f6537d.g()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final void e(d dVar) {
        synchronized (this.f6534a) {
            if (dVar.equals(this.f6536c)) {
                this.f6538e = e.a.SUCCESS;
            } else if (dVar.equals(this.f6537d)) {
                this.f6539f = e.a.SUCCESS;
            }
            if (this.f6535b != null) {
                this.f6535b.e(this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(com.bumptech.glide.e.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6534a
            monitor-enter(r0)
            com.bumptech.glide.e.d r1 = r2.f6537d     // Catch:{ all -> 0x002f }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0020
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.FAILED     // Catch:{ all -> 0x002f }
            r2.f6538e = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.e.e$a r3 = r2.f6539f     // Catch:{ all -> 0x002f }
            com.bumptech.glide.e.e$a r1 = com.bumptech.glide.e.e.a.RUNNING     // Catch:{ all -> 0x002f }
            if (r3 == r1) goto L_0x001e
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.RUNNING     // Catch:{ all -> 0x002f }
            r2.f6539f = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.e.d r3 = r2.f6537d     // Catch:{ all -> 0x002f }
            r3.a()     // Catch:{ all -> 0x002f }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x0020:
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.FAILED     // Catch:{ all -> 0x002f }
            r2.f6539f = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.e.e r3 = r2.f6535b     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002d
            com.bumptech.glide.e.e r3 = r2.f6535b     // Catch:{ all -> 0x002f }
            r3.f(r2)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.b.f(com.bumptech.glide.e.d):void");
    }

    public final e h() {
        e h2;
        synchronized (this.f6534a) {
            h2 = this.f6535b != null ? this.f6535b.h() : this;
        }
        return h2;
    }
}
