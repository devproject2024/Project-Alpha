package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.alipay.mobile.h5container.api.H5Param;
import java.io.IOException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f6025a = c.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f6026b = c.a.a("fc", H5Param.SAFEPAY_CONTEXT, "sw", "t");

    public static k a(c cVar, d dVar) throws IOException {
        cVar.c();
        k kVar = null;
        while (cVar.e()) {
            if (cVar.a(f6025a) != 0) {
                cVar.h();
                cVar.m();
            } else {
                cVar.c();
                a aVar = null;
                a aVar2 = null;
                com.airbnb.lottie.c.a.b bVar = null;
                com.airbnb.lottie.c.a.b bVar2 = null;
                while (cVar.e()) {
                    int a2 = cVar.a(f6026b);
                    if (a2 == 0) {
                        aVar = d.d(cVar, dVar);
                    } else if (a2 == 1) {
                        aVar2 = d.d(cVar, dVar);
                    } else if (a2 == 2) {
                        bVar = d.a(cVar, dVar, true);
                    } else if (a2 != 3) {
                        cVar.h();
                        cVar.m();
                    } else {
                        bVar2 = d.a(cVar, dVar, true);
                    }
                }
                cVar.d();
                kVar = new k(aVar, aVar2, bVar, bVar2);
            }
        }
        cVar.d();
        return kVar == null ? new k((a) null, (a) null, (com.airbnb.lottie.c.a.b) null, (com.airbnb.lottie.c.a.b) null) : kVar;
    }
}
