package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRError extends IJRPaytmDataModel {
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private String mMessage;
    @b(a = "params")
    private String mParams;
    @b(a = "type")
    private String mType;

    public enum TypeEnum {
        KYC,
        OAUTH,
        CBS,
        DCMS,
        PG,
        TandC
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getParams() {
        return this.mParams;
    }

    public void setParams(String str) {
        this.mParams = str;
    }
}
