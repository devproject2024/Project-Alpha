package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class Instrument {
    @c(a = "banks")
    @a
    public List<Bank> banks = null;
    @c(a = "commissionDetails")
    @a
    public CommissionDetails commissionDetails;
    @c(a = "commissionInfo")
    @a
    public List<CommissionInfo> commissionInfos;
    @c(a = "isActive")
    @a
    public boolean isActive;
    @c(a = "payMode")
    @a
    public String payMode;

    public String getPayMode() {
        return this.payMode;
    }

    public void setPayMode(String str) {
        this.payMode = str;
    }

    public CommissionDetails getCommissionDetails() {
        return this.commissionDetails;
    }

    public void setCommissionDetails(CommissionDetails commissionDetails2) {
        this.commissionDetails = commissionDetails2;
    }

    public List<CommissionInfo> getCommissionInfo() {
        return this.commissionInfos;
    }

    public void setCommissionInfo(List<CommissionInfo> list) {
        this.commissionInfos = list;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }
}
