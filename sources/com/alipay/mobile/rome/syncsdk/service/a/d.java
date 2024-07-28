package com.alipay.mobile.rome.syncsdk.service.a;

import com.alipay.mobile.rome.syncsdk.d.d.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15122a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15123b;

    public d(c cVar) {
        this.f15123b = cVar;
    }

    public void run() {
        h.a(f15122a, "DisconnectTask: run: ");
        h.b(f15122a, "disconnect: [ DisconnectTask ]");
        this.f15123b.a();
        a k = this.f15123b.k();
        this.f15123b.a((a) null);
        if (k != null) {
            k.d();
        }
    }
}
