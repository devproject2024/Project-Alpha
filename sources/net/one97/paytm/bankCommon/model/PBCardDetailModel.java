package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCardDetailModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cvv")
    private String mCvv;
    @b(a = "errorCode")
    private String mErrorCode;
    @b(a = "errorMessage")
    private String mErrorMessage;
    @b(a = "expiration")
    private String mExpiration;
    @b(a = "httpStatusCode")
    private String mHttpStatusCode;
    @b(a = "message")
    private String mMessage;
    @b(a = "pan")
    private String mPan;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "type")
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
