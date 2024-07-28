package com.airbnb.lottie.e;

import android.graphics.Rect;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    static c.a f6054a = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6055b = c.a.a("w", "h", ContactsConstant.IP, "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f6056c = c.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final c.a f6057d = c.a.a("cm", H5Param.TOOLBAR_MENU, H5Param.DELAY_RENDER);

    public static d a(c cVar) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        c cVar2 = cVar;
        float a2 = h.a();
        androidx.a.d<com.airbnb.lottie.c.c.d> dVar = new androidx.a.d<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        androidx.a.h<com.airbnb.lottie.c.d> hVar = new androidx.a.h<>();
        d dVar2 = new d();
        cVar.c();
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (cVar.e()) {
            switch (cVar2.a(f6055b)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i2 = cVar.l();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i3 = cVar.l();
                    continue;
                case 2:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = (float) cVar.k();
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) cVar.k()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) cVar.k();
                    break;
                case 5:
                    String[] split = cVar.i().split("\\.");
                    arrayList = arrayList3;
                    if (!h.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]))) {
                        dVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    break;
                case 6:
                    a(cVar2, dVar2, (List<com.airbnb.lottie.c.c.d>) arrayList2, dVar);
                    break;
                case 7:
                    a(cVar2, dVar2, (Map<String, List<com.airbnb.lottie.c.c.d>>) hashMap2, (Map<String, g>) hashMap3);
                    break;
                case 8:
                    a(cVar2, (Map<String, com.airbnb.lottie.c.c>) hashMap4);
                    break;
                case 9:
                    a(cVar2, dVar2, hVar);
                    break;
                case 10:
                    a(cVar2, (List<com.airbnb.lottie.c.h>) arrayList3);
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    cVar.h();
                    cVar.m();
                    break;
            }
            hashMap = hashMap4;
            arrayList = arrayList3;
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        dVar2.f5982i = new Rect(0, 0, (int) (((float) i2) * a2), (int) (((float) i3) * a2));
        dVar2.j = f2;
        dVar2.k = f3;
        dVar2.l = f4;
        dVar2.f5981h = arrayList2;
        dVar2.f5980g = dVar;
        dVar2.f5975b = hashMap2;
        dVar2.f5976c = hashMap3;
        dVar2.f5979f = hVar;
        dVar2.f5977d = hashMap4;
        dVar2.f5978e = arrayList3;
        return dVar2;
    }

    private static void a(c cVar, d dVar, List<com.airbnb.lottie.c.c.d> list, androidx.a.d<com.airbnb.lottie.c.c.d> dVar2) throws IOException {
        cVar.a();
        int i2 = 0;
        while (cVar.e()) {
            com.airbnb.lottie.c.c.d a2 = s.a(cVar, dVar);
            if (a2.f5945e == d.a.IMAGE) {
                i2++;
            }
            list.add(a2);
            dVar2.b(a2.f5944d, a2);
            if (i2 > 4) {
                com.airbnb.lottie.f.d.a("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.b();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.c.c.d>> map, Map<String, g> map2) throws IOException {
        cVar.a();
        while (cVar.e()) {
            ArrayList arrayList = new ArrayList();
            androidx.a.d dVar2 = new androidx.a.d();
            cVar.c();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (cVar.e()) {
                int a2 = cVar.a(f6054a);
                if (a2 == 0) {
                    str = cVar.i();
                } else if (a2 == 1) {
                    cVar.a();
                    while (cVar.e()) {
                        com.airbnb.lottie.c.c.d a3 = s.a(cVar, dVar);
                        dVar2.b(a3.f5944d, a3);
                        arrayList.add(a3);
                    }
                    cVar.b();
                } else if (a2 == 2) {
                    i2 = cVar.l();
                } else if (a2 == 3) {
                    i3 = cVar.l();
                } else if (a2 == 4) {
                    str2 = cVar.i();
                } else if (a2 != 5) {
                    cVar.h();
                    cVar.m();
                } else {
                    str3 = cVar.i();
                }
            }
            cVar.d();
            if (str2 != null) {
                g gVar = new g(i2, i3, str, str2, str3);
                map2.put(gVar.f6130c, gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.b();
    }

    private static void a(c cVar, Map<String, com.airbnb.lottie.c.c> map) throws IOException {
        cVar.c();
        while (cVar.e()) {
            if (cVar.a(f6056c) != 0) {
                cVar.h();
                cVar.m();
            } else {
                cVar.a();
                while (cVar.e()) {
                    com.airbnb.lottie.c.c a2 = k.a(cVar);
                    map.put(a2.f5921b, a2);
                }
                cVar.b();
            }
        }
        cVar.d();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, androidx.a.h<com.airbnb.lottie.c.d> hVar) throws IOException {
        cVar.a();
        while (cVar.e()) {
            com.airbnb.lottie.c.d a2 = j.a(cVar, dVar);
            hVar.b(a2.hashCode(), a2);
        }
        cVar.b();
    }

    private static void a(c cVar, List<com.airbnb.lottie.c.h> list) throws IOException {
        cVar.a();
        while (cVar.e()) {
            String str = null;
            cVar.c();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (cVar.e()) {
                int a2 = cVar.a(f6057d);
                if (a2 == 0) {
                    str = cVar.i();
                } else if (a2 == 1) {
                    f2 = (float) cVar.k();
                } else if (a2 != 2) {
                    cVar.h();
                    cVar.m();
                } else {
                    f3 = (float) cVar.k();
                }
            }
            cVar.d();
            list.add(new com.airbnb.lottie.c.h(str, f2, f3));
        }
        cVar.b();
    }
}
