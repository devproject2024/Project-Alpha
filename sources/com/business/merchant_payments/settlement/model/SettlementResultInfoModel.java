package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class SettlementResultInfoModel {
    @c(a = "resultCode")
    public String resultCode;
    @c(a = "resultCodeId")
    public String resultCodeId;
    @c(a = "resultMsg")
    public String resultMsg;
    @c(a = "resultStatus")
    public String resultStatus;

    public static /* synthetic */ SettlementResultInfoModel copy$default(SettlementResultInfoModel settlementResultInfoModel, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = settlementResultInfoModel.resultCode;
        }
        if ((i2 & 2) != 0) {
            str2 = settlementResultInfoModel.resultCodeId;
        }
        if ((i2 & 4) != 0) {
            str3 = settlementResultInfoModel.resultMsg;
        }
        if ((i2 & 8) != 0) {
            str4 = settlementResultInfoModel.resultStatus;
        }
        return settlementResultInfoModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.resultCode;
    }

    public final String component2() {
        return this.resultCodeId;
    }

    public final String component3() {
        return this.resultMsg;
    }

    public final String component4() {
        return this.resultStatus;
    }

    public final SettlementResultInfoModel copy(String str, String str2, String str3, String str4) {
        return new SettlementResultInfoModel(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementResultInfoModel)) {
            return false;
        }
        SettlementResultInfoModel settlementResultInfoModel = (SettlementResultInfoModel) obj;
        return k.a((Object) this.resultCode, (Object) settlementResultInfoModel.resultCode) && k.a((Object) this.resultCodeId, (Object) settlementResultInfoModel.resultCodeId) && k.a((Object) this.resultMsg, (Object) settlementResultInfoModel.resultMsg) && k.a((Object) this.resultStatus, (Object) settlementResultInfoModel.resultStatus);
    }

    public final int hashCode() {
        String str = this.resultCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultCodeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultMsg;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.resultStatus;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SettlementResultInfoModel(resultCode=" + this.resultCode + ", resultCodeId=" + this.resultCodeId + ", resultMsg=" + this.resultMsg + ", resultStatus=" + this.resultStatus + ")";
    }

    public SettlementResultInfoModel(String str, String str2, String str3, String str4) {
        this.resultCode = str;
        this.resultCodeId = str2;
        this.resultMsg = str3;
        this.resultStatus = str4;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }
}
