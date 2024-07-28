package com.google.android.exoplayer2;

import android.os.Handler;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    final b f31095a;

    /* renamed from: b  reason: collision with root package name */
    final ah f31096b;

    /* renamed from: c  reason: collision with root package name */
    int f31097c;

    /* renamed from: d  reason: collision with root package name */
    Object f31098d;

    /* renamed from: e  reason: collision with root package name */
    Handler f31099e;

    /* renamed from: f  reason: collision with root package name */
    int f31100f;

    /* renamed from: g  reason: collision with root package name */
    long f31101g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    boolean f31102h = true;

    /* renamed from: i  reason: collision with root package name */
    private final a f31103i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    public interface a {
        void a(aa aaVar);
    }

    public interface b {
        void a(int i2, Object obj) throws i;
    }

    public aa(a aVar, b bVar, ah ahVar, int i2, Handler handler) {
        this.f31103i = aVar;
        this.f31095a = bVar;
        this.f31096b = ahVar;
        this.f31099e = handler;
        this.f31100f = i2;
    }

    public final aa a(int i2) {
        com.google.android.exoplayer2.g.a.b(!this.j);
        this.f31097c = i2;
        return this;
    }

    public final aa a(Object obj) {
        com.google.android.exoplayer2.g.a.b(!this.j);
        this.f31098d = obj;
        return this;
    }

    public final aa a() {
        com.google.android.exoplayer2.g.a.b(!this.j);
        if (this.f31101g == -9223372036854775807L) {
            com.google.android.exoplayer2.g.a.a(this.f31102h);
        }
        this.j = true;
        this.f31103i.a(this);
        return this;
    }

    public final synchronized boolean b() {
        return this.m;
    }

    public final synchronized boolean c() throws InterruptedException {
        com.google.android.exoplayer2.g.a.b(this.j);
        com.google.android.exoplayer2.g.a.b(this.f31099e.getLooper().getThread() != Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.k;
    }

    public final synchronized void a(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }
}
