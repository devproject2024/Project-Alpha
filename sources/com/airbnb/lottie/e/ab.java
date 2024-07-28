package com.airbnb.lottie.e;

import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.g.d;
import java.io.IOException;

public final class ab implements ai<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final ab f6016a = new ab();

    private ab() {
    }

    public final /* synthetic */ Object a(c cVar, float f2) throws IOException {
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        float k = (float) cVar.k();
        float k2 = (float) cVar.k();
        while (cVar.e()) {
            cVar.m();
        }
        if (z) {
            cVar.b();
        }
        return new d((k / 100.0f) * f2, (k2 / 100.0f) * f2);
    }
}
