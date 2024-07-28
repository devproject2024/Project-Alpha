package com.airbnb.lottie.e;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f6051a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", H5Param.SAFEPAY_CONTEXT, "ks", H5Param.TRANSPARENT, "masksProperties", "shapes", "t", "ef", H5Param.SHOW_REPORT_BTN, H5Param.SHOW_TITLEBAR, "w", "h", ContactsConstant.IP, "op", H5Param.TOOLBAR_MENU, "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6052b = c.a.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f6053c = c.a.a("nm");

    public static d a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        float f2;
        ArrayList arrayList;
        c cVar2 = cVar;
        com.airbnb.lottie.d dVar2 = dVar;
        d.b bVar = d.b.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.c();
        Float valueOf = Float.valueOf(1.0f);
        boolean z = false;
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        String str = null;
        l lVar = null;
        j jVar = null;
        k kVar = null;
        b bVar3 = null;
        long j = 0;
        long j2 = -1;
        float f3 = 0.0f;
        float f4 = 1.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        float f5 = 0.0f;
        boolean z2 = false;
        String str2 = null;
        d.a aVar = null;
        String str3 = "UNSET";
        float f6 = 0.0f;
        while (cVar.e()) {
            switch (cVar2.a(f6051a)) {
                case 0:
                    str3 = cVar.i();
                    break;
                case 1:
                    j = (long) cVar.l();
                    break;
                case 2:
                    str = cVar.i();
                    break;
                case 3:
                    int l = cVar.l();
                    if (l >= d.a.UNKNOWN.ordinal()) {
                        aVar = d.a.UNKNOWN;
                        break;
                    } else {
                        aVar = d.a.values()[l];
                        break;
                    }
                case 4:
                    j2 = (long) cVar.l();
                    break;
                case 5:
                    i2 = (int) (((float) cVar.l()) * h.a());
                    break;
                case 6:
                    i3 = (int) (((float) cVar.l()) * h.a());
                    break;
                case 7:
                    i4 = Color.parseColor(cVar.i());
                    break;
                case 8:
                    lVar = c.a(cVar, dVar);
                    break;
                case 9:
                    bVar2 = d.b.values()[cVar.l()];
                    dVar2.a(1);
                    break;
                case 10:
                    cVar.a();
                    while (cVar.e()) {
                        arrayList2.add(u.a(cVar, dVar));
                    }
                    dVar2.a(arrayList2.size());
                    cVar.b();
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        com.airbnb.lottie.c.b.b a2 = g.a(cVar, dVar);
                        if (a2 != null) {
                            arrayList3.add(a2);
                        }
                    }
                    cVar.b();
                    break;
                case 12:
                    cVar.c();
                    while (cVar.e()) {
                        int a3 = cVar2.a(f6052b);
                        if (a3 == 0) {
                            jVar = new j(r.a(cVar2, dVar2, 1.0f, h.f6032a));
                        } else if (a3 != 1) {
                            cVar.h();
                            cVar.m();
                        } else {
                            cVar.a();
                            if (cVar.e()) {
                                kVar = b.a(cVar, dVar);
                            }
                            while (cVar.e()) {
                                cVar.m();
                            }
                            cVar.b();
                        }
                    }
                    cVar.d();
                    break;
                case 13:
                    cVar.a();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.e()) {
                        cVar.c();
                        while (cVar.e()) {
                            if (cVar2.a(f6053c) != 0) {
                                cVar.h();
                                cVar.m();
                            } else {
                                arrayList4.add(cVar.i());
                            }
                        }
                        cVar.d();
                    }
                    cVar.b();
                    dVar2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    break;
                case 14:
                    f4 = (float) cVar.k();
                    continue;
                case 15:
                    f5 = (float) cVar.k();
                    continue;
                case 16:
                    i5 = (int) (((float) cVar.l()) * h.a());
                    continue;
                case 17:
                    i6 = (int) (((float) cVar.l()) * h.a());
                    continue;
                case 18:
                    f3 = (float) cVar.k();
                    continue;
                case 19:
                    f6 = (float) cVar.k();
                    continue;
                case 20:
                    bVar3 = d.a(cVar2, dVar2, z);
                    continue;
                case 21:
                    str2 = cVar.i();
                    continue;
                case 22:
                    z2 = cVar.j();
                    continue;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
            z = false;
        }
        cVar.d();
        float f7 = f3 / f4;
        float f8 = f6 / f4;
        ArrayList arrayList5 = new ArrayList();
        if (f7 > 0.0f) {
            a aVar2 = r0;
            f2 = f4;
            arrayList = arrayList5;
            a aVar3 = new a(dVar, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f7));
            arrayList.add(aVar2);
        } else {
            f2 = f4;
            arrayList = arrayList5;
        }
        if (f8 <= 0.0f) {
            f8 = dVar2.k;
        }
        com.airbnb.lottie.d dVar3 = dVar;
        arrayList.add(new a(dVar3, valueOf, valueOf, (Interpolator) null, f7, Float.valueOf(f8)));
        arrayList.add(new a(dVar3, valueOf2, valueOf2, (Interpolator) null, f8, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            dVar2.a("Convert your Illustrator layers to shape layers.");
        }
        return new d(arrayList3, dVar, str3, j, aVar, j2, str, arrayList2, lVar, i2, i3, i4, f2, f5, i5, i6, jVar, kVar, arrayList, bVar2, bVar3, z2);
    }

    public static d a(com.airbnb.lottie.d dVar) {
        Rect rect = dVar.f5982i;
        List emptyList = Collections.emptyList();
        d.a aVar = d.a.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        l lVar = r4;
        l lVar2 = new l();
        return new d(emptyList, dVar, "__container", -1, aVar, -1, (String) null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), (j) null, (k) null, Collections.emptyList(), d.b.NONE, (b) null, false);
    }
}
