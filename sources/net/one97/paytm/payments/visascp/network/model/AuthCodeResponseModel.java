package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class AuthCodeResponseModel extends BaseModel {
    @c(a = "data")
    private String data;
    @c(a = "status")
    private ApiStatusModel status;

    public ApiStatusModel getStatus() {
        return this.status;
    }

    public void setStatus(ApiStatusModel apiStatusModel) {
        this.status = apiStatusModel;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthCodeResponseModel{status=");
        sb.append(this.status);
        sb.append(", data='");
        sb.append(this.data);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
