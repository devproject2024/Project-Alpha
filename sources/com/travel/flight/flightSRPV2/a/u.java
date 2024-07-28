package com.travel.flight.flightSRPV2.a;

import java.util.List;
import kotlin.g.b.k;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24126a = false;

    /* renamed from: b  reason: collision with root package name */
    public final int f24127b = 3;

    /* renamed from: c  reason: collision with root package name */
    public final g<Integer> f24128c;

    /* renamed from: d  reason: collision with root package name */
    public final g<Integer> f24129d;

    /* renamed from: e  reason: collision with root package name */
    public final g<Long> f24130e;

    /* renamed from: f  reason: collision with root package name */
    public final g<Long> f24131f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d> f24132g;

    public u(g<Integer> gVar, g<Integer> gVar2, g<Long> gVar3, g<Long> gVar4, List<d> list) {
        k.c(gVar, "durationRange");
        k.c(gVar2, "priceRange");
        k.c(gVar3, "departureRange");
        k.c(gVar4, "arrivalRange");
        k.c(list, "allAirlineList");
        this.f24128c = gVar;
        this.f24129d = gVar2;
        this.f24130e = gVar3;
        this.f24131f = gVar4;
        this.f24132g = list;
    }
}
