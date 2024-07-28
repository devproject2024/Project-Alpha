package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15044a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15045b;

    public g(c cVar) {
        this.f15045b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 8;
    }

    public final void a(a aVar) {
        h.a(f15044a, "ImplLinkSync processPacket");
        byte[] e2 = aVar.e();
        if (e2 == null || e2.length <= 0) {
            h.d(f15044a, "processPacket: [ packet dataStr=null ]");
        } else {
            this.f15045b.l().a();
        }
    }
}
