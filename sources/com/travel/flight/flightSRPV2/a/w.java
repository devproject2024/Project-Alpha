package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.utils.c;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class w extends x {

    /* renamed from: a  reason: collision with root package name */
    public final int f24135a;

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 3;
    }

    public final String g() {
        return "Duration";
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ w this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar) {
            super(1);
            this.this$0 = wVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            k.c(cJRFlightDetailsItem, "it");
            return c.j(cJRFlightDetailsItem.getmDuration()) <= this.this$0.f24135a;
        }
    }

    public w(boolean z, int i2) {
        super(z);
        this.f24135a = i2;
    }

    public final String a() {
        return "Upto " + c.a(this.f24135a);
    }

    public final b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        int i2 = this.f24135a;
        if (obj != null) {
            return i2 == ((w) obj).f24135a;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPDurationFilter");
    }

    public final /* synthetic */ Object b() {
        return new w(this.f24136c, this.f24135a);
    }
}
