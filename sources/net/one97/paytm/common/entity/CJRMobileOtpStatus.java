package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRMobileOtpStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String mError;
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "state")
    private String mState;
    @b(a = "status")
    private String mStatus;
    @b(a = "title")
    private String mTitle;

    public String getStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getmResponseCode() {
        return this.mResponseCode;
    }

    public String getError() {
        return this.mError;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getState() {
        return this.mState;
    }
}
