package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.a.c;
import com.alipay.mobile.rome.syncsdk.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f15150a;

    private j(h hVar) {
        this.f15150a = hVar;
    }

    /* synthetic */ j(h hVar, byte b2) {
        this(hVar);
    }

    public final void run() {
        h.b(h.f15141a, "FlowControlTask: [ flow control is over ]");
        c.a(false);
        a.a().b(LongLinkService.a().e(), "flow_control");
        c b2 = LongLinkService.b();
        if (b2 == null) {
            h.d(h.f15141a, "FlowControlTask: [ connManager=null ]");
        } else {
            b2.c();
        }
    }
}
