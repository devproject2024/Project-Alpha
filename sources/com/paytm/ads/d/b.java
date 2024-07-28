package com.paytm.ads.d;

import a.a.a.a.a.b.h;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f40894a = new b();

    private b() {
    }

    public static ArrayList<h> a(ArrayList<com.paytm.ads.b> arrayList) {
        k.c(arrayList, "resourceList");
        ArrayList<h> arrayList2 = new ArrayList<>();
        Iterator<com.paytm.ads.b> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            com.paytm.ads.b next = it2.next();
            arrayList2.add(h.a(next.f40876a, new URL(next.f40878c), next.f40877b));
        }
        return arrayList2;
    }
}
