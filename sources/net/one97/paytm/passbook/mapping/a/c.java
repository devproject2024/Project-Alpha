package net.one97.paytm.passbook.mapping.a;

import net.one97.paytm.passbook.caching.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f57878a;

    public static c a() {
        if (f57878a == null) {
            synchronized (c.class.getName()) {
                if (f57878a == null) {
                    f57878a = new c();
                }
            }
        }
        return f57878a;
    }

    public static void a(e eVar) {
        a();
        b(eVar);
    }

    public static void b(e eVar) {
        if (eVar instanceof a) {
            ((a) eVar).a();
        } else if (eVar instanceof b) {
            ((b) eVar).a();
        }
    }

    public static void a(e eVar, a aVar) {
        if (eVar instanceof a) {
            a aVar2 = (a) eVar;
            if (aVar2.f57873a != null) {
                aVar.a(aVar2.f57873a);
            }
        } else if (eVar instanceof b) {
            b bVar = (b) eVar;
            if (bVar.f57875a != null) {
                aVar.a(bVar.f57875a);
            }
        }
    }
}
