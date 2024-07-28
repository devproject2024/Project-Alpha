package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.e.h;
import java.util.concurrent.ScheduledFuture;

final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f15151a;

    private k(h hVar) {
        this.f15151a = hVar;
    }

    /* synthetic */ k(h hVar, byte b2) {
        this(hVar);
    }

    public final void run() {
        h.b(h.f15141a, "HeartBeatTask: ");
        synchronized (this.f15151a) {
            ScheduledFuture unused = this.f15151a.f15144d = null;
        }
        c b2 = LongLinkService.b();
        if (b2 == null) {
            h.d(h.f15141a, "HeartBeatTask: [ connManager=null ]");
        } else {
            b2.h();
        }
    }
}
