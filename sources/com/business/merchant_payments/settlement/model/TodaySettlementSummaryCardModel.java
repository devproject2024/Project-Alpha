package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TodaySettlementSummaryCardModel {
    public ApiState apiState;
    @c(a = "settlementAmountDetails")
    public ArrayList<LabelModel> settlementAmountDetails;
    @c(a = "settlementType")
    public String settlementType;
    @c(a = "availableBalance")
    public String totalAmount;
    @c(a = "totalPayments")
    public String totalPayments;

    public static /* synthetic */ TodaySettlementSummaryCardModel copy$default(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, String str, String str2, ArrayList<LabelModel> arrayList, String str3, ApiState apiState2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = todaySettlementSummaryCardModel.totalPayments;
        }
        if ((i2 & 2) != 0) {
            str2 = todaySettlementSummaryCardModel.settlementType;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            arrayList = todaySettlementSummaryCardModel.settlementAmountDetails;
        }
        ArrayList<LabelModel> arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            str3 = todaySettlementSummaryCardModel.totalAmount;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            apiState2 = todaySettlementSummaryCardModel.apiState;
        }
        return todaySettlementSummaryCardModel.copy(str, str4, arrayList2, str5, apiState2);
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

    public final String component4() {
        return this.totalAmount;
    }

    public final ApiState component5() {
        return this.apiState;
    }

    public final TodaySettlementSummaryCardModel copy(String str, String str2, ArrayList<LabelModel> arrayList, String str3, ApiState apiState2) {
        k.d(apiState2, "apiState");
        return new TodaySettlementSummaryCardModel(str, str2, arrayList, str3, apiState2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TodaySettlementSummaryCardModel)) {
            return false;
        }
        TodaySettlementSummaryCardModel todaySettlementSummaryCardModel = (TodaySettlementSummaryCardModel) obj;
        return k.a((Object) this.totalPayments, (Object) todaySettlementSummaryCardModel.totalPayments) && k.a((Object) this.settlementType, (Object) todaySettlementSummaryCardModel.settlementType) && k.a((Object) this.settlementAmountDetails, (Object) todaySettlementSummaryCardModel.settlementAmountDetails) && k.a((Object) this.totalAmount, (Object) todaySettlementSummaryCardModel.totalAmount) && k.a((Object) this.apiState, (Object) todaySettlementSummaryCardModel.apiState);
    }

    public final int hashCode() {
        String str = this.totalPayments;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.settlementType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<LabelModel> arrayList = this.settlementAmountDetails;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str3 = this.totalAmount;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ApiState apiState2 = this.apiState;
        if (apiState2 != null) {
            i2 = apiState2.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "TodaySettlementSummaryCardModel(totalPayments=" + this.totalPayments + ", settlementType=" + this.settlementType + ", settlementAmountDetails=" + this.settlementAmountDetails + ", totalAmount=" + this.totalAmount + ", apiState=" + this.apiState + ")";
    }

    public TodaySettlementSummaryCardModel(String str, String str2, ArrayList<LabelModel> arrayList, String str3, ApiState apiState2) {
        k.d(apiState2, "apiState");
        this.totalPayments = str;
        this.settlementType = str2;
        this.settlementAmountDetails = arrayList;
        this.totalAmount = str3;
        this.apiState = apiState2;
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

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TodaySettlementSummaryCardModel(String str, String str2, ArrayList arrayList, String str3, ApiState apiState2, int i2, g gVar) {
        this(str, str2, arrayList, str3, (i2 & 16) != 0 ? ApiState.SHIMMER : apiState2);
    }

    public final ApiState getApiState() {
        return this.apiState;
    }

    public final void setApiState(ApiState apiState2) {
        k.d(apiState2, "<set-?>");
        this.apiState = apiState2;
    }
}
