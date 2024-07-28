package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.Map;

public class HasLowSuccess implements BaseDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String msg;
    private boolean status;

    public HasLowSuccess(boolean z, String str) {
        this.status = z;
        this.msg = str;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
