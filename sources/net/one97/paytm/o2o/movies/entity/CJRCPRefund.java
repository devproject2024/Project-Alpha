package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;

public final class CJRCPRefund implements Serializable {
    @b(a = "desc")
    private String desc;
    @b(a = "label")
    private String label;

    public static /* synthetic */ CJRCPRefund copy$default(CJRCPRefund cJRCPRefund, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCPRefund.label;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRCPRefund.desc;
        }
        return cJRCPRefund.copy(str, str2);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.desc;
    }

    public final CJRCPRefund copy(String str, String str2) {
        return new CJRCPRefund(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPRefund)) {
            return false;
        }
        CJRCPRefund cJRCPRefund = (CJRCPRefund) obj;
        return k.a((Object) this.label, (Object) cJRCPRefund.label) && k.a((Object) this.desc, (Object) cJRCPRefund.desc);
    }

    public final int hashCode() {
        String str = this.label;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRCPRefund(label=" + this.label + ", desc=" + this.desc + ")";
    }

    public CJRCPRefund(String str, String str2) {
        this.label = str;
        this.desc = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }
}
