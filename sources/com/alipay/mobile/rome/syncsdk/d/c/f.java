package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.a.b;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;

public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15042a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15043b;

    public f(c cVar) {
        this.f15043b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 3;
    }

    public final void a(a aVar) {
        h.a(f15042a, "processPacket: heartbeat ");
        this.f15043b.a(System.currentTimeMillis());
        if (aVar.b() == 0) {
            try {
                a a2 = com.alipay.mobile.rome.syncsdk.d.b.c.a(this.f15043b.m());
                a2.a(3);
                a2.b(1);
                a2.a("");
                this.f15043b.k().a(a2);
            } catch (Exception e2) {
                String str = f15042a;
                h.d(str, "processPacket: [ Exception=" + e2 + " ]");
            }
        }
        com.alipay.mobile.rome.syncsdk.service.h.a().b(b.c());
    }
}
