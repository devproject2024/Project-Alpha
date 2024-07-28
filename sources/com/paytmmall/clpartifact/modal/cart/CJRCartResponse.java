package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRCartResponse implements Serializable {
    @c(a = "cart")
    private CJRCart cart;
    @c(a = "errorCode")
    private String errorCode;
    @c(a = "address")
    private CJRAddress mAddress;
    @c(a = "error")
    private String mError;
    @c(a = "status")
    private CJRCartStatus mStatus;
    @c(a = "code")
    private int mStatusCode;

    public CJRCart getCart() {
        return this.cart;
    }

    public void setCart(CJRCart cJRCart) {
        this.cart = cJRCart;
    }

    public CJRAddress getAddress() {
        return this.mAddress;
    }

    public void setAddress(CJRAddress cJRAddress) {
        this.mAddress = cJRAddress;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int i2) {
        this.mStatusCode = i2;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getError() {
        return this.mError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public CJRCartStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(CJRCartStatus cJRCartStatus) {
        this.mStatus = cJRCartStatus;
    }
}
