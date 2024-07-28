package net.one97.paytm.common.entity.recharge;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRAdditionalUserInfo implements Serializable {
    @c(a = "mobileNumber")
    private String mobileNumber;

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }
}
