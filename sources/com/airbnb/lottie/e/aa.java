package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.k;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class aa {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f6015a = c.a.a("nm", "c", "o", "tr", "hd");

    static k a(c cVar, d dVar) throws IOException {
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f6015a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                bVar = d.a(cVar, dVar, false);
            } else if (a2 == 2) {
                bVar2 = d.a(cVar, dVar, false);
            } else if (a2 == 3) {
                lVar = c.a(cVar, dVar);
            } else if (a2 != 4) {
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new k(str, bVar, bVar2, lVar, z);
    }
}
