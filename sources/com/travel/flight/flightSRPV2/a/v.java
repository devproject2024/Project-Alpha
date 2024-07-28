package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.utils.c;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class v extends x {

    /* renamed from: a  reason: collision with root package name */
    public final long f24133a;

    /* renamed from: b  reason: collision with root package name */
    public final long f24134b;

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 5;
    }

    public final String g() {
        return "Departure";
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ v this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar) {
            super(1);
            this.this$0 = vVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            String str = cJRFlightDetailsItem.getmDepartureTime();
            k.a((Object) str, "it.getmDepartureTime()");
            long time = t.a(str).getTime();
            return this.this$0.f24133a <= time && time <= this.this$0.f24134b;
        }
    }

    public v(boolean z, long j, long j2) {
        super(z);
        this.f24133a = j;
        this.f24134b = j2;
    }

    public final String a() {
        return "Departure " + c.a(this.f24133a, "dd MMM hh:mm a") + " to " + c.a(this.f24134b, "dd MMM hh:mm a");
    }

    public final b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        long j = this.f24133a;
        if (obj != null) {
            v vVar = (v) obj;
            return j == vVar.f24133a && this.f24134b == vVar.f24134b;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDepartureFilter");
    }

    public final /* synthetic */ Object b() {
        return new v(this.f24136c, this.f24133a, this.f24134b);
    }
}
