package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderCancel extends IJRPaytmDataModel {
    @b(a = "code")
    private int mCode;
    @b(a = "error")
    private String mError;
    @b(a = "message")
    String mMessage;
    @b(a = "status")
    private CJRStatus mStatus;
    @b(a = "statusCode")
    int mStatusCode;

    public int getmStatusCode() {
        return this.mStatusCode;
    }

    public void setmStatusCode(int i2) {
        this.mStatusCode = i2;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(String str) {
        this.mMessage = str;
    }

    public int getmCode() {
        return this.mCode;
    }

    public void setmCode(int i2) {
        this.mCode = i2;
    }

    public String getmError() {
        return this.mError;
    }

    public void setmError(String str) {
        this.mError = str;
    }

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(CJRStatus cJRStatus) {
        this.mStatus = cJRStatus;
    }
}
