package com.paytm.network.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class ErrorAdditionalInfo implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "confimation")
    private String confirmation;
    @b(a = "confimation_flag")
    private String mConfirmationFlag;

    public String getConfirmationFlag() {
        return this.mConfirmationFlag;
    }

    public void setConfirmationFlag(String str) {
        this.mConfirmationFlag = str;
    }

    public String getConfirmation() {
        return this.confirmation;
    }

    public void setConfirmation(String str) {
        this.confirmation = str;
    }
}
