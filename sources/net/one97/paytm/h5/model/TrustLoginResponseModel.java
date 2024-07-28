package net.one97.paytm.h5.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class TrustLoginResponseModel extends IJRPaytmDataModel {
    @c(a = "data")
    private String data;
    @c(a = "message")
    private String message;
    @c(a = "responseCode")
    private String responseCode;
    @c(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        return "TrustLoginResponseModel{status='" + this.status + '\'' + ", responseCode='" + this.responseCode + '\'' + ", message='" + this.message + '\'' + ", data='" + this.data + '\'' + '}';
    }
}
