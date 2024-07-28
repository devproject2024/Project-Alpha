package net.one97.paytm.games.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class GpCommonBaseResponse extends IJRPaytmDataModel {
    @c(a = "code")
    public int code;
    @c(a = "message")
    public String message;
    @c(a = "reqid")
    public String reqid;
    @c(a = "status")
    public String status;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "GpCommonBaseResponse{code=" + this.code + ", message=" + this.message + ", status=" + this.status + ", reqid=" + this.reqid + '}';
    }
}
