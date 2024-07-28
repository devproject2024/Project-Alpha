package com.paytm.signallocation.a;

import com.paytm.signal.b.a;
import com.paytm.signal.b.b;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43672a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f43673b;

    private c() {
    }

    public final a a(a aVar, com.paytm.signal.schedulers.a aVar2, b bVar, com.paytm.signal.data.c cVar) {
        a aVar3;
        k.c(aVar, "configProvider");
        k.c(aVar2, "jobScheduler");
        k.c(bVar, "pushEventProvider");
        k.c(cVar, "configPreferenceStore");
        a aVar4 = f43673b;
        if (aVar4 != null) {
            return aVar4;
        }
        synchronized (this) {
            aVar3 = f43673b;
            if (aVar3 == null) {
                b bVar2 = new b();
                f43673b = bVar2;
                aVar3 = bVar2;
            }
        }
        return aVar3;
    }
}
