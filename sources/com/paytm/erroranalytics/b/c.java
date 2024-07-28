package com.paytm.erroranalytics.b;

import com.paytm.erroranalytics.c.a.b;
import com.paytm.erroranalytics.c.b.a;

public final class c {
    public static synchronized a a(b bVar, com.paytm.erroranalytics.c.a aVar, String str) {
        a aVar2;
        String str2;
        String str3;
        synchronized (c.class) {
            aVar2 = new a();
            if (bVar.f42743c == null) {
                str2 = aVar.f42710b;
            } else {
                str2 = bVar.f42743c;
            }
            aVar2.f42765d = str2;
            if (bVar.f42742b == null) {
                str3 = aVar.f42709a;
            } else {
                str3 = bVar.f42742b;
            }
            aVar2.f42764c = str3;
            aVar2.j = bVar.f42745e == 0 ? 5 : bVar.f42745e;
            aVar2.k = bVar.f42746f;
            aVar2.l = bVar.f42747g;
            aVar2.f42763b = bVar.f42741a;
            aVar2.j = bVar.f42745e;
            aVar2.f42766e = a.a(bVar.f42744d);
            if (bVar.f42748h != null) {
                str = bVar.f42748h;
            }
            aVar2.m = str;
        }
        return aVar2;
    }
}
