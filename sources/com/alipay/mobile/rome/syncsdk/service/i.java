package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.e.h;
import java.util.concurrent.ScheduledFuture;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f15149a;

    private i(h hVar) {
        this.f15149a = hVar;
    }

    /* synthetic */ i(h hVar, byte b2) {
        this(hVar);
    }

    public final void run() {
        h.b(h.f15141a, "DelayedConnectTask: ");
        synchronized (this.f15149a) {
            ScheduledFuture unused = this.f15149a.f15147g = null;
        }
        c b2 = LongLinkService.b();
        if (b2 == null) {
            h.d(h.f15141a, "DelayedConnectTask: [ connManager=null ]");
        } else {
            b2.c();
        }
    }
}
