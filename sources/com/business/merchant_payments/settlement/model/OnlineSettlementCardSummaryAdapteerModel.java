package com.business.merchant_payments.settlement.model;

import kotlin.g.b.k;

public final class OnlineSettlementCardSummaryAdapteerModel {
    public TodaySettlementSummaryCardModel modelData;

    public static /* synthetic */ OnlineSettlementCardSummaryAdapteerModel copy$default(OnlineSettlementCardSummaryAdapteerModel onlineSettlementCardSummaryAdapteerModel, TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            todaySettlementSummaryCardModel = onlineSettlementCardSummaryAdapteerModel.modelData;
        }
        return onlineSettlementCardSummaryAdapteerModel.copy(todaySettlementSummaryCardModel);
    }

    public final TodaySettlementSummaryCardModel component1() {
        return this.modelData;
    }

    public final OnlineSettlementCardSummaryAdapteerModel copy(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel) {
        k.d(todaySettlementSummaryCardModel, "modelData");
        return new OnlineSettlementCardSummaryAdapteerModel(todaySettlementSummaryCardModel);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof OnlineSettlementCardSummaryAdapteerModel) && k.a((Object) this.modelData, (Object) ((OnlineSettlementCardSummaryAdapteerModel) obj).modelData);
        }
        return true;
    }

    public final int hashCode() {
        TodaySettlementSummaryCardModel todaySettlementSummaryCardModel = this.modelData;
        if (todaySettlementSummaryCardModel != null) {
            return todaySettlementSummaryCardModel.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "OnlineSettlementCardSummaryAdapteerModel(modelData=" + this.modelData + ")";
    }

    public OnlineSettlementCardSummaryAdapteerModel(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel) {
        k.d(todaySettlementSummaryCardModel, "modelData");
        this.modelData = todaySettlementSummaryCardModel;
    }

    public final TodaySettlementSummaryCardModel getModelData() {
        return this.modelData;
    }

    public final void setModelData(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel) {
        k.d(todaySettlementSummaryCardModel, "<set-?>");
        this.modelData = todaySettlementSummaryCardModel;
    }
}
