package com.business.merchant_payments.settlement.model;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class UTRResponse extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "result")
    public List<UTRResult> UTRResult = null;
    @c(a = "amount")
    @a
    public double amount;
    @c(a = "count")
    @a
    public long count;
    @c(a = "dashboardSummaryResponseObject")
    @a
    public DashboardSummaryResponseObject dashboardSummaryResponseObject;

    public DashboardSummaryResponseObject getDashboardSummaryResponseObject() {
        return this.dashboardSummaryResponseObject;
    }

    public void setDashboardSummaryResponseObject(DashboardSummaryResponseObject dashboardSummaryResponseObject2) {
        this.dashboardSummaryResponseObject = dashboardSummaryResponseObject2;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double d2) {
        this.amount = d2;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long j) {
        this.count = j;
    }

    public List<UTRResult> getUTRResult() {
        return this.UTRResult;
    }

    public void setUTRResult(List<UTRResult> list) {
        this.UTRResult = list;
    }
}
