package com.business.merchant_payments.model.paymentdaterangesummery;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public final class AggregateTxnDetails extends a {
    public String dayText;
    @c(a = "response")
    public AggregateTxnDetailsRespose mAggregateResponse;
    @c(a = "orderId")
    public String mOrderID;
    @c(a = "requestGuid")
    public String mRequestGUID;
    @c(a = "status")
    public String mStatus;
    @c(a = "statusCode")
    public String mStatusCode;
    @c(a = "statusMessage")
    public String mStatusMessage;
    public final ResultInfo resultInfo;
    public final PayMoneyAmount totalAmount;
    public final String totalCount;

    public final String getMRequestGUID() {
        return this.mRequestGUID;
    }

    public final void setMRequestGUID(String str) {
        this.mRequestGUID = str;
    }

    public final String getMOrderID() {
        return this.mOrderID;
    }

    public final void setMOrderID(String str) {
        this.mOrderID = str;
    }

    public final String getMStatus() {
        return this.mStatus;
    }

    public final void setMStatus(String str) {
        this.mStatus = str;
    }

    public final String getMStatusCode() {
        return this.mStatusCode;
    }

    public final void setMStatusCode(String str) {
        this.mStatusCode = str;
    }

    public final String getMStatusMessage() {
        return this.mStatusMessage;
    }

    public final void setMStatusMessage(String str) {
        this.mStatusMessage = str;
    }

    public final AggregateTxnDetailsRespose getMAggregateResponse() {
        return this.mAggregateResponse;
    }

    public final void setMAggregateResponse(AggregateTxnDetailsRespose aggregateTxnDetailsRespose) {
        this.mAggregateResponse = aggregateTxnDetailsRespose;
    }

    public final String getDayText() {
        return this.dayText;
    }

    public final void setDayText(String str) {
        this.dayText = str;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final PayMoneyAmount getTotalAmount() {
        return this.totalAmount;
    }
}
