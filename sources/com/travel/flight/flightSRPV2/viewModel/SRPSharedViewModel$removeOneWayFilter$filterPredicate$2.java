package com.travel.flight.flightSRPV2.viewModel;

import com.travel.flight.flightSRPV2.a.x;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;

final class SRPSharedViewModel$removeOneWayFilter$filterPredicate$2 extends l implements b<x, Boolean> {
    final /* synthetic */ x $filter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPSharedViewModel$removeOneWayFilter$filterPredicate$2(x xVar) {
        super(1);
        this.$filter = xVar;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((x) obj));
    }

    public final boolean invoke(x xVar) {
        k.c(xVar, "it");
        return xVar.e() != this.$filter.e();
    }
}
