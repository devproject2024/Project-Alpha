package com.business.merchant_payments.settlement.model;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;

public class DashboardSummaryResponseObject extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "totalChargeBackAmount")
    @a
    public String totalChargeBackAmount;
    @c(a = "totalCollectedAmount")
    @a
    public String totalCollectedAmount;
    @c(a = "totalCommissionAmount")
    @a
    public String totalCommissionAmount;
    @c(a = "totalGstAmount")
    @a
    public String totalGstAmount;
    @c(a = "totalNetAmount")
    @a
    public String totalNetAmount;
    @c(a = "totalRefundAmount")
    @a
    public String totalRefundAmount;

    public String getTotalCollectedAmount() {
        return this.totalCollectedAmount;
    }

    public void setTotalCollectedAmount(String str) {
        this.totalCollectedAmount = str;
    }

    public String getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public void setTotalNetAmount(String str) {
        this.totalNetAmount = str;
    }

    public String getTotalChargeBackAmount() {
        return this.totalChargeBackAmount;
    }

    public void setTotalChargeBackAmount(String str) {
        this.totalChargeBackAmount = str;
    }

    public String getTotalCommissionAmount() {
        return this.totalCommissionAmount;
    }

    public void setTotalCommissionAmount(String str) {
        this.totalCommissionAmount = str;
    }

    public String getTotalGstAmount() {
        return this.totalGstAmount;
    }

    public void setTotalGstAmount(String str) {
        this.totalGstAmount = str;
    }

    public String getTotalRefundAmount() {
        return this.totalRefundAmount;
    }

    public void setTotalRefundAmount(String str) {
        this.totalRefundAmount = str;
    }

    public class GenericResponse extends BaseModel {
        public static final long serialVersionUID = 1;
        @c(a = "response")
        @a
        public Response response;
        @c(a = "status")
        @a
        public String status;

        public GenericResponse(DashboardSummaryResponseObject dashboardSummaryResponseObject) {
        }

        public Response getResponse() {
            return this.response;
        }

        public void setResponse(Response response2) {
            this.response = response2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    public class Response extends BaseModel {
        public static final long serialVersionUID = 1;
        @c(a = "amount")
        @a
        public double amount;
        @c(a = "count")
        @a
        public long count;
        @c(a = "dashboardSummaryResponseObject")
        @a
        public DashboardSummaryResponseObject dashboardSummaryResponseObject;

        public Response(DashboardSummaryResponseObject dashboardSummaryResponseObject2) {
        }

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
    }
}
