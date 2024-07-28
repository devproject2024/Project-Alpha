package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.b.e;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.c.b.p;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;
import java.util.ArrayList;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f6041a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6042b = c.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f6043c = c.a.a("n", "v");

    static e a(c cVar, d dVar) throws IOException {
        com.airbnb.lottie.c.a.c cVar2;
        c cVar3 = cVar;
        d dVar2 = dVar;
        ArrayList arrayList = new ArrayList();
        String str = null;
        f fVar = null;
        com.airbnb.lottie.c.a.c cVar4 = null;
        com.airbnb.lottie.c.a.d dVar3 = null;
        com.airbnb.lottie.c.a.f fVar2 = null;
        com.airbnb.lottie.c.a.f fVar3 = null;
        b bVar = null;
        p.a aVar = null;
        p.b bVar2 = null;
        float f2 = 0.0f;
        b bVar3 = null;
        boolean z = false;
        while (cVar.e()) {
            switch (cVar3.a(f6041a)) {
                case 0:
                    str = cVar.i();
                    break;
                case 1:
                    int i2 = -1;
                    cVar.c();
                    while (cVar.e()) {
                        int a2 = cVar3.a(f6042b);
                        if (a2 != 0) {
                            cVar2 = cVar4;
                            if (a2 != 1) {
                                cVar.h();
                                cVar.m();
                            } else {
                                cVar4 = d.a(cVar3, dVar2, i2);
                            }
                        } else {
                            cVar2 = cVar4;
                            i2 = cVar.l();
                        }
                        cVar4 = cVar2;
                    }
                    com.airbnb.lottie.c.a.c cVar5 = cVar4;
                    cVar.d();
                    break;
                case 2:
                    dVar3 = d.a(cVar, dVar);
                    break;
                case 3:
                    fVar = cVar.l() == 1 ? f.LINEAR : f.RADIAL;
                    break;
                case 4:
                    fVar2 = d.b(cVar, dVar);
                    break;
                case 5:
                    fVar3 = d.b(cVar, dVar);
                    break;
                case 6:
                    bVar = d.a(cVar3, dVar2, true);
                    break;
                case 7:
                    aVar = p.a.values()[cVar.l() - 1];
                    break;
                case 8:
                    bVar2 = p.b.values()[cVar.l() - 1];
                    break;
                case 9:
                    f2 = (float) cVar.k();
                    break;
                case 10:
                    z = cVar.j();
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        cVar.c();
                        String str2 = null;
                        b bVar4 = null;
                        while (cVar.e()) {
                            int a3 = cVar3.a(f6043c);
                            if (a3 != 0) {
                                b bVar5 = bVar3;
                                if (a3 != 1) {
                                    cVar.h();
                                    cVar.m();
                                } else {
                                    bVar4 = d.a(cVar3, dVar2, true);
                                }
                                bVar3 = bVar5;
                            } else {
                                b bVar6 = bVar3;
                                str2 = cVar.i();
                            }
                        }
                        b bVar7 = bVar3;
                        cVar.d();
                        if (str2.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                dVar2.m = true;
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar7;
                        }
                    }
                    b bVar8 = bVar3;
                    cVar.b();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar3 = bVar8;
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new e(str, fVar, cVar4, dVar3, fVar2, fVar3, bVar, aVar, bVar2, f2, arrayList, bVar3, z);
    }
}
