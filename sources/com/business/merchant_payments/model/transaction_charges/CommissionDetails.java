package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class CommissionDetails {
    @c(a = "commissions")
    @a
    public List<Commission> commissions = null;
    @c(a = "feeType")
    @a
    public String feeType;

    public String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(String str) {
        this.feeType = str;
    }

    public List<Commission> getCommissions() {
        return this.commissions;
    }

    public void setCommissions(List<Commission> list) {
        this.commissions = list;
    }
}
