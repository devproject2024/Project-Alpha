package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import kotlin.g.b.k;

public final class h extends ae {
    private /* synthetic */ h() {
        this(true);
    }

    public h(boolean z) {
        super(z, false, 2);
    }

    public final Comparable<Object> a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        String str = cJRFlightDetailsItem.getmDepartureTime();
        k.a((Object) str, "flight.getmDepartureTime()");
        return Long.valueOf(t.a(str).getTime());
    }

    public final int a() {
        return this.f24082a ? 3 : 4;
    }

    public final String b() {
        return this.f24082a ? "Early take off" : "Late take off";
    }
}
