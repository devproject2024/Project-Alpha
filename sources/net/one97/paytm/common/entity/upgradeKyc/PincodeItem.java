package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gson.a.c;

public class PincodeItem extends BaseModel {
    private static final long serialVersionUID = 1;
    @c(a = "pincode")
    private String pincode;
    @c(a = "state")
    private String state;
    @c(a = "tier3Type")
    private String tier3Type;
    @c(a = "tier3Value")
    private String tier3Value;
    @c(a = "tier4Type")
    private String tier4Type;
    @c(a = "tier4Value")
    private String tier4Value;
    @c(a = "zone")
    private String zone;

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
}
