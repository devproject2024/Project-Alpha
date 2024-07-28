package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;

public final class CJRCPSlabItem implements Serializable {
    @b(a = "display_string")
    private String display_string;
    @b(a = "refund")
    private CJRCPRefund refund;

    public static /* synthetic */ CJRCPSlabItem copy$default(CJRCPSlabItem cJRCPSlabItem, String str, CJRCPRefund cJRCPRefund, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCPSlabItem.display_string;
        }
        if ((i2 & 2) != 0) {
            cJRCPRefund = cJRCPSlabItem.refund;
        }
        return cJRCPSlabItem.copy(str, cJRCPRefund);
    }

    public final String component1() {
        return this.display_string;
    }

    public final CJRCPRefund component2() {
        return this.refund;
    }

    public final CJRCPSlabItem copy(String str, CJRCPRefund cJRCPRefund) {
        return new CJRCPSlabItem(str, cJRCPRefund);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPSlabItem)) {
            return false;
        }
        CJRCPSlabItem cJRCPSlabItem = (CJRCPSlabItem) obj;
        return k.a((Object) this.display_string, (Object) cJRCPSlabItem.display_string) && k.a((Object) this.refund, (Object) cJRCPSlabItem.refund);
    }

    public final int hashCode() {
        String str = this.display_string;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CJRCPRefund cJRCPRefund = this.refund;
        if (cJRCPRefund != null) {
            i2 = cJRCPRefund.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPSlabItem(display_string=" + this.display_string + ", refund=" + this.refund + ")";
    }

    public CJRCPSlabItem(String str, CJRCPRefund cJRCPRefund) {
        this.display_string = str;
        this.refund = cJRCPRefund;
    }

    public final String getDisplay_string() {
        return this.display_string;
    }

    public final void setDisplay_string(String str) {
        this.display_string = str;
    }

    public final CJRCPRefund getRefund() {
        return this.refund;
    }

    public final void setRefund(CJRCPRefund cJRCPRefund) {
        this.refund = cJRCPRefund;
    }
}
