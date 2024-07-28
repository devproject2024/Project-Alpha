package com.alipay.mobile.rome.syncsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.d.b.b;
import com.alipay.mobile.rome.syncsdk.d.d.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.j;
import com.alipay.mobile.rome.syncsdk.service.a.d;
import com.alipay.mobile.rome.syncsdk.service.a.e;
import com.alipay.mobile.rome.syncsdk.service.a.f;
import com.alipay.mobile.rome.syncsdk.service.a.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15130b = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public volatile Context f15131a;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f15132c;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f15133d;

    /* renamed from: e  reason: collision with root package name */
    private volatile long f15134e;

    /* renamed from: f  reason: collision with root package name */
    private volatile a f15135f = new a();

    /* renamed from: g  reason: collision with root package name */
    private volatile int f15136g = b.f15028b;

    /* renamed from: h  reason: collision with root package name */
    private volatile g f15137h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ExecutorService f15138i;
    private volatile Future<?> j;
    private volatile Future<?> k;
    private volatile Future<?> l;
    private volatile Future<?> m;
    private volatile Future<?> n;
    private volatile Future<?> o;
    private f p;

    public c(Context context) {
        h.b(f15130b, "ConnManager");
        this.f15131a = context;
    }

    private boolean z() {
        h.a(f15130b, "checkCanConnect");
        if (TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().h()) || TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().i())) {
            h.c(f15130b, "checkCanConnect: [ isForceStopped=false host or port is null] ");
            return false;
        } else if (com.alipay.mobile.rome.syncsdk.a.c.a()) {
            h.c(f15130b, "checkCanConnect: [ isForceStopped=false ] ");
            return false;
        } else if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
            h.c(f15130b, "checkCanConnect: [ isReconnEnable=false ] ");
            return false;
        } else if (j.b(this.f15131a)) {
            return true;
        } else {
            h.c(f15130b, "checkCanConnect: [ isNetAvailable=false ] ");
            return false;
        }
    }

    public final synchronized void a() {
        this.f15135f.a();
    }

    public final synchronized b b() {
        return this.f15135f.b();
    }

    public final synchronized void c() {
        h.a(f15130b, "connect: ");
        if (z()) {
            if (this.j == null || this.j.isDone() || (this.k != null && !this.k.isDone())) {
                this.j = a((Runnable) new com.alipay.mobile.rome.syncsdk.service.a.c(this));
                return;
            }
            String str = f15130b;
            h.c(str, "connect: [ already has a connect task ][ futureConnect=" + this.j + " ]");
        }
    }

    public final synchronized void d() {
        h.a(f15130b, "connectOnRunned: ");
        this.j = null;
    }

    public final synchronized void e() {
        h.a(f15130b, "disconnect: ");
        h.a().c();
        if (this.j != null && !this.j.isDone()) {
            this.j.cancel(false);
        }
        if (this.l != null && !this.l.isDone()) {
            this.l.cancel(false);
        }
        if (this.m != null && !this.m.isDone()) {
            this.m.cancel(false);
        }
        if (this.n != null && !this.n.isDone()) {
            this.n.cancel(false);
        }
        if (this.o != null && !this.o.isDone()) {
            this.o.cancel(false);
        }
        if (this.k == null || this.k.isDone()) {
            a((Runnable) new com.alipay.mobile.rome.syncsdk.service.a.b(this));
            this.k = a((Runnable) new d(this));
            return;
        }
        String str = f15130b;
        h.c(str, "disconnect: [ already has a disconnect task ][ futureDisconnect=" + this.k + " ]");
    }

    public final synchronized void f() {
        h.a(f15130b, "reconnect: ");
        e();
        if (z()) {
            this.j = a((Runnable) new com.alipay.mobile.rome.syncsdk.service.a.c(this));
        }
    }

    public final synchronized void g() {
        h.a(f15130b, "sendRegisterPacket: ");
        if (p()) {
            this.l = a((Runnable) new f(this));
        }
    }

    public final synchronized void h() {
        h.a(f15130b, "sendHeartBeatPacket: ");
        if (p()) {
            if (h.a().b()) {
                h.c(f15130b, "sendHeartBeatPacket: [ wait heartbeat reply ] ");
                return;
            }
            if (this.n != null && !this.n.isDone()) {
                this.n.cancel(false);
            }
            this.n = a((Runnable) new e(this));
        }
    }

    public final synchronized void i() {
        h.a(f15130b, "sendBindUerPacket");
        if (!p()) {
            if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                com.alipay.mobile.rome.syncsdk.a.c.e();
            }
            if (z()) {
                c();
                return;
            }
            return;
        }
        this.m = a((Runnable) new com.alipay.mobile.rome.syncsdk.service.a.a(this));
    }

    public final synchronized void j() {
        h.a(f15130b, "sendUnBindUerPacket");
        if (!p()) {
            if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                com.alipay.mobile.rome.syncsdk.a.c.e();
            }
            if (z()) {
                c();
                return;
            }
            return;
        }
        this.o = a((Runnable) new g(this));
    }

    public final synchronized a k() {
        return this.f15132c;
    }

    public final synchronized void a(a aVar) {
        h.a(f15130b, "setConnection");
        this.f15132c = aVar;
    }

    public final synchronized g l() {
        return this.f15137h;
    }

    public final synchronized int m() {
        return this.f15136g;
    }

    public final synchronized long n() {
        return this.f15133d;
    }

    public final synchronized void a(long j2) {
        this.f15133d = j2;
    }

    public final synchronized long o() {
        return this.f15134e;
    }

    public final synchronized void b(long j2) {
        this.f15134e = j2;
    }

    public final synchronized boolean p() {
        boolean i2;
        i2 = this.f15135f.i();
        String str = f15130b;
        h.a(str, "isConnected [ " + i2 + " ]");
        return i2;
    }

    public final synchronized boolean q() {
        boolean j2;
        j2 = this.f15135f.j();
        String str = f15130b;
        h.a(str, "isDeviceBinded [ " + j2 + " ]");
        return j2;
    }

    public final synchronized boolean r() {
        boolean k2;
        k2 = this.f15135f.k();
        String str = f15130b;
        h.a(str, "isUserBinded [ " + k2 + " ]");
        return k2;
    }

    public final synchronized void s() {
        try {
            this.f15135f.c();
            if (this.f15135f.k()) {
                com.alipay.mobile.rome.syncsdk.a.c.a("");
            }
        } catch (Exception e2) {
            String str = f15130b;
            h.d(str, "onRecvRegisterReply: [ Exception=" + e2 + " ]");
            h.a().c();
            e();
            h.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
        }
    }

    public final synchronized void c(long j2) {
        this.f15135f.d();
        h.b(f15130b, "[onConnecting] Notify connected event.");
        A().a(new com.alipay.mobile.rome.longlinkservice.a(com.alipay.mobile.rome.longlinkservice.b.Connected, Long.valueOf(j2)));
    }

    public final synchronized void t() {
        h.b(f15130b, "[onConnecting] Notify connecting event.");
        A().a(new com.alipay.mobile.rome.longlinkservice.a(com.alipay.mobile.rome.longlinkservice.b.Connecting));
    }

    public final synchronized void a(String str) {
        h.b(f15130b, "[onConnectFailed] Notify connect failed event.");
        A().a(new com.alipay.mobile.rome.longlinkservice.a(com.alipay.mobile.rome.longlinkservice.b.ConnectFailed, str));
    }

    public final synchronized void u() {
        h.b(f15130b, "[onConnecting] Notify disconnected event.");
        A().a(new com.alipay.mobile.rome.longlinkservice.a(com.alipay.mobile.rome.longlinkservice.b.Disconnected));
    }

    public final synchronized void v() {
        this.f15135f.e();
    }

    public final synchronized void w() {
        this.f15135f.f();
    }

    public final synchronized void x() {
        this.f15135f.g();
    }

    public final synchronized void y() {
        this.f15135f.h();
    }

    private f A() {
        f fVar = this.p;
        if (fVar != null) {
            return fVar;
        }
        synchronized (this) {
            if (this.p != null) {
                f fVar2 = this.p;
                return fVar2;
            }
            f fVar3 = new f();
            this.p = fVar3;
            return fVar3;
        }
    }

    private Future<?> a(Runnable runnable) {
        if (this.f15138i == null || this.f15138i.isTerminated() || this.f15138i.isShutdown()) {
            this.f15138i = Executors.newSingleThreadExecutor(new d(this));
        }
        return this.f15138i.submit(runnable);
    }
}
