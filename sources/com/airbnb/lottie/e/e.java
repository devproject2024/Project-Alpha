package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.a;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f6029a = c.a.a("nm", "p", "s", "hd", "d");

    static a a(c cVar, d dVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        boolean z2 = false;
        while (cVar.e()) {
            int a2 = cVar.a(f6029a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                mVar = a.b(cVar, dVar);
            } else if (a2 == 2) {
                fVar = d.b(cVar, dVar);
            } else if (a2 == 3) {
                z2 = cVar.j();
            } else if (a2 != 4) {
                cVar.h();
                cVar.m();
            } else {
                z = cVar.l() == 3;
            }
        }
        return new a(str, mVar, fVar, z, z2);
    }
}
