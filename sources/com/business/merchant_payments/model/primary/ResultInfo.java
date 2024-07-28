package com.business.merchant_payments.model.primary;

import com.google.gson.a.a;
import com.google.gson.a.c;

public final class ResultInfo {
    @c(a = "resultCode")
    @a
    public String resultCode;
    @c(a = "resultCodeId")
    @a
    public String resultCodeId;
    @c(a = "resultMsg")
    @a
    public String resultMsg;
    @c(a = "resultStatus")
    @a
    public String resultStatus;

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
