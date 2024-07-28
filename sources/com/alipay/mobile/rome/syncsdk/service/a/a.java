package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.e.f;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.k;
import com.alipay.mobile.rome.syncsdk.service.b;
import com.alipay.mobile.rome.syncsdk.service.c;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15116a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15117b;

    public a(c cVar) {
        this.f15117b = cVar;
    }

    public void run() {
        h.a(f15116a, "BindUserTask: run ");
        if (b.DEVICE_BINDED != this.f15117b.b()) {
            h.c(f15116a, "BindUserTask: run: [ not device binded state ]");
            return;
        }
        h.b(f15116a, "sendBindUserPacket: ");
        com.alipay.mobile.rome.syncsdk.d.b.a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15117b.m());
        a2.a(0);
        a2.b(0);
        String str = com.alipay.mobile.rome.syncsdk.a.a.a().f14988a;
        String f2 = com.alipay.mobile.rome.syncsdk.a.a.a().f();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f2)) {
            h.c(f15116a, "sendBindUserPacket: [ userId or sessionId is null ]");
            return;
        }
        a2.a(k.a(f.a(this.f15117b.f15131a, "bind")));
        try {
            if (b.DEVICE_BINDED != this.f15117b.b()) {
                h.c(f15116a, "BindUserTask: run: [ not device binded state ]");
                return;
            }
            this.f15117b.x();
            long currentTimeMillis = System.currentTimeMillis();
            this.f15117b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.h.a().b(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Exception e2) {
            String str2 = f15116a;
            h.d(str2, "sendBindUserPacket: [ Exception=" + e2 + " ]");
        }
    }
}
