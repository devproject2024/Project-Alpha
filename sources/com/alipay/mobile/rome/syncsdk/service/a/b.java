package com.alipay.mobile.rome.syncsdk.service.a;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15118a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15119b;

    public b(c cVar) {
        this.f15119b = cVar;
    }

    public void run() {
        h.a(f15118a, "CloseConnTask: run: ");
        if (!this.f15119b.p()) {
            h.c(f15118a, "sendClosePacket: [ isConnected=false ]");
            return;
        }
        h.b(f15118a, "sendClosePacket: ");
        a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15119b.m());
        a2.a(1);
        a2.b(0);
        a2.a("");
        try {
            this.f15119b.k().a(a2);
        } catch (Exception e2) {
            String str = f15118a;
            h.d(str, "sendClosePacket: [ Exception=" + e2 + " ]");
        }
    }
}
