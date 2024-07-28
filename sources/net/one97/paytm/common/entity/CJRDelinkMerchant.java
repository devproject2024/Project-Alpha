package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRDelinkMerchant extends IJRPaytmDataModel {
    @b(a = "error")
    private String mError;
    @b(a = "error_description")
    private String mErrorDescription;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "responseMessage")
    private String mResponseMessage;

    public String getmError() {
        return this.mError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(String str) {
        this.mResponseCode = str;
    }

    public String getResponseMessage() {
        return this.mResponseMessage;
    }

    public void setResponseMessage(String str) {
        this.mResponseMessage = str;
    }
}
