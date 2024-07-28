package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ac implements ai<l> {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f6017a = new ac();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6018b = c.a.a("c", "v", "i", "o");

    private ac() {
    }

    public final /* synthetic */ Object a(c cVar, float f2) throws IOException {
        if (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
        }
        cVar.c();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f6018b);
            if (a2 == 0) {
                z = cVar.j();
            } else if (a2 == 1) {
                list = p.a(cVar, f2);
            } else if (a2 == 2) {
                list2 = p.a(cVar, f2);
            } else if (a2 != 3) {
                cVar.h();
                cVar.m();
            } else {
                list3 = p.a(cVar, f2);
            }
        }
        cVar.d();
        if (cVar.f() == c.b.END_ARRAY) {
            cVar.b();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new l(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new a(g.a(list.get(i3), list3.get(i3)), g.a(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new a(g.a(list.get(i4), list3.get(i4)), g.a(pointF3, list2.get(0)), pointF3));
            }
            return new l(pointF, z, arrayList);
        }
    }
}
