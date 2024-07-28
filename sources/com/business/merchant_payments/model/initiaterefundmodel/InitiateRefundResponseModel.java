package com.business.merchant_payments.model.initiaterefundmodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;

public class InitiateRefundResponseModel extends BaseModel {
    @c(a = "metadata")
    public Object metadata;
    @c(a = "orderId")
    public String orderId;
    @c(a = "requestGuid")
    public Object requestGuid;
    @c(a = "response")
    public InitiateRefundResponse response;
    @c(a = "status")
    public String status;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public String statusMessage;
    @c(a = "type")
    public Object type;

    public Object getType() {
        return this.type;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public Object getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(Object obj) {
        this.requestGuid = obj;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
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

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public InitiateRefundResponse getResponse() {
        return this.response;
    }

    public void setResponse(InitiateRefundResponse initiateRefundResponse) {
        this.response = initiateRefundResponse;
    }

    public Object getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Object obj) {
        this.metadata = obj;
    }
}
