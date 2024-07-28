package com.business.merchant_payments.model.qrsummarymodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;

public class GeneratedNewQRItem extends BaseModel {
    @c(a = "upiHandle")
    public String deepLink;
    @c(a = "encryptedData")
    public String encryptedData;
    @c(a = "orderId")
    public String orderId;
    @c(a = "qrPath")
    public String qrPath;
    @c(a = "requestGuid")
    public String requestGuid;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public String statusMessage;

    public String getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
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

    public String getQrPath() {
        return this.qrPath;
    }

    public void setQrPath(String str) {
        this.qrPath = str;
    }

    public String getEncryptedData() {
        return this.encryptedData;
    }

    public void setEncryptedData(String str) {
        this.encryptedData = str;
    }

    public String getDeepLink() {
        return this.deepLink;
    }
}
