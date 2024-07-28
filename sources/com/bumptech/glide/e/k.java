package com.bumptech.glide.e;

import com.bumptech.glide.e.e;

public final class k implements d, e {

    /* renamed from: a  reason: collision with root package name */
    private final e f6574a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f6575b;

    /* renamed from: c  reason: collision with root package name */
    private volatile d f6576c;

    /* renamed from: d  reason: collision with root package name */
    private volatile d f6577d;

    /* renamed from: e  reason: collision with root package name */
    private e.a f6578e = e.a.CLEARED;

    /* renamed from: f  reason: collision with root package name */
    private e.a f6579f = e.a.CLEARED;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6580g;

    public k(Object obj, e eVar) {
        this.f6575b = obj;
        this.f6574a = eVar;
    }

    public final void a(d dVar, d dVar2) {
        this.f6576c = dVar;
        this.f6577d = dVar2;
    }

    public final boolean b(d dVar) {
        boolean z;
        boolean z2;
        synchronized (this.f6575b) {
            z = false;
            if (this.f6574a != null) {
                if (!this.f6574a.b(this)) {
                    z2 = false;
                    if (z2 && (dVar.equals(this.f6576c) || this.f6578e != e.a.SUCCESS)) {
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
        synchronized (this.f6575b) {
            z = false;
            if (this.f6574a != null) {
                if (!this.f6574a.c(this)) {
                    z2 = false;
                    if (z2 && dVar.equals(this.f6576c) && !g()) {
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
        synchronized (this.f6575b) {
            z = false;
            if (this.f6574a != null) {
                if (!this.f6574a.d(this)) {
                    z2 = false;
                    if (z2 && dVar.equals(this.f6576c) && this.f6578e != e.a.PAUSED) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f6575b) {
            if (!this.f6577d.g()) {
                if (!this.f6576c.g()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(com.bumptech.glide.e.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6575b
            monitor-enter(r0)
            com.bumptech.glide.e.d r1 = r2.f6577d     // Catch:{ all -> 0x002d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.SUCCESS     // Catch:{ all -> 0x002d }
            r2.f6579f = r3     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0011:
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.SUCCESS     // Catch:{ all -> 0x002d }
            r2.f6578e = r3     // Catch:{ all -> 0x002d }
            com.bumptech.glide.e.e r3 = r2.f6574a     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x001e
            com.bumptech.glide.e.e r3 = r2.f6574a     // Catch:{ all -> 0x002d }
            r3.e(r2)     // Catch:{ all -> 0x002d }
        L_0x001e:
            com.bumptech.glide.e.e$a r3 = r2.f6579f     // Catch:{ all -> 0x002d }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002b
            com.bumptech.glide.e.d r3 = r2.f6577d     // Catch:{ all -> 0x002d }
            r3.b()     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.k.e(com.bumptech.glide.e.d):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(com.bumptech.glide.e.d r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6575b
            monitor-enter(r0)
            com.bumptech.glide.e.d r1 = r2.f6576c     // Catch:{ all -> 0x0020 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.FAILED     // Catch:{ all -> 0x0020 }
            r2.f6579f = r3     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0011:
            com.bumptech.glide.e.e$a r3 = com.bumptech.glide.e.e.a.FAILED     // Catch:{ all -> 0x0020 }
            r2.f6578e = r3     // Catch:{ all -> 0x0020 }
            com.bumptech.glide.e.e r3 = r2.f6574a     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x001e
            com.bumptech.glide.e.e r3 = r2.f6574a     // Catch:{ all -> 0x0020 }
            r3.f(r2)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.k.f(com.bumptech.glide.e.d):void");
    }

    public final e h() {
        e h2;
        synchronized (this.f6575b) {
            h2 = this.f6574a != null ? this.f6574a.h() : this;
        }
        return h2;
    }

    public final void a() {
        synchronized (this.f6575b) {
            this.f6580g = true;
            try {
                if (!(this.f6578e == e.a.SUCCESS || this.f6579f == e.a.RUNNING)) {
                    this.f6579f = e.a.RUNNING;
                    this.f6577d.a();
                }
                if (this.f6580g && this.f6578e != e.a.RUNNING) {
                    this.f6578e = e.a.RUNNING;
                    this.f6576c.a();
                }
            } finally {
                this.f6580g = false;
            }
        }
    }

    public final void b() {
        synchronized (this.f6575b) {
            this.f6580g = false;
            this.f6578e = e.a.CLEARED;
            this.f6579f = e.a.CLEARED;
            this.f6577d.b();
            this.f6576c.b();
        }
    }

    public final void c() {
        synchronized (this.f6575b) {
            if (!this.f6579f.isComplete()) {
                this.f6579f = e.a.PAUSED;
                this.f6577d.c();
            }
            if (!this.f6578e.isComplete()) {
                this.f6578e = e.a.PAUSED;
                this.f6576c.c();
            }
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f6575b) {
            z = this.f6578e == e.a.RUNNING;
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f6575b) {
            z = this.f6578e == e.a.SUCCESS;
        }
        return z;
    }

    public final boolean f() {
        boolean z;
        synchronized (this.f6575b) {
            z = this.f6578e == e.a.CLEARED;
        }
        return z;
    }

    public final boolean a(d dVar) {
        if (dVar instanceof k) {
            k kVar = (k) dVar;
            if (this.f6576c != null ? this.f6576c.a(kVar.f6576c) : kVar.f6576c == null) {
                if (this.f6577d == null) {
                    if (kVar.f6577d == null) {
                        return true;
                    }
                } else if (this.f6577d.a(kVar.f6577d)) {
                    return true;
                }
            }
        }
        return false;
    }
}
