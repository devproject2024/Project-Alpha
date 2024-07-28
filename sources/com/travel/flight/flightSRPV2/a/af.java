package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class af extends x {

    /* renamed from: a  reason: collision with root package name */
    public final int f24086a;

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 2;
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ af this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(af afVar) {
            super(1);
            this.this$0 = afVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            if (this.this$0.f24086a == 3) {
                return true;
            }
            ArrayList<CJRFlightStops> arrayList = cJRFlightDetailsItem.getmFlights();
            int size = arrayList != null ? arrayList.size() : 0;
            int i2 = this.this$0.f24086a;
            return i2 != 1 ? i2 == 2 && size <= 2 : size == 1;
        }
    }

    public af(boolean z, int i2) {
        super(z);
        this.f24086a = i2;
    }

    public final String a() {
        int i2 = this.f24086a;
        if (i2 != 1) {
            return i2 != 2 ? "All flights" : "Max 1 stop flights only";
        }
        return "Non stop flights only";
    }

    public final int k() {
        return this.f24086a;
    }

    public final String g() {
        int i2 = this.f24086a;
        if (i2 != 1) {
            return i2 != 2 ? "All flights" : "Max 1 Stop";
        }
        return "Non Stop";
    }

    public final b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        int i2 = this.f24086a;
        if (obj != null) {
            return i2 == ((af) obj).f24086a;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPStopsFilter");
    }

    public final /* synthetic */ Object b() {
        return new af(this.f24136c, this.f24086a);
    }
}
