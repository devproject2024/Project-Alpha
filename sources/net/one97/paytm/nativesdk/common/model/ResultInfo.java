package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.Map;

public class ResultInfo implements BaseDataModel {
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
