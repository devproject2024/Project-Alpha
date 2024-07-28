package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ResultInfo extends IJRPaytmDataModel {
    @a
    @b(a = "resultCode")
    private String resultCode;
    @a
    @b(a = "resultCodeId")
    private String resultCodeId;
    @a
    @b(a = "resultMsg")
    private String resultMsg;
    @a
    @b(a = "resultStatus")
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

    public String getResultCodeId() {
        return this.resultCodeId;
    }

    public void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
