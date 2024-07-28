package com.paytmmall.artifact.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRError extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancelButton")
    private String mCancelButtonText;
    @b(a = "message")
    private String mMessage;
    @b(a = "okbutton")
    private String mOkButtonText;
    @b(a = "title")
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getOkButtonText() {
        return this.mOkButtonText;
    }

    public String getCancelButtonText() {
        return this.mCancelButtonText;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setOkButton(String str) {
        this.mOkButtonText = str;
    }

    public void setCancelButton(String str) {
        this.mCancelButtonText = str;
    }
}
