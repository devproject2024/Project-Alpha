package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Bank {
    @c(a = "bank")
    @a
    public String bank;
    @c(a = "commissionDetails")
    @a
    public CommissionDetails commissionDetails;

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public CommissionDetails getCommissionDetails() {
        return this.commissionDetails;
    }

    public void setCommissionDetails(CommissionDetails commissionDetails2) {
        this.commissionDetails = commissionDetails2;
    }
}
