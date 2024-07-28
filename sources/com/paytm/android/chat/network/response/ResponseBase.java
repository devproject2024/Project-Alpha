package com.paytm.android.chat.network.response;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class ResponseBase implements Serializable {
    @b(a = "resultCode")
    private String mResultCode;
    @b(a = "resultMessage")
    private String mResultMessage;
    @b(a = "success")
    private boolean mSuccess;

    public String getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode(String str) {
        this.mResultCode = str;
    }

    public String getResultMessage() {
        return this.mResultMessage;
    }

    public void setResultMessage(String str) {
        this.mResultMessage = str;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public void setSuccess(boolean z) {
        this.mSuccess = z;
    }

    public String toString() {
        return "ResponseBase{mResultCode=" + this.mResultCode + ", mResultMessage=" + this.mResultMessage + ", mSuccess=" + this.mSuccess + '}';
    }
}
