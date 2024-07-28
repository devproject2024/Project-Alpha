package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CardDetailModel implements UpiBaseDataModel {
    @c(a = "cvv")
    private String mCvv;
    @c(a = "errorCode")
    private String mErrorCode;
    @c(a = "errorMessage")
    private String mErrorMessage;
    @c(a = "expiration")
    private String mExpiration;
    @c(a = "httpStatusCode")
    private String mHttpStatusCode;
    @c(a = "message")
    private String mMessage;
    @c(a = "pan")
    private String mPan;
    @c(a = "statusCode")
    private String mStatusCode;
    @c(a = "type")
    private String mType;

    public String getPan() {
        return this.mPan;
    }

    public String getCvv() {
        return this.mCvv;
    }

    public String getExpiration() {
        return this.mExpiration;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String getType() {
        return this.mType;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setHttpStatusCode(String str) {
        this.mHttpStatusCode = str;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }
}
