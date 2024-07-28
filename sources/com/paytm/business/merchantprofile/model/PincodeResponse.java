package com.paytm.business.merchantprofile.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.google.gson.o;
import java.io.Serializable;

public class PincodeResponse implements Serializable {
    @c(a = "addressDictionary")
    @a
    public o addressDictionary;
    @c(a = "responseCode")
    @a
    public String responseCode;
    @c(a = "responseMessage")
    @a
    public String responseMessage;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public o getAddressDictionary() {
        return this.addressDictionary;
    }

    public void setAddressDictionary(o oVar) {
        this.addressDictionary = oVar;
    }
}
