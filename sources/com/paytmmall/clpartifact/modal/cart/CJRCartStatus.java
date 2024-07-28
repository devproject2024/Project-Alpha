package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;

public class CJRCartStatus {
    private static final long serialVersionUID = 1;
    @c(a = "code")
    private String mCode;
    @c(a = "result")
    private String mResult;

    public String getResult() {
        return this.mResult;
    }

    public String getCode() {
        return this.mCode;
    }
}
