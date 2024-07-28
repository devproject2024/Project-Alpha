package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class SettlementBillListModel {
    @c(a = "merchantSettlementStatus")
    public String merchantSettlementStatus;
    @c(a = "resultInfo")
    public SettlementResultInfoModel resultInfo;
    @c(a = "settlementBillList")
    public ArrayList<SettlementBillListItemModel> settlementBillList;

    public static /* synthetic */ SettlementBillListModel copy$default(SettlementBillListModel settlementBillListModel, SettlementResultInfoModel settlementResultInfoModel, String str, ArrayList<SettlementBillListItemModel> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            settlementResultInfoModel = settlementBillListModel.resultInfo;
        }
        if ((i2 & 2) != 0) {
            str = settlementBillListModel.merchantSettlementStatus;
        }
        if ((i2 & 4) != 0) {
            arrayList = settlementBillListModel.settlementBillList;
        }
        return settlementBillListModel.copy(settlementResultInfoModel, str, arrayList);
    }

    public final SettlementResultInfoModel component1() {
        return this.resultInfo;
    }

    public final String component2() {
        return this.merchantSettlementStatus;
    }

    public final ArrayList<SettlementBillListItemModel> component3() {
        return this.settlementBillList;
    }

    public final SettlementBillListModel copy(SettlementResultInfoModel settlementResultInfoModel, String str, ArrayList<SettlementBillListItemModel> arrayList) {
        return new SettlementBillListModel(settlementResultInfoModel, str, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementBillListModel)) {
            return false;
        }
        SettlementBillListModel settlementBillListModel = (SettlementBillListModel) obj;
        return k.a((Object) this.resultInfo, (Object) settlementBillListModel.resultInfo) && k.a((Object) this.merchantSettlementStatus, (Object) settlementBillListModel.merchantSettlementStatus) && k.a((Object) this.settlementBillList, (Object) settlementBillListModel.settlementBillList);
    }

    public final int hashCode() {
        SettlementResultInfoModel settlementResultInfoModel = this.resultInfo;
        int i2 = 0;
        int hashCode = (settlementResultInfoModel != null ? settlementResultInfoModel.hashCode() : 0) * 31;
        String str = this.merchantSettlementStatus;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ArrayList<SettlementBillListItemModel> arrayList = this.settlementBillList;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SettlementBillListModel(resultInfo=" + this.resultInfo + ", merchantSettlementStatus=" + this.merchantSettlementStatus + ", settlementBillList=" + this.settlementBillList + ")";
    }

    public SettlementBillListModel(SettlementResultInfoModel settlementResultInfoModel, String str, ArrayList<SettlementBillListItemModel> arrayList) {
        this.resultInfo = settlementResultInfoModel;
        this.merchantSettlementStatus = str;
        this.settlementBillList = arrayList;
    }

    public final SettlementResultInfoModel getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(SettlementResultInfoModel settlementResultInfoModel) {
        this.resultInfo = settlementResultInfoModel;
    }

    public final String getMerchantSettlementStatus() {
        return this.merchantSettlementStatus;
    }

    public final void setMerchantSettlementStatus(String str) {
        this.merchantSettlementStatus = str;
    }

    public final ArrayList<SettlementBillListItemModel> getSettlementBillList() {
        return this.settlementBillList;
    }

    public final void setSettlementBillList(ArrayList<SettlementBillListItemModel> arrayList) {
        this.settlementBillList = arrayList;
    }
}
