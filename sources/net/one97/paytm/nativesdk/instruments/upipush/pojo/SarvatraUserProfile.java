package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class SarvatraUserProfile implements BaseDataModel {
    @c(a = "response")
    @a
    private Response response;
    @c(a = "status")
    @a
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }
}
