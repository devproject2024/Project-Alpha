package com.airbnb.lottie.e;

import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class r {

    /* renamed from: a  reason: collision with root package name */
    static c.a f6050a = c.a.a("k");

    static <T> List<a<T>> a(c cVar, d dVar, float f2, ai<T> aiVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.f() == c.b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.e()) {
            if (cVar.a(f6050a) != 0) {
                cVar.m();
            } else if (cVar.f() == c.b.BEGIN_ARRAY) {
                cVar.a();
                if (cVar.f() == c.b.NUMBER) {
                    arrayList.add(q.a(cVar, dVar, f2, aiVar, false));
                } else {
                    while (cVar.e()) {
                        arrayList.add(q.a(cVar, dVar, f2, aiVar, true));
                    }
                }
                cVar.b();
            } else {
                arrayList.add(q.a(cVar, dVar, f2, aiVar, false));
            }
        }
        cVar.d();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends a<T>> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            a aVar = (a) list.get(i3);
            i3++;
            a aVar2 = (a) list.get(i3);
            aVar.f6139f = Float.valueOf(aVar2.f6138e);
            if (aVar.f6136c == null && aVar2.f6135b != null) {
                aVar.f6136c = aVar2.f6135b;
                if (aVar instanceof h) {
                    ((h) aVar).a();
                }
            }
        }
        a aVar3 = (a) list.get(i2);
        if ((aVar3.f6135b == null || aVar3.f6136c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
