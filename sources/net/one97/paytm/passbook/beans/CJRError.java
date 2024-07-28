package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRError extends IJRDataModel {
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
