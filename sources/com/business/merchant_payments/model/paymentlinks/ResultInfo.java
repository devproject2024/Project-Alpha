package com.business.merchant_payments.model.paymentlinks;

import com.google.gson.a.c;

public class ResultInfo {
    @c(a = "resultCode")
    public String resultCode;
    @c(a = "resultCodeId")
    public String resultCodeId;
    @c(a = "resultMsg")
    public String resultMsg;
    @c(a = "resultStatus")
    public String resultStatus;

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public String getResultCodeId() {
        return this.resultCodeId;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public String toString() {
        return "ResultInfo{resultStatus = '" + this.resultStatus + '\'' + ",resultCode = '" + this.resultCode + '\'' + ",resultCodeId = '" + this.resultCodeId + '\'' + ",resultMsg = '" + this.resultMsg + '\'' + "}";
    }
}
