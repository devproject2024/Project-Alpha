package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.Map;

public class VpaDetails implements BaseDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String vpa;

    public String getVpa() {
        return this.vpa;
    }

    public void setVpa(String str) {
        this.vpa = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
