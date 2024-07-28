package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRResultInfo extends IJRPaytmDataModel {
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "resultCodeId")
    private String resultCodeId;
    @b(a = "resultMsg")
    private String resultMsg;
    @b(a = "resultStatus")
    private String resultStatus;

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String getResultCodeId() {
        return this.resultCodeId;
    }

    public void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
