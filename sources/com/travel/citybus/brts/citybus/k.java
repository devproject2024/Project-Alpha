package com.travel.citybus.brts.citybus;

import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f23304a;

    /* renamed from: b  reason: collision with root package name */
    public final CJRCityAutoSuggest f23305b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f23304a == kVar.f23304a && kotlin.g.b.k.a((Object) this.f23305b, (Object) kVar.f23305b);
    }

    public final int hashCode() {
        int i2 = this.f23304a * 31;
        CJRCityAutoSuggest cJRCityAutoSuggest = this.f23305b;
        return i2 + (cJRCityAutoSuggest != null ? cJRCityAutoSuggest.hashCode() : 0);
    }

    public final String toString() {
        return "CJRCityBusSelectedModelForBus(cityTypeId=" + this.f23304a + ", busStop=" + this.f23305b + ")";
    }

    public k(int i2, CJRCityAutoSuggest cJRCityAutoSuggest) {
        kotlin.g.b.k.c(cJRCityAutoSuggest, "busStop");
        this.f23304a = i2;
        this.f23305b = cJRCityAutoSuggest;
    }
}
