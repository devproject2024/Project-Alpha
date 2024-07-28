package net.one97.paytm.addmoney.common.paymethodresponse;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class PostConvinienceFee extends IJRPaytmDataModel implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String isEnabled;

    public String getIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(String str) {
        this.isEnabled = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
