package com.alipay.mobile.rome.syncsdk.service.a;

import com.alipay.mobile.rome.syncsdk.a.b;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.f;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.k;
import com.alipay.mobile.rome.syncsdk.service.c;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15128a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15129b;

    public g(c cVar) {
        this.f15129b = cVar;
    }

    public void run() {
        h.a(f15128a, "UnBindUserTask: run ");
        if (!this.f15129b.r()) {
            h.c(f15128a, "UnBindUserTask: run: [ user not binded ]");
            return;
        }
        h.b(f15128a, "sendUnbindUserPacket: ");
        a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15129b.m());
        a2.a(0);
        a2.b(0);
        try {
            a2.a(k.a(f.a(this.f15129b.f15131a, "unbind")));
            this.f15129b.y();
            long currentTimeMillis = System.currentTimeMillis();
            this.f15129b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.h.a().b(currentTimeMillis, b.a());
        } catch (Exception e2) {
            String str = f15128a;
            h.d(str, "sendUnbindUserPacket: [ Exception=" + e2 + " ]");
        }
    }
}
