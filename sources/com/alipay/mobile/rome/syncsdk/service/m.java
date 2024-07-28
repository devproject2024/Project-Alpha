package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.a.c;
import com.alipay.mobile.rome.syncsdk.e.h;
import java.util.concurrent.ScheduledFuture;

final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f15152a;

    /* renamed from: b  reason: collision with root package name */
    private int f15153b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f15154c;

    /* renamed from: d  reason: collision with root package name */
    private String f15155d;

    public m(h hVar, String str, long j, int i2) {
        this.f15152a = hVar;
        this.f15155d = str;
        this.f15154c = j;
        this.f15153b = i2;
    }

    public final void run() {
        long j;
        String d2 = h.f15141a;
        h.b(d2, "ReplyCheckTask: [ type=" + this.f15155d + " ][ sendTimeMillis=" + this.f15154c + " ][ delay=" + this.f15153b + " ]");
        c b2 = LongLinkService.b();
        if (b2 == null) {
            h.d(h.f15141a, "ReplyCheckTask: [ connManager=null ]");
            return;
        }
        if ("typeHeartBeat".equals(this.f15155d)) {
            j = b2.n();
            synchronized (this.f15152a) {
                ScheduledFuture unused = this.f15152a.f15145e = null;
            }
        } else if ("typeInit".equals(this.f15155d)) {
            j = b2.o();
            synchronized (this.f15152a) {
                ScheduledFuture unused2 = this.f15152a.f15146f = null;
            }
        } else {
            String d3 = h.f15141a;
            h.d(d3, "ReplyCheckTask: [ unknown type ][ type=" + this.f15155d + " ]");
            return;
        }
        if (this.f15154c > j) {
            String d4 = h.f15141a;
            h.d(d4, "ReplyCheckTask: Reply check Timeout[ type=" + this.f15155d + " ][ sendTimeMillis=" + this.f15154c + " ][ lastTime=" + j + " ]");
            c.c();
            b2.f();
        }
    }
}
