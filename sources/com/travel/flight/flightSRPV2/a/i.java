package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import kotlin.g.b.k;

public final class i extends ae {
    private /* synthetic */ i() {
        this(true, true);
    }

    public i(boolean z, boolean z2) {
        super(z, z2);
    }

    public final Comparable<Object> a(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        String str = (this.f24083b ? cJRIntlFlightMapping.getOnwardItem() : cJRIntlFlightMapping.getReturnItem()).getmDepartureTime();
        k.a((Object) str, "data.getmDepartureTime()");
        return Long.valueOf(t.a(str).getTime());
    }

    public final int a() {
        return this.f24082a ? this.f24083b ? 3 : 7 : this.f24083b ? 4 : 8;
    }

    public final String b() {
        return this.f24082a ? "Early take off" : "Late take off";
    }

    public final String b(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        String str = (this.f24083b ? cJRIntlFlightMapping.getOnwardItem() : cJRIntlFlightMapping.getReturnItem()).getmDepartureTime();
        k.a((Object) str, "data.getmDepartureTime()");
        return String.valueOf(t.a(str).getTime());
    }
}
