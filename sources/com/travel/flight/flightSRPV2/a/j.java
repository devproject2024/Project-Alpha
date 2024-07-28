package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.utils.c;
import kotlin.g.b.k;

public final class j extends ae {
    public final int a() {
        return 2;
    }

    private j() {
        super(true, false, 2);
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    public final Comparable<Object> a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        return Integer.valueOf(c.j(cJRFlightDetailsItem.getmDuration()));
    }

    public final String b() {
        return this.f24082a ? "Fastest" : "Slowest";
    }
}
