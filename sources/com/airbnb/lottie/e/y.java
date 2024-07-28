package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.i;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f6061a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    static i a(c cVar, d dVar) throws IOException {
        String str = null;
        i.a aVar = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        boolean z = false;
        while (cVar.e()) {
            switch (cVar.a(f6061a)) {
                case 0:
                    str = cVar.i();
                    break;
                case 1:
                    aVar = i.a.forValue(cVar.l());
                    break;
                case 2:
                    bVar = d.a(cVar, dVar, false);
                    break;
                case 3:
                    mVar = a.b(cVar, dVar);
                    break;
                case 4:
                    bVar2 = d.a(cVar, dVar, false);
                    break;
                case 5:
                    bVar4 = d.a(cVar, dVar, true);
                    break;
                case 6:
                    bVar6 = d.a(cVar, dVar, false);
                    break;
                case 7:
                    bVar3 = d.a(cVar, dVar, true);
                    break;
                case 8:
                    bVar5 = d.a(cVar, dVar, false);
                    break;
                case 9:
                    z = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
