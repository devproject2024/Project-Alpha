package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import kotlin.g.b.k;

public final class p extends ae {
    public final int a() {
        return 1;
    }

    private p() {
        super(true, false, 2);
    }

    public /* synthetic */ p(byte b2) {
        this();
    }

    public final Comparable<Object> a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        String str = cJRFlightDetailsItem.getmPrice().get(0).getmDisplayPrice();
        k.a((Object) str, "flight.getmPrice()[0].getmDisplayPrice()");
        return Integer.valueOf((int) Double.parseDouble(str));
    }

    public final String b() {
        return this.f24082a ? "Cheapest" : "Costliest";
    }
}
