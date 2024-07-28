package com.travel.flight.pojo;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MoreInfo extends IJRPaytmDataModel {

    /* renamed from: default  reason: not valid java name */
    private final String f377default;

    public MoreInfo() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ MoreInfo copy$default(MoreInfo moreInfo, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = moreInfo.f377default;
        }
        return moreInfo.copy(str);
    }

    public final String component1() {
        return this.f377default;
    }

    public final MoreInfo copy(String str) {
        k.c(str, "default");
        return new MoreInfo(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MoreInfo) && k.a((Object) this.f377default, (Object) ((MoreInfo) obj).f377default);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f377default;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "MoreInfo(default=" + this.f377default + ")";
    }

    public MoreInfo(String str) {
        k.c(str, "default");
        this.f377default = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MoreInfo(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getDefault() {
        return this.f377default;
    }
}
