package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRErrorStatus extends IJRPaytmDataModel {
    @b(a = "message")
    private CJRMessageFormat message;
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public CJRMessageFormat getMessage() {
        return this.message;
    }

    public void setMessage(CJRMessageFormat cJRMessageFormat) {
        this.message = cJRMessageFormat;
    }
}
