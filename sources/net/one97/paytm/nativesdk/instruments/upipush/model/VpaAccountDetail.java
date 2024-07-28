package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class VpaAccountDetail implements BaseDataModel {
    private String defaultCreditAccRefId;
    private String defaultDebitAccRefId;
    private String name;
    private boolean primary;

    public static /* synthetic */ VpaAccountDetail copy$default(VpaAccountDetail vpaAccountDetail, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = vpaAccountDetail.name;
        }
        if ((i2 & 2) != 0) {
            str2 = vpaAccountDetail.defaultCreditAccRefId;
        }
        if ((i2 & 4) != 0) {
            str3 = vpaAccountDetail.defaultDebitAccRefId;
        }
        if ((i2 & 8) != 0) {
            z = vpaAccountDetail.primary;
        }
        return vpaAccountDetail.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.defaultCreditAccRefId;
    }

    public final String component3() {
        return this.defaultDebitAccRefId;
    }

    public final boolean component4() {
        return this.primary;
    }

    public final VpaAccountDetail copy(String str, String str2, String str3, boolean z) {
        return new VpaAccountDetail(str, str2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VpaAccountDetail)) {
            return false;
        }
        VpaAccountDetail vpaAccountDetail = (VpaAccountDetail) obj;
        return k.a((Object) this.name, (Object) vpaAccountDetail.name) && k.a((Object) this.defaultCreditAccRefId, (Object) vpaAccountDetail.defaultCreditAccRefId) && k.a((Object) this.defaultDebitAccRefId, (Object) vpaAccountDetail.defaultDebitAccRefId) && this.primary == vpaAccountDetail.primary;
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.defaultCreditAccRefId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.defaultDebitAccRefId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.primary;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "VpaAccountDetail(name=" + this.name + ", defaultCreditAccRefId=" + this.defaultCreditAccRefId + ", defaultDebitAccRefId=" + this.defaultDebitAccRefId + ", primary=" + this.primary + ")";
    }

    public VpaAccountDetail(String str, String str2, String str3, boolean z) {
        this.name = str;
        this.defaultCreditAccRefId = str2;
        this.defaultDebitAccRefId = str3;
        this.primary = z;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDefaultCreditAccRefId() {
        return this.defaultCreditAccRefId;
    }

    public final void setDefaultCreditAccRefId(String str) {
        this.defaultCreditAccRefId = str;
    }

    public final String getDefaultDebitAccRefId() {
        return this.defaultDebitAccRefId;
    }

    public final void setDefaultDebitAccRefId(String str) {
        this.defaultDebitAccRefId = str;
    }

    public final boolean getPrimary() {
        return this.primary;
    }

    public final void setPrimary(boolean z) {
        this.primary = z;
    }
}
