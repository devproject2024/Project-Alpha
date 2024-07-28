package com.business.merchant_payments.settlement.model;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class UTRMainModel extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "response")
    public UTRResponse UTRResponse;
    public String mEndDate;
    public String mStartDate;
    @c(a = "results")
    public List<UTRResult> results;
    @c(a = "settlementBillList")
    @a
    public List<SettlementBills> settlementBillsList;
    @c(a = "status")
    public String status;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public Object statusMessage;

    public List<SettlementBills> getSettlementBillsList() {
        return this.settlementBillsList;
    }

    public String getmStartDate() {
        return this.mStartDate;
    }

    public void setmStartDate(String str) {
        this.mStartDate = str;
    }

    public String getmEndDate() {
        return this.mEndDate;
    }

    public void setmEndDate(String str) {
        this.mEndDate = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public Object getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(Object obj) {
        this.statusMessage = obj;
    }

    public UTRResponse getUTRResponse() {
        if (this.UTRResponse == null && this.results != null) {
            UTRResponse uTRResponse = new UTRResponse();
            this.UTRResponse = uTRResponse;
            uTRResponse.setUTRResult(this.results);
        }
        return this.UTRResponse;
    }

    public void setUTRResponse(UTRResponse uTRResponse) {
        this.UTRResponse = uTRResponse;
    }
}
