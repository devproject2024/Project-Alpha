package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.Map;

public class IsDisabled implements BaseDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private boolean merchantAccept;
    private String msg;
    private boolean status;
    private boolean userAccountExist;

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public boolean getMerchantAccept() {
        return this.merchantAccept;
    }

    public void setMerchantAccept(boolean z) {
        this.merchantAccept = z;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public boolean getUserAccountExist() {
        return this.userAccountExist;
    }

    public void setUserAccountExist(boolean z) {
        this.userAccountExist = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ClassPojo [merchantAccept = " + this.merchantAccept + ", status = " + this.status + ", userAccountExist = " + this.userAccountExist + ", msg = " + this.msg + "]";
    }
}
