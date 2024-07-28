package com.alipay.mobile.rome.syncsdk.d.c;

import android.text.TextUtils;
import com.alipay.a.a.a.b;
import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.k;
import com.alipay.mobile.rome.syncsdk.service.c;
import com.alipay.mobile.rome.syncsdk.service.g;

public class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15050a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f15051b;

    public j(c cVar) {
        this.f15051b = cVar;
    }

    public final boolean b(a aVar) {
        return aVar != null && aVar.a() == 0;
    }

    public final void a(a aVar) {
        String str;
        this.f15051b.a(System.currentTimeMillis());
        byte[] e2 = aVar.e();
        if (e2 == null || e2.length <= 0) {
            str = "";
        } else {
            b bVar = (b) k.a(e2, b.class);
            if (bVar == null) {
                h.d(f15050a, "processPacket parsePBObject exception, pb is null.");
                return;
            }
            if (bVar.f14679f != null && bVar.f14679f.intValue() > 0) {
                com.alipay.mobile.rome.syncsdk.a.b.c(bVar.f14679f.intValue());
            }
            if (bVar.f14680g != null && bVar.f14680g.intValue() > 0) {
                com.alipay.mobile.rome.syncsdk.a.b.a(bVar.f14680g.intValue());
            }
            String str2 = bVar.f14681h;
            if (!TextUtils.isEmpty(str2)) {
                com.alipay.mobile.rome.syncsdk.a.a.a().a(this.f15051b.f15131a, str2);
            }
            str = bVar.f14677d;
            if (bVar.f14678e.intValue() >= 10 && bVar.f14678e.intValue() <= 600) {
                String str3 = f15050a;
                h.c(str3, "ImplRegister processPacket: [ flow control =" + bVar.f14678e + " ]");
                long intValue = (long) (bVar.f14678e.intValue() * 1000);
                this.f15051b.e();
                com.alipay.mobile.rome.syncsdk.service.h.a().b(intValue);
                return;
            }
        }
        String str4 = f15050a;
        h.a(str4, "processPacket： [ action=" + str + " ][ replyTimeout=" + com.alipay.mobile.rome.syncsdk.a.b.a() + " ][ keepLiveTime=" + com.alipay.mobile.rome.syncsdk.a.b.c() + " ]");
        this.f15051b.s();
        g l = this.f15051b.l();
        if (l == null) {
            h.d(f15050a, "processPacket: [ longLinkNotifer=null ]");
            return;
        }
        this.f15051b.b(System.currentTimeMillis());
        String str5 = com.alipay.mobile.rome.syncsdk.a.a.a().f14988a;
        String f2 = com.alipay.mobile.rome.syncsdk.a.a.a().f();
        int i2 = k.f15052a[this.f15051b.b().ordinal()];
        if (i2 == 1) {
            if ("unbind".equals(str)) {
                h.a(f15050a, "processPacket: [ unbind don't need send device register 1001 ]");
            } else {
                l.c();
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(f2)) {
                this.f15051b.i();
            }
        } else if (i2 == 2) {
            l.b();
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(f2)) {
                this.f15051b.j();
            }
        } else if (i2 == 3) {
            l.d();
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(f2)) {
                this.f15051b.j();
            }
        }
        com.alipay.mobile.rome.syncsdk.a.c.d();
        if (com.alipay.mobile.rome.syncsdk.d.a.a().equals("https")) {
            com.alipay.mobile.rome.syncsdk.service.h.a().b(com.alipay.mobile.rome.syncsdk.a.b.c());
        }
    }
}
