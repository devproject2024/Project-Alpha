package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.utils.c;

public final class k extends ae {
    public final int a() {
        return 2;
    }

    private k() {
        super(true, false, 2);
    }

    public /* synthetic */ k(byte b2) {
        this();
    }

    public final Comparable<Object> a(CJRIntlFlightMapping cJRIntlFlightMapping) {
        kotlin.g.b.k.c(cJRIntlFlightMapping, "flightMapping");
        return Integer.valueOf(c.j(cJRIntlFlightMapping.getOnwardItem().getmDuration()) + c.j(cJRIntlFlightMapping.getReturnItem().getmDuration()));
    }

    public final String b(CJRIntlFlightMapping cJRIntlFlightMapping) {
        kotlin.g.b.k.c(cJRIntlFlightMapping, "flightMapping");
        return String.valueOf(c.j(cJRIntlFlightMapping.getOnwardItem().getmDuration()) + c.j(cJRIntlFlightMapping.getReturnItem().getmDuration()));
    }

    public final String b() {
        return this.f24082a ? "Fastest" : "Slowest";
    }
}
