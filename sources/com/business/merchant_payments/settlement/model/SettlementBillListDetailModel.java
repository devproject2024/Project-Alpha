package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class SettlementBillListDetailModel {
    @c(a = "amountDetails")
    public SettlementAmountDetailsModel amountDetails;
    @c(a = "m2b")
    public M2BModel m2b;

    public static /* synthetic */ SettlementBillListDetailModel copy$default(SettlementBillListDetailModel settlementBillListDetailModel, M2BModel m2BModel, SettlementAmountDetailsModel settlementAmountDetailsModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            m2BModel = settlementBillListDetailModel.m2b;
        }
        if ((i2 & 2) != 0) {
            settlementAmountDetailsModel = settlementBillListDetailModel.amountDetails;
        }
        return settlementBillListDetailModel.copy(m2BModel, settlementAmountDetailsModel);
    }

    public final M2BModel component1() {
        return this.m2b;
    }

    public final SettlementAmountDetailsModel component2() {
        return this.amountDetails;
    }

    public final SettlementBillListDetailModel copy(M2BModel m2BModel, SettlementAmountDetailsModel settlementAmountDetailsModel) {
        return new SettlementBillListDetailModel(m2BModel, settlementAmountDetailsModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementBillListDetailModel)) {
            return false;
        }
        SettlementBillListDetailModel settlementBillListDetailModel = (SettlementBillListDetailModel) obj;
        return k.a((Object) this.m2b, (Object) settlementBillListDetailModel.m2b) && k.a((Object) this.amountDetails, (Object) settlementBillListDetailModel.amountDetails);
    }

    public final int hashCode() {
        M2BModel m2BModel = this.m2b;
        int i2 = 0;
        int hashCode = (m2BModel != null ? m2BModel.hashCode() : 0) * 31;
        SettlementAmountDetailsModel settlementAmountDetailsModel = this.amountDetails;
        if (settlementAmountDetailsModel != null) {
            i2 = settlementAmountDetailsModel.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SettlementBillListDetailModel(m2b=" + this.m2b + ", amountDetails=" + this.amountDetails + ")";
    }

    public SettlementBillListDetailModel(M2BModel m2BModel, SettlementAmountDetailsModel settlementAmountDetailsModel) {
        this.m2b = m2BModel;
        this.amountDetails = settlementAmountDetailsModel;
    }

    public final M2BModel getM2b() {
        return this.m2b;
    }

    public final void setM2b(M2BModel m2BModel) {
        this.m2b = m2BModel;
    }

    public final SettlementAmountDetailsModel getAmountDetails() {
        return this.amountDetails;
    }

    public final void setAmountDetails(SettlementAmountDetailsModel settlementAmountDetailsModel) {
        this.amountDetails = settlementAmountDetailsModel;
    }
}
