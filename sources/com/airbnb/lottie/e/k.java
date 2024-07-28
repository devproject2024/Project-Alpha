package com.airbnb.lottie.e;

import com.airbnb.lottie.e.a.c;
import java.io.IOException;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f6037a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    static com.airbnb.lottie.c.c a(c cVar) throws IOException {
        cVar.c();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (cVar.e()) {
            int a2 = cVar.a(f6037a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                str2 = cVar.i();
            } else if (a2 == 2) {
                str3 = cVar.i();
            } else if (a2 != 3) {
                cVar.h();
                cVar.m();
            } else {
                f2 = (float) cVar.k();
            }
        }
        cVar.d();
        return new com.airbnb.lottie.c.c(str, str2, str3, f2);
    }
}
