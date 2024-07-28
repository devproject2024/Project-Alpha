package net.one97.paytm.nativesdk.otp.Model;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class Head implements BaseDataModel {
    private String responseTimestamp;
    private String version;

    public String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "ClassPojo [responseTimestamp = " + this.responseTimestamp + ", version = " + this.version + "]";
    }
}
