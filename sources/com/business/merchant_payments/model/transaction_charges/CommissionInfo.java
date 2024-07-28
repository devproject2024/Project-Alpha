package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class CommissionInfo {
    @c(a = "banks")
    @a
    public List<Bank> banks = null;
    @c(a = "commissionDetails")
    @a
    public CommissionDetails commissionDetails;
    @c(a = "tieredEnd")
    @a
    public Double tieredEnd;
    @c(a = "tieredStart")
    @a
    public Double tieredStart;

    public CommissionInfo() {
        Double valueOf = Double.valueOf(-1.0d);
        this.tieredStart = valueOf;
        this.tieredEnd = valueOf;
    }

    public Double getTieredStart() {
        return this.tieredStart;
    }

    public void setTieredStart(Double d2) {
        this.tieredStart = d2;
    }

    public Double getTieredEnd() {
        return this.tieredEnd;
    }

    public void setTieredEnd(Double d2) {
        this.tieredEnd = d2;
    }

    public CommissionDetails getCommissionDetails() {
        return this.commissionDetails;
    }

    public void setCommissionDetails(CommissionDetails commissionDetails2) {
        this.commissionDetails = commissionDetails2;
    }

    public List<Bank> getBanks() {
        return this.banks;
    }

    public void setBanks(List<Bank> list) {
        this.banks = list;
    }
}
