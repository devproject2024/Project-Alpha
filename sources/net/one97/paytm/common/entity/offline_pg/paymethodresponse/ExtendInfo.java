package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class ExtendInfo implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String key;
    String lenderDescription;
    String lenderId;
    String otpRequired;
    String passcodeRequired;

    public String getPasscodeRequired() {
        return this.passcodeRequired;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public String getLenderId() {
        return this.lenderId;
    }

    public String getLenderDescription() {
        return this.lenderDescription;
    }

    public String getOtpRequired() {
        return this.otpRequired;
    }
}
