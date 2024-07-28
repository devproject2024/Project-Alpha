package com.paytmmall.artifact.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTermsAndConditions extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancelButton")
    private String mCancelButton;
    @b(a = "message")
    private String mMessage;
    @b(a = "okbutton")
    private String mOkButton;
    @b(a = "title")
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getCancelButton() {
        return this.mCancelButton;
    }

    public String getOkButton() {
        return this.mOkButton;
    }
}
