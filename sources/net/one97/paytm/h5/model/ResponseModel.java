package net.one97.paytm.h5.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ResponseModel extends IJRPaytmDataModel {
    @c(a = "openId")
    private String openId;

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public String toString() {
        return "Response{openId='" + this.openId + '\'' + '}';
    }
}
