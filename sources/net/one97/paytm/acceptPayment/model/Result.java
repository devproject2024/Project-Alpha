package net.one97.paytm.acceptPayment.model;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import kotlin.g.b.k;

public final class Result {
    private String cta;
    private boolean forceUpdate;
    private String heading;
    private String subHeading;

    public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = result.heading;
        }
        if ((i2 & 2) != 0) {
            str2 = result.subHeading;
        }
        if ((i2 & 4) != 0) {
            str3 = result.cta;
        }
        if ((i2 & 8) != 0) {
            z = result.forceUpdate;
        }
        return result.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.heading;
    }

    public final String component2() {
        return this.subHeading;
    }

    public final String component3() {
        return this.cta;
    }

    public final boolean component4() {
        return this.forceUpdate;
    }

    public final Result copy(String str, String str2, String str3, boolean z) {
        k.d(str, "heading");
        k.d(str2, "subHeading");
        k.d(str3, Item.KEY_CTA);
        return new Result(str, str2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return k.a((Object) this.heading, (Object) result.heading) && k.a((Object) this.subHeading, (Object) result.subHeading) && k.a((Object) this.cta, (Object) result.cta) && this.forceUpdate == result.forceUpdate;
    }

    public final int hashCode() {
        String str = this.heading;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subHeading;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cta;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.forceUpdate;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Result(heading=" + this.heading + ", subHeading=" + this.subHeading + ", cta=" + this.cta + ", forceUpdate=" + this.forceUpdate + ")";
    }

    public Result(String str, String str2, String str3, boolean z) {
        k.d(str, "heading");
        k.d(str2, "subHeading");
        k.d(str3, Item.KEY_CTA);
        this.heading = str;
        this.subHeading = str2;
        this.cta = str3;
        this.forceUpdate = z;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        k.d(str, "<set-?>");
        this.heading = str;
    }

    public final String getSubHeading() {
        return this.subHeading;
    }

    public final void setSubHeading(String str) {
        k.d(str, "<set-?>");
        this.subHeading = str;
    }

    public final String getCta() {
        return this.cta;
    }

    public final void setCta(String str) {
        k.d(str, "<set-?>");
        this.cta = str;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }
}
