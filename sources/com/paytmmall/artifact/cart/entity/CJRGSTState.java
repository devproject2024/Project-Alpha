package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRGSTState extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private String errorMessage;
    @b(a = "title")
    private String errorTitle;
    @b(a = "name")
    private String name;
    @b(a = "state_code")
    private String stateCode;
    @b(a = "state_tin_code")
    private String stateTINCode;

    public String getStateTINCode() {
        return this.stateTINCode;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public String getName() {
        return this.name;
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
