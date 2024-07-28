package com.alipay.mobile.rome.syncsdk.service;

import android.content.Context;
import com.alipay.mobile.rome.syncsdk.a.c;
import com.alipay.mobile.rome.syncsdk.b.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15141a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledExecutorService f15142b = Executors.newSingleThreadScheduledExecutor(new l());

    /* renamed from: c  reason: collision with root package name */
    private static volatile h f15143c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile ScheduledFuture<?> f15144d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile ScheduledFuture<?> f15145e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile ScheduledFuture<?> f15146f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile ScheduledFuture<?> f15147g;

    /* renamed from: h  reason: collision with root package name */
    private volatile ScheduledFuture<?> f15148h;

    private h() {
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f15143c == null) {
                f15143c = new h();
            }
            hVar = f15143c;
        }
        return hVar;
    }

    public final synchronized void a(int i2) {
        String str = f15141a;
        com.alipay.mobile.rome.syncsdk.e.h.b(str, "startDelayedConnectTimer [ delay=" + i2 + " ]");
        i();
        if (this.f15147g == null || this.f15147g.isDone() || this.f15147g.isCancelled()) {
            this.f15147g = f15142b.schedule(new i(this, (byte) 0), (long) i2, TimeUnit.SECONDS);
            return;
        }
        String str2 = f15141a;
        com.alipay.mobile.rome.syncsdk.e.h.c(str2, "already have a DelayedConnectTimer: [ delayedConnectFuture=" + this.f15147g + " ]");
    }

    private synchronized void e() {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "stopDelayedConnectTimer: ");
        if (this.f15147g != null && !this.f15147g.isDone()) {
            this.f15147g.cancel(true);
        }
    }

    public final synchronized void b(int i2) {
        String str = f15141a;
        com.alipay.mobile.rome.syncsdk.e.h.b(str, "startHeartBeatTimer [ delay=" + i2 + " ]");
        i();
        f();
        this.f15144d = f15142b.schedule(new k(this, (byte) 0), (long) i2, TimeUnit.SECONDS);
    }

    private synchronized void f() {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "stopHeartBeatTimer: ");
        if (this.f15144d != null && !this.f15144d.isDone()) {
            this.f15144d.cancel(true);
        }
    }

    public final synchronized void a(long j, int i2) {
        a("typeHeartBeat", j, i2);
    }

    private synchronized void g() {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "stopHeartBeatReplayCheckTimer: ");
        if (this.f15145e != null && !this.f15145e.isDone()) {
            this.f15145e.cancel(true);
        }
    }

    public final synchronized boolean b() {
        if (this.f15145e == null || this.f15145e.isDone()) {
            return false;
        }
        return true;
    }

    public final synchronized void b(long j, int i2) {
        a("typeInit", j, i2);
    }

    private synchronized void h() {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "stopInitReplayCheckTimer: ");
        if (this.f15146f != null && !this.f15146f.isDone()) {
            this.f15146f.cancel(true);
        }
    }

    private synchronized void a(String str, long j, int i2) {
        String str2 = f15141a;
        com.alipay.mobile.rome.syncsdk.e.h.b(str2, "startReplayCheckTimer: [ type=" + str + " ][ sendTimeMillis=" + j + " ][ delay=" + i2 + " ]");
        i();
        if ("typeHeartBeat".equals(str)) {
            g();
            this.f15145e = f15142b.schedule(new m(this, str, j, i2), (long) i2, TimeUnit.SECONDS);
        } else if ("typeInit".equals(str)) {
            h();
            this.f15146f = f15142b.schedule(new m(this, str, j, i2), (long) i2, TimeUnit.SECONDS);
        } else {
            com.alipay.mobile.rome.syncsdk.e.h.d(f15141a, "startReplayCheckTimer: [ unknown type ]");
        }
    }

    public final synchronized void c() {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "clearAllTimers: ");
        f();
        g();
        h();
        e();
        j();
    }

    private static synchronized void i() {
        synchronized (h.class) {
            if (f15142b == null || f15142b.isTerminated() || f15142b.isShutdown()) {
                com.alipay.mobile.rome.syncsdk.e.h.c(f15141a, "checkExecutorService: newSingleThreadScheduledExecutor ");
                f15142b = Executors.newSingleThreadScheduledExecutor(new l());
            }
        }
    }

    public final synchronized void a(long j) {
        com.alipay.mobile.rome.syncsdk.e.h.a(f15141a, "startFlowControlTimer: controlTime=".concat(String.valueOf(j)));
        c.a(true);
        j();
        this.f15148h = f15142b.schedule(new j(this, (byte) 0), j, TimeUnit.SECONDS);
    }

    public final synchronized void b(long j) {
        a a2 = a.a();
        Context e2 = LongLinkService.a().e();
        a2.a(e2, "flow_control", Long.toString(System.currentTimeMillis() + j) + AppConstants.COMMA + Long.toString(j));
        a(j);
    }

    private synchronized void j() {
        if (this.f15148h != null && !this.f15148h.isDone()) {
            this.f15148h.cancel(true);
        }
    }
}
