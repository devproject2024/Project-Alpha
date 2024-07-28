package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15040a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15041b;

    public e(c cVar) {
        this.f15041b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 1;
    }

    public final void a(a aVar) {
        h.a(f15040a, "processPacket: close ");
        this.f15041b.e();
    }
}
