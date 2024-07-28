package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRForgetPassword extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "detail")
    private String mDetail;
    @b(a = "error")
    private String mError;
    @b(a = "errorCode")
    private String mErrorCode;
    @b(a = "message")
    private String mMessage;
    @b(a = "code")
    private String mRevivedCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "type")
    private String mType;
    @b(a = "username")
    private String mUserName;

    public String getMessage() {
        return this.mMessage;
    }

    public String getDetail() {
        return this.mDetail;
    }

    public String getError() {
        return this.mError;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getCode() {
        return this.mRevivedCode;
    }

    public String getType() {
        return this.mType;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }
}
