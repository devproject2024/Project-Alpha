package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class SettlementAmountDetailsModel {
    @c(a = "settlementAmountDetails")
    public ArrayList<LabelModel> settlementAmountDetails;
    @c(a = "settlementType")
    public String settlementType;
    @c(a = "totalPayments")
    public String totalPayments;

    public static /* synthetic */ SettlementAmountDetailsModel copy$default(SettlementAmountDetailsModel settlementAmountDetailsModel, String str, String str2, ArrayList<LabelModel> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = settlementAmountDetailsModel.totalPayments;
        }
        if ((i2 & 2) != 0) {
            str2 = settlementAmountDetailsModel.settlementType;
        }
        if ((i2 & 4) != 0) {
            arrayList = settlementAmountDetailsModel.settlementAmountDetails;
        }
        return settlementAmountDetailsModel.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.totalPayments;
    }

    public final String component2() {
        return this.settlementType;
    }

    public final ArrayList<LabelModel> component3() {
        return this.settlementAmountDetails;
    }

    public final SettlementAmountDetailsModel copy(String str, String str2, ArrayList<LabelModel> arrayList) {
        return new SettlementAmountDetailsModel(str, str2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementAmountDetailsModel)) {
            return false;
        }
        SettlementAmountDetailsModel settlementAmountDetailsModel = (SettlementAmountDetailsModel) obj;
        return k.a((Object) this.totalPayments, (Object) settlementAmountDetailsModel.totalPayments) && k.a((Object) this.settlementType, (Object) settlementAmountDetailsModel.settlementType) && k.a((Object) this.settlementAmountDetails, (Object) settlementAmountDetailsModel.settlementAmountDetails);
    }

    public final int hashCode() {
        String str = this.totalPayments;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.settlementType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<LabelModel> arrayList = this.settlementAmountDetails;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SettlementAmountDetailsModel(totalPayments=" + this.totalPayments + ", settlementType=" + this.settlementType + ", settlementAmountDetails=" + this.settlementAmountDetails + ")";
    }

    public SettlementAmountDetailsModel(String str, String str2, ArrayList<LabelModel> arrayList) {
        this.totalPayments = str;
        this.settlementType = str2;
        this.settlementAmountDetails = arrayList;
    }

    public final String getTotalPayments() {
        return this.totalPayments;
    }

    public final void setTotalPayments(String str) {
        this.totalPayments = str;
    }

    public final String getSettlementType() {
        return this.settlementType;
    }

    public final void setSettlementType(String str) {
        this.settlementType = str;
    }

    public final ArrayList<LabelModel> getSettlementAmountDetails() {
        return this.settlementAmountDetails;
    }

    public final void setSettlementAmountDetails(ArrayList<LabelModel> arrayList) {
        this.settlementAmountDetails = arrayList;
    }
}
