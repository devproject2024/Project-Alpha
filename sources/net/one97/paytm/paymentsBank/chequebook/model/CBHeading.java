package net.one97.paytm.paymentsBank.chequebook.model;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CBHeading implements IJRDataModel {
    private final String cbNumber;
    private final String leavesTv;

    public static /* synthetic */ CBHeading copy$default(CBHeading cBHeading, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cBHeading.cbNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = cBHeading.leavesTv;
        }
        return cBHeading.copy(str, str2);
    }

    public final String component1() {
        return this.cbNumber;
    }

    public final String component2() {
        return this.leavesTv;
    }

    public final CBHeading copy(String str, String str2) {
        k.c(str, "cbNumber");
        k.c(str2, "leavesTv");
        return new CBHeading(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CBHeading)) {
            return false;
        }
        CBHeading cBHeading = (CBHeading) obj;
        return k.a((Object) this.cbNumber, (Object) cBHeading.cbNumber) && k.a((Object) this.leavesTv, (Object) cBHeading.leavesTv);
    }

    public final int hashCode() {
        String str = this.cbNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.leavesTv;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CBHeading(cbNumber=" + this.cbNumber + ", leavesTv=" + this.leavesTv + ")";
    }

    public CBHeading(String str, String str2) {
        k.c(str, "cbNumber");
        k.c(str2, "leavesTv");
        this.cbNumber = str;
        this.leavesTv = str2;
    }

    public final String getCbNumber() {
        return this.cbNumber;
    }

    public final String getLeavesTv() {
        return this.leavesTv;
    }
}
