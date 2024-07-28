package net.one97.paytm.addmoney.common.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class VpaDetails implements IJRDataModel {
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
