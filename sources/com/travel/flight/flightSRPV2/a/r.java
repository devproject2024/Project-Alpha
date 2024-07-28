package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;

public final class r extends x {

    /* renamed from: a  reason: collision with root package name */
    public final d f24121a;

    public final boolean c() {
        return true;
    }

    public final int e() {
        return 7;
    }

    public final String g() {
        return "Airline";
    }

    static final class a extends l implements kotlin.g.a.b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ r this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r rVar) {
            super(1);
            this.this$0 = rVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            String str = cJRFlightDetailsItem.getmAirLine();
            k.a((Object) str, "airline");
            if (!p.a((CharSequence) str, '|', false)) {
                return p.a(this.this$0.f24121a.f24095a, cJRFlightDetailsItem.getmAirLineCode(), true);
            }
            ArrayList<CJRFlightStops> arrayList = cJRFlightDetailsItem.getmFlights();
            Collection collection = arrayList;
            if (collection == null || collection.isEmpty()) {
                return false;
            }
            Iterator<CJRFlightStops> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (p.a(this.this$0.f24121a.f24095a, it2.next().getmAirLineCode(), true)) {
                    return true;
                }
            }
            return false;
        }
    }

    static final class b extends l implements kotlin.g.a.b<CJRDiscountedStrip, Boolean> {
        final /* synthetic */ r this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r rVar) {
            super(1);
            this.this$0 = rVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRDiscountedStrip) obj));
        }

        public final boolean invoke(CJRDiscountedStrip cJRDiscountedStrip) {
            k.c(cJRDiscountedStrip, "it");
            return p.a(this.this$0.f24121a.f24095a, cJRDiscountedStrip.getAirlineCode(), true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(boolean z, d dVar) {
        super(z);
        k.c(dVar, "airlineInfo");
        this.f24121a = dVar;
    }

    public final String a() {
        return this.f24121a.f24096b;
    }

    public final String d() {
        return this.f24121a.f24095a;
    }

    public final kotlin.g.a.b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    public final kotlin.g.a.b<CJRDiscountedStrip, Boolean> h() {
        return new b(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        String str = this.f24121a.f24095a;
        if (obj != null) {
            return p.a(str, ((r) obj).f24121a.f24095a, true);
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPAirlineFilter");
    }

    public final /* synthetic */ Object b() {
        return new r(this.f24136c, this.f24121a.b());
    }
}
