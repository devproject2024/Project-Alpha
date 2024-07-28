package com.paytm.location.a;

import com.paytm.analytics.b.a;
import com.paytm.analytics.data.c;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f42840a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f42841b;

    private b() {
    }

    public final a a(a aVar, com.paytm.analytics.schedulers.a aVar2, com.paytm.analytics.b.b bVar, c cVar) {
        a aVar3;
        k.c(aVar, "configProvider");
        k.c(aVar2, "jobScheduler");
        k.c(bVar, "pushEventProvider");
        k.c(cVar, "configPreferenceStore");
        a aVar4 = f42841b;
        if (aVar4 != null) {
            return aVar4;
        }
        synchronized (this) {
            aVar3 = f42841b;
            if (aVar3 == null) {
                aVar3 = new c(aVar, aVar2, bVar, cVar);
                f42841b = aVar3;
            }
        }
        return aVar3;
    }
}
