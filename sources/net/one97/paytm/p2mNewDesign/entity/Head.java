package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class Head extends CJRWalletDataModel implements IJRDataModel {
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
