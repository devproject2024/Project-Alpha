package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class PincodeItem extends a {
    public static final long serialVersionUID = 1;
    @c(a = "pincode")
    public String pincode;
    @c(a = "state")
    public String state;
    @c(a = "tier3Type")
    public String tier3Type;
    @c(a = "tier3Value")
    public String tier3Value;
    @c(a = "tier4Type")
    public String tier4Type;
    @c(a = "tier4Value")
    public String tier4Value;
    @c(a = "zone")
    public String zone;

    public String getPincode() {
        return this.pincode;
    }

    public String getTier4Value() {
        return this.tier4Value;
    }

    public String getZone() {
        return this.zone;
    }

    public String getTier3Value() {
        return this.tier3Value;
    }

    public String getTier3Type() {
        return this.tier3Type;
    }

    public String getState() {
        return this.state;
    }

    public String getTier4Type() {
        return this.tier4Type;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }
}
