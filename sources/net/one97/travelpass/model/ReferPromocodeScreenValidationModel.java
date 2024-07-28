package net.one97.travelpass.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferPromocodeScreenValidationModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "body")
    private String body;
    @c(a = "code")
    private int code;
    @c(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }
}
