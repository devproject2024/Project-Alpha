package com.business.merchant_payments.model.primary;

import com.google.gson.a.a;
import com.google.gson.a.c;

public final class OrderSummary {
    @c(a = "ipRoleId")
    @a
    public String ipRoleId;
    @c(a = "resultInfo")
    @a
    public ResultInfo resultInfo;
    @c(a = "totalAmount")
    @a
    public TotalAmount totalAmount;
    @c(a = "totalCount")
    @a
    public String totalCount;

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final TotalAmount getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(TotalAmount totalAmount2) {
        this.totalAmount = totalAmount2;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(String str) {
        this.totalCount = str;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }
}
