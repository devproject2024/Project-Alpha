package net.one97.paytm.h5.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class OpenIdResponseModel extends IJRPaytmDataModel {
    @c(a = "code")
    private String code;
    @c(a = "message")
    private String message;
    @c(a = "response")
    private ResponseModel response;
    @c(a = "status")
    private String status;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ResponseModel getResponse() {
        return this.response;
    }

    public void setResponse(ResponseModel responseModel) {
        this.response = responseModel;
    }

    public String toString() {
        return "OpenIdResponseModel{code='" + this.code + '\'' + ", status='" + this.status + '\'' + ", message='" + this.message + '\'' + ", response=" + this.response.toString() + '}';
    }
}
