package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.utils.c;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    public final long f24122a;

    /* renamed from: b  reason: collision with root package name */
    public final long f24123b;

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 6;
    }

    public final String g() {
        return "Arrival";
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ s this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(s sVar) {
            super(1);
            this.this$0 = sVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            String str = cJRFlightDetailsItem.getmArrivalTime();
            k.a((Object) str, "it.getmArrivalTime()");
            long time = t.a(str).getTime();
            return this.this$0.f24122a <= time && time <= this.this$0.f24123b;
        }
    }

    public s(boolean z, long j, long j2) {
        super(z);
        this.f24122a = j;
        this.f24123b = j2;
    }

    public final String a() {
        return "Arrival " + c.a(this.f24122a, "dd MMM hh:mm a") + " to " + c.a(this.f24123b, "dd MMM hh:mm a");
    }

    public final b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        long j = this.f24122a;
        if (obj != null) {
            s sVar = (s) obj;
            return j == sVar.f24122a && this.f24123b == sVar.f24123b;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPArrivalFilter");
    }

    public final /* synthetic */ Object b() {
        return new s(this.f24136c, this.f24122a, this.f24123b);
    }
}
