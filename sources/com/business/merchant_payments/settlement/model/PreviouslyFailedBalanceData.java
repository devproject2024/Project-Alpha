package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class PreviouslyFailedBalanceData {
    @c(a = "failedAmount")
    public AmountModel amountModel;
    @c(a = "date")
    public String date;

    public static /* synthetic */ PreviouslyFailedBalanceData copy$default(PreviouslyFailedBalanceData previouslyFailedBalanceData, String str, AmountModel amountModel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = previouslyFailedBalanceData.date;
        }
        if ((i2 & 2) != 0) {
            amountModel2 = previouslyFailedBalanceData.amountModel;
        }
        return previouslyFailedBalanceData.copy(str, amountModel2);
    }

    public final String component1() {
        return this.date;
    }

    public final AmountModel component2() {
        return this.amountModel;
    }

    public final PreviouslyFailedBalanceData copy(String str, AmountModel amountModel2) {
        k.d(amountModel2, "amountModel");
        return new PreviouslyFailedBalanceData(str, amountModel2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviouslyFailedBalanceData)) {
            return false;
        }
        PreviouslyFailedBalanceData previouslyFailedBalanceData = (PreviouslyFailedBalanceData) obj;
        return k.a((Object) this.date, (Object) previouslyFailedBalanceData.date) && k.a((Object) this.amountModel, (Object) previouslyFailedBalanceData.amountModel);
    }

    public final int hashCode() {
        String str = this.date;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AmountModel amountModel2 = this.amountModel;
        if (amountModel2 != null) {
            i2 = amountModel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "PreviouslyFailedBalanceData(date=" + this.date + ", amountModel=" + this.amountModel + ")";
    }

    public PreviouslyFailedBalanceData(String str, AmountModel amountModel2) {
        k.d(amountModel2, "amountModel");
        this.date = str;
        this.amountModel = amountModel2;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final AmountModel getAmountModel() {
        return this.amountModel;
    }

    public final void setAmountModel(AmountModel amountModel2) {
        k.d(amountModel2, "<set-?>");
        this.amountModel = amountModel2;
    }
}
