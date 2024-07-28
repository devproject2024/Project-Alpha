package com.travel.flight.flightorder.j;

import com.travel.flight.b.be;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import kotlin.g.b.k;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody;

public final class p extends a {

    /* renamed from: a  reason: collision with root package name */
    private final be f24580a;

    /* renamed from: b  reason: collision with root package name */
    private final CJRFlightOrderSummaryResponse f24581b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(be beVar, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        super(beVar.getRoot());
        k.c(beVar, "layoutFlightRefundBinding");
        k.c(cJRFlightOrderSummaryResponse, "orderSummary");
        this.f24580a = beVar;
        this.f24581b = cJRFlightOrderSummaryResponse;
    }

    public final void a(b.C0467b bVar) {
        be beVar = this.f24580a;
        CJROrderSummaryBody body = this.f24581b.getBody();
        k.a((Object) body, "orderSummary.body");
        beVar.a(body.getRefundDetails());
    }
}
