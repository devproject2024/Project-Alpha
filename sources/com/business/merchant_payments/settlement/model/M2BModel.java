package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class M2BModel {
    @c(a = "orderList")
    public ArrayList<M2BOrderListItemModel> orderList;
    @c(a = "pageNum")
    public String pageNum;
    @c(a = "pageSize")
    public String pageSize;
    @c(a = "resultInfo")
    public SettlementResultInfoModel resultInfo;

    public static /* synthetic */ M2BModel copy$default(M2BModel m2BModel, ArrayList<M2BOrderListItemModel> arrayList, String str, String str2, SettlementResultInfoModel settlementResultInfoModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = m2BModel.orderList;
        }
        if ((i2 & 2) != 0) {
            str = m2BModel.pageNum;
        }
        if ((i2 & 4) != 0) {
            str2 = m2BModel.pageSize;
        }
        if ((i2 & 8) != 0) {
            settlementResultInfoModel = m2BModel.resultInfo;
        }
        return m2BModel.copy(arrayList, str, str2, settlementResultInfoModel);
    }

    public final ArrayList<M2BOrderListItemModel> component1() {
        return this.orderList;
    }

    public final String component2() {
        return this.pageNum;
    }

    public final String component3() {
        return this.pageSize;
    }

    public final SettlementResultInfoModel component4() {
        return this.resultInfo;
    }

    public final M2BModel copy(ArrayList<M2BOrderListItemModel> arrayList, String str, String str2, SettlementResultInfoModel settlementResultInfoModel) {
        return new M2BModel(arrayList, str, str2, settlementResultInfoModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M2BModel)) {
            return false;
        }
        M2BModel m2BModel = (M2BModel) obj;
        return k.a((Object) this.orderList, (Object) m2BModel.orderList) && k.a((Object) this.pageNum, (Object) m2BModel.pageNum) && k.a((Object) this.pageSize, (Object) m2BModel.pageSize) && k.a((Object) this.resultInfo, (Object) m2BModel.resultInfo);
    }

    public final int hashCode() {
        ArrayList<M2BOrderListItemModel> arrayList = this.orderList;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        String str = this.pageNum;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.pageSize;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        SettlementResultInfoModel settlementResultInfoModel = this.resultInfo;
        if (settlementResultInfoModel != null) {
            i2 = settlementResultInfoModel.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "M2BModel(orderList=" + this.orderList + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", resultInfo=" + this.resultInfo + ")";
    }

    public M2BModel(ArrayList<M2BOrderListItemModel> arrayList, String str, String str2, SettlementResultInfoModel settlementResultInfoModel) {
        this.orderList = arrayList;
        this.pageNum = str;
        this.pageSize = str2;
        this.resultInfo = settlementResultInfoModel;
    }

    public final ArrayList<M2BOrderListItemModel> getOrderList() {
        return this.orderList;
    }

    public final void setOrderList(ArrayList<M2BOrderListItemModel> arrayList) {
        this.orderList = arrayList;
    }

    public final String getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(String str) {
        this.pageNum = str;
    }

    public final String getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(String str) {
        this.pageSize = str;
    }

    public final SettlementResultInfoModel getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(SettlementResultInfoModel settlementResultInfoModel) {
        this.resultInfo = settlementResultInfoModel;
    }
}
