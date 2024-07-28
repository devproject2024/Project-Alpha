package com.business.merchant_payments.settlement.model;

import com.business.common_module.utilities.a.b;
import kotlin.g.b.k;

public final class BWSettlementM2BTransactionDetailObservableModel {
    public final int position;
    public final b<SettlementBillListDetailModel> wrappedData;

    public static /* synthetic */ BWSettlementM2BTransactionDetailObservableModel copy$default(BWSettlementM2BTransactionDetailObservableModel bWSettlementM2BTransactionDetailObservableModel, b<SettlementBillListDetailModel> bVar, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = bWSettlementM2BTransactionDetailObservableModel.wrappedData;
        }
        if ((i3 & 2) != 0) {
            i2 = bWSettlementM2BTransactionDetailObservableModel.position;
        }
        return bWSettlementM2BTransactionDetailObservableModel.copy(bVar, i2);
    }

    public final b<SettlementBillListDetailModel> component1() {
        return this.wrappedData;
    }

    public final int component2() {
        return this.position;
    }

    public final BWSettlementM2BTransactionDetailObservableModel copy(b<SettlementBillListDetailModel> bVar, int i2) {
        k.d(bVar, "wrappedData");
        return new BWSettlementM2BTransactionDetailObservableModel(bVar, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BWSettlementM2BTransactionDetailObservableModel)) {
            return false;
        }
        BWSettlementM2BTransactionDetailObservableModel bWSettlementM2BTransactionDetailObservableModel = (BWSettlementM2BTransactionDetailObservableModel) obj;
        return k.a((Object) this.wrappedData, (Object) bWSettlementM2BTransactionDetailObservableModel.wrappedData) && this.position == bWSettlementM2BTransactionDetailObservableModel.position;
    }

    public final int hashCode() {
        b<SettlementBillListDetailModel> bVar = this.wrappedData;
        return ((bVar != null ? bVar.hashCode() : 0) * 31) + this.position;
    }

    public final String toString() {
        return "BWSettlementM2BTransactionDetailObservableModel(wrappedData=" + this.wrappedData + ", position=" + this.position + ")";
    }

    public BWSettlementM2BTransactionDetailObservableModel(b<SettlementBillListDetailModel> bVar, int i2) {
        k.d(bVar, "wrappedData");
        this.wrappedData = bVar;
        this.position = i2;
    }

    public final b<SettlementBillListDetailModel> getWrappedData() {
        return this.wrappedData;
    }

    public final int getPosition() {
        return this.position;
    }
}
