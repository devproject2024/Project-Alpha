package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class af {

    /* renamed from: a  reason: collision with root package name */
    static c.a f6021a = c.a.a("nm", "ind", "ks", "hd");

    static o a(c cVar, d dVar) throws IOException {
        int i2 = 0;
        String str = null;
        h hVar = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f6021a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                i2 = cVar.l();
            } else if (a2 == 2) {
                hVar = d.c(cVar, dVar);
            } else if (a2 != 3) {
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new o(str, i2, hVar, z);
    }
}
