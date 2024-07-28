package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class MandateDetails implements UpiBaseDataModel {
    @c(a = "mandateState")
    private final String mandateState;
    @c(a = "type")
    private final String type;
    @c(a = "umn")
    private final String umn;
    @c(a = "validityEndDate")
    private final Long validityEndDate;
    @c(a = "validityStartDate")
    private final Long validityStartDate;

    public static /* synthetic */ MandateDetails copy$default(MandateDetails mandateDetails, String str, Long l, Long l2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandateDetails.umn;
        }
        if ((i2 & 2) != 0) {
            l = mandateDetails.validityStartDate;
        }
        Long l3 = l;
        if ((i2 & 4) != 0) {
            l2 = mandateDetails.validityEndDate;
        }
        Long l4 = l2;
        if ((i2 & 8) != 0) {
            str2 = mandateDetails.mandateState;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = mandateDetails.type;
        }
        return mandateDetails.copy(str, l3, l4, str4, str3);
    }

    public final String component1() {
        return this.umn;
    }

    public final Long component2() {
        return this.validityStartDate;
    }

    public final Long component3() {
        return this.validityEndDate;
    }

    public final String component4() {
        return this.mandateState;
    }

    public final String component5() {
        return this.type;
    }

    public final MandateDetails copy(String str, Long l, Long l2, String str2, String str3) {
        k.c(str3, "type");
        return new MandateDetails(str, l, l2, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateDetails)) {
            return false;
        }
        MandateDetails mandateDetails = (MandateDetails) obj;
        return k.a((Object) this.umn, (Object) mandateDetails.umn) && k.a((Object) this.validityStartDate, (Object) mandateDetails.validityStartDate) && k.a((Object) this.validityEndDate, (Object) mandateDetails.validityEndDate) && k.a((Object) this.mandateState, (Object) mandateDetails.mandateState) && k.a((Object) this.type, (Object) mandateDetails.type);
    }

    public final int hashCode() {
        String str = this.umn;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.validityStartDate;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.validityEndDate;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str2 = this.mandateState;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "MandateDetails(umn=" + this.umn + ", validityStartDate=" + this.validityStartDate + ", validityEndDate=" + this.validityEndDate + ", mandateState=" + this.mandateState + ", type=" + this.type + ")";
    }

    public MandateDetails(String str, Long l, Long l2, String str2, String str3) {
        k.c(str3, "type");
        this.umn = str;
        this.validityStartDate = l;
        this.validityEndDate = l2;
        this.mandateState = str2;
        this.type = str3;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final Long getValidityStartDate() {
        return this.validityStartDate;
    }

    public final Long getValidityEndDate() {
        return this.validityEndDate;
    }

    public final String getMandateState() {
        return this.mandateState;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isRecurring() {
        return k.a((Object) this.type, (Object) "RECURRING");
    }
}
