package com.alipay.mobile.rome.syncsdk.service.a;

import com.alipay.mobile.rome.syncsdk.a.b;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15124a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15125b;

    public e(c cVar) {
        this.f15125b = cVar;
    }

    public void run() {
        h.a(f15124a, "HeartBeatTask: run: ");
        if (!this.f15125b.q()) {
            h.c(f15124a, "HeartBeatTask: run: [ connection isDeviceBined=false ]");
            return;
        }
        h.b(f15124a, "sendHeartBeat: ");
        a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15125b.m());
        a2.a(3);
        a2.b(0);
        a2.a("");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f15125b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.h.a().a(currentTimeMillis, b.a());
        } catch (Exception e2) {
            String str = f15124a;
            h.d(str, "sendHeartBeat: [ Exception=" + e2 + " ]");
        }
    }
}
