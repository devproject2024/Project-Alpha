package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.pojo.flightticket.CJRIntlFlightPricing;
import kotlin.g.b.k;
import kotlin.g.b.l;

public final class ab extends x {
    public final String a() {
        return "Refundable only";
    }

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 1;
    }

    public final String g() {
        return "Refundable";
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements kotlin.g.a.b<CJRFlightDetailsItem, Boolean> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            return cJRFlightDetailsItem.ismIsRefundable();
        }
    }

    static final class b extends l implements kotlin.g.a.b<CJRIntlFlightMapping, Boolean> {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRIntlFlightMapping) obj));
        }

        public final boolean invoke(CJRIntlFlightMapping cJRIntlFlightMapping) {
            k.c(cJRIntlFlightMapping, "it");
            CJRIntlFlightPricing pricing = cJRIntlFlightMapping.getPricing();
            k.a((Object) pricing, "it.pricing");
            return pricing.isRefundable();
        }
    }

    public ab(boolean z) {
        super(z);
    }

    public final kotlin.g.a.b<CJRFlightDetailsItem, Boolean> f() {
        return a.INSTANCE;
    }

    public final kotlin.g.a.b<CJRIntlFlightMapping, Boolean> j() {
        return b.INSTANCE;
    }

    public final /* synthetic */ Object b() {
        return new ab(this.f24136c);
    }
}
