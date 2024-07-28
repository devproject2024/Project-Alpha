package com.business.merchant_payments.settlement.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SettlementRangeSummaryModel {
    public boolean isLoading;
    public String settlementAmount;
    public int summaryCardVisibility;

    public static /* synthetic */ SettlementRangeSummaryModel copy$default(SettlementRangeSummaryModel settlementRangeSummaryModel, String str, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = settlementRangeSummaryModel.settlementAmount;
        }
        if ((i3 & 2) != 0) {
            z = settlementRangeSummaryModel.isLoading;
        }
        if ((i3 & 4) != 0) {
            i2 = settlementRangeSummaryModel.summaryCardVisibility;
        }
        return settlementRangeSummaryModel.copy(str, z, i2);
    }

    public final String component1() {
        return this.settlementAmount;
    }

    public final boolean component2() {
        return this.isLoading;
    }

    public final int component3() {
        return this.summaryCardVisibility;
    }

    public final SettlementRangeSummaryModel copy(String str, boolean z, int i2) {
        k.d(str, "settlementAmount");
        return new SettlementRangeSummaryModel(str, z, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementRangeSummaryModel)) {
            return false;
        }
        SettlementRangeSummaryModel settlementRangeSummaryModel = (SettlementRangeSummaryModel) obj;
        return k.a((Object) this.settlementAmount, (Object) settlementRangeSummaryModel.settlementAmount) && this.isLoading == settlementRangeSummaryModel.isLoading && this.summaryCardVisibility == settlementRangeSummaryModel.summaryCardVisibility;
    }

    public final int hashCode() {
        String str = this.settlementAmount;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isLoading;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.summaryCardVisibility;
    }

    public final String toString() {
        return "SettlementRangeSummaryModel(settlementAmount=" + this.settlementAmount + ", isLoading=" + this.isLoading + ", summaryCardVisibility=" + this.summaryCardVisibility + ")";
    }

    public SettlementRangeSummaryModel(String str, boolean z, int i2) {
        k.d(str, "settlementAmount");
        this.settlementAmount = str;
        this.isLoading = z;
        this.summaryCardVisibility = i2;
    }

    public final String getSettlementAmount() {
        return this.settlementAmount;
    }

    public final void setSettlementAmount(String str) {
        k.d(str, "<set-?>");
        this.settlementAmount = str;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettlementRangeSummaryModel(String str, boolean z, int i2, int i3, g gVar) {
        this(str, z, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getSummaryCardVisibility() {
        return this.summaryCardVisibility;
    }

    public final void setSummaryCardVisibility(int i2) {
        this.summaryCardVisibility = i2;
    }
}
