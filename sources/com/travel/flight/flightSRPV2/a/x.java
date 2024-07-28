package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.u;

public abstract class x implements o<x> {

    /* renamed from: c  reason: collision with root package name */
    public boolean f24136c;

    public abstract String a();

    public abstract boolean c();

    public abstract int e();

    public abstract b<CJRFlightDetailsItem, Boolean> f();

    public abstract String g();

    public x(boolean z) {
        this.f24136c = z;
    }

    public int i() {
        throw new IllegalArgumentException("This Filter does not support static resource");
    }

    public String d() {
        throw new IllegalArgumentException("This Filter does not support remote resource");
    }

    public b<CJRDiscountedStrip, Boolean> h() {
        throw new IllegalArgumentException("This Filter does not support DiscountStrip");
    }

    public b<CJRIntlFlightMapping, Boolean> j() {
        throw new IllegalArgumentException("This Filter does not support IRT");
    }

    public int k() {
        throw new IllegalArgumentException("This Filter does not support IRT");
    }

    public boolean equals(Object obj) {
        return a(obj, false);
    }

    public final boolean a(Object obj, boolean z) {
        if (!a(obj)) {
            return false;
        }
        if (z) {
            return true;
        }
        boolean z2 = this.f24136c;
        if (obj != null) {
            return z2 == ((x) obj).f24136c;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPFilter");
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        return k.a((Object) y.b(getClass()), (Object) y.b(obj.getClass()));
    }
}
