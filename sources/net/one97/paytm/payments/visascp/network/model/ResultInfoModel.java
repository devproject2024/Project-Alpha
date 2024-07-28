package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class ResultInfoModel extends BaseModel {
    @c(a = "resultCode")
    private String mResultCode;
    @c(a = "resultMsg")
    private String mResultMsg;
    @c(a = "resultStatus")
    private String mResultStatus;

    public String getResultStatus() {
        return this.mResultStatus;
    }

    public String getResultCode() {
        return this.mResultCode;
    }

    public String getResultMsg() {
        return this.mResultMsg;
    }
}
