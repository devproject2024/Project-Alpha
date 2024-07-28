package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRReturnCancelError extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error_description")
    private String errorDescription;
    @b(a = "error_title")
    private String errorTitle;

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }
}
