package com.business.merchant_payments.model.primary;

import com.google.gson.a.a;
import com.google.gson.a.c;

public final class RewardsBalance {
    @c(a = "activeBalance")
    @a
    public String activeBalance;
    @c(a = "exchangeRate")
    @a
    public String exchangeRate;
    @c(a = "result")
    @a
    public ResultInfo result;

    public final ResultInfo getResult() {
        return this.result;
    }

    public final void setResult(ResultInfo resultInfo) {
        this.result = resultInfo;
    }

    public final String getActiveBalance() {
        return this.activeBalance;
    }

    public final void setActiveBalance(String str) {
        this.activeBalance = str;
    }

    public final String getExchangeRate() {
        return this.exchangeRate;
    }

    public final void setExchangeRate(String str) {
        this.exchangeRate = str;
    }
}
