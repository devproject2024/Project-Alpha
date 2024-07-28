package net.one97.paytm.addmoney.common.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class ResultInfo implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String resultCode;
    private String resultMsg;
    private String resultStatus;

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
