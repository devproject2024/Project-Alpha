package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCartStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private CJRError mMessage;
    @b(a = "result")
    private String mResult;

    public void setmResult(String str) {
        this.mResult = str;
    }

    public String getResult() {
        return this.mResult;
    }

    public CJRError getMessage() {
        return this.mMessage;
    }

    public String getCode() {
        return this.mCode;
    }
}
