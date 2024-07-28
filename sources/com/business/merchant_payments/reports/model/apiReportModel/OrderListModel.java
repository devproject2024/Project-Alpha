package com.business.merchant_payments.reports.model.apiReportModel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;

public final class OrderListModel extends BaseModel {
    @c(a = "downloadId")
    @a
    public String downloadId;
    @c(a = "resultInfo")
    @a
    public com.paytm.business.a.a.a.a resultInfo;
    @c(a = "status")
    @a
    public String status;
    @c(a = "statusMessage")
    @a
    public String statusMessage;

    public final String getDownloadId() {
        return this.downloadId;
    }

    public final void setDownloadId(String str) {
        this.downloadId = str;
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
