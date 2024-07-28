package com.travel.bus.busticket.i;

import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.b.c;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22476a = v.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static b f22477b;

    public static void a(c cVar) {
        b().a(cVar);
    }

    public static void a() {
        b().dispose();
    }

    private static b b() {
        b bVar = f22477b;
        if (bVar == null || bVar.isDisposed()) {
            f22477b = new b();
        }
        return f22477b;
    }

    private v() {
    }
}
