package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.k;
import com.alipay.mobile.rome.syncsdk.service.b;
import com.alipay.mobile.rome.syncsdk.service.c;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15126a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15127b;

    public f(c cVar) {
        this.f15127b = cVar;
    }

    public void run() {
        h.a(f15126a, "RegisterTask: run ");
        if (b.CONNECTED != this.f15127b.b()) {
            h.c(f15126a, "RegisterTask: run: [ not connected state ]");
            return;
        }
        h.b(f15126a, "sendRegisterPacket");
        a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15127b.m());
        boolean z = false;
        a2.a(0);
        a2.b(0);
        try {
            String g2 = com.alipay.mobile.rome.syncsdk.a.c.g();
            if (TextUtils.isEmpty(g2)) {
                g2 = "reconn";
            }
            a2.a(k.a(com.alipay.mobile.rome.syncsdk.e.f.a(this.f15127b.f15131a, g2)));
            if (b.CONNECTED != this.f15127b.b()) {
                h.c(f15126a, "RegisterTask: run: [ not connected state ]");
                return;
            }
            if (!TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f14988a) && !TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f())) {
                z = true;
            }
            if (z) {
                this.f15127b.v();
            } else {
                this.f15127b.w();
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f15127b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.h.a().b(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Throwable th) {
            String str = f15126a;
            h.d(str, "sendRegisterPacket: [ Exception=" + th + " ]" + th.getMessage());
            com.alipay.mobile.rome.syncsdk.service.h.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
        }
    }
}
