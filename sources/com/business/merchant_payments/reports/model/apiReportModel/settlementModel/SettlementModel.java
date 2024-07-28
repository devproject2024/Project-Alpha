package com.business.merchant_payments.reports.model.apiReportModel.settlementModel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;

public final class SettlementModel extends BaseModel {
    @c(a = "ipRoleId")
    @a
    public String ipRoleId;
    @c(a = "resultInfo")
    @a
    public com.paytm.business.a.a.a.a resultInfo;
    @c(a = "status")
    @a
    public String status;
    @c(a = "statusMessage")
    @a
    public String statusMessage;

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final com.paytm.business.a.a.a.a getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(com.paytm.business.a.a.a.a aVar) {
        this.resultInfo = aVar;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }
}
