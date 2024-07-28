package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.common.entity.CJRStatusError;

public class CJRIllegalCodeError extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "additional_info")
    private ErrorAdditionalInfo additionalInfo;
    @b(a = "code")
    private String code;
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "error_message")
    private String error_message;
    @b(a = "error")
    private String mError;
    @b(a = "error_title")
    private String mErrorTitle;
    @b(a = "internal_code")
    private String mInternalErrorCode;
    @b(a = "status")
    private CJRStatusError mStatusError;
    @b(a = "title")
    private String mTitle;

    public String getmInternalErrorCode() {
        return this.mInternalErrorCode;
    }

    public void setmInternalErrorCode(String str) {
        this.mInternalErrorCode = str;
    }

    public String getError_message() {
        return this.error_message;
    }

    public void setError_message(String str) {
        this.error_message = str;
    }

    public String getCode() {
        return this.code;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public ErrorAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getmErrorTitle() {
        return this.mErrorTitle;
    }

    public CJRStatusError getStatusError() {
        return this.mStatusError;
    }

    public String getError() {
        return this.mError;
    }

    public void setStatusError(CJRStatusError cJRStatusError) {
        this.mStatusError = cJRStatusError;
    }

    public String getTitle() {
        return this.mTitle;
    }
}
