package com.airbnb.lottie.e;

import android.graphics.Path;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class ad {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f6019a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static m a(c cVar, d dVar) throws IOException {
        String str = null;
        a aVar = null;
        com.airbnb.lottie.c.a.d dVar2 = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (cVar.e()) {
            int a2 = cVar.a(f6019a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                aVar = d.d(cVar, dVar);
            } else if (a2 == 2) {
                dVar2 = d.a(cVar, dVar);
            } else if (a2 == 3) {
                z = cVar.j();
            } else if (a2 == 4) {
                i2 = cVar.l();
            } else if (a2 != 5) {
                cVar.h();
                cVar.m();
            } else {
                z2 = cVar.j();
            }
        }
        return new m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2, z2);
    }
}
