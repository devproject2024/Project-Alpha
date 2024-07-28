package com.business.merchant_payments.model.transaction_charges;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Commission {
    @c(a = "commissionTypeBoth")
    @a
    public Boolean commissionTypeBoth;
    @c(a = "endRange")
    @a
    public String endRange;
    @c(a = "flatCommission")
    @a
    public String flatCommission;
    @c(a = "percentCommission")
    @a
    public String percentCommission;
    @c(a = "startRange")
    @a
    public String startRange;

    public String getStartRange() {
        return this.startRange;
    }

    public void setStartRange(String str) {
        this.startRange = str;
    }

    public String getEndRange() {
        return this.endRange;
    }

    public void setEndRange(String str) {
        this.endRange = str;
    }

    public String getFlatCommission() {
        return this.flatCommission;
    }

    public void setFlatCommission(String str) {
        this.flatCommission = str;
    }

    public String getPercentCommission() {
        return this.percentCommission;
    }

    public void setPercentCommission(String str) {
        this.percentCommission = str;
    }

    public Boolean getCommissionTypeBoth() {
        return this.commissionTypeBoth;
    }

    public void setCommissionTypeBoth(Boolean bool) {
        this.commissionTypeBoth = bool;
    }
}
