package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;

public final class CJRImpsRefundResultInfo {
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "resultCodeId")
    private String resultCodeId;
    @b(a = "resultMsg")
    private String resultMsg;
    @b(a = "resultStatus")
    private String resultStatus;

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
