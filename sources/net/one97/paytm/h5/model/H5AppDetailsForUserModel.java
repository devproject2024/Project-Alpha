package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class H5AppDetailsForUserModel extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "message")
    private String message;
    @b(a = "response")
    private H5AppDataResponseModel response;
    @b(a = "status")
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

    public H5AppDataResponseModel getResponse() {
        return this.response;
    }

    public void setResponse(H5AppDataResponseModel h5AppDataResponseModel) {
        this.response = h5AppDataResponseModel;
    }

    public String toString() {
        return "H5AppDetailsForUserModel{code='" + this.code + '\'' + ", status='" + this.status + '\'' + ", message='" + this.message + '\'' + ", response=" + this.response.toString() + '}';
    }
}
