package net.one97.paytm.nativesdk.login.models;

import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.otp.Model.Body;
import net.one97.paytm.nativesdk.otp.Model.Head;

public class SendOTPResponse implements BaseDataModel {
    @c(a = "body")
    private Body body;
    @c(a = "head")
    private Head head;
    private String mMobileNo;

    public String getMobileNo() {
        return this.mMobileNo;
    }

    public void setMobileNo(String str) {
        this.mMobileNo = str;
    }

    public Head getHead() {
        return this.head;
    }

    public Body getBody() {
        return this.body;
    }
}
