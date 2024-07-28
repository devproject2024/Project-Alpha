package com.airbnb.lottie.e;

import android.graphics.Color;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

public final class f implements ai<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f6030a = new f();

    private f() {
    }

    public final /* synthetic */ Object a(c cVar, float f2) throws IOException {
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        double k = cVar.k();
        double k2 = cVar.k();
        double k3 = cVar.k();
        double k4 = cVar.k();
        if (z) {
            cVar.b();
        }
        if (k <= 1.0d && k2 <= 1.0d && k3 <= 1.0d) {
            k *= 255.0d;
            k2 *= 255.0d;
            k3 *= 255.0d;
            if (k4 <= 1.0d) {
                k4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) k4, (int) k, (int) k2, (int) k3));
    }
}
