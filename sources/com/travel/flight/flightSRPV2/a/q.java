package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import kotlin.g.b.k;

public final class q extends ae {
    public final int a() {
        return 1;
    }

    private q() {
        super(true, false, 2);
    }

    public /* synthetic */ q(byte b2) {
        this();
    }

    public final Comparable<Object> a(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        String str = cJRIntlFlightMapping.getPricing().getmDisplayPrice();
        k.a((Object) str, "flightMapping.pricing.getmDisplayPrice()");
        return Integer.valueOf((int) Double.parseDouble(str));
    }

    public final String b(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        String str = cJRIntlFlightMapping.getPricing().getmDisplayPrice();
        k.a((Object) str, "flightMapping.pricing.getmDisplayPrice()");
        return String.valueOf((int) Double.parseDouble(str));
    }

    public final String b() {
        return this.f24082a ? "Cheapest" : "Costliest";
    }
}
