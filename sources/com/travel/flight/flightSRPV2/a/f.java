package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import kotlin.g.b.k;

public final class f extends ae {
    private /* synthetic */ f() {
        this(true, true);
    }

    public f(boolean z, boolean z2) {
        super(z, z2);
    }

    public final Comparable<Object> a(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        if (this.f24083b) {
            String str = cJRIntlFlightMapping.getOnwardItem().getmArrivalTime();
            k.a((Object) str, "flightMapping.onwardItem.getmArrivalTime()");
            return Long.valueOf(t.a(str).getTime());
        }
        String str2 = cJRIntlFlightMapping.getReturnItem().getmArrivalTime();
        k.a((Object) str2, "flightMapping.returnItem.getmArrivalTime()");
        return Long.valueOf(t.a(str2).getTime());
    }

    public final int a() {
        return this.f24082a ? this.f24083b ? 5 : 9 : this.f24083b ? 6 : 10;
    }

    public final String b() {
        return this.f24082a ? "Landing early" : "Landing late";
    }

    public final String b(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        String str = (this.f24083b ? cJRIntlFlightMapping.getOnwardItem() : cJRIntlFlightMapping.getReturnItem()).getmArrivalTime();
        k.a((Object) str, "data.getmArrivalTime()");
        return String.valueOf(t.a(str).getTime());
    }
}
