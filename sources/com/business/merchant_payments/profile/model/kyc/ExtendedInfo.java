package com.business.merchant_payments.profile.model.kyc;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import kotlin.g.b.k;

public final class ExtendedInfo {
    public final String canEnableInstantSettlement;
    public final String canEnableInstantSettlementMessage;
    public final String gstin;
    public final String panNo;
    public final int payoutDays;
    public final String settlementType;
    public final String signatoryName;

    public static /* synthetic */ ExtendedInfo copy$default(ExtendedInfo extendedInfo, String str, String str2, String str3, int i2, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = extendedInfo.panNo;
        }
        if ((i3 & 2) != 0) {
            str2 = extendedInfo.gstin;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = extendedInfo.signatoryName;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            i2 = extendedInfo.payoutDays;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str4 = extendedInfo.settlementType;
        }
        String str9 = str4;
        if ((i3 & 32) != 0) {
            str5 = extendedInfo.canEnableInstantSettlement;
        }
        String str10 = str5;
        if ((i3 & 64) != 0) {
            str6 = extendedInfo.canEnableInstantSettlementMessage;
        }
        return extendedInfo.copy(str, str7, str8, i4, str9, str10, str6);
    }

    public final String component1() {
        return this.panNo;
    }

    public final String component2() {
        return this.gstin;
    }

    public final String component3() {
        return this.signatoryName;
    }

    public final int component4() {
        return this.payoutDays;
    }

    public final String component5() {
        return this.settlementType;
    }

    public final String component6() {
        return this.canEnableInstantSettlement;
    }

    public final String component7() {
        return this.canEnableInstantSettlementMessage;
    }

    public final ExtendedInfo copy(String str, String str2, String str3, int i2, String str4, String str5, String str6) {
        k.d(str, "panNo");
        k.d(str2, AddEditGstinViewModelKt.BODY_PARAM_GSTIN);
        k.d(str3, "signatoryName");
        k.d(str4, "settlementType");
        k.d(str5, "canEnableInstantSettlement");
        String str7 = str6;
        k.d(str7, "canEnableInstantSettlementMessage");
        return new ExtendedInfo(str, str2, str3, i2, str4, str5, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendedInfo)) {
            return false;
        }
        ExtendedInfo extendedInfo = (ExtendedInfo) obj;
        return k.a((Object) this.panNo, (Object) extendedInfo.panNo) && k.a((Object) this.gstin, (Object) extendedInfo.gstin) && k.a((Object) this.signatoryName, (Object) extendedInfo.signatoryName) && this.payoutDays == extendedInfo.payoutDays && k.a((Object) this.settlementType, (Object) extendedInfo.settlementType) && k.a((Object) this.canEnableInstantSettlement, (Object) extendedInfo.canEnableInstantSettlement) && k.a((Object) this.canEnableInstantSettlementMessage, (Object) extendedInfo.canEnableInstantSettlementMessage);
    }

    public final int hashCode() {
        String str = this.panNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.gstin;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.signatoryName;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.payoutDays) * 31;
        String str4 = this.settlementType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.canEnableInstantSettlement;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.canEnableInstantSettlementMessage;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "ExtendedInfo(panNo=" + this.panNo + ", gstin=" + this.gstin + ", signatoryName=" + this.signatoryName + ", payoutDays=" + this.payoutDays + ", settlementType=" + this.settlementType + ", canEnableInstantSettlement=" + this.canEnableInstantSettlement + ", canEnableInstantSettlementMessage=" + this.canEnableInstantSettlementMessage + ")";
    }

    public ExtendedInfo(String str, String str2, String str3, int i2, String str4, String str5, String str6) {
        k.d(str, "panNo");
        k.d(str2, AddEditGstinViewModelKt.BODY_PARAM_GSTIN);
        k.d(str3, "signatoryName");
        k.d(str4, "settlementType");
        k.d(str5, "canEnableInstantSettlement");
        k.d(str6, "canEnableInstantSettlementMessage");
        this.panNo = str;
        this.gstin = str2;
        this.signatoryName = str3;
        this.payoutDays = i2;
        this.settlementType = str4;
        this.canEnableInstantSettlement = str5;
        this.canEnableInstantSettlementMessage = str6;
    }

    public final String getPanNo() {
        return this.panNo;
    }

    public final String getGstin() {
        return this.gstin;
    }

    public final String getSignatoryName() {
        return this.signatoryName;
    }

    public final int getPayoutDays() {
        return this.payoutDays;
    }

    public final String getSettlementType() {
        return this.settlementType;
    }

    public final String getCanEnableInstantSettlement() {
        return this.canEnableInstantSettlement;
    }

    public final String getCanEnableInstantSettlementMessage() {
        return this.canEnableInstantSettlementMessage;
    }
}
