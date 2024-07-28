package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import kotlin.g.b.k;

public final class e extends ae {
    private /* synthetic */ e() {
        this(true);
    }

    public e(boolean z) {
        super(z, false, 2);
    }

    public final Comparable<Object> a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        String str = cJRFlightDetailsItem.getmArrivalTime();
        k.a((Object) str, "flight.getmArrivalTime()");
        return Long.valueOf(t.a(str).getTime());
    }

    public final int a() {
        return this.f24082a ? 5 : 6;
    }

    public final String b() {
        return this.f24082a ? "Landing early" : "Landing late";
    }
}
