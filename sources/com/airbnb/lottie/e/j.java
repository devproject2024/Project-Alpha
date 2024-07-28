package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;
import java.util.ArrayList;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f6035a = c.a.a("ch", ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6036b = c.a.a("shapes");

    static d a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (cVar.e()) {
            int a2 = cVar.a(f6035a);
            if (a2 == 0) {
                c2 = cVar.i().charAt(0);
            } else if (a2 == 1) {
                d2 = cVar.k();
            } else if (a2 == 2) {
                d3 = cVar.k();
            } else if (a2 == 3) {
                str = cVar.i();
            } else if (a2 == 4) {
                str2 = cVar.i();
            } else if (a2 != 5) {
                cVar.h();
                cVar.m();
            } else {
                cVar.c();
                while (cVar.e()) {
                    if (cVar.a(f6036b) != 0) {
                        cVar.h();
                        cVar.m();
                    } else {
                        cVar.a();
                        while (cVar.e()) {
                            arrayList.add((n) g.a(cVar, dVar));
                        }
                        cVar.b();
                    }
                }
                cVar.d();
            }
        }
        cVar.d();
        return new d(arrayList, c2, d2, d3, str, str2);
    }
}
