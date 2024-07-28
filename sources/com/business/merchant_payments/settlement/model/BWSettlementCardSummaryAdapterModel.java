package com.business.merchant_payments.settlement.model;

import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BWSettlementCardSummaryAdapterModel {
    public ArrayList<M2BOrderListItemModel> alreadySettledData;
    public boolean isAlreadySettledExpanded;
    public boolean isInstantSettled;
    public boolean isPendingSettledListExpanded;
    public TodaySettlementSummaryCardModel modelData;
    public ArrayList<M2BOrderListItemModel> pendingToBeSettledData;
    public boolean shouldShowSettlementToolTip;

    public static /* synthetic */ BWSettlementCardSummaryAdapterModel copy$default(BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel, TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, boolean z, boolean z2, ArrayList<M2BOrderListItemModel> arrayList, boolean z3, ArrayList<M2BOrderListItemModel> arrayList2, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            todaySettlementSummaryCardModel = bWSettlementCardSummaryAdapterModel.modelData;
        }
        if ((i2 & 2) != 0) {
            z = bWSettlementCardSummaryAdapterModel.shouldShowSettlementToolTip;
        }
        boolean z5 = z;
        if ((i2 & 4) != 0) {
            z2 = bWSettlementCardSummaryAdapterModel.isInstantSettled;
        }
        boolean z6 = z2;
        if ((i2 & 8) != 0) {
            arrayList = bWSettlementCardSummaryAdapterModel.alreadySettledData;
        }
        ArrayList<M2BOrderListItemModel> arrayList3 = arrayList;
        if ((i2 & 16) != 0) {
            z3 = bWSettlementCardSummaryAdapterModel.isAlreadySettledExpanded;
        }
        boolean z7 = z3;
        if ((i2 & 32) != 0) {
            arrayList2 = bWSettlementCardSummaryAdapterModel.pendingToBeSettledData;
        }
        ArrayList<M2BOrderListItemModel> arrayList4 = arrayList2;
        if ((i2 & 64) != 0) {
            z4 = bWSettlementCardSummaryAdapterModel.isPendingSettledListExpanded;
        }
        return bWSettlementCardSummaryAdapterModel.copy(todaySettlementSummaryCardModel, z5, z6, arrayList3, z7, arrayList4, z4);
    }

    public final TodaySettlementSummaryCardModel component1() {
        return this.modelData;
    }

    public final boolean component2() {
        return this.shouldShowSettlementToolTip;
    }

    public final boolean component3() {
        return this.isInstantSettled;
    }

    public final ArrayList<M2BOrderListItemModel> component4() {
        return this.alreadySettledData;
    }

    public final boolean component5() {
        return this.isAlreadySettledExpanded;
    }

    public final ArrayList<M2BOrderListItemModel> component6() {
        return this.pendingToBeSettledData;
    }

    public final boolean component7() {
        return this.isPendingSettledListExpanded;
    }

    public final BWSettlementCardSummaryAdapterModel copy(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, boolean z, boolean z2, ArrayList<M2BOrderListItemModel> arrayList, boolean z3, ArrayList<M2BOrderListItemModel> arrayList2, boolean z4) {
        k.d(todaySettlementSummaryCardModel, "modelData");
        return new BWSettlementCardSummaryAdapterModel(todaySettlementSummaryCardModel, z, z2, arrayList, z3, arrayList2, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BWSettlementCardSummaryAdapterModel)) {
            return false;
        }
        BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel = (BWSettlementCardSummaryAdapterModel) obj;
        return k.a((Object) this.modelData, (Object) bWSettlementCardSummaryAdapterModel.modelData) && this.shouldShowSettlementToolTip == bWSettlementCardSummaryAdapterModel.shouldShowSettlementToolTip && this.isInstantSettled == bWSettlementCardSummaryAdapterModel.isInstantSettled && k.a((Object) this.alreadySettledData, (Object) bWSettlementCardSummaryAdapterModel.alreadySettledData) && this.isAlreadySettledExpanded == bWSettlementCardSummaryAdapterModel.isAlreadySettledExpanded && k.a((Object) this.pendingToBeSettledData, (Object) bWSettlementCardSummaryAdapterModel.pendingToBeSettledData) && this.isPendingSettledListExpanded == bWSettlementCardSummaryAdapterModel.isPendingSettledListExpanded;
    }

    public final int hashCode() {
        TodaySettlementSummaryCardModel todaySettlementSummaryCardModel = this.modelData;
        int i2 = 0;
        int hashCode = (todaySettlementSummaryCardModel != null ? todaySettlementSummaryCardModel.hashCode() : 0) * 31;
        boolean z = this.shouldShowSettlementToolTip;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.isInstantSettled;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        ArrayList<M2BOrderListItemModel> arrayList = this.alreadySettledData;
        int hashCode2 = (i4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z3 = this.isAlreadySettledExpanded;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode2 + (z3 ? 1 : 0)) * 31;
        ArrayList<M2BOrderListItemModel> arrayList2 = this.pendingToBeSettledData;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        int i6 = (i5 + i2) * 31;
        boolean z4 = this.isPendingSettledListExpanded;
        if (z4) {
            z4 = true;
        }
        return i6 + (z4 ? 1 : 0);
    }

    public final String toString() {
        return "BWSettlementCardSummaryAdapterModel(modelData=" + this.modelData + ", shouldShowSettlementToolTip=" + this.shouldShowSettlementToolTip + ", isInstantSettled=" + this.isInstantSettled + ", alreadySettledData=" + this.alreadySettledData + ", isAlreadySettledExpanded=" + this.isAlreadySettledExpanded + ", pendingToBeSettledData=" + this.pendingToBeSettledData + ", isPendingSettledListExpanded=" + this.isPendingSettledListExpanded + ")";
    }

    public BWSettlementCardSummaryAdapterModel(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, boolean z, boolean z2, ArrayList<M2BOrderListItemModel> arrayList, boolean z3, ArrayList<M2BOrderListItemModel> arrayList2, boolean z4) {
        k.d(todaySettlementSummaryCardModel, "modelData");
        this.modelData = todaySettlementSummaryCardModel;
        this.shouldShowSettlementToolTip = z;
        this.isInstantSettled = z2;
        this.alreadySettledData = arrayList;
        this.isAlreadySettledExpanded = z3;
        this.pendingToBeSettledData = arrayList2;
        this.isPendingSettledListExpanded = z4;
    }

    public final TodaySettlementSummaryCardModel getModelData() {
        return this.modelData;
    }

    public final void setModelData(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel) {
        k.d(todaySettlementSummaryCardModel, "<set-?>");
        this.modelData = todaySettlementSummaryCardModel;
    }

    public final boolean getShouldShowSettlementToolTip() {
        return this.shouldShowSettlementToolTip;
    }

    public final void setShouldShowSettlementToolTip(boolean z) {
        this.shouldShowSettlementToolTip = z;
    }

    public final boolean isInstantSettled() {
        return this.isInstantSettled;
    }

    public final void setInstantSettled(boolean z) {
        this.isInstantSettled = z;
    }

    public final ArrayList<M2BOrderListItemModel> getAlreadySettledData() {
        return this.alreadySettledData;
    }

    public final void setAlreadySettledData(ArrayList<M2BOrderListItemModel> arrayList) {
        this.alreadySettledData = arrayList;
    }

    public final boolean isAlreadySettledExpanded() {
        return this.isAlreadySettledExpanded;
    }

    public final void setAlreadySettledExpanded(boolean z) {
        this.isAlreadySettledExpanded = z;
    }

    public final ArrayList<M2BOrderListItemModel> getPendingToBeSettledData() {
        return this.pendingToBeSettledData;
    }

    public final void setPendingToBeSettledData(ArrayList<M2BOrderListItemModel> arrayList) {
        this.pendingToBeSettledData = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BWSettlementCardSummaryAdapterModel(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, boolean z, boolean z2, ArrayList arrayList, boolean z3, ArrayList arrayList2, boolean z4, int i2, g gVar) {
        this(todaySettlementSummaryCardModel, z, z2, (i2 & 8) != 0 ? null : arrayList, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? null : arrayList2, (i2 & 64) != 0 ? false : z4);
    }

    public final boolean isPendingSettledListExpanded() {
        return this.isPendingSettledListExpanded;
    }

    public final void setPendingSettledListExpanded(boolean z) {
        this.isPendingSettledListExpanded = z;
    }
}
