package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class ApiStatusModel extends BaseModel {
    @c(a = "respCode")
    private String respCode;
    @c(a = "respDesc")
    private String respDesc;

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String str) {
        this.respCode = str;
    }

    public String getRespDesc() {
        return this.respDesc;
    }

    public void setRespDesc(String str) {
        this.respDesc = str;
    }
}
