package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class ResultInfo implements BaseDataModel {
    @c(a = "resultCode")
    @a
    private String resultCode;
    @c(a = "resultMsg")
    @a
    private String resultMsg;
    @c(a = "resultStatus")
    @a
    private String resultStatus;

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
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
