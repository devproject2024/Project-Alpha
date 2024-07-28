package com.business.merchant_payments.model.kyc;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import kotlin.g.b.k;

public final class ExtendedInfo {
    public final String canEnableTransactionWiseSettlementMessage;
    public final String gstin;
    public final String panNo;
    public final int payoutDays;
    public final String settlementType;
    public final String signatoryName;

    public static /* synthetic */ ExtendedInfo copy$default(ExtendedInfo extendedInfo, String str, String str2, String str3, int i2, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = extendedInfo.canEnableTransactionWiseSettlementMessage;
        }
        if ((i3 & 2) != 0) {
            str2 = extendedInfo.gstin;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = extendedInfo.panNo;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            i2 = extendedInfo.payoutDays;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str4 = extendedInfo.settlementType;
        }
        String str8 = str4;
        if ((i3 & 32) != 0) {
            str5 = extendedInfo.signatoryName;
        }
        return extendedInfo.copy(str, str6, str7, i4, str8, str5);
    }

    public final String component1() {
        return this.canEnableTransactionWiseSettlementMessage;
    }

    public final String component2() {
        return this.gstin;
    }

    public final String component3() {
        return this.panNo;
    }

    public final int component4() {
        return this.payoutDays;
    }

    public final String component5() {
        return this.settlementType;
    }

    public final String component6() {
        return this.signatoryName;
    }

    public final ExtendedInfo copy(String str, String str2, String str3, int i2, String str4, String str5) {
        k.d(str, "canEnableTransactionWiseSettlementMessage");
        k.d(str2, AddEditGstinViewModelKt.BODY_PARAM_GSTIN);
        k.d(str3, "panNo");
        k.d(str4, "settlementType");
        k.d(str5, "signatoryName");
        return new ExtendedInfo(str, str2, str3, i2, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendedInfo)) {
            return false;
        }
        ExtendedInfo extendedInfo = (ExtendedInfo) obj;
        return k.a((Object) this.canEnableTransactionWiseSettlementMessage, (Object) extendedInfo.canEnableTransactionWiseSettlementMessage) && k.a((Object) this.gstin, (Object) extendedInfo.gstin) && k.a((Object) this.panNo, (Object) extendedInfo.panNo) && this.payoutDays == extendedInfo.payoutDays && k.a((Object) this.settlementType, (Object) extendedInfo.settlementType) && k.a((Object) this.signatoryName, (Object) extendedInfo.signatoryName);
    }

    public final int hashCode() {
        String str = this.canEnableTransactionWiseSettlementMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.gstin;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.panNo;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.payoutDays) * 31;
        String str4 = this.settlementType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.signatoryName;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ExtendedInfo(canEnableTransactionWiseSettlementMessage=" + this.canEnableTransactionWiseSettlementMessage + ", gstin=" + this.gstin + ", panNo=" + this.panNo + ", payoutDays=" + this.payoutDays + ", settlementType=" + this.settlementType + ", signatoryName=" + this.signatoryName + ")";
    }

    public ExtendedInfo(String str, String str2, String str3, int i2, String str4, String str5) {
        k.d(str, "canEnableTransactionWiseSettlementMessage");
        k.d(str2, AddEditGstinViewModelKt.BODY_PARAM_GSTIN);
        k.d(str3, "panNo");
        k.d(str4, "settlementType");
        k.d(str5, "signatoryName");
        this.canEnableTransactionWiseSettlementMessage = str;
        this.gstin = str2;
        this.panNo = str3;
        this.payoutDays = i2;
        this.settlementType = str4;
        this.signatoryName = str5;
    }

    public final String getCanEnableTransactionWiseSettlementMessage() {
        return this.canEnableTransactionWiseSettlementMessage;
    }

    public final String getGstin() {
        return this.gstin;
    }

    public final String getPanNo() {
        return this.panNo;
    }

    public final int getPayoutDays() {
        return this.payoutDays;
    }

    public final String getSettlementType() {
        return this.settlementType;
    }

    public final String getSignatoryName() {
        return this.signatoryName;
    }
}
